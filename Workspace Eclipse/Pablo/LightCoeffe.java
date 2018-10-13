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
	// C is the cost of the Java Coffee
	// n is the number of coins in Alice's wallet
	// coin_values[i] and coin_weight[i] are the value and the weight of
	// the i-th coin, respectively (coins are numbered from 0 to n-1).
	static int solve(int C, int n, int[] coin_values, int[] coin_weights) {

		// C = 10;
		// n = 4;
		// int[] coin_values1 = { 5, 5, 10, 1 };
		// int[] coin_weights1 = { 2, 3, 10, 1 };

		int[][] Teven = new int[n][C + 1];
		int[][] Todd = new int[n][C + 1];

		boolean[][] even = new boolean[n][C + 1];
		boolean[][] odd = new boolean[n][C + 1];

		for (int i = 0; i < n; i++) {
			even[i][0] = true;
			odd[i][0] = false;
		}

		for (int i = 0; i < (n); i++) {
			for (int j = 1; j < (C + 1); j++) {

				if (i == 0) {
					if (j == coin_values[i]) {

						Todd[i][j] = coin_weights[i];
						odd[i][j] = true;
					}

				} else {

					if (j < coin_values[i]) {
						Teven[i][j] = Teven[i - 1][j];
						Todd[i][j] = Todd[i - 1][j];

						even[i][j] = even[i - 1][j];
						odd[i][j] = odd[i - 1][j];

					} else {

						if ((j - coin_values[i]) >= 0) {

							if (even[i - 1][j - coin_values[i]] == true) {

								Todd[i][j] = Math.max(Todd[i - 1][j],
										Teven[i - 1][j - coin_values[i]] + coin_weights[i]);
								odd[i][j] = true;

							} else {
								Todd[i][j] = Todd[i - 1][j];
								odd[i][j] = odd[i - 1][j];
							}

							if (odd[i - 1][j - coin_values[i]] == true) {
								Teven[i][j] = Math.max(Teven[i - 1][j],
										Todd[i - 1][j - coin_values[i]] + coin_weights[i]);
								even[i][j] = true;
							} else {
								Teven[i][j] = Teven[i - 1][j];
								even[i][j] = even[i - 1][j];
							}

						} else {
							Teven[i][j] = Teven[i - 1][j];
							Todd[i][j] = Todd[i - 1][j];
							even[i][j] = even[i - 1][j];
							odd[i][j] = odd[i - 1][j];
						}
					}

				}
			}

		}

		return Teven[n - 1][C];

	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("public_testcases/extra.in.txt"));
		int ntestcases = scanner.nextInt();

		for (int testno = 0; testno < ntestcases; testno++) {
			int C = scanner.nextInt();

			int n = scanner.nextInt();
			int[] coin_values = new int[n];
			int[] coin_weights = new int[n];

			for (int i = 0; i < n; i++) {
				coin_values[i] = scanner.nextInt();
			}

			for (int i = 0; i < n; i++) {
				coin_weights[i] = scanner.nextInt();
			}

			System.out.println(solve(C, n, coin_values, coin_weights));
		}

		scanner.close();
	}
}
