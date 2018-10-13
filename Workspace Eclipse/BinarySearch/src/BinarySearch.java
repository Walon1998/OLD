
public class BinarySearch {

	public static void main(String[] args) {

		int[] array = { 1, 3, 5, 7, 9 };
		int a = binarySearch(array, 10);
		int b = binarySearch(array, 8);
		System.out.println(a);
		System.out.println(b);

	}

	private static int binarySearch(int[] A, int k) {
		int left = 0;
		int middle = 0;
		int right = A.length - 1;
		while (left <= right) {
			middle = ((left + right) / 2);
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

}
