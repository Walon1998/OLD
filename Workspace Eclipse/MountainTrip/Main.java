//NB: or the judge to run the program you must use the default package

//NB: Importing other classes is NOT ALLOWED
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Main {

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

	public static int solve(int n, int[] mountain_cities, int[] sea_cities, int[] trip_beginning, int[] trip_end) {

		mergesort(mountain_cities);
		mergesort(sea_cities);

		int maximumOld = 0;
		int maximumNew = 0;
		int bestTrip = 0;
		for (int i = 0; i < trip_beginning.length; i++) {
			maximumNew = 0;

			int key = binarySearch(sea_cities, trip_beginning[i]);

			int key2 = binarySearch(sea_cities, trip_end[i]);

			if ((key == key2)) {
				maximumNew = countMountain(i, mountain_cities, sea_cities, trip_beginning, trip_end);
			}

			if (maximumNew > maximumOld) {
				maximumOld = maximumNew;
				bestTrip = i + 1;
			}

		}
		return bestTrip;
	}

	private static int countMountain(int i, int[] mountain_cities, int[] sea_cities, int[] trip_beginning,
			int[] trip_end) {

		int anfang = trip_beginning[i];
		int ende = trip_end[i];
		int key = 0;
		int key2 = 0;

		key = binarySearch(mountain_cities, anfang);

		key2 = binarySearch(mountain_cities, ende);

		if ((key > 0) && (key2 > 0)) {
			return (key2 - key) + 1;

		} else if ((key < 0) && (key2 > 0)) {
			key = (key * -1) - 1;
			return (key2 - key) + 1;

		} else if ((key > 0) && (key2 < 0)) {
			key2 = (key2 * -1);
			return (key2 - key) - 1;

		} else if (key == key2) {

			return 0;

		}
		return key - key2;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
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
