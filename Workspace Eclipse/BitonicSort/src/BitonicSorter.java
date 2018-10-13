/**
 * @author Neville Walo
 *
 * Datum: 13.06.2018
 */
public class BitonicSorter extends Thread {
	int cutoff = 10000;
	int[] a;
	int lo;
	int n;
	boolean dir;

	BitonicSorter(int a[], int lo, int n, boolean dir) {
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
				int m = n / 2;
				BitonicSorter s1 = new BitonicSorter(a, lo, m, !dir);
				BitonicSorter s2 = new BitonicSorter(a, lo + m, n - m, dir);
				s1.start();
				s2.run();
				try {
					s1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BitonicMerger m0 = new BitonicMerger(a, lo, n, dir);
				m0.run();
			}
		} else {
			if (n > 1) {
				int m = n / 2;
				bitonicSort(lo, m, !dir);
				bitonicSort(lo + m, n - m, dir);
				BitonicMerger m0 = new BitonicMerger(a, lo, n, dir);
				m0.run();
			}
		}
	}

	private void bitonicSort(int lo, int n, boolean dir) {
		if (n > 1) {
			int m = n / 2;
			bitonicSort(lo, m, !dir);
			bitonicSort(lo + m, n - m, dir);
			BitonicMerger m0 = new BitonicMerger(a, lo, n, dir);
			m0.run();
		}
	}
}
