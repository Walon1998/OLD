
/*
* Author: Neville Walo; Herbst 2017, Uebung 4
* Entwurf uebernommen von einer Assistentin
* Gibt Dreiecke in Dreieck etc. => Super Iluminati!!!
*/
import java.util.Random;

public class ChaosGame {

	public static void main(String[] args) {
		Window window = new Window("Chaos", 800, 800);
		window.open();
		window.setColor(0, 0, 0);
		int ecke0x = 400;
		int ecke0y = 0;
		int ecke1x = 0;
		int ecke1y = 800;
		int ecke2x = 800;
		int ecke2y = 800;
		int x = 0, y = 0;
		Random rand = new Random();
		int randomNumber = rand.nextInt(800);
		int randomNumber2 = rand.nextInt(800);

		while (window.isOpen()) {

			int randomNumber3 = rand.nextInt(3);
			switch (randomNumber3) {
			case 0:
				x = ecke0x;
				y = ecke0y;
				break;
			case 1:
				x = ecke1x;
				y = ecke1y;
				break;
			case 2:
				x = ecke2x;
				y = ecke2y;
				break;
			}

			randomNumber = (randomNumber + x) / 2;
			randomNumber2 = (randomNumber2 + y) / 2;
			window.fillRect(randomNumber, randomNumber2, 1, 1);
			window.refresh();
		}
	}

}
