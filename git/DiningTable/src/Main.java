import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 03.07.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		// final Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("sample.in"));
		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {

		ArrayList<Integer> RSide = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		int[] color = new int[n];
		for (int i = 0; i < n; i++) {
			color[i] = -1;
		}
		for (int i = 0; i < m; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(r);
		RSide.add(r);
		while (!que.isEmpty()) {
			int node = que.pop();
			if (color[node] == -1) {
				color[node] = 0;
				for (int i = 0; i < graph.get(node).size(); i++) {
					que.add(graph.get(node).get(i));
					color[graph.get(node).get(i)] = 1;

				}

			} else if (color[node] == 0) {
				for (int i = 0; i < graph.get(node).size(); i++) {
					if (color[graph.get(node).get(i)] == -1) {
						color[graph.get(node).get(i)] = 1;
						que.add(graph.get(node).get(i));

					} else if (color[graph.get(node).get(i)] == 0) {
						que.clear();
						RSide.clear();
					}
				}

			} else if (color[node] == 1) {
				for (int i = 0; i < graph.get(node).size(); i++) {
					if (color[graph.get(node).get(i)] == -1) {
						color[graph.get(node).get(i)] = 0;
						que.add(graph.get(node).get(i));
						RSide.add(graph.get(node).get(i));

					} else if (color[graph.get(node).get(i)] == 1) {
						que.clear();
						RSide.clear();

					}
				}

			}

		}
		if (RSide.isEmpty()) {
			System.out.println("no");

		} else {
			Collections.sort(RSide);
			for (int i = 0; i < RSide.size(); i++) {
				System.out.print(RSide.get(i));
				System.out.print(" ");
			}
			System.out.println();
		}


		// Your main algorithm (solution) should go here

	}
}