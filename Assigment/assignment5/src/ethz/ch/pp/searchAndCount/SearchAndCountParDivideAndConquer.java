package ethz.ch.pp.searchAndCount;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ethz.ch.pp.util.Workload;

public class SearchAndCountParDivideAndConquer {
	/*
	 * You need to synchronize on counter, otherwise it will not hold the correct value.
	 * This is the same issue as the counter in assignment 3.
	 * -Tyler
	 */
	static int counter = 0;

	/*
	 * Instead of throwing exceptings, you should catch them.
	 * This way the unit tests compile
	 * -Tyler
	 */
	public static int countNoAppearances(int[] input, Workload.Type wt, int cutOff, int numThreads)
			/*throws InterruptedException, ExecutionException*/ {

		ExecutorService exs = Executors.newFixedThreadPool(numThreads);
		counter = 0;
		int i = 0;
		try {
			i = countNoAppearances(input, wt, cutOff, exs, 0, input.length - 1, numThreads);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exs.shutdown();
		return i;
	}

	public static int countNoAppearances(int[] input, Workload.Type wt, int cutOff, ExecutorService exs,
			int from, int to, int numThreads) throws InterruptedException, ExecutionException {
		/*
		 * Cutoff handling looks good, but just know that it is possible to still execute in a divide-and-conquer manner,
		 * without creating more threads.
		 * -Tyler
		 */
		if (((to - from) < cutOff) || (counter >= numThreads)) {

			int count = 0;
			for (int i = from; i <= to; i++) {
				if (Workload.doWork(input[i], wt)) {
					count++;
				}
			}
			return count;

		} else {

			int middle = (from + to) / 2;
			Future<Integer> f1 = exs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws InterruptedException, ExecutionException {
					return countNoAppearances(input, wt, cutOff, exs, from, middle, numThreads);
				}

			});
			counter++;
			Future<Integer> f2 = exs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws InterruptedException, ExecutionException {
					return countNoAppearances(input, wt, cutOff, exs, middle + 1, to, numThreads);
				}

			});
			counter++;
			return f1.get() + f2.get();
		}
	}
}