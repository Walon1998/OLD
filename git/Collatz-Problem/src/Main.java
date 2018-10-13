import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Neville Walo
 *
 * Datum: 09.06.2018
 */
public class Main {

	final static BigInteger ZERO = new BigInteger("0");
	final static BigInteger ONE = new BigInteger("1");
	final static BigInteger TWO = new BigInteger("2");
	final static BigInteger THREE = new BigInteger("3");
	final static BigInteger FOUR = new BigInteger("4");
	static HashSet<BigInteger> set = new HashSet<BigInteger>();
	static ExecutorService exs = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	static File file = new File("possible");
	static PrintStream out;

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		out = new PrintStream(file);
		set.add(FOUR);
		set.add(TWO);
		set.add(ONE);
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		BigInteger n = new BigInteger(input);
		while (true) {
			Thread i = new Colatz(n);
			exs.execute(i);
			n = n.add(ONE);


			// System.out.println(n);
		}
		// exs.shutdown();
		// sc.close();
	}

	/**
	 * @param n
	 * @return
	 */
	private static boolean Colatz(BigInteger n) {

		HashSet<BigInteger> set2 = new HashSet<BigInteger>();

		while (!set.contains(n)) {
			set2.add(n);
			if (n.mod(TWO).equals(ZERO)) {
				n = n.divide(TWO);
			} else {
				n = n.multiply(THREE).add(ONE);

			}

			// System.out.println(n);
		}
		set.addAll(set2);
		return true;
	}

}
