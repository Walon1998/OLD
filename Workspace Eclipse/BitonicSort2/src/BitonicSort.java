import java.util.concurrent.RecursiveAction;

/**
 * @author Neville Walo
 *
 * Datum: 13.06.2018
 */
public class BitonicSort extends RecursiveAction {

	int cutoff = 1000;
	int lo;
	int n;
	boolean dir;
	private int[] a;
	private final static boolean ASCENDING = true; // sorting direction

	public BitonicSort(int[] a)
	{
		this.a=a;
		// bitonicSort(0, a.length, ASCENDING);
		lo = 0;
		n = a.length;
		dir = true;
	}

	public BitonicSort(int[] a, int lo, int n, boolean dir) {
		this.a = a;
		this.lo = lo;
		this.dir = dir;
		this.n = n;

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
				int m = n / 2;
				BitonicSort s1 = new BitonicSort(a, lo, m, !dir);
				BitonicSort s2 = new BitonicSort(a, lo + m, n - m, dir);
				s1.fork();
				s2.compute();
				s1.join();

				// bitonicSort(lo + m, n - m, dir);
				bitonicMerge(lo, n, dir);
				BitonicMerge m0 = new BitonicMerge(a, lo, n, dir);
				m0.compute();
			}
		} else {
			if (n > 1) {
				int m = n / 2;
				bitonicSort(lo, m, !dir);
				bitonicSort(lo + m, n - m, dir);
				bitonicMerge(lo, n, dir);
			}

		}


	}

	private void bitonicSort(int lo, int n, boolean dir)
	{
		if (n>1)
		{
			int m=n/2;
			bitonicSort(lo, m, !dir);
			bitonicSort(lo+m, n-m, dir);
			bitonicMerge(lo, n, dir);
		}
	}

	private void bitonicMerge(int lo, int n, boolean dir)
	{
		if (n>1)
		{
			int m=greatestPowerOfTwoLessThan(n);
			for (int i=lo; i<lo+n-m; i++) {
				compare(i, i+m, dir);
			}
			bitonicMerge(lo, m, dir);
			bitonicMerge(lo+m, n-m, dir);
		}
	}

	private void compare(int i, int j, boolean dir)
	{
		if (dir==a[i]>a[j]) {
			exchange(i, j);
		}
	}

	private void exchange(int i, int j)
	{
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	// n>=2  and  n<=Integer.MAX_VALUE
	private int greatestPowerOfTwoLessThan(int n)
	{
		int k=1;
		while (k>0 && k<n) {
			k=k<<1;
		}
		return k>>>1;
	}





}