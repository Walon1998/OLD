import java.util.concurrent.RecursiveAction;

/**
 * @author Neville Walo
 *
 * Datum: 14.06.2018
 */
public class BitonicMerge extends RecursiveAction {

	int cutoff = 1000;
	int lo;
	int n;
	boolean dir;
	private int[] a;
	BitonicMerge(int[] a, int low, int n, boolean dir) {
		lo = 0;
		n = a.length;
		dir = true;
		this.a = a;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.concurrent.RecursiveAction#compute()
	 */
	@Override
	protected void compute() {

		if (n > cutoff) {
			if (n > 1) {
				int m = greatestPowerOfTwoLessThan(n);
				for (int i = lo; i < lo + n - m; i++) {
					compare(i, i + m, dir);
				}
				BitonicMerge m1 = new BitonicMerge(a, lo, m, dir);
				BitonicMerge m2 = new BitonicMerge(a, lo + m, n - m, dir);
				// bitonicMerge(lo, m, dir);
				// bitonicMerge(lo + m, n - m, dir);
			}

		} else {
			if (n > 1) {
				int m = greatestPowerOfTwoLessThan(n);
				for (int i = lo; i < lo + n - m; i++) {
					compare(i, i + m, dir);
				}
				bitonicMerge(lo, m, dir);
				bitonicMerge(lo + m, n - m, dir);
			}
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

	private void bitonicMerge(int lo, int n, boolean dir) {
		if (n > 1) {
			int m = greatestPowerOfTwoLessThan(n);
			for (int i = lo; i < lo + n - m; i++) {
				compare(i, i + m, dir);
			}
			bitonicMerge(lo, m, dir);
			bitonicMerge(lo + m, n - m, dir);
		}
	}


}
