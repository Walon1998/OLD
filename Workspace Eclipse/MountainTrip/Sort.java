//NB: or the judge to run the program you must use the default package

//NB: Importing other classes is NOT ALLOWED
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Sort {

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

	static void mergesort(int A[]) {
		int B[] = new int[A.length];
		mergesort2(A, B, 0, A.length - 1);
	}

	static void mergesort2(int[] A, int[] B, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			mergesort2(A, B, left, middle);
			mergesort2(A, B, middle + 1, right);
			merge(A, B, left, middle + 1, right);

		}

	}

	static void merge(int[] A, int[] B, int left, int middle, int right) {

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

	// mountain_cities[i] is the position of the (i+1)-th mountain city
	// sea_cities[i] is the position of the (i+1)-th sea city
	// trip_beginning[i] and trip_end[i] are the beginning and ending kilometers of
	// the (i+1)-th trip
	// The number of elements of an array A can be accessed using A.length
	public static int solve(int n, int[] mountain_cities, int[] sea_cities, int[] trip_beginning, int[] trip_end) {
		int groesse = 0;
		Boolean[] isMountain = new Boolean[9999999];

		mergesort(mountain_cities);
		mergesort(sea_cities);

		int maximumOld = 0;
		int maximumNew = 0;
		int bestTrip = 0;
		for (int i = 0; i < trip_beginning.length; i++) {
			maximumNew = 0;

			// int key = Arrays.binarySearch(sea_cities, trip_beginning[i]);
			int key = binarySearch(sea_cities, trip_beginning[i]);

			// System.out.println(key);
			// int key2 = Arrays.binarySearch(sea_cities, trip_end[i]);

			int key2 = binarySearch(sea_cities, trip_end[i]);

			// System.out.println(key2);

			if ((key == key2) && (key < 0) && (key2 < 0)) {
				maximumNew = countMountain(i, mountain_cities, sea_cities, trip_beginning, trip_end);

				// System.out.println("si");
			}

			if (maximumNew > maximumOld) {
				maximumOld = maximumNew;
				bestTrip = i + 1;
			}

		}

		// TODO Return the best trip
		// Keep in mind that the i-th trip in the input has index i-1 in the arrays
		// trip_beginning and trip_end
		// System.out.println("Road: " + n);
		// System.out.println("Begin: " + trip_beginning[bestTrip - 1]);
		// System.out.println("End: " + trip_end[bestTrip - 1]);

		return bestTrip;
	}

	private static int countMountain(int i, int[] mountain_cities, int[] sea_cities, int[] trip_beginning,
			int[] trip_end) {
		int anfang = trip_beginning[i];
		int ende = trip_end[i];
		int key = 0;
		int key2 = 0;

		do {
			// key = Arrays.binarySearch(mountain_cities, anfang);
			key = binarySearch(mountain_cities, anfang);
			anfang++;
		} while ((key < 0) && (anfang < trip_end[i]));

		do {
			// key2 = Arrays.binarySearch(mountain_cities, ende);
			key2 = binarySearch(mountain_cities, ende);
			ende--;
		} while ((key2 < 0) && (ende > trip_beginning[i]));

		// System.out.println(key);

		// int key2 = Arrays.binarySearch(mountain_cities, trip_end[i]);

		// System.out.println(key2);

		if ((key > 0) && (key2 > 0)) {
			return Math.abs(key - key2) + 1;
		} else if (key2 > 0) {
			return 1;

		} else {
			return 0;
		}

		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
		int ntestcases = scanner.nextInt();

		for (int testno = 0; testno < ntestcases; testno++) {
			int n = scanner.nextInt();
			int M = scanner.nextInt();
			int S = scanner.nextInt();
			int T = scanner.nextInt();

			int[] mountain_cities = new int[M];
			for (int i = 0; i < M; i++) {
				mountain_cities[i] = scanner.nextInt();
			}

			int[] sea_cities = new int[S];
			for (int i = 0; i < S; i++) {
				sea_cities[i] = scanner.nextInt();
			}

			int[] trip_beginning = new int[T];
			for (int i = 0; i < T; i++) {
				trip_beginning[i] = scanner.nextInt();
			}

			int[] trip_end = new int[T];
			for (int i = 0; i < T; i++) {
				trip_end[i] = scanner.nextInt();
			}

			System.out.println(solve(n, mountain_cities, sea_cities, trip_beginning, trip_end));
		}

		scanner.close();
	}
}
