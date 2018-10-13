//NB: or the judge to run the program you must use the default package

//NB: Importing other classes is NOT ALLOWED
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Vorberechnung {

	// mountain_cities[i] is the position of the (i+1)-th mountain city
	// sea_cities[i] is the position of the (i+1)-th sea city
	// trip_beginning[i] and trip_end[i] are the beginning and ending kilometers of
	// the (i+1)-th trip
	// The number of elements of an array A can be accessed using A.length
	public static int solve(int n, int[] mountain_cities, int[] sea_cities, int[] trip_beginning, int[] trip_end) {
		int groesse = 9999999;
		Boolean[] isMountain = new Boolean[groesse + 1];
		long[][] ergebnis = new long[groesse + 1][groesse + 1];

		for (int i = 0; i < mountain_cities.length; i++) {
			isMountain[mountain_cities[i]] = true;

		}
		for (int i = 0; i < sea_cities.length; i++) {
			isMountain[sea_cities[i]] = false;

		}
		int maximumOld = 0;
		int maximumNew = 0;
		for (int i = 0; i < (groesse); i++) {
			// System.out.println(Arrays.deepToString(ergebnis));
			// System.out.println("\n");
			maximumNew = 0;
			for (int j = i; j < (groesse); j++) {
				if (isMountain[j] == null) {
					ergebnis[i][j] = maximumNew;
				} else if (isMountain[j] == true) {
					maximumNew++;
					ergebnis[i][j] = maximumNew;
				} else {
					maximumNew = 0;
					ergebnis[i][j] = maximumNew;
					j = groesse;
				}

			}

		}
		int bestTrip = 0;
		maximumNew = 0;
		maximumOld = 0;
		for (int i = 0; i < trip_beginning.length; i++) {
			maximumNew = (int) ergebnis[trip_beginning[i]][trip_end[i]];

			if (maximumNew > maximumOld) {
				maximumOld = maximumNew;
				bestTrip = i + 1;
			}
		}

		return bestTrip;
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
			// System.out.println("Trips: " + T);
			System.out.println(solve(n, mountain_cities, sea_cities, trip_beginning, trip_end));
		}

		scanner.close();
	}
}
