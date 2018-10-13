/* EasyCODE V6.8 */
/* EasyCODE ( 0 
Struktogramm */
package zahlensysteme;
        import java.util.*;
/* EasyCODE ( 0
zahlensysteme */
/* EasyCODE C */
public class zahlensysteme
{
    /* EasyCODE ( 0
    main */
    /* EasyCODE F */
    public static void main (String argv[])
    { 
        Scanner input = new Scanner (System.in);
        int a,b; 
        long c;
        String n;
        
        
                System.out.print("Geben sie eine Zahl (bzw.Buchstaben beim Hexadezimalsystem) ein: "); 
                                /*"Falls eine Zahl mit Kommastellen (Bsp. 3.5) eingeben wird es das Programm später ein Fehler ausgeben.
                 Falls eine Zahl eingegeben wird die nicht zum Zahlentyp gehört wird auch ein Fehler ausgegeben:*/
        n = input.next();
        System.out.println("Eingegebene Zahl:"+n+" ");
        System.out.print("Basis der eingegebenen Zahl: ");
        a = input.nextInt();
        while( a!=16&&a!=10&&a!=8&&a!=2 )
        {
                    System.out.println("Sie haben eine Basis eingegeben, welche nicht den Zahlentypen 2,8,10 oder 16 entspricht.(Das Programm kann zurzeit nur diese Zahlentypen verwenden, wir werden es sobald wie möglich erweitern..;)"
                                    + " Versuchen sie es erneut.");
            System.out.print("Basis der eingegebenen Zahl: ");
            a = input.nextInt();
        }
        System.out.print("Basis der umgewandelten Zahl: ");
        b = input.nextInt();
        while( b!=16&&b!=10&&b!=8&&b!=2 )
        {
                    System.out.println("Sie haben eine Basis eingegeben, welche nicht den Zahlentypen 2,8,10 oder 16 entspricht.(Das Programm kann zurzeit nur diese zahlentypen verwenden, wir werden es sobald wie möglich erweitern..;)"
                                    + " Versuchen sie es erneut.");
            b = input.nextInt();
        }
        switch( a )
        {
        case 2:
            switch( b )
            {
            case 2:
                c = (Long.valueOf(""+n+"",2)); System.out.println("Umgewandelte Zahl: "+Long.toBinaryString(c)+"");
                /* EasyCODE - */
                break;
            case 8:
                c = (Long.valueOf(""+n+"",2));System.out.println("Umgewandelte Zahl: "+Long.toOctalString(c)+"");
                /* EasyCODE - */
                break;
            case 16:
                c = (Long.valueOf(""+n+"",2));System.out.println("Umgewandelte Zahl: "+Long.toHexString(c)+"");
                /* EasyCODE - */
                break;
            case 10:
                c = (Long.valueOf(""+n+"",2));System.out.println("Umgewandelte Zahl: "+Long.toString(c)+"");
            }
            break;
        case 8:
            switch( b )
            {
            case 2:
                c = (Long.valueOf(""+n+"",8)); System.out.println("Umgewandelte Zahl: "+Long.toBinaryString(c)+"");
                /* EasyCODE - */
                break;
            case 8:
                c = (Long.valueOf(""+n+"",8)); System.out.println("Umgewandelte Zahl: "+Long.toOctalString(c)+"");
                /* EasyCODE - */
                break;
            case 16:
                c = (Long.valueOf(""+n+"",8)); System.out.println("Umgewandelte Zahl: "+Long.toHexString(c)+"");
                /* EasyCODE - */
                break;
            case 10:
                c = (Long.valueOf(""+n+"",8)) ;System.out.println("Umgewandelte Zahl: "+Long.toString(c)+"");
            }
            break;
        case 16:
            switch( b )
            {
            case 2:
                c = (Long.valueOf(""+n+"",16)); System.out.println("Umgewandelte Zahl: "+Long.toBinaryString(c)+"");
                /* EasyCODE - */
                break;
            case 8:
                c = (Long.valueOf(""+n+"",16));  System.out.println("Umgewandelte Zahl: "+Long.toOctalString(c)+"");
                /* EasyCODE - */
                break;
            case 16:
                c = (Long.valueOf(""+n+"",16)); System.out.println("Umgewandelte Zahl: "+Long.toHexString(c)+"");
                /* EasyCODE - */
                break;
            case 10:
                c = (Long.valueOf(""+n+"",16)); System.out.println("Umgewandelte Zahl: "+Long.toString(c)+"");
            }
            break;
        case 10:
            switch( b )
            {
            case 2:
                c = (Long.valueOf(""+n+"",10)); System.out.println("Umgewandelte Zahl: "+Long.toBinaryString(c)+"");
                /* EasyCODE - */
                break;
            case 8:
                c = (Long.valueOf(""+n+"",10)); System.out.println("Umgewandelte Zahl: "+Long.toOctalString(c)+"");
                /* EasyCODE - */
                break;
            case 16:
                c = (Long.valueOf(""+n+"",10)); System.out.println("Umgewandelte Zahl: "+Long.toHexString(c)+"");
                /* EasyCODE - */
                break;
            case 10:
                c = (Long.valueOf(""+n+"",16)); System.out.println("Umgewandelte Zahl: "+Long.toString(c)+"");
            }
            break;
        }
        System.out.print("Programmende");
    } 
    /* EasyCODE ) */
} 
/* EasyCODE E */
/* EasyCODE ) */
/* EasyCODE ) */
