
package jojodani;
import java.util.*;
public class jojadani {
	public static void main(String[] argv) 
	   {
	   Scanner input = new Scanner (System.in);   
 System.out.print("Grenzwert eingeben: ");
 long a = input.nextLong();
 if (a<=0)
 {System.out.print("fehler");
 // Chönder wenn er wend no besser mache
 }
 long i,j,c,d,e,f;
 j = 2;
 d = j+2;
	while (j<=a){
		
		i = 0;
		c = 1;
		e = 0;
		f = 1;
  while (i<=j)
	{
	i++;
	c = j%i;
if (c == 0&&i!=1&&i!=j)
	break;
	}
	
 if (c!=0){
 
		
 while (e<=d)
	{
	e++;
	f = d%e;
if (f == 0&&e!=1&&e!=d)
	break;
	}
 if (f!=0&&d==j+2)
 { System.out.println(""+j+" und "+d+" sind Primzahlen mit Abstand 2");}}
	j++; 
	d++;
	} 
	System.out.print("Programmende Primzahl von Daniel und Johannes");


	   } }