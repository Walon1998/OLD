public class Uhr {
	private static final int SIZE = 400;

	public static void main(String[] args) {
		Window window = new Window("Uhr", SIZE, SIZE);
		window.open();
		int SekundenzeigerLänge = 80;
		int MinutenzeigerLänge = 80;
		int StundenzeigerLänge = 55;

		int SekundenzeigerX2;
		int SekundenzeigerY2;
		int MinutenzeigerX2;
		int MinutenzeigerY2;
		int StundenzeigerX2;
		int StundenzeigerY2;

		while (window.isOpen()) {

			long milisekunden = System.currentTimeMillis();
			double sekundenNow2 = (int) (milisekunden / 1000) % 60;
			double sekundenNow = (int) (milisekunden / 1000);
			double minutenNow = sekundenNow / 60;
			double stundenNow = (minutenNow / 60) + 2;

			double winkelSekunden = sekundenNow2 * -6;
			double winkelMinuten = minutenNow * -6;
			double winkelStunden = stundenNow * -30;

			window.setColor(220, 220, 220);
			window.fillCircle(SIZE / 2, SIZE / 2, 100);
			// Stunden
			window.setStrokeWidth(5);
			window.setColor(0, 0, 0);
			StundenzeigerX2 = (int) (-((int) (StundenzeigerLänge * Math.sin((winkelStunden * Math.PI) / 180))));
			StundenzeigerY2 = (int) (((int) (StundenzeigerLänge * Math.cos((winkelStunden * Math.PI) / 180))));
			window.drawLine(SIZE / 2, SIZE / 2, (SIZE / 2) + StundenzeigerX2, (SIZE / 2) - StundenzeigerY2);
			// Minuten
			MinutenzeigerX2 = (int) (-((int) (MinutenzeigerLänge * Math.sin((winkelMinuten * Math.PI) / 180))));
			MinutenzeigerY2 = (int) (((int) (MinutenzeigerLänge * Math.cos((winkelMinuten * Math.PI) / 180))));
			window.drawLine(SIZE / 2, SIZE / 2, (SIZE / 2) + MinutenzeigerX2, (SIZE / 2) - MinutenzeigerY2);
			// Sekunden
			window.setStrokeWidth(1);
			SekundenzeigerX2 = (int) (-((int) (SekundenzeigerLänge * Math.sin((winkelSekunden * Math.PI) / 180))));
			SekundenzeigerY2 = (int) (((int) (SekundenzeigerLänge * Math.cos((winkelSekunden * Math.PI) / 180))));
			window.drawLine(SIZE / 2, SIZE / 2, (SIZE / 2) + SekundenzeigerX2, (SIZE / 2) - SekundenzeigerY2);

			window.refreshAndClear(20);
		}
	}

}
