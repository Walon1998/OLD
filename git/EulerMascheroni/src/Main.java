
/**
 * @author Neville Walo
 *
 * Datum: 09.05.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 10000;
		double fehler = 0;
		for (int i = 1; i < count; i++) {
			fehler = sum(i) - Math.log(i);

		}
		System.out.println(fehler);
	}

	/**
	 * @param i
	 * @return
	 */
	private static double sum(int i) {
		double sum = 0;
		for (int j = 1; j <= i; j++) {
			sum += 1.0 / j;
		}
		return sum;
	}

}
