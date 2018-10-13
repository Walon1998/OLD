
/*
* Author: Neville Walo; Herbst 2017, Uebung 4
* Entwurf uebernommen von einer Assistentin
* Berechnet alle Primzahlen bis zur einem Limit
* Mithilfe des Sieb des Eratosthenes
*/
import java.util.Scanner;

public class Sieb {

	public static void main(String[] args) {
		// Liest limit ein
		Scanner console = new Scanner(System.in);
		System.out.print("Limit: ");
		int limit = console.nextInt();
		// limit +1, da Array bei 0 beginnt
		limit += 1;
		// initialisier boolean array und setze alle werte = true
		boolean[] array = new boolean[limit];
		System.out.print("Primzahlen: ");
		for (int i = 2; i < limit; i++) {
			array[i] = true;
		}
		// Falls i im array true ist, ist i primzahl und die schleife schreicht alle
		// vielfachen von i
		for (int i = 2; i < limit; i++) {
			if (array[i] == true) {
				System.out.print(i + ",");

				int k = 1;
				int j = i;
				while (j < limit) {
					array[j] = false;
					k++;
					j = i * k;
				}

			}
		}
	}
}
