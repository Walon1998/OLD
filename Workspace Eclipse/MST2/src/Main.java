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
		Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			System.out.println(Main.testCase(sc));
		}
		sc.close();
	}


	public static int testCase(final Scanner sc) {
		ArrayList<Edge> list = new ArrayList<Edge>();

		int spanningtreesize=0;
		int n = sc.nextInt();
		int m=sc.nextInt();

		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list.add(new Edge(from, to, weight));

		}
		UnionFind uni = new UnionFind(n);

		Collections.sort(list);

		for (int i = 0; i < m; i++) {

			if (uni.Find(list.get(i).from) != uni.Find(list.get(i).to)) {
				uni.Union(list.get(i).from, list.get(i).to);
				spanningtreesize += list.get(i).weight;

			}


		}

		return spanningtreesize;

	}
}
