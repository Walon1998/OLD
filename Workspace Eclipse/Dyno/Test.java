//NB: Do not add a package

//NB: Importing classes in other packages is NOT ALLOWED.
//NB: Using classes in other packages in NOT ALLOWED (with the exception of the classes in java.lang.* that are imported by default)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Test {

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

	/**
	 * L is the length of the desert (positions in the desert are indexed from 0 to
	 * L-1) D is the distance Dino can jump, i.e., if Dino is at position p and it
	 * jumps, it lands at position p+D. C is the number of cacti in the desert cacti
	 * is an array of C elements containing the cacti positions, in increasing
	 * order.
	 **/
	public static int solve(final int L, final int D, final int C, final int[] cacti) {

		boolean[] besucht = new boolean[L];
		int maxL = 0;
		besucht[0] = true;
		for (int i = 0; i < L; i++) {
			if (besucht[i]) {
				maxL = i;
				int possible1 = binarySearch(cacti, i + 1);
				int possible2 = binarySearch(cacti, i + D);
				if (possible1 < 0) {

					besucht[i + 1] = true;

				}
				if (possible2 < 0) {

					besucht[i + D] = true;

				}

			}

		}

		return maxL;
	}

	public static void main(String[] args) throws FileNotFoundException {
		long start = System.currentTimeMillis();

		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
		int ntestcases = scanner.nextInt();

		for (int testno = 0; testno < ntestcases; testno++) {
			int L = scanner.nextInt();
			int D = scanner.nextInt();
			int C = scanner.nextInt();

			int[] cacti = new int[C];
			for (int j = 0; j < C; j++) {
				cacti[j] = scanner.nextInt();
			}

			System.out.println(solve(L, D, C, cacti));
		}
		long finish = System.currentTimeMillis() - start;
		System.out.println("Zeit:" + finish);

		scanner.close();
	}
}
