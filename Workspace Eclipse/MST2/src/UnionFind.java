/**
 *
 */


/**
 * @author Neville Walo
 * Datum: 22.02.2018
 *
 */
public class UnionFind {
	int[] children;
	int[] parent;

	UnionFind(int grenze) {
		this.children = new int[grenze];
		this.parent = new int[grenze];
		for (int i = 0; i < grenze; i++) {
			this.parent[i] = i;
		}
	}

	int Find(int x) {
		int root = this.parent[x];

		if (x == root) {
			return x;
		} else {
			return this.parent[x] = this.Find(root);
		}

	}

	void Union(int i, int j) {
		int root1 = this.Find(i);
		int root2 = this.Find(j);

		if (this.children[root1] > this.children[root2]) {
			this.parent[root2] = root1;
			this.children[root1] += this.children[root2] + 1;
		} else if (this.children[root2] > this.children[root1]) {
			this.parent[root1] = root2;
			this.children[root2] += this.children[root1] + 1;
		} else {
			this.parent[root2] = root1;
			this.children[root1]++;
		}
	}

}



