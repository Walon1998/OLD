
public class GCD {

	public static void main(String[] args) {
		int a = 4;
		int b = 2;
		// mit a>=b

		int s1 = a;
		int s2 = b;
		int u1 = 1;
		int u2 = 0;
		int v1 = 0;
		int v2 = 1;
		while (s2 > 0) {
			int q = s1 / s2;
			int r = s1 - (q * s2);
			s1 = s2;
			s2 = r;
			int t = u2;
			u2 = u1 - (q * u2);
			u1 = t;
			t = v2;
			v2 = v1 - (q * v2);
			v1 = t;

		}

		int d = s1;
		int u = u1;
		int v = v1;

		System.out.println("GCD(" + a + ", " + b + ") = " + d + " = " + u + "*" + a + "+" + v + "*" + b);
		System.out.println();
		// TODO Auto-generated method stub

	}

}
