
//NB: Do not add a package

//NB: Importing other classes is NOT ALLOWED
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class insertion {

	private static int binarySearch(int[] A, int from, int to, int k) {

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

	static int solve(int[] A) {
		return (count(A));

	}

	private static int count(int[] A) {
		int zaehler = 0;
		for (int k = 0; k < (((A.length)) - 1); k++) {
			int i = Math.abs(binarySearch(A, 0, k + 1, A[k + 1])) - 1;

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
