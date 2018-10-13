import java.util.HashSet;

/**
 * @author Neville Walo
 *
 * Datum: 19.08.2018
 */
public class Rezept {
	HashSet<String> Zutaten;
	String name;
	int time;
	double rating; // from 0 to 5
	String Rezept;

	Rezept(String name, HashSet<String> Zutaten, int time) {
		this.name = name;
		this.Zutaten = Zutaten;
		this.time = time;
		rating = 0;
		Rezept = "Mache Blabla";
	}

	@Override
	public String toString() {

		return name;

	}
}
