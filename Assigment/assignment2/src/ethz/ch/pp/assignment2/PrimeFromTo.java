/**
 *
 */
package ethz.ch.pp.assignment2;

/**
 * @author Neville Walo
 * Datum: 28.02.2018
 *
 */
public class PrimeFromTo extends Thread {
	int[] array;
	int result[];
	int from;
	int length;

	/**
	 * @param result
	 * @param values
	 * @param startIndex
	 * @param length
	 */

	PrimeFromTo(int[] array, int from, int length, int[] result) {
		this.array = array;
		this.result = result;
		this.from = from;
		this.length = length;
	}



	/**
	 * @param values
	 * @param startIndex
	 * @param length
	 */

	@Override
	public void run() {
		computePrimeFactors(this.array, this.from, this.length);

	}

	void computePrimeFactors(int[] values, int from, int length) {
		for (int i = from; i < (from + length); i++) {
			this.result[i] = numPrimeFactors(values[i]);
		}

	}

	int numPrimeFactors(int number) {
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
