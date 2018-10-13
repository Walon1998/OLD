import java.util.*;
public class EulerischeZahl {
	public static void main(String[] argv) 
	   {
		 Scanner input = new Scanner (System.in); 
		 double a,b,c,d;
		 System.out.print("Geben sie einen Hochzahl ein: ");
			 b = input.nextDouble();
			 //b= 1;
			 d = 0;
			// while (b<=a) {
				 c= 1+(1/b);
				 System.out.println(" c = "+c+"");
				 d = Math.pow(c,b);
				 //System.out.println("Eulersche Zahl ="+d+"");
				 
				// b++;
						 
	//		 }
	System.out.println("Eulersche Zahl ="+d+"");
			System.out.print("ende");	 
	   }
}
