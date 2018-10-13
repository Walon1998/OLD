import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Neville Walo
 * für Einführung in die Programmierung
 *
 * Liest eine Höhenserie aus einer Datei und lokalisiert den höchsten Gipfel
 */

public class Gipfel {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("gipfelhoehen.txt"));
		int[] hoehen = liesHoehen(scanner);
		scanner.close();
		int[] test = { 2, 1, 2, 5, 4, 3, 4, 6, 5, 6 };
		System.out.println("Höchste Erhebung: " + findeGroessteErhebung(hoehen) + " m");
	}

	/**
	 * Lies die Höhen aus dem übergebenen Scanner.
	 */
	static int[] liesHoehen(Scanner scanner) {
		int[] hoehen = new int[scanner.nextInt()];
		for (int i = 0; i < hoehen.length; i++) {
			hoehen[i] = scanner.nextInt();
		}
		return hoehen;
	}

	/**
	 * Sucht im Array 'hoehen' nach der grössten "Erhebung" und gibt diese zurück
	 */
	static int findeGroessteErhebung(int[] hoehen) {
		// Variablendekl.
		int k = 0, j = 0;
		int[] hoeheGipfel = new int[hoehen.length];
		boolean[] istGipfel = new boolean[hoehen.length];
		boolean[] istTal = new boolean[hoehen.length];

		// Findet Gipfel und Täler
		for (int i = 1; i < (hoehen.length - 1); i++) {
			if ((hoehen[i] > hoehen[i + 1]) && (hoehen[i] > hoehen[i - 1])) {
				istGipfel[i] = true;
			} else if ((hoehen[i] < hoehen[i + 1]) && (hoehen[i] < hoehen[i - 1])) {
				istTal[i] = true;
			}
		}
		// Für jeden Gipfel...
		for (int i = 0; i < hoehen.length; i++) {
			if (istGipfel[i]) {
				boolean notFoundYet = true;
				j = i;
				// Findet linkes Tal an stelle j
				// Wahrscheinlich auch als for schleife möglich ;)
				while ((j >= 1) && notFoundYet) {
					j--;
					if (istTal[j]) {
						notFoundYet = false;
					}

				}

				notFoundYet = true;
				// Findet rechtes Tal an Stelle k
				// Wahrscheinlich auch als for schleife möglich ;)
				k = i;
				while ((k < (hoehen.length - 1)) && notFoundYet) {
					k++;
					if (istTal[k]) {
						notFoundYet = false;
					}

				}
				// Speicheret den kleineren der beiden Werte

				int hoehe1 = hoehen[i] - hoehen[j];
				int hoehe2 = hoehen[i] - hoehen[k];

				// Falls kein linkes oder rechtes Tal existiert = 0
				if ((j == 0) || (k == hoehen.length)) {
					hoeheGipfel[i] = 0;
				} else if (hoehe2 > hoehe1) {
					hoeheGipfel[i] = hoehe1;
				} else {
					hoeheGipfel[i] = hoehe2;
				}

			}

		}
		int max = 0;
		// liest den grössten aus
		for (int i = 0; i < hoehen.length; i++) {
			if (hoeheGipfel[i] > max) {
				max = hoeheGipfel[i];
			}
		}

		return max;
	}

}
