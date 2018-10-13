import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
	static boolean korrekt = true;
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		final Scanner sc = new Scanner(System.in);
		// final Scanner sc = new Scanner(new File("test2.in"));

		// Read the number of testcases to follow
		final int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		korrekt = true;
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			graph.get(from).add(to);
			graph.get(to).add(from);
		}
		boolean[] visited = new boolean[n];
		int[] visitedAt = new int[n];
		visitedAt[0] = 1;


		// for (int i = 0; i < n; i++) {
		// System.out.println(graph.get(i));
		// }
		// System.out.println(Arrays.toString(visitedAt));
		for (int i = 0; i < n; i++) {
			DFS(i, graph);
		}
		if (korrekt) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}

	}


	private static boolean DFS(int node, ArrayList<ArrayList<Integer>> graph) {
		int[] color = new int[graph.size()];
		for (int i = 0; i < color.length; i++) {
			color[i] = -1;

		}
		color[node]=1;
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(node);
		while (!que.isEmpty()) {
			int p = que.pop();
			for (int i = 0; i < graph.get(p).size(); i++) {
				if (color[graph.get(p).get(i)] == -1) {
					color[graph.get(p).get(i)] = Math.abs(1 - color[p]);
					que.add(graph.get(p).get(i));
				} else if (color[p] == color[graph.get(p).get(i)]) {
					korrekt = false;
					return false;
				}
			}
		}

		return true;



	}






}

