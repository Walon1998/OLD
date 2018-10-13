
/*
* Author: Neville Walo; Herbst 2017, Uebung 2
* Entwurf uebernommen von einer Assistentin
*/
import java.util.Scanner;

public class Adder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a, b, c;
		Scanner name = new Scanner(System.in);
		System.out.print("Geben Sie Zahl 1 ein: ");
		a = name.nextLong();
		System.out.print("Geben Sie Zahl 2 ein: ");
		b = name.nextLong();
		c = a + b;
		System.out.println("" + a + " + " + b + " = " + c + "");
	}

}
