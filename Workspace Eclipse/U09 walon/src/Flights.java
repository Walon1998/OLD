import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Flights {

	public static void main(String[] args) throws FileNotFoundException {
		calculateMiles(new File("flights.txt"), new File("miles.txt"));
	}

	/**
	 * Liest eine Datei 'input' mit Flügen von Personen ein, berechnet die Anzahl
	 * Meilen pro Person und schreibt das Resultat in eine Datei 'output'.
	 *
	 * Verändern Sie <b>nicht</b> die Signatur dieser Methode.
	 */
	public static void calculateMiles(File input, File output) throws FileNotFoundException {

		Scanner eingabe = new Scanner(input);
		PrintStream ausgabe = new PrintStream(output);
		String nextLine;
		int meilen;
		int gesamt;

		while (eingabe.hasNextLine()) {
			meilen = 0;
			gesamt = 0;

			String name = eingabe.nextLine();
			ausgabe.print(name + ": ");

			while (eingabe.hasNextLine()) {
				nextLine = eingabe.nextLine();
				Scanner scanner = new Scanner(nextLine);
				if (nextLine.equals(".")) {
					ausgabe.println(gesamt);
					break;
				} else {
					for (int i = 0; i < 2; i++) {
						scanner.next();
					}
					String klasse = scanner.next();
					if (scanner.hasNext()) {
						meilen = scanner.nextInt();
					} else {
						meilen = 125;
					}
					if (klasse.equals("BUSINESS")) {
						meilen *= 2;
					} else if (klasse.equals("FIRST")) {
						meilen *= 3;
					}
					gesamt += meilen;
				}

			}

		}

	}

}
