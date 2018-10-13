import java.math.BigInteger;
import java.util.HashSet;

/**
 * @author Neville Walo
 *
 *         Datum: 09.06.2018
 */
public class Colatz extends Thread {
	BigInteger n;
	BigInteger real;
	final static BigInteger ZERO = new BigInteger("0");
	final static BigInteger ONE = new BigInteger("1");
	final static BigInteger TWO = new BigInteger("2");
	final static BigInteger THREE = new BigInteger("3");
	final static BigInteger FOUR = new BigInteger("4");
	final int CUTOFF = 100000000;
	public Colatz(BigInteger n) {
		this.n = n;
		real = n;
		if (n.mod(new BigInteger("100000")).equals(ZERO)) {
			System.out.println(n);
		}

	}

	@Override
	public void run() {
		int counter = 0;

		HashSet<BigInteger> set2 = new HashSet<BigInteger>();
		while (!Main.set.contains(n)) {
			counter++;
			if (counter > CUTOFF) {
				Main.out.println(real);
				System.out.println(real);
			}
			set2.add(n);
			if (n.mod(TWO).equals(ZERO)) {
				n = n.divide(TWO);
			} else {
				n = n.multiply(THREE).add(ONE);

			}

			// System.out.println(n);
		}
		// System.out.println(real);
		Main.set.addAll(set2);

	}

}
