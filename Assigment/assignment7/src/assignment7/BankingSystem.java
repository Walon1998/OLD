package assignment7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankingSystem {
	protected List<Account> accountList;

	/**
	 * Initializes the BankingSystem: accountList is empty and totalMoneyInBank()
	 * should return 0.
	 */
	public BankingSystem() {
		this.setAccountList(new ArrayList<Account>());
	}

	/**
	 * Transfers Money from one account to another.
	 *
	 * @param from
	 *            Account to transfer money from.
	 * @param to
	 *            Account to transfer money to.
	 * @param amount
	 *            Amount to transfer.
	 * @return True if Money was transferred successfully. False if there was not
	 *         enough balance in from.
	 */
	/*
	 * 1. You can write this much more succinctly
	 * 2. There is a bug: The "from.getBalance() < amount" check has to be inside
	 * of the locked region. Otherwise the check can pass, another thread can take money from `from',
	 * and then there won't be enough money to transfer to `to'.
	 * -Tyler
	 */
	public boolean transferMoney(Account from, Account to, int amount) {
		if (from.getBalance() < amount) {
			return false;
		} else {
			if (from.getId() == to.getId()) {
				from.lock.writeLock().lock();
				from.setBalance(from.getBalance() - amount);
				to.setBalance(to.getBalance() + amount);
				from.lock.writeLock().unlock();
			} else if (from.getId() < to.getId()) {
				from.lock.writeLock().lock();
				to.lock.writeLock().lock();
				from.setBalance(from.getBalance() - amount);
				to.setBalance(to.getBalance() + amount);
				from.lock.writeLock().unlock();
				to.lock.writeLock().unlock();
			} else if (from.getId() > to.getId()) {
				to.lock.writeLock().lock();
				from.lock.writeLock().lock();
				to.setBalance(to.getBalance() + amount);
				from.setBalance(from.getBalance() - amount);
				to.lock.writeLock().unlock();
				from.lock.writeLock().unlock();
			}
		}
		// System.out.println(from.getId());
		return true;
	}

	/**
	 * Returns the sum of a given list of accounts.
	 *
	 * @fixme Tends to return wrong results :-(
	 */
	/*
	 * Good.
	 * -Tyler
	 */
	public int sumAccounts(List<Account> accounts) {
		int sum = 0;
		Collections.sort(accounts);
		// for (int i = 0; i < accounts.size(); i++) {
		// accounts.get(i).lock.writeLock().lock();
		// sum += accounts.get(i).getBalance();
		// }
		for (Account a : accounts) {
			a.lock.writeLock().lock();
			sum += a.getBalance();
		}

		for (Account a : accounts) {
			a.lock.writeLock().unlock();
		}

		return sum;
	}

	/**
	 * Calculates the total amount of money in the bank at any point in time.
	 *
	 * @return The total amount of money.
	 *
	 * @fixme Tends to return wrong results :-(
	 */
	public int totalMoneyInBank() {
		return this.sumAccounts(this.getAccountList());
	}

	/**
	 * Adds a new account to the bank. The account needs to have a positive balance
	 * to be added to the system.
	 *
	 * @param a
	 *            New account
	 * @return True if account was added successfully. False if account could not be
	 *         added to the system (ie., account did not have enough balance).
	 */
	public boolean addAccount(Account a) {
		if (a.getBalance() >= 0) {
			this.getAccountList().add(a);
			return true;
		} else {
			return false;
		}

	}

	protected List<Account> getAccountList() {
		return this.accountList;
	}

	protected void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}
