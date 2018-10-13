package public_testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class topoRuck {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists; // adjLists[u][j] is the j-th neighbor of vertex u in G (i.e., (u,
								// adjLists[u][j]) is an edge in G)
	static boolean[] isWinner;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
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
		isWinner = new boolean[n];

		int[] real = new int[n];
		Deque<Integer> S = new ArrayDeque<Integer>(n);
		int[] A = new int[n];
		int[] Ord = new int[n];
		for (int i = 0; i < (n); i++) {
			A[i] = 0;
		}

		for (int i = 0; i < (n); i++) {
			for (int j = 0; j < outdegrees[i]; j++) {
				A[adjLists[i][j]]++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (A[i] == 0) {
				S.addLast(i);
			}
		}

		int i = 1;

		while (!(S.isEmpty())) {
			int v = S.pollLast();
			// System.out.println(v);
			Ord[v] = i;
			i++;

			for (int j = 0; j < outdegrees[v]; j++) {

				A[adjLists[v][j]]--;
				if (A[adjLists[v][j]] == 0) {
					S.addLast(adjLists[v][j]);

				}

			}

		}
		// System.out.println(Arrays.toString(Ord));
		for (i = 0; i < n; i++) {
			real[Ord[i] - 1] = i;

		}
		// System.out.println(Arrays.toString(real));
		for (int k = n - 1; k > 0; k--) {

			if (outdegrees[real[k]] == 0) {
				isWinner[real[k]] = false;
			} else if (onlyLoosers(real[k])) {
				isWinner[real[k]] = true;

			} else if (onlyGewinner(real[k])) {
				isWinner[real[k]] = false;
			} else {
				isWinner[real[k]] = true;
			}
			// System.out.println(Arrays.toString(isWinner));
			// System.out.println(real[k]);
		}

		// System.out.println(Arrays.toString(Ord));

		if (isWinner[0] == true) {
			return 'A';
		}
		return 'B';

	}

	private static boolean onlyGewinner(int knoten) {
		for (int i = 0; i < outdegrees[knoten]; i++) {
			// System.out.println(knoten);
			if (isWinner[adjLists[knoten][i]] == false) {
				return false;
			}
		}
		return true;

	}

	private static boolean onlyLoosers(int knoten) {
		for (int i = 0; i < outdegrees[knoten]; i++) {
			// System.out.println(knoten);
			if (isWinner[adjLists[knoten][i]] == true) {
				return false;
			}
		}
		return true;
	}
}
