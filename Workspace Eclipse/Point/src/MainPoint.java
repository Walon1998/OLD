public class MainPoint {
	public static void main(String[] args) {
		Point p1 = new Point();
		p1.x = 3;
		p1.y = 4;
		System.out.println("distance to (0,0): " + p1.distance());
		Point p2 = new Point();
		p2.x = 5;
		p2.y = 12;
		System.out.print(p2.toString());
		System.out.print(p2.distance());
	}
}