import java.util.Arrays;

// A Java Program to find length of the Longest
// Common Increasing Subsequence (LCIS)

class LICS {

	/* Driver program to test above function */
	public static void main(String[] args) {
		int A[] = { 1 };
		int B[] = { 9, 1, 7, 3, 5 };

		System.out.println("Length of LCIS is " + LCIS(A, B));
	}

	// Returns the length and the LCIS of two
	// arrays arr1[0..n-1] and arr2[0..m-1]
	static int LCIS(int A[], int B[]) {
		// table[j] is going to store length of
		// LCIS ending with arr2[j].a We initialize
		// it as 0,
		int table[] = new int[B.length];
		int parent[] = new int[B.length];
		for (int j = 0; j < B.length; j++) {
			table[j] = 0;
		}

		// Traverse all elements of arr1[]
		for (int i = 0; i < A.length; i++) {
			// Initialize current length of LCIS
			int current = 0, last = -1;

			// For each element of arr1[], trvarse
			// all elements of arr2[].
			for (int j = 0; j < B.length; j++) {
				// If both the array have same
				// elements. Note that we don't
				// break the loop here.

				if ((A[i] == B[j]) && ((current + 1) > table[j])) {

					table[j] = current + 1;
					parent[j] = last;

				}
				/*
				 * Now seek for previous smaller common element for current element of arr1
				 */
				if ((A[i] > B[j]) && (table[j] > current)) {

					current = table[j];
					last = j;

				}

			}
		}

		// The maximum value in table[] is out
		// result
		int result = 0;
		int index = -1;
		for (int i = 0; i < B.length; i++) {
			if (table[i] > result) {
				result = table[i];
				index = i;
			}
		}

		// LCIS is going to store elements
		// of LCIS
		int lcis[] = new int[result];
		for (int i = 0; index != -1; i++) {
			lcis[i] = B[index];
			index = parent[index];
		}

		System.out.print("The LCIS is : ");
		for (int i = result - 1; i >= 0; i--) {
			System.out.print(lcis[i] + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(table));
		return result;
	}

}
// This code is contributed by Prerna Saini