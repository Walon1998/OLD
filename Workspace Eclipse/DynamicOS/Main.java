//NB: Do not add a package

//NB: Importing classes in other packages is NOT ALLOWED.
//NB: Using classes in other packages in NOT ALLOWED (with the exception of the classes in java.lang.* that are imported by default)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Main {
	static int alpha;// This parameter alpha of the problem definition
	static int[] array;
	static double A;

	// Sets A to the empty set and sets up the structure to handle up to n "add"
	// operations
	static void reset(int n) {
		array = new int[n + 1];
		A = 0;
		// TODO: Implement this method
	}

	// Adds x to A
	static void add(int x) {
		int stelle = -binarySearch(array, 0, (int) A, x) - 1;
		for (int i = (int) (A - 1); i >= (stelle); i--) {

			array[i + 1] = array[i];

		}

		array[stelle] = x;
		A++;
		// System.out.println(Arrays.toString(array));
		// TODO: Implement this method
	}

	// Returns the k-th order statistic of A for k = |A|/alpha, rounded up
	static int query() {
		int[] test = new int[1];
		System.out.print(test[9]);

		// System.out.println(Math.ceil(A / alpha));
		// TODO: Implement this method
		return array[(int) Math.ceil(A / alpha) - 1];
	}

	static int binarySearch(int[] A, int from, int to, int k) {
		if (from > 0) {
			from = 0;
		}
		if (to > (A.length - 1)) {
			to = A.length - 1;
		}
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

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
		alpha = scanner.nextInt();

		int noperations = scanner.nextInt();
		for (int i = 0; i < noperations; i++) {
			String operation = scanner.next();
			if (operation.equals("R")) {
				int n = scanner.nextInt();
				reset(n);
			} else if (operation.equals("A")) {
				int x = scanner.nextInt();
				add(x);
			} else if (operation.equals("Q")) {
				System.out.println(query());
			} else {
				throw new RuntimeException("Unknown operation");
			}
		}

		scanner.close();
	}
}
