package lychrelzahlen;
import java.util.*;
public class lychrelzahlen {
	public static void main(String[] argv) 
	   {
	  Scanner input = new Scanner (System.in); 
	  long a,b,c,d,e,f,g,h,i,j,k,l,m,o,p,q,r,t,u,v,w,x,y,z;
	  System.out.print("Geben sie einen Grenzwert ein: ");
		v = input.nextLong();
	 // System.out.print("Geben sie eine positive Zahl ein: ");
		//a = input.nextLong();
		while (v<=0){
			System.out.println("Sie haben eine negative Zahl oder 0 gewählt. Versuchen sie es erneut.");
			System.out.print("Geben sie eine positive Zahl ein: ");
			a = input.nextLong();
		}
		o = 0;
		m = 1;
		z = 0;
		h = 0;
		while (m<=v){
			a = m;
		
		while (a<v){
			x = 1;
			c = 0;
			y = 0;
			i = 1;
			z = 0;
			h = 0;
			j = 1;
			l=0;
			
			b = 0;
		while (a>=x){
			x = x*10;
			y++;}
			
				//"Die Zahl a hat y Ziffern");
		while (i<=y){
			b=1;
			d = 0;
			c = 0;
			while (b<=a){
				c = a/b;
				if (c<10){ break;}
				 b = b*10;}
			
					d = b*c;
					a = a-d;
					h = h+c*j;
					l = l+c*b;
					i++;
					j=j*10;
					}
		
					/*System.out.println("Umgekehrte Zahl: "+h+"");
					System.out.println(""+m+"");*/
					if (o == h)
					{//System.out.print("fehler");
						z = 1;
					break;}
					else
					a = h+l;
					o =a;
					//System.out.println(""+a+" ist eine possible Lyrchelzahl");
					
			
		}		if (z==0){
			System.out.println(""+m+" ist eine possible Lyrchelzahl");}
		/*if ( z == 1)
			System.out.println(""+m+" ist keine possible Lyrchelzahl");*/
		m++;}
	
}}
