
public class rekursiv {

	static void mergesort(int[] A, int left, int right) {
		if (left < right) {

			int middle = (left + right) / 2;
			// System.out.println(middle);
			mergesort(A, left, middle);
			mergesort(A, middle + 1, right);
			merge(A, left, middle + 1, right);

		}

	}

	static void merge(int[] A, int left, int middle, int right) {
		int[] B = new int[A.length];
		int i = left;
		int j = middle;
		int k = left;

		while ((i <= (middle - 1)) && (j <= right)) {
			if (A[i] <= A[j]) {
				B[k] = A[i];
				i++;
				k++;
			} else {
				B[k] = A[j];
				j++;
				k++;
			}

		}
		while (i <= (middle - 1)) {
			B[k] = A[i];
			i++;
			k++;
		}
		while (j <= right) {
			B[k] = A[j];
			j++;
			k++;
		}
		for (i = left; i <= right; i++) {
			A[i] = B[i];
		}

	}

	public static void main(String[] args) {
		int[] array = { 4, 6, 12, 8, 20, 1, 1, 1 };
		mergesort(array, 0, array.length - 1);

	}

}
