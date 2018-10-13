import java.util.*;
public class Gleichungdrei {
	public static void main(String argv[])
	{
		Scanner input = new Scanner (System.in);
double a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
System.out.println("Matrix-System");
System.out.println("Geben sie die erste Gleichung ein");
System.out.print("Zahl 1:  ");
a = input.nextDouble();
System.out.print("Zahl 2:  ");
b = input.nextDouble();
System.out.print("Zahl 3:  ");
c = input.nextDouble();
System.out.print("Ergebnis:  ");
d = input.nextDouble();
System.out.println("Geben sie die zweite Gleichung ein");
System.out.print("Zahl 1:  ");
e = input.nextDouble();
System.out.print("Zahl 2:  ");
f = input.nextDouble();
System.out.print("Zahl 3:  ");
g = input.nextDouble();
System.out.print("Ergebnis:  ");
h = input.nextDouble();
System.out.println("Geben sie die dritte Gleichung ein");
System.out.print("Zahl 1:  ");
i = input.nextDouble();
System.out.print("Zahl 2:  ");
j = input.nextDouble();
System.out.print("Zahl 3:  ");
k = input.nextDouble();
System.out.print("Ergebnis:  ");
l = input.nextDouble();
m = (b*-e)+f*a;
n = c*-e+g*a;
o = d*-e+h*a;
p = b*-i+j*a;
q = c*-i+k*a;
r = d*-i+l*a;
s = n*-p+q*m;
t = o*-p+m*r;
z = s/t;
y =(o-(z*n))/m;
x= (d-b*y-c*z)/a;
if(s==0&&t==0)
	System.out.print("Unentlichviele Lösungen");
else if (s==0&&t!=0)
      System.out.print("Keine Lösung");
       else
            System.out.println(" Die Ergebnisse sind:");
            System.out.println("X = "+x+"");
            System.out.println("Y = "+y+"");
            System.out.println("Z = "+z+"");
            


}
}