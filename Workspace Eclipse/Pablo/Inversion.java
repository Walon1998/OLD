//NB: Do not add a package

//NB: Importing other classes is NOT ALLOWED
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"

class Main {
	static int[] B;

	static int zaehler = 0;

	static void mergesort(int[] A, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergesort(A, left, middle);
			mergesort(A, middle + 1, right);
			merge(A, left, middle + 1, right);

		}

	}

	static void merge(int[] A, int left, int middle, int right) {

		int i = left;
		int j = middle;
		int k = left;

		while ((i <= (middle - 1)) && (j <= right)) {
			if (A[i] <= A[j]) {
				B[k] = A[i];
				i++;

			} else {
				B[k] = A[j];
				j++;
				zaehler += (middle - i);

			}
			k++;

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

	static int solve(int[] A) {
		mergesort(A, 0, A.length - 1);

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
			B = new int[A.length];
			zaehler = 0;

			System.out.println(solve(A));
		}

		scanner.close();

	}

}
