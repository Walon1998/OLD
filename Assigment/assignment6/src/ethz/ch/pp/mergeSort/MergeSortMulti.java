package ethz.ch.pp.mergeSort;

/*
 * Good
 * -Tyler
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import ethz.ch.pp.util.ArrayUtils;

public class MergeSortMulti extends RecursiveTask<int[]> {

	// Run Time Complexity:
	// Speedup:

	private static final long serialVersionUID = 1531647254971804196L;

	public static ForkJoinPool pool;
	int[] input;
	int start;
	int length;

	public static int[] sort(int[] input, int numThreads) {
		pool = new ForkJoinPool(numThreads);
		int[] i = pool.invoke(new MergeSortMulti(input, 0, input.length));
		pool.shutdown();
		return i;
	}

	MergeSortMulti(int[] input, int start, int length) {
		this.input = input;
		this.length = length;
		this.start = start;

	}

	@Override
	protected int[] compute() {
		int[] result = new int[length];

		if (length == 1) {

			/*
			 * Simple case: input is only 1 number
			 */
			result[0] = input[start];

		} else if (length == 2) {

			/*
			 * Base case: input is two numbers. Return them in the correct order.
			 */
			if (input[start] > input[start + 1]) {
				result[0] = input[start + 1];
				result[1] = input[start];
			} else {
				result[0] = input[start];
				result[1] = input[start + 1];
			}

		} else if (length > 2) {

			/*
			 * Generic case: input is more than two numbers.
			 */
			int halfSize = (length) / 2;

			/*
			 * Sort first half
			 */
			MergeSortMulti f1 = new MergeSortMulti(input, start, halfSize);
			f1.fork();

			/*
			 * Sort second half
			 */
			MergeSortMulti f2 = new MergeSortMulti(input, start + halfSize, length - halfSize);
			int[] secondHalf = f2.compute();

			/*
			 * Merge the results
			 */
			ArrayUtils.merge(f1.join(), secondHalf, result);
		}

		return result;
	}

}
