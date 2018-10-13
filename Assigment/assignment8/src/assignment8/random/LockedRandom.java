package assignment8.random;

import java.util.concurrent.locks.ReentrantLock;

public class LockedRandom implements RandomInterface {
	private static final long a = 25214903917L;
	private static final long c = 11;
	private long state;
	ReentrantLock lock;

	public LockedRandom(long seed) {
		this.state = seed;
		this.lock = new ReentrantLock();
	}

	@Override
	public int nextInt() {
		this.lock.lock();
		// get the current seed value
		long orig = this.state;
		// using recurrence equation to generate next seed
		long next = ((a * orig) + c) & (~0L >>> 16);
		// store the updated seed
		this.state = next;
		this.lock.unlock();
		return (int) (next >>> 16);

	}
}
