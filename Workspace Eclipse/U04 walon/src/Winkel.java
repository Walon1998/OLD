/*
* Author: Neville Walo; Herbst 2017, Uebung 4
* Entwurf uebernommen von einer Assistentin
* Die Methode sollte also das Ergebnis true liefern, wenn
die Summe von zwei Winkeln 90 und die Summe eines anderen Paares von Winkeln 180
ergibt; andernfalls soll das Ergebnis false sein.
*/
public class Winkel {

	public static void main(String[] args) {
		System.out.println("passendeWinkel(0, 90, 180): " + passendeWinkel(0, 90, 180));
		System.out.println("passendeWinkel(35, 60, 30): " + passendeWinkel(35, 60, 30));

	}

	static boolean passendeWinkel(int a, int b, int c) {
		boolean is90 = false;
		boolean is180 = false;

		if ((a + b) == 90) {
			is90 = true;
		}
		if ((a + c) == 90) {
			is90 = true;
		}
		if ((c + b) == 90) {
			is90 = true;
		}
		if ((a + b) == 180) {
			is180 = true;
		}
		if ((a + c) == 180) {
			is180 = true;
		}
		if ((c + b) == 180) {
			is180 = true;
		}
		if (is90 && is180) {
			return true;
		} else {
			return false;
		}

	}
}
