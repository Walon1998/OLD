
/*
* Author: Neville Walo; Herbst 2017, Uebung 3
* Entwurf uebernommen von einer Assistentin
* Berechnet den GGT zweier Zahlen
*/
import java.util.Scanner;

public class GGT {

	public static void ggt(int x, int y) {
		if ((x >= y) && ((x % y) == 0)) {
			System.out.print(y);
		} else {
			ggt(y, x % y);
		}
	}

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		System.out.print("Zahl 1: ");
		int x = name.nextInt();
		System.out.print("Zahl 2: ");
		int y = name.nextInt();
		ggt(x, y);
	}

}
