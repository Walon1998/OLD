import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Neville Walo Datum: 12.04.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(System.in);
		// final Scanner sc = new Scanner(new File("testme.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		// System.out.println();
		ArrayList<Integer> list = new ArrayList<Integer>();

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int next = sc.nextInt();
			if (!list.contains(next)) {
				if (newSmalldivider(list, next)) {
					list = delete(list, next);
					list.add(next);
				} else if (newBigdivider(list, next)) {

				} else {
					list.add(next);
				}

			}

		}
		double result = calculate(list);

		DecimalFormat df = new DecimalFormat("0.0####");
		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println(df.format(result));

	}

	/**
	 * @param list
	 * @param next
	 * @return
	 */
	private static ArrayList<Integer> delete(ArrayList<Integer> list, int next) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i % next == 0) {

			} else {
				newList.add(i);
			}
		}

		return newList;
	}

	/**
	 * @param list
	 * @param next
	 * @return
	 */
	private static boolean newBigdivider(ArrayList<Integer> list, int next) {
		for (Integer i : list) {
			if (next % i == 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param list
	 * @param next
	 * @return
	 */
	private static boolean newSmalldivider(ArrayList<Integer> list, int next) {
		for (Integer i : list) {
			if (i % next == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param list
	 * @return
	 */
	private static double calculate(ArrayList<Integer> list) {
		// System.out.println(list);
		ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
		for (Integer i : list) {
			group.add(new ArrayList<Integer>());
		}
		group.get(0).add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			group.get(i).add(lcm(sumiToZero(i, list)));
			for (int j = i - 1; j >= 1; j--) {
				for (Integer k : group.get(j - 1)) {
					group.get(j).add(lcm(k, list.get(i)));
				}
			}
			group.get(0).add(list.get(i));
		}
		// System.out.println(group);
		return sumUp(group);
	}

	/**
	 * @param group
	 * @return
	 */
	private static double sumUp(ArrayList<ArrayList<Integer>> group) {
		double result = 0;
		for (int i = 0; i < group.size(); i++) {
			for (int j = 0; j < group.get(i).size(); j++) {
				double a = Math.pow(-1, i) * (1.0 / (double) group.get(i).get(j));
				result += a;
			}
		}
		// System.out.println("result" + result);
		return 1 - result;
	}

	/**
	 * @param i
	 * @param list
	 * @return
	 */
	private static int[] sumiToZero(int i, ArrayList<Integer> list) {
		int[] array = new int[i + 1];
		for (int j = 0; j <= i; j++) {
			array[j] = list.get(j);

		}
		// System.out.println("+sumtoZero" + Arrays.toString(array));
		return array;
	}

	static double gcd(Double a, Double b) {
		if (a < b) {
			double c = a;
			a = b;
			b = c;
		}
		// mit a>=b

		while (b > 0) {
			double c = b;
			b = a % b;
			a = c;
		}
		return a;
	}

	static double lcm(Double a, Double b) {
		double c = a * (b / gcd(a, b));
		return c;
	}

	private static int lcm(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = lcm(result, input[i]);
		}
		// System.out.println("lcm" + result);
		return result;
	}

	static int gcd(int a, int b) {
		if (a < b) {
			int c = a;
			a = b;
			b = c;
		}
		// mit a>=b

		while (b > 0) {
			int c = b;
			b = a % b;
			a = c;
		}
		return a;
	}

	static int lcm(int a, int b) {
		int c = a * (b / gcd(a, b));
		return c;
	}
}
