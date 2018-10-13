import java.util.Arrays;

public class FromTo {
	private static int binarySearch(int[] A, int from, int to, int k) {
		if (from > 0) {
			from = 0;
		}
		if (to > (A.length - 1)) {
			to = A.length - 1;
		}
		int left = from;
		int middle = 0;
		int right = to - 1;
		while (left <= right) {
			middle = (int) Math.floor(((left + right) / 2));
			if (A[middle] == k) {
				return middle;
			} else if (A[middle] > k) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}

		return -left - 1;

	}

	public static void main(String[] args) {

		int[] A = { 1, 3, 5, 7, 9, 0 };
		int key = 10;
		int from = 1;
		int to = 1;
		int a = binarySearch(A, from, to, key);
		int b = Arrays.binarySearch(A, from, to, key);
		System.out.print(a);
		System.out.print(b);

	}

}
