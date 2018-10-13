/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 30.04.2018
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double x = 1;

		int i = 0;
		while ((i < 1000) && (Math.abs(f(x)) > 1.0E-10)) {
			x = x - (f(x) / fAbleitung(x));
			i++;
		}
		System.out.println(x);
		System.out.println(i);

	}

	static double f(double x) {
		double result = Math.pow(x, 5) - 2;
		// double result = Math.atan(x) - 1;
		//		double result = (x * Math.pow(Math.E, x)) - 1;

		return result;
	}

	static double fAbleitung(double x) {
		double result = 4 * Math.pow(x, 4);
		// double result = 1.0 / (Math.pow(x, 2) + 1);
		// double result = (x + 1) * Math.pow(Math.E, x);

		return result;
	}

}
