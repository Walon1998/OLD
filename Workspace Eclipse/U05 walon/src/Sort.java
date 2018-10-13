import java.util.Arrays;
import java.util.Random;

/*
 * Author: ...
 * for Einfuehrung in die Programmierung
 *
 * This program sorts a given array by repeatedly swapping two random
 * elements of the array.
 */
public class Sort {
	// schaut,ob array sortiert ist,falls ja gibt true zurück, sonst nein
	static boolean isSorted(int[] values) {
		for (int i = 0; i < (values.length - 1); i++) {
			if (values[i] > values[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] values = new int[] { 1, 2, -1, 0, 0, };

		System.out.println("Sorting: " + Arrays.toString(values));
		int steps = randomSort(values);
		System.out.println("Sorted:  " + Arrays.toString(values));
		System.out.println("Steps:   " + steps);
		randomSort(values);
	}

	/**
	 * Sorts the given array <code>values</code> using an inefficent algorithm. It
	 * returns the number of steps that the algorithm performed.
	 *
	 * Do NOT change the signature of the method.
	 */
	static int randomSort(int[] values) {
		int steps = 0;
		Random r = new Random();
		// Schaut, ob Array leer ist
		boolean isEmpty = true;
		for (int i = 0; i < (values.length); i++) {
			if (values[i] != 0) {
				isEmpty = false;
				break;
			}
		}
		if (isEmpty) {
			return 0;
		}
		// Solange nicht sortiert, wählt zufällig 2 Zahlen und zählt schritte
		while (!isSorted(values)) {
			int someNumber = r.nextInt(values.length);
			int someNumber2 = r.nextInt(values.length);
			int numberOld = values[someNumber];
			values[someNumber] = values[someNumber2];
			values[someNumber2] = numberOld;
			steps++;
		}
		return steps;
	}
}
