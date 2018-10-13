import java.util.Random;

/**
 * @author Neville Walo
 *
 * Datum: 10.06.2018
 */
public class Boolean {
	final static long TESTSIZE = 2000000;
	final static long ROUNDS = 200;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long totaldiff = 0;
		for (int j = 0; j < ROUNDS; j++) {
			long yes = 0;
			long no = 0;
			Random R = new Random();
			for (int i = 0; i < TESTSIZE; i++) {
				boolean next = R.nextBoolean();
				if (next) {
					yes++;
				} else {
					no++;
				}

			}
			// System.out.println("yes: " + yes);
			// System.out.println("no: " + no);
			long diff = yes - no;
			// System.out.println(diff);
			totaldiff += diff;
		}
		System.out.println(totaldiff);

	}

}
