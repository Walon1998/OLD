package ethz.ch.pp.assignment3.counters;


/*
 * Good.
 * -Tyler
 */
public class SequentialCounter implements Counter {
	int i;

	/*
	 * (non-Javadoc)
	 *
	 * @see ethz.ch.pp.assignment3.counters.Counter#increment()
	 */
	@Override
	public void increment() {
		i++;

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
		return 0;
	}

}