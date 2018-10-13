
public class Quadrat extends Rechteck {

	public Quadrat(Koordinate koordinate, int seitenlange) {
		super(koordinate, seitenlange, seitenlange);

	}

	@Override
	public String toString() {
		return "Quadrat(" + koordinate.toString() + ", " + breite + ")";
	}

}
