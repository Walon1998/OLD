import java.util.Random;

public class Person {
	int warenkorbgroesse;
	int faulheit;
	int zeit;
	int warenkorbAnfang;

	/**
	 * Erstellt eine neue Person mit den gegebenen Werten für die Eigenschaften.
	 */
	Person(int faulheit, int maxWarenkorbgroesse) {
		Random R = new Random();
		warenkorbgroesse = R.nextInt(maxWarenkorbgroesse);
		this.faulheit = faulheit;
		this.warenkorbAnfang = warenkorbgroesse;
	}

}
