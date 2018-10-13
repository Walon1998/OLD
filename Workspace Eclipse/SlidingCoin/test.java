
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class test {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists;
	static Boolean[] isWinner;// adjLists[u][j] is the j-th neighbor of vertex u in G (i.e., (u,
	// adjLists[u][j]) is an edge in G)

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("public_testcases/example.in.txt"));
		int ntestcases = scanner.nextInt();

		for (int testno = 0; testno < ntestcases; testno++) {
			n = scanner.nextInt();
			outdegrees = new int[n];
			adjLists = new int[n][];

			for (int i = 0; i < n; i++) {
				outdegrees[i] = scanner.nextInt();
				adjLists[i] = new int[outdegrees[i]];
				for (int j = 0; j < outdegrees[i]; j++) {
					adjLists[i][j] = scanner.nextInt();
				}
			}
			System.out.println(solve());
		}

		scanner.close();
	}

	public static char solve() {
		int zähler = 0;
		isWinner = new Boolean[n];
		int[] postZahl = new int[n];
		Boolean[] besucht = new Boolean[n];

		Deque<Integer> S = new ArrayDeque<Integer>(n);

		S.push(0);
		while (!(S.isEmpty())) {
			int v = S.getLast();
			besucht[v] = true;
			postZahl[zähler] = v;
			zähler++;
			{
				for (int i = 0; i < outdegrees[v]; i++) {

					if (besucht[adjLists[v][i]] == null) {
						System.out.println(adjLists[v][i]);
						S.add(adjLists[v][i]);

					}

				}
			}

			System.out.println(Arrays.toString(postZahl));
			System.out.println(zähler);

			System.out.println(v);

		}
		// System.out.println(Arrays.toString(topoRueck));
		System.out.println(zähler);

		for (int i = zähler; zähler >= 0; i--) {

			if (outdegrees[i] == 0) {
				isWinner[i] = false;
			} else if (onlyGewinner(i)) {
				isWinner[i] = false;

			} else {
				isWinner[i] = true;
			}

		}

		// if (isWinner[0] == true) {
		// return 'A';
		// }
		return 'B';

	}

	private static boolean onlyGewinner(int knoten) {
		for (int i = 0; i < outdegrees[knoten]; i++) {
			System.out.println(knoten);
			if (isWinner[adjLists[knoten][i]] == false) {
				return false;
			}
		}
		return true;

	}

}
/*
 * }
 *
 * private static boolean onlyLoosers(int knoten) { for (int i = 0; i <
 * outdegrees[knoten]; i++) { // System.out.println(knoten); if
 * (isWinner[adjLists[knoten][i]] == true) { return false; } } return true; } }
 */