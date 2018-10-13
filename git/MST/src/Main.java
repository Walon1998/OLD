import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 22.02.2018
 *
 */
class Main {

	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			System.out.println(Main.testCase(sc));
		}
		sc.close();
	}

	public static int testCase(final Scanner sc) {

		int spanningtreesize=0;
		int n = sc.nextInt();
		int m=sc.nextInt();
		int[] from = new int[m];
		int[] to = new int[m];
		int[] weight = new int[m];
		for (int i = 0; i < m; i++) {
			from[i] = sc.nextInt();
			to[i] = sc.nextInt();
			weight[i] = sc.nextInt();

		}
		// System.out.println("m:" + m);
		// System.out.println("n:" + n);
		UnionFind uni = new UnionFind(n);
		Main.mergesort(weight, 0, weight.length - 1, from, to);

		for (int i = 0; i < m; i++) {

			if (uni.Find(from[i]) != uni.Find(to[i])) {
				uni.Union(from[i], to[i]);
				spanningtreesize += weight[i];

			}


		}

		return spanningtreesize;

	}

	static void mergesort(int[] A, int left, int right, int[] from, int[] to) {
		if (left < right) {

			int middle = (left + right) / 2;
			// System.out.println(middle);
			Main.mergesort(A, left, middle, from, to);
			Main.mergesort(A, middle + 1, right, from, to);
			Main.merge(A, left, middle + 1, right,from,to);

		}

	}

	static void merge(int[] A, int left, int middle, int right, int[] from, int[] to) {
		int[] B = new int[A.length];
		int[]C = new int[from.length];
		int[]D= new int[to.length];
		int i = left;
		int j = middle;
		int k = left;

		while (i <= middle - 1 && j <= right) {
			if (A[i] <= A[j]) {
				B[k] = A[i];
				C[k] = from[i];
				D[k] = to[i];
				i++;
				k++;
			} else {
				B[k] = A[j];
				C[k] = from[j];
				D[k] = to[j];
				j++;
				k++;
			}

		}
		while (i <= middle - 1) {
			B[k] = A[i];
			C[k] = from[i];
			D[k] = to[i];
			i++;
			k++;
		}
		while (j <= right) {
			B[k] = A[j];
			C[k] = from[j];
			D[k] = to[j];
			j++;
			k++;
		}
		for (i = left; i <= right; i++) {
			A[i] = B[i];
			from[i] = C[i];
			to[i] = D[i];

		}

	}
}
