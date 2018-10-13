/**
 *
 */
package ethz.ch.pp.assignment3.counters;

/*
 * This project was designed so that any counter would work. So the logic in increment should have been inside FairThreadCounter.
 * Otherwise, this works, but only with 4 threads.
 * This really ought to be able to function correctly with any number of threads.
 * -Tyler
 */
/**
 * @author Neville Walo
 * Datum: 07.03.2018
 *
 */
public class FairCounter implements Counter {
	int i;
	int id;

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#increment()
	 */
	@Override
	public void increment() {
		i++;
		id++;
		if (id > 3) {
			id = 0;
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#value()
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
		return id;
	}

}
