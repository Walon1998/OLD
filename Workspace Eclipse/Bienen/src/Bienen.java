import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Scanner;

public class Bienen {
	// public static void main (String args[]) throws FileNotFoundException {
	// Scanner scanner = new Scanner(new File("bienen.txt"));
	// Scanner scanner2 = new Scanner(new File("bienen.txt"));
	// Scanner scanner3 = new Scanner(new File("bienen.txt"));
	// System.out.println(höchsteGesamtzahlung1(scanner));
	// System.out.println(höchsterProzent2(scanner2));
	// System.out.println(bestesLand3(scanner3));
	// }

	/**
	 * Liest die Bienenzüchterdaten aus der Datei <code>input</code>, analysiert sie
	 * und schreibt die Resultate in die Datei <code>output</code>.
	 */
	public static void analyze(final File input, final File output) throws FileNotFoundException {
		final Scanner scanner = new Scanner(input);
		final Scanner scanner2 = new Scanner(input);
		final Scanner scanner3 = new Scanner(input);

		final PrintStream ausgabe = new PrintStream(output);

		ausgabe.println(Bienen.höchsteGesamtzahlung1(scanner));

		ausgabe.println(Bienen.höchsterProzent2(scanner2));

		ausgabe.println(Bienen.bestesLand3(scanner3));
		ausgabe.close();
		scanner.close();
	}

	private static String bestesLand3(final Scanner scanner) {
		final Hashtable<String, Integer> table = new Hashtable<>();

		String bester = null;
		int max = 0;
		int NewMax = 0;
		while (scanner.hasNext()) {
			scanner.next();
			// System.out.println(name);
			final String land = scanner.next();
			scanner.nextInt();
			// System.out.println(Sitzungsgelder);
			final int Sonderzahlungen = scanner.nextInt();
			// System.out.println(Sonderzahlungen);
			// System.out.println(table);

			if (!table.containsKey(land)) {
				table.put(land, Sonderzahlungen);
				NewMax = Sonderzahlungen;
			} else {
				final int erster = table.get(land);
				table.put(land, Sonderzahlungen + erster);
				NewMax = Sonderzahlungen + erster;
			}

			if (NewMax > max) {
				bester = land;
				max = NewMax;
			}

		}

		return bester + " " + max;

	}

	private static String höchsterProzent2(final Scanner scanner) {
		String bester = null;
		int max = 0;
		while (scanner.hasNext()) {

			final String name = scanner.next();
			scanner.next();
			// System.out.println(land);
			final int Sitzungsgelder = scanner.nextInt();
			// System.out.println(Sitzungsgelder);
			final int Sonderzahlungen = scanner.nextInt();
			// System.out.println(Sonderzahlungen);
			final int NewMax = (Sonderzahlungen * 100) / (Sitzungsgelder + Sonderzahlungen);
			if (NewMax > max) {
				bester = name;
				max = NewMax;
			}

		}

		return bester + " " + max;

	}

	private static String höchsteGesamtzahlung1(final Scanner scanner) {
		String bester = null;
		int max = 0;
		while (scanner.hasNext()) {

			final String name = scanner.next();
			scanner.next();
			// System.out.println(land);
			final int Sitzungsgelder = scanner.nextInt();
			// System.out.println(Sitzungsgelder);
			final int Sonderzahlungen = scanner.nextInt();
			// System.out.println(Sonderzahlungen);
			final int NewMax = Sitzungsgelder + Sonderzahlungen;
			if (NewMax > max) {
				bester = name;
				max = NewMax;
			}

		}
		return bester + " " + max;
	}
}