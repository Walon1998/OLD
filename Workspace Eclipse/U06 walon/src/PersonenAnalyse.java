import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * Author: Maximiliana Muster
 * für Einführung in die Programmierung
 *
 * Analysiert einen Datensatz von Personen-Eigenschaften. Findet "ungesunde" Personen und teilt
 * alle Personen in Trainingspartner-Paare ein.
 */
public class PersonenAnalyse {
	static Person[] array;
	static int datensätze;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("body.dat.txt"));
		liesPersonen(scanner);
		PrintStream file = new PrintStream(new File("ungesund.txt"));
		druckeUngesunde(array, file);
		druckeGuteTrainingpartner();

	}

	private static void druckeGuteTrainingpartner() {
		for (int j = 0; j < (array.length); j++) {
			for (int i = j + 1; i < (array.length); i++) {
				if (partnerQualitaet(array[j], array[i]) > 0.8) {
					System.out.println(array[j].beschreibung());
					System.out.println(array[i].beschreibung());
					System.out.println("Qualität: " + partnerQualitaet(array[j], array[i]) + "\n");
				}
			}

		}
	}

	/**
	 * Liest die Personen-Daten von dem gegebenen Scanner ein und gibt sie als
	 * Person[] zurück.
	 */
	static Person[] liesPersonen(Scanner scanner) {

		datensätze = scanner.nextInt();
		array = new Person[datensätze];
		for (int i = 0; i < array.length; i++) {
			double Schulterbreite = scanner.nextDouble();
			double brustTiefe = scanner.nextDouble();
			double brustBreite = scanner.nextDouble();
			int alter = scanner.nextInt();
			double gewicht = scanner.nextDouble();
			double groesse = scanner.nextDouble();
			int istMaennlich = scanner.nextInt();

			boolean maennlich;
			if (istMaennlich == 1) {
				maennlich = true;
			} else {
				maennlich = false;
			}
			array[i] = new Person(alter, gewicht, groesse, maennlich, Schulterbreite, brustTiefe, brustBreite);

		}

		return null;
	}

	/**
	 * Findet alle Personen, die nicht normalgewichtig sind und gibt deren
	 * Beschreibungen, sowie die entsprechende Gewichts-Klassen aus.
	 */
	static void druckeUngesunde(Person[] personen, PrintStream ausgabe) {
		for (int i = 0; i < personen.length; i++) {

			if (personen[i].bodyMassIndex() >= 30) {
				ausgabe.println(personen[i].beschreibung() + " ist fettleibig");
			} else if (personen[i].bodyMassIndex() > 25) {
				ausgabe.println(personen[i].beschreibung() + " ist übergewichtig");

			} else if (personen[i].bodyMassIndex() < 18.5) {
				ausgabe.println(personen[i].beschreibung() + " ist untergewichtig");
			}
		}

	}

	/**
	 * Gibt die Partner-Qualität von zwei Trainingspartner p1 und p2 zurück. Wert
	 * liegt zwischen 0 (schlechtester Wert) und 1 (bester Wert).
	 */
	static double partnerQualitaet(Person p1, Person p2) {
		double groessenDiff = p1.groesse - p2.groesse;
		double brustDiff = (p1.brustTiefe * p1.brustBreite) - (p2.brustTiefe * p2.brustBreite);
		double schulterDiff = p1.schulterBreite - p2.schulterBreite;
		double Q = 1 / (1 + Math.pow(groessenDiff, 2) + (Math.abs(brustDiff) / 5) + (schulterDiff / 5));
		// System.out.println(Q);
		return Q;
	}
}