import java.util.Arrays;

public class reines {

	static void mergesort(int[] A, int left, int right) {

		int laenge = 1;
		int n = A.length;
		while (laenge < n) {
			int rechts = 0;
			while ((rechts + laenge) < n) {

				int links = rechts + 1;
				int mitte = (links + laenge) - 1;
				rechts = Math.min(mitte + laenge, n);
				merge(A, links - 1, mitte, rechts - 1);
			}
			laenge = laenge * 2;
		}

	}

	static void merge(int[] A, int left, int middle, int right) {
		// System.out.println(Arrays.toString(A));
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
		System.out.print(Arrays.toString(array));

	}

}
