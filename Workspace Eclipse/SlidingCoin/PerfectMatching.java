import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class PerfectMatching {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists;
	static Integer isMatchedWith[];
	static int leererKnoten;
	static int wegZähler = 0;
	// static int knoten;// adjLists[u][j] is the j-th neighbor of vertex u in G
	// (i.e., (u,
	// adjLists[u][j]) is an edge in G)
	static Deque<Integer> S;
	static int zähler = 0;
	static Integer weg[];

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

		isMatchedWith = new Integer[n];
		for (int i = 0; i < n; i++) {
			isMatchedWith[i] = null;
		}
		System.out.print(n);
		int knoten = 0;
		int breaker = 0;
		while (leereKnoten()) {

			// System.out.println("Matching" + Arrays.toString(isMatchedWith));
			// System.out.println("Hi");
			for (int i = 0; i < n; i++) {
				suchePfad(i);
			}
			if (breaker > (n + 1)) {
				return 'A';
			}
			breaker++;

		}

		return 'B';
	}

	private static void suchePfad(int knoten) {

		weg = new Integer[n];
		bereinigeWeg();

		// System.out.println("weg" + Arrays.toString(weg));
		S = new ArrayDeque<Integer>(n);
		S.add(knoten);
		if ((isMatchedWith[knoten] != null) && !isNachfolger(knoten, isMatchedWith[knoten])) {
			// System.out.println("hi2");
			S.clear();

		}
		while (!(S.isEmpty())) {
			int w = S.pollLast();
			weg[wegZähler] = w;
			// System.out.println("Knoten" + w);

			if ((isMatchedWith[w] != null) && isNachfolger(w, isMatchedWith[w])) {
				// System.out.println("hi");
				S.clear();
				S.addFirst(isMatchedWith[w]);
			} else {

				for (int i = 0; i < outdegrees[w]; i++) {
					S.addLast(adjLists[w][i]);
					if (isMatchedWith[adjLists[w][i]] == null) {
						wegZähler++;
						weg[wegZähler] = adjLists[w][i];

						// System.out.println("weg" + Arrays.toString(weg));
						changePfad(knoten, adjLists[w][i]);
						S.clear();
						i = outdegrees[w];
					}
				}
			}
			wegZähler++;
		}

	}

	private static boolean isNachfolger(int w, Integer possibleNachfolger) {

		for (int i = 0; i < outdegrees[w]; i++) {
			if (isMatchedWith[w] == adjLists[w][i]) {
				return true;
			}
		}

		return false;
	}

	private static void changePfad(int knotenAnfang, int Knotenende) {

		// System.out.println("WegZähler" + wegZähler);

		if ((wegZähler % 2) == 1) {
			for (int i = 0; i < wegZähler; i++) {

				if (isMatchedWith[weg[i]] == null) {
					// System.out.println("yes");
					// System.out.println(weg[i + 1]);
					isMatchedWith[weg[i]] = weg[i + 1];

					isMatchedWith[weg[i + 1]] = weg[i];
					// System.out.println("Matching" + Arrays.toString(isMatchedWith));

					if (weg[i + 2] != null) {
						isMatchedWith[weg[i + 2]] = null;
					}

				}
			}

			zähler++;
		}
		if ((wegZähler % 2) == 0) {
			for (int i = 1; i < wegZähler; i++) {
				isMatchedWith[weg[i]] = weg[i + 1];
				isMatchedWith[weg[i + 1]] = weg[i];
				i++;

			}
			isMatchedWith[weg[0]] = null;
		}
		bereinigeWeg();

		// System.out.println("Matching" + Arrays.toString(isMatchedWith));
	}

	private static void bereinigeWeg() {
		for (int i = 0; i < n; i++) {
			weg[i] = null;
			wegZähler = 0;
		}

	}

	private static boolean leereKnoten() {

		for (int i = 0; i < n; i++) {
			if (isMatchedWith[i] == null) {
				leererKnoten = i;
				return true;

			}
		}

		return false;
	}

}
