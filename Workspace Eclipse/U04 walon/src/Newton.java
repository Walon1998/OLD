
/*
/*
/* Author: Neville Walo; Herbst 2017, Uebung 4
* Entwurf uebernommen von einer Assistentin
* Brechent die Quadartwurzel mithilfe von Newton-Raphson
*/
import java.util.Scanner;

//rekursiv
/*
public class Newton {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Gib Zahl ein: ");
		double zahl = console.nextDouble();
		double fehler = 0.0000000000001;
		double t = 1.1;
		wurzel(t, zahl, fehler);
	}

	public static void wurzel(double t, double zahl, double fehler) {
		if (Math.abs((t * t) - zahl) < fehler) {
			System.out.print(t);
		} else {
			t = ((zahl / t) + t) / 2;
			wurzel(t, zahl, fehler);
		}
	}
}

*/

//iterativ

public class Newton {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Gib Zahl ein: ");
		double zahl = console.nextDouble();
		double fehler = 0.0000001;
		double t = 1;
		while (Math.abs((t * t) - zahl) > fehler) {
			t = ((zahl / t) + t) / 2;
		}
		System.out.print(t);
	}
}
