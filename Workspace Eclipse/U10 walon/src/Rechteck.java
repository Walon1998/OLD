
public class Rechteck extends Form {

	int breite;
	int hoehe;

	public Rechteck(Koordinate koordinate, int breite, int hoehe) {
		super(koordinate);
		this.breite = breite;
		this.hoehe = hoehe;

	}

	@Override
	public int flaeche() {
		return breite * hoehe;

	}

	public int diagonale() {
		return (int) Math.sqrt(Math.pow(breite, 2) + Math.pow(hoehe, 2));

	}

	@Override
	public String toString() {
		return "Rechteck(" + koordinate.toString() + ", " + breite + ", " + hoehe + ")";
	}

}
