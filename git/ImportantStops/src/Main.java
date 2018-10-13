import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	static int ArtCounter;
	static int ccounter;

	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(new File("test1.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}

	}

	public static void testCase(final Scanner sc) {
		ArtCounter = 0;
		int num = 0;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] dfs = new int[n];
		int[] low = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for (int i = 0; i < n; i++) {
			if (dfs[i] == 0) {
				ccounter = 0;
				DFS(i, dfs, low, graph, num);
			}
			if (ccounter > 1) {
				ArtCounter++;
			}
		}
		System.out.println(ArtCounter);
		// Your main algorithm (solution) should go here

	}

	public static int DFS(int node, int[] dfs, int [] low, ArrayList<ArrayList<Integer>> graph, int num) {
		num++;
		dfs[node] = num;
		low[node] = num;
		int counter = 0;
		for (int i = 0; i < graph.get(node).size(); i++) {
			if (dfs[i] == 0) {
				int val = DFS(i, dfs, low, graph, num);
				if (val > dfs[i]) {
					ArtCounter++;
				}
				low[i] = Math.min(low[i], val);
				counter++;
			} else {
				low[node] = Math.max(low[node], dfs[i]);
			}
		}
		ccounter = counter;
		return low[node];

	}
}
