package test;

public class Test {
	public static void main(final String[] args) {
		double a = -3;
		double b = 4;

		// double fa = ((3 * Math.pow(a, 2)) - (5 * a)) + 1;
		// double fb = ((3 * Math.pow(b, 2)) - (5 * b)) + 1;
		// double fa = (a + 3) / (a - 4);
		// double fb = (b + 3) / (b - 4);
		double fa = Math.sqrt(25 - Math.pow(a, 2));
		double fb = Math.sqrt(25 - Math.pow(b, 2));

		double z = (fb - fa) / (b - a);
		System.out.println(fa);
		System.out.println(fb);

		System.out.println(z);

	}

}
