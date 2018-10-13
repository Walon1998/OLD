import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class WoerterRaten {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("woerter.txt"));
		String[] woerter = liesWoerter(scanner);
		scanner.close();

		rateSpiel(woerter);
	}

	/**
	 * Liest die Wörter von dem gegebenen Scanner ein und gibt sie als Array zurück.
	 */
	static String[] liesWoerter(Scanner scanner) {
		String[] woerter = new String[scanner.nextInt()];
		for (int i = 0; i < woerter.length; i++) {
			woerter[i] = scanner.next();
		}
		return woerter;
	}

	/**
	 * Führt das Rate-Spiel einmal durch.
	 */
	static void rateSpiel(String[] woerter) {
		Scanner scanner = new Scanner(System.in);
		String wort = zufallsWort(woerter);
		System.out.println(wort);
		System.out.print("Gib dein Tipp ein: ");
		String tipp = scanner.nextLine();
		int zähler = 1;
		while (!hinweis(wort, tipp)) {
			System.out.print("Gib dein Tipp ein: ");
			tipp = scanner.nextLine();
			zähler++;
		}
		System.out.println("Glückwunsch, du hast nur " + zähler + " Versuche benötigt!");
	}

	/**
	 * Wählt zufällig ein Wort aus dem "woerter"-Array aus und gibt es zurück.
	 */
	static String zufallsWort(String[] woerter) {
		Random r = new Random();
		int someNumber = r.nextInt(woerter.length);
		return woerter[someNumber];
	}

	/**
	 * Vergleicht das gegebene "wort" und die "tipp"-Zeichenkette und gibt einen
	 * Hinweis zurück. Folgende Hinweise sind möglich: "ist", "beginnt mit", "endet
	 * mit", "beginnt mit und endet mit", "enthält" oder "enthält nicht".
	 */
	static boolean hinweis(String wort, String tipp) {
		Random r = new Random();
		if (tipp.equals(wort)) {
			System.out.println("Das Wort ist \"" + wort + "\"! ");

			return true;
		} else {

			int hilfe = r.nextInt(3);
			switch (hilfe) {
			case 0:
				System.out.println("Wort beginnt mit: " + wort.substring(0, 1));
				break;
			case 1:
				System.out.println("Wort endet mit: " + wort.substring(wort.length() - 1));
				break;
			case 2:
				int number1 = r.nextInt(wort.length() - 2) + 1;
				int number2 = number1 + 1;
				System.out.println("Wort enthält : " + wort.substring(number1, number2));
				break;
			case 3:
				char c = (char) (r.nextInt(26) + 'a');
				while (wort.contains(String.valueOf(c))) {
					c = (char) (r.nextInt(26) + 'a');
				}
				System.out.println("Wort enthält nicht: " + c);
				break;
			}

			return false;
		}

	}
}