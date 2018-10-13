
public class Mountain extends PointOfInterest {
	int Hoehe;

	Mountain(String name, int east, int north, int Hoehe) {
		super(name, east, north);
		this.Hoehe = Hoehe;
		// TODO Auto-generated constructor stub
	}

	@Override
	Color color() {
		return new Color(111, 111, 111);
	}

	/**
	 * Returns the description that should be displayed for this point.
	 */
	@Override
	String description() {
		return (name + "( " + Hoehe + " Meter )");
	}

}
