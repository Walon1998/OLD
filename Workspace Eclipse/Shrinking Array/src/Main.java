import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Neville Walo
 *
 * Datum: 28.06.2018
 */
class Main {

	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		// final Scanner sc = new Scanner(System.in);
		final Scanner sc = new Scanner(new File("sample.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		HashMap<String, Double> map = new HashMap<String, Double>();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] input = new int[n];
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		sum[0] = input[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + input[i];
		}
		double result = calculate(0, n - 1, k, input, sum, map);
		DecimalFormat df = new DecimalFormat("0.0##");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		System.out.println(df.format(result)); // Replace 3.5 with your desired double


	}

	static double calculate(int links, int rechts, int k, int[] input, int[] sum, HashMap<String, Double> map) {
		String key = Integer.toString(links) + " " + Integer.toString(rechts) + " " + Integer.toString(k);
		if (map.containsKey(key)) {
			return map.get(key);
		}

		if(k==0) {
			int sum1 = 0;
			// if (rechts >= links) {
			if (links > 0) {
				sum1 = sum[rechts] - sum[links - 1];
			} else {
				sum1 = sum[rechts];
			}
			// }

			map.put(key, (double) sum1);
			return sum1;
		}
		double result = (input[links] * calculate(links + 1, rechts, k - 1, input, sum, map)
				+ input[rechts] * calculate(links, rechts - 1, k - 1, input, sum, map))
				/ (input[links] + input[rechts]);
		map.put(key, result);
		return result;

	}
}
