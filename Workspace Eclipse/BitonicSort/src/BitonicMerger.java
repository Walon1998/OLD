/**
 * @author Neville Walo
 *
 * Datum: 13.06.2018
 */
public class BitonicMerger extends Thread {
	int cutoff = 10000;
	int[] a;
	int lo;
	int n;
	boolean dir;

	BitonicMerger(int a[], int lo, int n, boolean dir) {
		this.a = a;
		this.lo = lo;
		this.n = n;
		this.dir = dir;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.concurrent.RecursiveAction#compute()
	 */
	@Override
	public void run() {
		if (n > cutoff) {
			if (n > 1) {
				// Halfcleaner
				int m = greatestPowerOfTwoLessThan(n);
				for (int i = lo; i < lo + n - m; i++) {
					compare(i, i + m, dir);
				}
				BitonicMerger m1 = new BitonicMerger(a, lo, m, dir);
				BitonicMerger m2 = new BitonicMerger(a, lo + m, n - m, dir);
				m1.start();
				m2.run();
				try {
					m1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {

			if (n > 1) {
				int m = greatestPowerOfTwoLessThan(n);
				for (int i = lo; i < lo + n - m; i++) {
					compare(i, i + m, dir);
				}
				BitonicMerger m1 = new BitonicMerger(a, lo, m, dir);
				BitonicMerger m2 = new BitonicMerger(a, lo + m, n - m, dir);
				m1.run();
				m2.run();

				// bitonicMerge(lo, m, dir);
				// bitonicMerge(lo + m, n - m, dir);
			}
		}


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
	/**
	 * @param i
	 * @param j
	 * @param dir2
	 */
	private void compare(int i, int j, boolean dir) {
		if (dir == a[i] > a[j]) {
			exchange(i, j);
		}
	}

	/**
	 * @param i
	 * @param j
	 */
	private void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * @param n2
	 * @return
	 */
	private int greatestPowerOfTwoLessThan(int n2) {
		int k = 1;
		while (k > 0 && k < n) {
			k = k << 1;
		}
		return k >>> 1;
	}

}
