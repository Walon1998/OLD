
public class City extends PointOfInterest {

	int inhabitants;
	double area;

	City(SwissMap SwissMap, String name, int east, int north, int inhabitants, double area) {
		super(SwissMap, name, east, north);
		this.inhabitants = inhabitants;
		this.area = area;
	}

	@Override
	String description() {
		return super.description() + " (" + inhabitants + " Einw., " + area + " km²)";
	}
}