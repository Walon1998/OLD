/**
 * Eine Person mit diversen Eigenschaften, inkl. Alter, Gewichts, Grösse,
 * Geschlecht und einigen spezielleren Körper-Eigenschaften.
 */
class Person {
	double schulterBreite;
	double brustTiefe;
	double brustBreite;
	int alter;
	double gewicht;
	double groesse;
	boolean istMaennlich;

	/**
	 * Erstellt eine neue Person mit den gegebenen Werten für die Eigenschaften.
	 */
	Person(int alter, double gewicht, double groesse, boolean istMaennlich, double schulterBreite, double brustTiefe,
			double brustBreite) {
		this.alter = alter;
		this.gewicht = gewicht;
		this.groesse = groesse;
		this.istMaennlich = istMaennlich;
		this.schulterBreite = schulterBreite;
		this.brustTiefe = brustTiefe;
		this.brustBreite = brustBreite;

	}

	String beschreibung() {

		String geschlecht;
		if (istMaennlich) {
			geschlecht = "m";
		} else {
			geschlecht = "f";
		}

		return "Person( " + geschlecht + ", " + alter + " Jahre, " + groesse + " cm, " + gewicht + " kg)";
	}

	double bodyMassIndex() {
		double BMI = ((gewicht / Math.pow(groesse / 100, 2)));
		return BMI;
	}

}
