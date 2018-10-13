package ethz.ch.pp.assignment3.threads;

import ethz.ch.pp.assignment3.counters.Counter;

public class FairThreadCounter extends ThreadCounter {


	public FairThreadCounter(Counter counter, int id, int numThreads, int numIterations) {
		super(counter, id, numThreads, numIterations);
	}

	@Override
	public void run() {

		/*
		 * This is supposed to be:
		 synchronized(counter) {
		 	Wait until I am supposed to increment the counter
		 	
		 	increment the counter
		 	
		 	wake up the other threads
		 */
		
		/*
		 * What you did is:
		 synchronized(counter) {
		 	Increment the counter and wake up the other threads
		 
		 	Wait until I am supposed to increment the counter
		 }
		 *
		 * -Tyler
		 */
		while ((counter.value()) < (numIterations)) {
			synchronized (counter) {
				counter.increment();
				counter.notifyAll();
				// System.out.println(id);

				while ((counter.getID() != id) && (counter.value() != numIterations)) {
					try {

						counter.wait();

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}







	}

}
