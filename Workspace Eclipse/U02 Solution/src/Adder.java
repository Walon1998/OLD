import java.util.Scanner;

/*
 * Author: Maximiliana Muster
 * für Einfuehrung in die Programmierung, HS 2017
 * 
 * Dieses Programm addiert zwei ganze Zahlen miteinander.
 */
public class Adder {

	public static void main(String[] args) {
		int zahl1, zahl2, summe;
		
		// erstelle Scanner Objekt
		Scanner console = new Scanner(System.in);
		
		// frage nach den beiden Zahlen
		System.out.print("Geben Sie Zahl 1 ein: ");
		zahl1 = console.nextInt();
		
		System.out.print("Geben Sie Zahl 2 ein: ");
		zahl2 = console.nextInt();
		
		// berechne und drucke die Summe
		summe = zahl1 + zahl2;
		System.out.println(zahl1 + " + " + zahl2 + " = " + summe);
	}

}

