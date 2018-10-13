
/*
* Author: Neville Walo; Herbst 2017, Uebung 3
* Entwurf uebernommen von einer Assistentin
*/
import java.util.Scanner;

public class RealSwissFlag {

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		System.out.print("Grösse der Flagge: ");
		int length = name.nextInt();
		Window window = new Window("Fahne", length, length);
		window.setColor(255, 0, 0);
		window.fillRect(0, 0, length, length);
		window.setColor(255, 255, 255);
		window.fillRect((15 * length) / 40, (5 * length) / 40, length / 4, (3 * length) / 4);
		window.fillRect((5 * length) / 40, (15 * length) / 40, (3 * length) / 4, length / 4);
		window.open();
		window.waitUntilClosed();
	}

}
