package ethz.ch.pp.assignment3.counters;


public class SynchronizedCounter implements Counter {
	int i;

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#increment()
	 */
	@Override
	public void increment() {
		synchronized (this) {
			i++;
			notify();
			// System.out.println(Thread.currentThread().getId());

		}

	}

	/*
	 * This really should be synchronized.
	 * What happens if one thread calls value() after another thread has called increment() but not finished incrementing i?
	 * Will it return the right result? or one less than the correct result?
	 * -Tyler
	 * 
	 */
	@Override
	public int value() {
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ethz.ch.pp.assignment3.counters.Counter#getID()
	 */
	@Override
	public int getID() {
		return 0;
	}

}