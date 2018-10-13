/**
 *
 */
package ethz.ch.pp.assignment2;

/**
 * @author Neville Walo
 * Datum: 28.02.2018
 *
 */
public class ComputePrime extends Thread {
	int[] array;
	int[] result;

	ComputePrime(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		result = computePrimeFactors(array);

	}

	public static int[] computePrimeFactors(int[] values) {
		int[] factors = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			factors[i] = numPrimeFactors(values[i]);
		}
		return factors;
	}

	public static int numPrimeFactors(int number) {
		int primeFactors = 0;
		int n = number;
		for (int i = 2; i <= n; i++) {
			while ((n % i) == 0) {
				primeFactors++;
				n /= i;
			}
		}
		return primeFactors;
	}
}
