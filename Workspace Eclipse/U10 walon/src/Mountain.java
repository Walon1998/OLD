
public class Mountain extends PointOfInterest {

	int height;

	Mountain(SwissMap SwissMap, String name, int east, int north, int height) {
		super(SwissMap, name, east, north);
		this.height = height;
	}

	@Override
	String description() {
		return super.description() + " (" + height + " m.ü.M.)";
	}
}