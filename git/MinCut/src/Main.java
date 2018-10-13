import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 22.02.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		// final Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);

		}
	}

	public static void testCase(final Scanner sc) {
		int min = Integer.MAX_VALUE;

		int n = sc.nextInt();
		int m = sc.nextInt();


		ArrayList<Edge> list = new ArrayList<Edge>();
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list.add(new Edge(from, to));

		}

		int lamda = 50;
		for (int i = 0; i < lamda; i++) {
			UnionFind union = new UnionFind(n);
			Collections.shuffle(list);

			for (Edge e : list) {
				if (union.getUnionCount() <= 2) {
					break;
				}
				if (union.Find(e.from) != union.Find(e.to)) {
					union.Union(e.from, e.to);
				}

			}
			int newMin = countEdge(union, list);
			if (newMin < min) {
				min = newMin;
			}

		}
		System.out.println(min);


	}

	/**
	 * @param union
	 * @param list
	 * @return
	 */
	private static int countEdge(UnionFind union, ArrayList<Edge> list) {
		int counter = 0;

		for (Edge e : list) {
			if (union.Find(e.from) != union.Find(e.to)) {
				counter++;
			}

		}

		return counter;
	}
}



