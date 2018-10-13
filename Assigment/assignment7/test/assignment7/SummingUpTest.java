package assignment7;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;

public class SummingUpTest {

	private static final int TRANSFER_AMOUNT = 1;
	private static final int INITIAL_BALANCE = 100000;
	private static final int ACCOUNTS = 10000;
	private static final int TRANSACTIONS = 1000000;

	private BankingSystem bs;
	private int initialSum, lastSum;
	private List<Account> accounts;
	private List<Thread> threads;

	private AtomicLong remainingTransactions;

	@Before
	public void setUp() throws Exception {
		int noOfCores = Runtime.getRuntime().availableProcessors();
		assertTrue("Running on a multicore machine.", noOfCores > 1);

		this.bs = new BankingSystem();
		this.accounts = new ArrayList<Account>();
		for (int i = 0; i < ACCOUNTS; i++) {
			Account a = new Account(i);
			a.setBalance(INITIAL_BALANCE);
			this.initialSum += INITIAL_BALANCE;
			this.accounts.add(a);
		}

		// Add the accounts shuffled.
		List<Account> shuffled = new ArrayList<Account>(this.accounts);
		Collections.shuffle(shuffled);
		for (Account a : shuffled) {
			this.bs.addAccount(a);
		}

		this.remainingTransactions = new AtomicLong(noOfCores * TRANSACTIONS);

		// one transfer thread for each core
		this.threads = new ArrayList<Thread>(noOfCores + 1);
		for (int i = 0; i < noOfCores; i++) {
			this.threads.add(new Thread() {
				@Override
				public void run() {
					Random generator = new Random();
					while (SummingUpTest.this.remainingTransactions.decrementAndGet() > 0) {
						Account from = SummingUpTest.this.accounts.get(generator.nextInt(ACCOUNTS));
						Account to = SummingUpTest.this.accounts.get(generator.nextInt(ACCOUNTS));
						SummingUpTest.this.bs.transferMoney(from, to, TRANSFER_AMOUNT);
					}
				}
			});
		}

		// additional revisor thread which sums stuff up
		this.threads.add(new Thread() {
			@Override
			public void run() {

				while (SummingUpTest.this.remainingTransactions.decrementAndGet() > 0) {
					SummingUpTest.this.lastSum = SummingUpTest.this.bs.totalMoneyInBank();
					if (SummingUpTest.this.lastSum != SummingUpTest.this.initialSum) {
						// mismatch found, finish early
						SummingUpTest.this.remainingTransactions.set(0);
					}
				}
			}
		});
	}

	@Test(timeout = 15000) // Timeout in case of deadlock
	public void testSum() throws InterruptedException {
		for (Thread t : this.threads) {
			t.start();
		}

		for (Thread t : this.threads) {
			t.join();
		}

		assertThat("Concurrent summing up was incorrect", this.lastSum, is(this.initialSum));
	}
}
