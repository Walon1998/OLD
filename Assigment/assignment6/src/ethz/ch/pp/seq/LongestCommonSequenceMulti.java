package ethz.ch.pp.seq;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/* Good
 * -Tyler
 */
public class LongestCommonSequenceMulti extends RecursiveTask<Sequence> {

	private static final long serialVersionUID = 4179716026313995745L;
	public static ForkJoinPool pool;
	int[] input;
	int start;
	int length;

	public static Sequence longestCommonSequence(int[] input, int numThreads) {
		pool = new ForkJoinPool(numThreads);
		Sequence i = pool.invoke(new LongestCommonSequenceMulti(input, 0, input.length));
		pool.shutdown();

		return i;
	}

	LongestCommonSequenceMulti(int[] input, int start, int length) {
		this.input = input;
		this.start = start;
		this.length = length;
	}

	@Override
	protected Sequence compute() {

		final int CUTOFF = 100;
		if (length < CUTOFF) {
			/*
			 * You can just call the sequential LongestCommonSequence code here to avoid
			 * code duplication.
			 * -Tyler
			 */
			Sequence result = new Sequence(start, start);

			int currLength = 1;
			for (int i = start + 1; i < (start + length); i++) {

				// Using Math.exp makes the computation more compute-intensive while
				// retaining the task semantics (i.e., finding equal values)
				if (Math.exp(input[i - 1]) == Math.exp(input[i])) {
					currLength++;
				} else {
					if (result.lenght() < currLength) {
						result = new Sequence(i - currLength, i - 1);
					}
					currLength = 1;
				}
			}
			// In case the longest sequence ends at the last input element
			if (result.lenght() < currLength) {
				result = new Sequence((start + length) - currLength, (start + length) - 1);
			}

			return result;

		} else {

			int i = searchDivideSpot();
			LongestCommonSequenceMulti f1 = new LongestCommonSequenceMulti(input, start, i);
			LongestCommonSequenceMulti f2 = new LongestCommonSequenceMulti(input, start + i, length - i);
			f1.fork();
			Sequence a = f2.compute();
			return GetMax(f1.join(), a);

		}
	}

	private Sequence GetMax(Sequence b, Sequence a) {
		if (a.isGreaterThan(b)) {
			return a;
		} else {
			return b;
		}
	}

	private int searchDivideSpot() {
		int half = length / 2;
		while (input[start + half] == ((start + half) - 1)) {
			half++;
		}
		return half;
	}
}
