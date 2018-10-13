import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Neville Walo
 *
 *         Datum: 26.04.2018 NotSoWell
 */
class Main2 {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(System.in);
		// final Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		final BigInteger three = new BigInteger("3");
		final BigInteger two = new BigInteger("2");
		final BigInteger one = new BigInteger("1");
		final BigInteger zero = new BigInteger("0");
		BigInteger N=sc.nextBigInteger();
		if (N.equals(two) || N.equals(three)) {
			System.out.println("yes");
			return;
		}
		if (N.compareTo(two) < 0 || N.mod(two).equals(zero) || N.mod(three).equals(zero)) {
			System.out.println("no");
			return;
		}

		BigInteger j= new BigInteger("5");
		BigInteger m = sqrt(N);
		// BigInteger m = m.sqrt();
		m = m.add(one);

		BigInteger four = new BigInteger("4");
		while (j.compareTo(m) < 0) {
			if (N.mod(j).equals(zero)) {
				System.out.println("no");
				return;
			}
			j = j.add(two);
			if (N.mod(j).equals(zero)) {
				System.out.println("no");
				return;
			}
			j = j.add(four);

		}
		System.out.println("yes");
	}

	public static BigInteger sqrt(BigInteger x) {
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
		BigInteger div2 = div;
		// Loop until we hit the same value twice in a row, or wind
		// up alternating.
		for (;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if (y.equals(div) || y.equals(div2)) {
				return y;
			}
			div2 = div;
			div = y;
		}
	}



}



