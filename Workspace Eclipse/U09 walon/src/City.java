
public class City extends PointOfInterest {
	int Einwohnerzahl;
	double Flaeche;

	City(String name, int east, int north, int Einwohnerzahl, double Flaeche) {
		super(name, east, north);
		this.Einwohnerzahl = Einwohnerzahl;
		this.Flaeche = Flaeche;

	}

	@Override
	Color color() {
		return new Color(255, 0, 0);
	}

	/**
	 * Returns the description that should be displayed for this point.
	 */
	@Override
	String description() {
		return (name + "( " + Flaeche + " km^2, " + Einwohnerzahl + " Einwohner )");
	}

}
