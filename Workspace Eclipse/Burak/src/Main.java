import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Burak
 */

class Main {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		final int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			int next = sc.nextInt();
			input[i] = next;
		}
		ArrayList<ArrayList<Integer>> column = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			column.add(new ArrayList<Integer>());
		}
		column.get(0).add(input[0]);
		for (int i = 1; i < n; i++) {
			for (int j = i; j >= 1; j--) {
				for (Integer h : column.get(j - 1)) {
					column.get(j).add(kgv(h, input[i]));
				}
			}
			column.get(0).add(input[i]);
		}
		double x = 0;
		for (int i = 0; i < column.size(); i++) {
			for (int j = 0; j < column.get(i).size(); j++) {
				double a = Math.pow(-1, i) * (1.0 / column.get(i).get(j));
				x += a;
			}
		}
		if (x > 1) {
			x = 1;
		}
		DecimalFormat df = new DecimalFormat("0.0####");
		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println(df.format(1 - x));

	}

	static int ggt(int a, int b) {
		if (a < b) {
			int c = a;
			a = b;
			b = c;
		}
		while (b > 0) {
			int c = b;
			b = a % b;
			a = c;
		}
		return a;
	}

	static int kgv(int a, int b) {
		int c = a * (b / ggt(a, b));
		return c;
	}
}
