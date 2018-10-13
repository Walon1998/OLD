package ethz.ch.pp.searchAndCount;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import ethz.ch.pp.util.Workload;

/*
 * Good.
 * -Tyler
 */
public class SearchAndCountForkJoin extends RecursiveTask<Integer> {

	public static ForkJoinPool pool;
	int from;
	int to;
	int[] input;
	int cutOff;
	Workload.Type wt;

	public static Integer countNoAppearances(int[] input, Workload.Type wt, int cutOff, int noThreads) {

		pool = new ForkJoinPool(noThreads);
		int i = pool.invoke(new SearchAndCountForkJoin(input, wt, 0, input.length - 1, cutOff));

		pool.shutdownNow();
		return i;
	}

	SearchAndCountForkJoin(int[] input, Workload.Type wt, int from, int to, int cutOff) {
		this.from = from;
		this.to = to;
		this.input = input;
		this.wt = wt;
		this.cutOff = cutOff;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.concurrent.RecursiveTask#compute()
	 */
	@Override
	protected Integer compute() {
		if ((to - from) < cutOff) {

			int count = 0;
			for (int i = from; i <= to; i++) {
				if (Workload.doWork(input[i], wt)) {
					count++;
				}
			}
			return count;

		} else {
			int middle = (from + to) / 2;
			SearchAndCountForkJoin f1 = new SearchAndCountForkJoin(input, wt, from, middle, cutOff);
			SearchAndCountForkJoin f2 = new SearchAndCountForkJoin(input, wt, middle + 1, to, cutOff);
			f1.fork();
			return f2.compute() + f1.join();

		}
	}

}