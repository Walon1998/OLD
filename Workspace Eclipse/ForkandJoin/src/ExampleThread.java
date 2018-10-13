import java.util.concurrent.RecursiveTask;

/**
 * @author Neville Walo
 *
 * Datum: 12.06.2018
 */
public class ExampleThread extends RecursiveTask<V> {
	public ExampleThread() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.concurrent.RecursiveAction#compute()
	 */
	@Override
	protected V compute() {

		if ("Work" < Cutoff) {
			// Do Serial
		}

		ExampleThread t1 = new ExampleThread();
		ExampleThread t2 = new ExampleThread();

		t1.fork();
		return t2.compute() + t1.join();

	}

}
