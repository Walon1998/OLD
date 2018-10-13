import java.util.LinkedList;
import java.util.Random;

public class RandomWalks {
	private static final int SIZE = 500;
	// STRASSE muss ungerade sein!
	private static final int STRASSE = 99;
	private static final int testInstanzen = 100;

	static int fliehenZaehler = 0;
	static int fliehenWeglaenge = 0;
	static int nichtFliehenWeglaenge = 0;

	static Window window = new Window("Self-avoiding Random Walks", SIZE, SIZE);

	public static void main(String[] args) {

		drawGitter();
		for (int i = 0; i < testInstanzen; i++) {
			testen();
		}

		double prozent = ((double) fliehenZaehler / (double) testInstanzen) * 100;

		System.out.println("Der Wolf konnte " + prozent + "% von " + testInstanzen + " Versuchen gewinnen.");
		System.out.println("Die Grösse betrug: " + STRASSE + " Strassen");
		if (fliehenZaehler > 0) {
			double durschschnittFliehen = (double) (fliehenWeglaenge / (double) (fliehenZaehler)) + 1;
			System.out.println("Die Durchschnittslänge der erfolgreichen Pfaden beträgt: " + durschschnittFliehen);
		}
		if (fliehenZaehler != testInstanzen) {
			double durschschnittnichtFliehen = (double) (nichtFliehenWeglaenge
					/ (double) (testInstanzen - fliehenZaehler)) + 1;
			System.out.println(
					"Die Durchschnittslänge der nicht erfolgreichen Pfaden beträgt: " + durschschnittnichtFliehen);

		}

		window.open();
		window.waitUntilClosed();
	}

	public static void drawGitter() {

		window.setStrokeWidth(1);
		window.setColor(170, 170, 170);

		double abstand = (750 / STRASSE) * (SIZE / 710.0);

		for (int i = 1; i < ((STRASSE / 2) + 1); i++) {
			window.drawLine((SIZE / 2) - (((STRASSE / 2)) * abstand), (SIZE / 2) - (i * abstand),
					(SIZE / 2) + (((STRASSE / 2)) * abstand), (SIZE / 2) - (i * abstand));
		}
		for (int i = 0; i < ((STRASSE / 2) + 1); i++) {
			window.drawLine((SIZE / 2) - (((STRASSE / 2)) * abstand), (SIZE / 2) - (i * -abstand),
					(SIZE / 2) + (((STRASSE / 2)) * abstand), (SIZE / 2) - (i * -abstand));
		}

		for (int i = 1; i < ((STRASSE / 2) + 1); i++) {
			window.drawLine((SIZE / 2) - (i * abstand), (SIZE / 2) - (((STRASSE / 2)) * abstand),
					(SIZE / 2) - (i * abstand), (SIZE / 2) + (((STRASSE / 2)) * abstand));
		}
		for (int i = 0; i < ((STRASSE / 2) + 1); i++) {
			window.drawLine((SIZE / 2) + (i * abstand), (SIZE / 2) - (((STRASSE / 2)) * abstand),
					(SIZE / 2) + (i * abstand), (SIZE / 2) + (((STRASSE / 2)) * abstand));
		}

	}

	public static void testen() {
		LinkedList list = new LinkedList();
		Random R = new Random();
		boolean verloren = false;
		int moeglichkeiten = 0;
		boolean[][] stadt = new boolean[STRASSE][STRASSE];
		int positionX = (STRASSE - 1) / 2;
		int positionY = (STRASSE - 1) / 2;

		while ((positionY > 0) && (positionX > 0) && (positionX < (STRASSE - 1)) && (positionY < (STRASSE - 1))) {

			stadt[positionX][positionY] = true;
			moeglichkeiten = 0;

			Integer[] possible = new Integer[4];

			for (int i = 0; i < possible.length; i++) {
				possible[i] = null;
			}

			if (((positionX + 1) <= STRASSE) && (stadt[positionX + 1][positionY] == false)) {
				possible[moeglichkeiten] = 2;
				moeglichkeiten++;
			}
			if (((positionX - 1) >= 0) && (stadt[positionX - 1][positionY] == false)) {
				possible[moeglichkeiten] = 3;
				moeglichkeiten++;

			}
			if (((positionY + 1) <= STRASSE) && (stadt[positionX][positionY + 1] == false)) {
				possible[moeglichkeiten] = 0;
				moeglichkeiten++;

			}
			if (((positionY - 1) >= 0) && (stadt[positionX][positionY - 1] == false)) {
				possible[moeglichkeiten] = 1;
				moeglichkeiten++;
			}

			if (moeglichkeiten == 0) {

				verloren = true;
				break;
			}
			int weg = R.nextInt(moeglichkeiten);

			int wegreal = possible[weg];

			list.addLast(wegreal);

			if (wegreal == 0) {

				positionY++;
			} else if (wegreal == 1) {

				positionY--;

			} else if (wegreal == 2) {

				positionX++;

			} else if (wegreal == 3) {
				positionX--;

			}

		}

		if (verloren) {
			nichtFliehenWeglaenge += list.size();
		} else {
			fliehenZaehler++;
			fliehenWeglaenge += list.size();
		}
		draw(verloren, list);
	}

	public static void draw(boolean verloren, LinkedList list) {
		double abstand = (750 / STRASSE) * (SIZE / 710.0);
		double positionX = SIZE / 2;
		double positionY = SIZE / 2;
		int size = list.size();
		window.setStrokeWidth(1);

		if (verloren == true) {
			window.setColor(255, 0, 0);

		} else {
			window.setColor(0, 255, 0);

		}
		for (int i = 0; i < size; i++) {

			if ((int) list.getFirst() == 0) {
				window.drawLine(positionX, positionY, positionX, positionY -= abstand);

			} else if ((int) list.getFirst() == 1) {
				window.drawLine(positionX, positionY, positionX, positionY += abstand);

			} else if ((int) list.getFirst() == 2) {
				window.drawLine(positionX, positionY, positionX += abstand, positionY);

			} else if ((int) list.getFirst() == 3) {
				window.drawLine(positionX, positionY, positionX -= abstand, positionY);

			}

			list.pollFirst();

		}

	}

}
