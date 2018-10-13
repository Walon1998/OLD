package public_testcases;

//NB: Do not add a package

//NB: Importing other classes is NOT ALLOWED
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Test {
	static int mergeSort(int arr[], int array_size) {
		int temp[] = new int[array_size];
		return _mergeSort(arr, temp, 0, array_size - 1);
	}

	/*
	 * An auxiliary recursive method that sorts the input array and returns the
	 * number of inversions in the array.
	 */
	static int _mergeSort(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {
			/*
			 * Divide the array into two parts and call _mergeSortAndCountInv() for each of
			 * the parts
			 */
			mid = (right + left) / 2;

			/*
			 * Inversion count will be sum of inversions in left-part, right-part and number
			 * of inversions in merging
			 */
			inv_count = _mergeSort(arr, temp, left, mid);
			inv_count += _mergeSort(arr, temp, mid + 1, right);

			/* Merge the two parts */
			inv_count += merge(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	/*
	 * This method merges two sorted arrays and returns inversion count in the
	 * arrays.
	 */
	static int merge(int arr[], int temp[], int left, int mid, int right) {
		int i, j, k;
		int inv_count = 0;

		i = left; /* i is index for left subarray */
		j = mid; /* j is index for right subarray */
		k = left; /* k is index for resultant merged subarray */
		while ((i <= (mid - 1)) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];

				/* this is tricky -- see above explanation/diagram for merge() */
				inv_count = inv_count + (mid - i);
			}
		}

		/*
		 * Copy the remaining elements of left subarray (if there are any) to temp
		 */
		while (i <= (mid - 1)) {
			temp[k++] = arr[i++];
		}

		/*
		 * Copy the remaining elements of right subarray (if there are any) to temp
		 */
		while (j <= right) {
			temp[k++] = arr[j++];
		}

		/* Copy back the merged elements to original array */
		for (i = left; i <= right; i++) {
			arr[i] = temp[i];
		}

		return inv_count;
	}

	// "A" is the input vector.
	// The number of elements of A can be accessed using A.length
	static int solve(int[] A) {
		// System.out.println("Number of inversions are " + mergeSort(A, A.length));
		// return (mergeSort(A, A.length));
		return (count(A));

	}

	private static int count(int[] A) {
		int zaehler = 0;
		for (int k = 0; k < (((A.length)) - 1); k++) {
			int i = Math.abs((Arrays.binarySearch(A, 0, k + 1, A[k + 1]))) - 1;
			int b = A[k + 1];
			for (int j = k; j >= i; j--) {
				A[j + 1] = A[j];
			}
			A[i] = b;
			zaehler += ((k - i) + 1);
		}
		return zaehler;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
		int ntestcases = scanner.nextInt();

		for (int testno = 0; testno < ntestcases; testno++) {
			int n = scanner.nextInt();
			int[] A = new int[n];

			for (int i = 0; i < n; i++) {
				A[i] = scanner.nextInt();
			}

			System.out.println(solve(A));
		}

		scanner.close();
	}
}
