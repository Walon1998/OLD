
public class Lake extends PointOfInterest {

	double area;
	int depth;

	Lake(SwissMap SwissMap, String name, int east, int north, double area, int depth) {
		super(SwissMap, name, east, north);
		this.area = area;
		this.depth = depth;
	}

	@Override
	String description() {
		return super.description() + " (" + area + " km², " + depth + " m tief)";
	}
}