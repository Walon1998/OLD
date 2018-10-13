import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Neville Walo
 *
 *         Datum: 26.04.2018 Good one
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(System.in);
		// final Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		// System.out.println();
		final BigInteger two = new BigInteger("2");
		final BigInteger one = new BigInteger("1");
		final BigInteger zero = new BigInteger("0");

		BigInteger N = sc.nextBigInteger();
		// long time = System.nanoTime();
		if (N.equals(two)) {
			System.out.println("yes");
			return;
		}
		if (N.equals(one) || N.mod(two).equals(zero)) {
			System.out.println("no");
			return;
		}

		BigInteger d = N.subtract(one);
		int k = 0;
		while (d.mod(two).equals(zero)) {
			d = d.divide(two);
			k++;
		}
		for (int i = 0; i < 40; i++) {
			BigInteger a = generateRandom(N.subtract(one));
			// System.out.println(d);
			// System.out.println(k);
			BigInteger x = a.modPow(d, N);
			if (x.equals(one) || x.equals(N.subtract(one))) {
				continue;
			}
			int j = 0;
			for (; j < k; j++) {
				x = x.modPow(two, N);
				if (x.equals(one)) {
					System.out.println("no");
					return;
				}
				if (x.equals(N.subtract(one))) {
					break;
				}

			}
			if (j == k) {
				System.out.println("no");
				return;
			}

		}
		System.out.println("yes");



		// System.out.println(System.nanoTime() - time);
	}

	/**
	 * @param subtract
	 * @return
	 */
	private static BigInteger generateRandom(BigInteger upperLimit) {
		BigInteger two = new BigInteger("2");
		BigInteger random = new BigInteger(upperLimit.bitLength(), new Random());
		while (random.compareTo(two) < 0 || random.compareTo(upperLimit) > 0) {
			random = new BigInteger(upperLimit.bitLength(), new Random());
		}
		return random;
	}

}
