public class RekursionBaum {
	private static final int SIZE = 1000;
	static double strokewith = 5;

	public static void main(String[] args) {

		Window window = new Window("Baum", SIZE, SIZE);

		double x0 = SIZE / 2;
		double y0 = (SIZE) - (SIZE / 10);
		double l0 = 100 * (SIZE / 750.0);
		double a0 = (Math.PI) / 2.0;
		window.setStrokeWidth(1);
		window.setColor(0, 0, 0);
		window.open();
		drawTree(x0, y0, l0, a0, window);
		window.waitUntilClosed();

	}

	public static void drawTree(double x, double y, double l, double a, Window window) {

		window.refresh(50);
		double x2 = -l * Math.sin(a - ((Math.PI) / 2.0));
		double y2 = l * Math.cos(a - ((Math.PI) / 2.0));
		window.setColor(0, 0, 0);
		window.setStrokeWidth(l / 20);
		window.drawLine(x, y, x + x2, y - y2);

		if (l < 10) {
			window.setColor(0, 255, 0);
			window.drawCircle(x + x2, y - y2, 1);
		} else {

			drawTree(x + x2, y - y2, l * 0.8, a + (Math.PI / 5.0), window);
			drawTree(x + x2, y - y2, l * 0.6, a - (Math.PI / 3.0), window);

		}

	}
}
