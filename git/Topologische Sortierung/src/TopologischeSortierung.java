import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TopologischeSortierung {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists; // adjLists[u][j] is the j-th neighbor of vertex u in G (i.e., (u,
	// adjLists[u][j]) is an edge in G)

	public static void main(String[] args) throws FileNotFoundException {

		int[] real = new int[n];
		Deque<Integer> S = new ArrayDeque<Integer>(n);
		int[] A = new int[n];
		int[] Ord = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = 0;
		}

		for (int i = 0; i < n; i++) {
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

		while (!S.isEmpty()) {
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
		System.out.println(Arrays.toString(real));

	}
}
