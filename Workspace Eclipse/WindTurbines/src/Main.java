
//NB: KEIN Paket hinzufügen!
//NB: Es ist NICHT ERLAUBT, andere Klassen zu importieren.
//NB: Es ist NICHT ERLAUBT, andere Klassen die nicht zu java.lang.* gehören zu verwenden.

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// BITTE VERÄNDERN SIE DIE ZEILEN OBERHALB NICHT!

// NB: Bitte verändern Sie die untenstehenden Deklarationen der Klasse Main und der Methode main() NICHT, um das Programm auf dem Judge laufen zu lassen.
// Die Klasse muss als "class Main { ... }" deklariert sein.
// Die Methode muss als "public static void main(String[] args) { ... }" deklariert sein.

class Main {
	// n ist die Anzahl möglicher Positionen für die Windturbinen
	// D ist der Mindestabstand zwischen zwi Windturbinen
	// Für i=1,...,n gilt: die Elemente d[i] and e[i] sind Position und Energie der
	// i-ten Turbine.
	// d[0] und e[0] werden nicht benützt und sind gleich 0.
	static int solve(int n, int D, int[] d, int[] e) {
		int realMax = 0;
		int[] nutzen = new int[n + 1];
		int[] five = new int[n + 1];

		for (int i = 0; i < (n + 1); i++) {

			if ((d[i] - D) >= 0) {
				int j = i;

				while ((d[i] - d[j]) < D) {
					j--;

				}
				nutzen[i] = five[j] + e[i];
			} else {
				nutzen[i] = +e[i];
			}

			if (nutzen[i] > realMax) {
				realMax = nutzen[i];
			}
			five[i] = realMax;
		}
		// System.out.println(Arrays.toString(five));
		// System.out.println(Arrays.toString(nutzen));
		return realMax;

	}

	public static void main(String[] args) throws FileNotFoundException {
		read_and_solve(System.in, System.out);
	}

	public static void read_and_solve(InputStream istream, PrintStream output) throws FileNotFoundException {
		Scanner scanner = new Scanner(istream);

		int ntestcases = scanner.nextInt();
		for (int t = 0; t < ntestcases; t++) {
			int n = scanner.nextInt();
			int D = scanner.nextInt();
			int[] d = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				d[i] = scanner.nextInt();
			}

			int[] e = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				e[i] = scanner.nextInt();
			}

			output.println(solve(n, D, d, e));
		}

		scanner.close();
	}
}