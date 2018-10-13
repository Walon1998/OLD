package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

/*
 * Good.
 * -Tyler
 */
public class SearchAndCountSeqDivideAndConquer {

	public static int countNoAppearances(int[] input, Workload.Type wt, int from, int to) {
		int cutoff = 100;

		if ((to - from) < cutoff) {

			int count = 0;
			for (int i = from; i <= to; i++) {
				if (Workload.doWork(input[i], wt)) {
					count++;
				}
			}
			return count;



		} else {
			int middle = (from + to) / 2;
			int sum1 = countNoAppearances(input, wt, from, middle);
			int sum2 = countNoAppearances(input, wt, middle + 1, to);
			return sum1 + sum2;
		}
	}

	public static int countNoAppearances(int[] input, Workload.Type wt) {
		return countNoAppearances(input, wt, 0, input.length - 1);
	}
}