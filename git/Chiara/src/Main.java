import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Neville Walo
 *
 * Datum: 01.06.2018
 */
public class Main {
	final static int TESTS = 100000;
	final static int SIZE = 100;
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int[] counterarray = new int[SIZE];
		for (int i = 0; i < TESTS; i++) {
			int[] array = new int[SIZE];
			Random R = new Random();
			boolean last = R.nextBoolean();
			int counter = 1;
			int max = 0;
			for (int j = 1; j < SIZE; j++) {
				boolean next = R.nextBoolean();
				if (next != last) {
					array[counter]++;
					max = Math.max(max, counter);
					counter = 0;
				}
				last = next;
				counter++;

			}
			max = Math.max(max, counter);
			array[counter]++;


			counterarray[max]++;
			// System.out.println(Arrays.toString(array));
			// System.out.println(max);
		}

		for (int i = 0; i < counterarray.length; i++) {
			if (counterarray[i] != 0) {
				System.out.println(i + ": " + counterarray[i]);
			}
		}

		// File bitstream = generateBitstream(size);
		// int[] array = count(bitstream);

		// printResult(array);

	}

	/**
	 * @param array
	 */
	private static void printResult(int[] array) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				System.out.println(i + ": " + array[i]);
			}
		}



	}

	/**
	 * @param bitstream
	 * @return
	 * @throws FileNotFoundException
	 */
	private static int[] count(File bitstream) throws FileNotFoundException {
		int arraysize = 100;
		int[] array = new int[arraysize];
		Scanner sc = new Scanner(bitstream);
		int last = sc.nextInt();
		int counter = 1;
		while (sc.hasNext()) {
			int next = sc.nextInt();
			if (next != last) {
				array[counter]++;

				counter = 0;
			}
			last = next;
			counter++;

		}
		array[counter]++;


		return array;
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	private static File generateBitstream(int size) throws FileNotFoundException {
		File file = new File("bitstream.txt");
		PrintStream f = new PrintStream(file);
		Random R = new Random();
		for (int i = 0; i < size; i++) {
			int r = R.nextInt(2);
			f.print(r + " ");

		}

		return file;
	}

}
