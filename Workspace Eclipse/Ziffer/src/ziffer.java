import java.util.*;
public class ziffer {
	public static void main(String argv[]){
		Scanner input = new Scanner (System.in);
		long a,b,c,d;
		System.out.print("Geben sie eine positive Zahl ein: ");
		a = input.nextLong();
		while (a<=0){
			System.out.println("Sie haben eine negative Zahl oder 0 gewählt. Versuchen sie es erneut.");
			System.out.print("Geben sie eine positive Zahl ein: ");
			a = input.nextLong();
		}
		b = 1;
		c = 0;
		d = 0;
		
		while (a>=b){
			b = b*10;
			d++;}
			
				{System.out.println("Die Zahl "+a+" hat "+d+" Ziffern");
			System.out.print("Programmende Ziffer");
		
}
}}