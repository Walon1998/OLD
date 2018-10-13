
public class Lake extends PointOfInterest {

	double Flaeche;
	int Tiefe;

	Lake(String name, int east, int north, double Flaeche, int Tiefe) {
		super(name, east, north);
		this.Flaeche = Flaeche;
		this.Tiefe = Tiefe;

	}

	@Override
	Color color() {
		return new Color(0, 0, 255);
	}

	/**
	 * Returns the description that should be displayed for this point.
	 */
	@Override
	String description() {
		return (name + "( " + Flaeche + "km^2, " + Tiefe + " Tief )");
	}
}
