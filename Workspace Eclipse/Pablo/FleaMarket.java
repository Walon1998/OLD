//NB: Do not add a package

//NB: Importing classes in other packages is NOT ALLOWED.
//NB: Using classes in other packages in NOT ALLOWED (with the exception of the classes in java.lang.* that are imported by default)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Main {
	// n is the number of items
	// S is the area to free from the basement
	// W is the maximum weight you can carry
	// space[i], weight[i], and price[i] for i=1,...,n are the values s_i, w_i, p_i
	// in the input description
	// space[0], weight[0], and price[0] are 0.
	static int solve(int n, int S, int W, int[] space, int[] weight, int[] price) {
		int[][][] table = new int[n + 1][S + 1][W + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 0; j <= S; j++) {
				for (int k = 1; k <= W; k++) {

					if ((weight[i] <= k) && (space[i] >= j)) {
						table[i][j][k] = price[i];
					}

					if ((weight[i] <= k) && (space[i] >= j)) {
						table[i][j][k] = Math.max(table[i - 1][j][k], price[i]);
					}

					if (((k - weight[i]) >= 0)) {

						if ((j - space[i]) >= 0) {

							if (table[i - 1][j - space[i]][k - weight[i]] > 0) {
								table[i][j][k] = Math.max(table[i][j][k],
										table[i - 1][j - space[i]][k - weight[i]] + price[i]);
							}

						} else {

							if (table[i - 1][0][k - weight[i]] > 0) {
								table[i][j][k] = Math.max(table[i][j][k], table[i - 1][0][k - weight[i]] + price[i]);
							}

						}
						table[i][j][k] = Math.max(table[i - 1][j][k], table[i][j][k]);
					} else {
						table[i][j][k] = Math.max(table[i - 1][j][k], table[i][j][k]);
					}

				}
			}
		}

		return table[n][S][W];

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));

		int ntestcases = scanner.nextInt();
		for (int t = 0; t < ntestcases; t++) {
			int n = scanner.nextInt();
			int S = scanner.nextInt();
			int W = scanner.nextInt();

			int[] space = new int[n + 1];
			int[] weight = new int[n + 1];
			int[] price = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				space[i] = scanner.nextInt();
				weight[i] = scanner.nextInt();
				price[i] = scanner.nextInt();
			}

			System.out.println(solve(n, S, W, space, weight, price));
		}

		scanner.close();
	}
}
