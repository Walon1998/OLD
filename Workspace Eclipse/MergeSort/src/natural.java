import java.util.Arrays;

public class natural {
	static int zaehler = 0;
	static int zaehler2 = 0;

	static void mergesort(int[] A, int left, int right) {
		int n = A.length - 1;
		do {
			right = 0;
			while (right < n) {
				left = right + 1;
				int middle = left;
				while ((middle < n) && (A[middle + 1] >= A[middle])) {
					middle++;
				}
				if (middle < n) {
					right = middle + 1;
					while ((right < n) && (A[right + 1] >= A[right])) {
						right++;
					}
					merge(A, left - 1, middle + 1, right);

				} else {
					right = n;
				}
			}

		} while (left != 1);

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
				zaehler += ((middle) - i);
				zaehler2++;
				// System.out.println("hi");
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
		int[] array = { 2, 12, 8, 43, 1, 7, 3 };
		mergesort(array, 0, array.length - 1);
		System.out.print(Arrays.toString(array));
		int rundung = (int) Math.floor(zaehler2 / 2.0);
		System.out.println(rundung);
		zaehler = zaehler - rundung;
		System.out.println(zaehler);

	}

}
