
/*
* Author: Neville Walo; Herbst 2017, Uebung 3
* Entwurf uebernommen von einer Assistentin
* Berechnet folgende Summe für Eingabe N: S=(1/(1^2)+(1/(2^2)+(1/(3^2)+....+(1/(N^2)
*/
import java.util.Scanner;

public class Reihe {

	public static void main(String[] args) {
		double Summe = 0;
		Scanner name = new Scanner(System.in);
		System.out.print("Gib Zahl N ein: ");
		int Eingabe = name.nextInt();
		for (int i = 1; i <= Eingabe; i++) {
			double Nenner = Math.pow(i, 2);
			double Glied = 1 / Nenner;
			Summe += Glied;

		}
		System.out.println(Summe);
	}
	// Summe strebt gegen Pi^2/6 ~ 1.64493
}
