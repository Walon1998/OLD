
/*
* Author: Neville Walo; Herbst 2017, Uebung 3
* Entwurf uebernommen von einer Assistentin
* Wandelt ein Zahl vom Dezimal ins Binärsystem um.
*/
import java.util.Scanner;

public class Binaer {

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		System.out.print("Gib Zahl Z ein:");
		double Eingabe = name.nextInt();
		if (Eingabe == 0) {
			System.out.print("0");
			System.exit(0);
		}
		int k = 0;
		double a = 0;
		int b;
		while (a <= Eingabe) {
			a = Math.pow(2, k);
			k++;
		}

		b = k - 2;

		for (int i = b; i >= 0; i--) {
			if ((Math.pow(2, b) > Eingabe)) {
				System.out.print("0");
			} else {
				System.out.print("1");
				Eingabe = Eingabe - (Math.pow(2, b));
			}

			b--;

		}

	}

}

//Siehe unten für meine Zweite Lösung
//Wahrscheinlich die Elegantere
//Kann für jede "Basis" Zahlen vom Dezimalsystem umwandeln



/*
public class Binaer {

	public static void main(String[] args) {
		int Stellen = 0;
		int Basis = 2;
		Scanner name = new Scanner(System.in);
		System.out.print("Gib Zahl Z ein:");
		int Eingabe = name.nextInt();
		int Eingabe2 = Eingabe;
		if (Eingabe == 0) {
			System.out.print("0");
			System.exit(0);
		}
		while (Eingabe != 0) {
			Eingabe = Eingabe / Basis;
			Stellen++;
		}
		int ergebnis[] = new int[Stellen];
		for (int i = 0; i < Stellen; i++) {
			ergebnis[i] = Eingabe2 % Basis;
			Eingabe2 = Eingabe2 / Basis;
		}

		for (int i = Stellen - 1; i >= 0; i--) {
			System.out.print(ergebnis[i]);
		}

	}

}
*/
