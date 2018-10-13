
import java.util.ArrayDeque;
import java.util.Deque;

public class AbstandUnitär {
	static int n; // the number of vertices in G
	static int[] outdegrees; // outdegrees[u] is the out-degree of vertex u in G
	static int[][] adjLists; // adjLists[u][j] is the j-th neighbor of vertex u in G (i.e., (u,
								// adjLists[u][j]) is an edge in G)

	public static void main(String[] args) {
		// Von Konten s nach Knoten;
		int s = 0;
		int t = 6;
		Integer[] P = new Integer[n];
		Deque<Integer> S = new ArrayDeque<Integer>(n);
		S.add(0);
		while (!(S.isEmpty())) {
			int u = S.pollFirst();
			for (int i = 0; i < outdegrees[u]; i++) {
				int v = adjLists[u][i];
				if (P[v] == null) {
					P[v] = u;
					S.addLast(v);
				}
			}
		}

		int v = t;
		int abstand = 0;
		// System.out.print(t);
		while (v != s) {
			v = P[v];
			abstand++;
		}
		System.out.println(abstand);
	}
}