package public_testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class TutteTheorem {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists; // adjLists[u][j] is the j-th neighbor of vertex u in G (i.e., (u,
								// adjLists[u][j]) is an edge in G)
	static boolean visited[];

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
		int summeZK = 0;
		int groesseZusammenhangkomponente = 0;
		visited = new boolean[n];

		Deque<Integer> S = new ArrayDeque<Integer>(n);
		S.add(0);
		while (!(S.isEmpty())) {
			int w = S.pollFirst();
			groesseZusammenhangkomponente++;
			visited[w] = true;
			for (int i = 0; i < outdegrees[w]; i++) {
				if ((visited[adjLists[w][i]] == false) && !S.contains(adjLists[w][i])) {
					S.addLast(adjLists[w][i]);
				}
			}

		}
		System.out.println(groesseZusammenhangkomponente);
		if ((groesseZusammenhangkomponente % 2) == 1) {
			return 'A';
		}

		return 'B';
	}
}