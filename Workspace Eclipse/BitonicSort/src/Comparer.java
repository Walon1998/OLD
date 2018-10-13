
/**
 * @author Neville Walo
 *
 * Datum: 14.06.2018
 */
public class Comparer extends Thread {
	int m;
	boolean dir;
	int from;
	int length;
	int[] a;

	public Comparer(int[] a, int from, int length, int m, boolean dir) {

		this.a = a;
		this.from = from;
		this.length = length;
		this.m = m;
		this.dir = dir;

	}

	@Override
	public void run() {
		for (int i = from; i < from + length; i++) {
			compare(i, i + m, dir);
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


}
