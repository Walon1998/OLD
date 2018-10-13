/**
 *UnionFind with Arrays
 */

/**
 * @author Neville Walo
 * Datum: 22.02.2018
 *
 */
public class UnionFind {
	private int[] children;
	private int[] parent;
	private int size;

	UnionFind(int grenze) {
		size = grenze;
		children = new int[grenze];
		parent = new int[grenze];
		for (int i = 0; i < grenze; i++) {
			parent[i] = i;
		}
	}

	int Find(int x) {
		int root = parent[x];

		if (x == root) {
			return x;
		} else {
			return parent[x] = Find(root);
		}

	}

	void Union(int i, int j) {


		int root1 = Find(i);
		int root2 = Find(j);

		if (root1 == root2) {
			return;
		}

		size--;
		if (children[root1] > children[root2]) {
			parent[root2] = root1;
			children[root1] += children[root2] + 1;
		} else if (children[root2] > children[root1]) {
			parent[root1] = root2;
			children[root2] += children[root1] + 1;
		} else {
			parent[root2] = root1;
			children[root1]++;
		}
	}

	/**
	 * Retrun How many diffferent Unions there are!
	 */
	public int getUnionCount() {

		return size;
	}

}
