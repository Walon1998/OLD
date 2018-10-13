public class Point {
	int x;
	int y;

	@Override
	public String toString() {
		return "( " + x + ", " + y + " )";
	}

	public double distance() {
		// distance to (0, 0)
		return Math.sqrt((x * x) + (y * y));
	}

	public double distance(Point other) {
		// distance to other
		return Math.sqrt(((x - other.x) * (x - other.x)) + ((y - other.y) * (y - other.y)));
	}
}