import java.util.Scanner;

/* NB: For the judge to run the program, do not modify the declaration of the class Main or
 *     method main() below. The class has to be declared as "class Main { ... }"
 *     and the method as "public static void main(String[] args) { ... }" */
//Programm für Online Judge
class Main {
	// Gloabe Hilfsmatrix
	public static int Mhilfe[][];
	static int n;

	// Stores the matrix M.
	// Element m_{i,j} (with 1<=i,j<=n) is stored in M[i][j]. Entries of the form
	// M[i][0] and M[0][j] are equal to 0.
	static int[][] M;

	static void preprocess() {
		// Bereite die Matrix Mhilfe vor. Berechnet alle Submatrixsummen der
		// Eingabematrix M

		// Kopiere die erste Spalte
		for (int i = 0; i < (n + 1); i++) {
			Mhilfe[0][i] = M[0][i];
		}
		// Adiere zuerst die spalten
		for (int i = 1; i < (n + 1); i++) {
			for (int j = 0; j < (n + 1); j++) {
				Mhilfe[i][j] = M[i][j] + Mhilfe[i - 1][j];
			}
		}

		// Dann die Zeilen
		for (int i = 0; i < (n + 1); i++) {
			for (int j = 1; j < (n + 1); j++) {
				Mhilfe[i][j] += Mhilfe[i][j - 1];
			}
		}

	}

	static int query(int a, int b, int c, int d) {

		int result = Mhilfe[b][d];

		// Ziehe das èberflüssige ab
		if (a > 1) {
			result = result - Mhilfe[a - 1][d];
		}
		if (c > 1) {
			result = result - Mhilfe[b][c - 1];
		}

		if ((a > 1) && (c > 1)) {
			result = result + Mhilfe[a - 1][c - 1];
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		Mhilfe = new int[n + 1][n + 1];
		M = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				M[i][j] = scanner.nextInt();

			}

		}

		preprocess();

		int m = scanner.nextInt();
		for (int i = 0; i < m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();

			System.out.println(query(a, b, c, d));
		}

		scanner.close();
	}
}
