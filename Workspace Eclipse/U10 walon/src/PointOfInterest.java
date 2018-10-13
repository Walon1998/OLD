public class PointOfInterest implements Drawable, Hoverable {

	/**
	 * Name of this POI
	 */
	String name;

	/**
	 * East coordinate of this POI. Coordinates are in the Swiss coordinate system
	 * (see <a href=
	 * "https://en.wikipedia.org/wiki/Swiss_coordinate_system">Wikipedia</a>)
	 */
	int east;

	/**
	 * North coordinate of this POI. Coordinates are in the Swiss coordinate system
	 * (see <a href=
	 * "https://en.wikipedia.org/wiki/Swiss_coordinate_system">Wikipedia</a>)
	 */
	int north;
	SwissMap SwissMap;
	boolean anzeigen = false;

	PointOfInterest(SwissMap SwissMap, String name, int east, int north) {
		this.SwissMap = SwissMap;
		this.name = name;
		this.east = east;
		this.north = north;

	}

	/**
	 * Returns the description that should be displayed for this POI.
	 */
	String description() {
		return name;
	}

	@Override
	public void draw(Window window) {
		if (SwissMap.nightMode) {
			window.setColor(233, 233, 233);
		} else {
			window.setColor(0, 0, 0);
		}

		if (anzeigen) {
			window.fillCircle(SwissMap.toGuiX(east), SwissMap.toGuiY(north), window.getHeight() / 100);
			window.setFontSize((int) window.getHeight() / 50);
			window.drawString(description(), SwissMap.toGuiX(east) + 10, SwissMap.toGuiY(north) - 10);
		} else {
			window.fillCircle(SwissMap.toGuiX(east), SwissMap.toGuiY(north), window.getHeight() / 200);
		}

	}

	@Override
	public Rectangle getBoundingBox() {
		int radius = 10;
		double x = SwissMap.toGuiX(east) - radius;
		// System.out.println(x);

		double y = (int) SwissMap.toGuiY(north) - radius;
		// System.out.println(y);

		return new Rectangle(x, y, 2 * radius, 2 * radius);

	}

	@Override
	public void onMouseEnter() {
		anzeigen = true;
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseExit() {
		anzeigen = false;
		int groesse = 100;
		// TODO Auto-generated method stub

	}
}