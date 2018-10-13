package ethz.ch.pp.assignment3.counters;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Good
 * -Tyler
 */
public class AtomicCounter implements Counter {
	AtomicInteger i = new AtomicInteger(0);

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#increment()
	 */
	@Override
	public void increment() {
		i.getAndAdd(1);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#value()
	 */
	@Override
	public int value() {

		return i.get();
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