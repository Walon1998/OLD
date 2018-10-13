import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Neville Walo
 *
 * Datum: 14.06.2018
 */
public class Last {
	private int[] a;
	private final static boolean ASCENDING = true; // sorting direction
	ExecutorService exs = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	public Last(int[] a)
	{
		this.a=a;
		bitonicSort(0, a.length, ASCENDING);
		// exs.shutdown();
	}

	private void bitonicSort(int lo, int n, boolean dir) {
		if (n > 1) {
			int m = n / 2;
			bitonicSort(lo, m, !dir);
			bitonicSort(lo + m, n - m, dir);
			bitonicMerge(lo, n, dir);
		}
	}

	private void bitonicMerge(int lo, int n, boolean dir) {
		if (n > 1) {
			int m = greatestPowerOfTwoLessThan(n);
			if (n > 1000) {

				Comparer[] threads = new Comparer[Runtime.getRuntime().availableProcessors()];
				ArraySplit[] spliter = PartitionData(n - m, Runtime.getRuntime().availableProcessors());
				for (int i = 0; i < spliter.length; i++) {
					threads[i] = new Comparer(a, spliter[i].startIndex + lo, spliter[i].length,
							m, dir);
					threads[i].start();
					// exs.execute(threads[i]);


				}
				for (int i = 0; i < spliter.length; i++) {
					try {
						threads[i].join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = lo; i < lo + n - m; i++) {
					compare(i, i + m, dir);
				}
			}

			bitonicMerge(lo, m, dir);
			bitonicMerge(lo + m, n - m, dir);
		}
	}

	private void compare(int i, int j, boolean dir) {
		if (dir == a[i] > a[j]) {
			exchange(i, j);
		}
	}

	private void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// n>=2 and n<=Integer.MAX_VALUE
	private int greatestPowerOfTwoLessThan(int n) {
		int k = 1;
		while (k > 0 && k < n) {
			k = k << 1;
		}
		return k >>> 1;
	}

	public static class ArraySplit {
		public final int startIndex;
		public final int length;

		ArraySplit(int startIndex, int length) {
			this.startIndex = startIndex;
			this.length = length;

		}

	}



	public static ArraySplit[] PartitionData(int length, int numPartitions) {
		// Splits everything in "most" equal parts
		// Alternative way...?
		ArraySplit[] array = new ArraySplit[numPartitions];
		int rest = length % numPartitions;
		int divide = length / numPartitions;
		int stelle = 0;
		for (int i = 0; i < numPartitions; i++) {

			if (rest > 0) {
				array[i] = new ArraySplit(stelle, divide + 1);
				rest--;
				stelle += divide + 1;

			} else {
				array[i] = new ArraySplit(stelle, divide);
				stelle += divide;
			}

		}
		return array;
	}
}
