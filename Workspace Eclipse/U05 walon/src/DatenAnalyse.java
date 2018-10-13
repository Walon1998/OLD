import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DatenAnalyse {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("groessen.txt"));
		int[] groessen = liesGroessen(scanner);
		scanner.close();

		einfacheAnalyse(groessen);

		int histMin = 140; // Wir nehmen an, dass alle Groessen >= 1.40m sind
		int histMax = 200; // Wir nehmen an, dass alle Groessen < 2.00m sind
		histogrammAnalyse(groessen, histMin, histMax);
	}

	/**
	 * Liest die Körpergrössen von dem gegebenen Scanner ein und gibt sie als Array
	 * zurück.
	 */
	static int[] liesGroessen(Scanner scanner) {
		int anzahlDaten = scanner.nextInt();
		int[] groessen = new int[anzahlDaten];
		for (int i = 0; i < anzahlDaten; i++) {
			int groesse = scanner.nextInt();
			groessen[i] = groesse;
		}
		return groessen;
	}

	/**
	 * Macht eine einfache Datenanalyse: Gibt die Anzahl Daten, das Minimum, das
	 * Maximum und den Durchschnitt der Körpergrössen aus.
	 */
	static void einfacheAnalyse(int[] groessen) {
		System.out.println("Anzahl Daten: " + groessen.length);
		int oldmax = 0;
		int oldmin = 200;
		for (int i = 0; i < ((groessen.length)); i++) {
			int max = Math.max(groessen[i], oldmax);
			if (max > oldmax) {
				oldmax = max;
			}
			int min = Math.min(groessen[i], oldmin);
			if (oldmin > min) {
				oldmin = min;
			}
		}
		System.out.println("Maxium: " + oldmax);
		System.out.println("Minimum: " + oldmin);
	}

	/**
	 * Erstellt ein Histogramm der Körpergrössen und gibt es aus. Zuerst wird der
	 * Benutzer nach der Anzahl Histogramm-Klassen gefragt.
	 */
	static void histogrammAnalyse(int[] groessen, int histMin, int histMax) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Wieviele Klassen? ");
		int klassen = scanner.nextInt();
		int[] histogramm = erstelleHistogramm(groessen, histMin, histMax, klassen);
		System.out.print(Arrays.toString(histogramm));

	}

	/**
	 * Erstellt von den Körpergrössen in dem "groessen"-Array ein Histogramm mit den
	 * gegebenen Grössen Minimum, Maximum und Anzahl Klassen.
	 *
	 * @return das Histogramm, als Array. Jedes Element entspricht einer Klasse im
	 *         Histogramm und enthält die Anzahl Körpergrössen in dieser Klasse.
	 */
	static int[] erstelleHistogramm(int[] groessen, int histMin, int histMax, int klassen) {
		int breite = klassenBreite(histMin, histMax, klassen);
		int[] histogramm = new int[klassen];
		int untereGrenze = histMin;
		int obereGrenze = histMin + breite;
		for (int j = 0; j < klassen; j++) {

			for (int i = 0; i < groessen.length; i++) {
				if ((groessen[i] > untereGrenze) && (groessen[i] < obereGrenze)) {
					histogramm[j]++;
				}

			}
			untereGrenze = obereGrenze;
			obereGrenze += breite;
		}
		return histogramm;
	}

	/**
	 * Gibt die Klassenbreite in einem Histogramm mit den gegebenen Grössen Minimum,
	 * Maximum und Anzahl Klassen zurück. Falls sich die gesamte Breite des
	 * Histogramms nicht restlos auf die Klassen aufteilen lässt, wird die
	 * Klassenbreite aufgerundet. Das heisst, dass das Histogramm "histMax"
	 * überschreiten kann.
	 */
	static int klassenBreite(int histMin, int histMax, int klassen) {
		int abstand = 0;
		int wichtig = histMax - histMin;
		if ((wichtig % klassen) == 0) {
			abstand = wichtig / klassen;
		} else {
			abstand = (wichtig / klassen) + 1;
		}

		return abstand;
	}
}