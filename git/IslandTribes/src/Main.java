import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 04.07.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(new File("sample.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		int b = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		// Your main algorithm (solution) should go here

	}
}