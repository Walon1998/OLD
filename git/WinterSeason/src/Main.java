import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 22.03.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		// final Scanner sc = new Scanner(new File("test1.in"));
		final Scanner sc = new Scanner(new File("sample.in"));
		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		int n = sc.nextInt();
		int k = sc.nextInt();
		double[] input = new double[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextDouble();
		}
		double[][] table = new double[k + 1][n + 1];
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					table[i][j] = 1;
				} else if (j == 0) {
					table[i][j] = 0;
				} else if (j < i) {
					table[i][j] = 0;
				} else {
					double a = input[j - 1] * table[i - 1][j - 1] + (1 - input[j - 1]) * table[i][j - 1];
					table[i][j] = a;
				}
			}
		}
		System.out.println(Arrays.deepToString(table));
		DecimalFormat df = new DecimalFormat("0.0##");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		System.out.println(df.format(table[k][n]));

	}
}