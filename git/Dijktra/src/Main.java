import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

/**
 *
 */

/**
 * @author Neville Walo Datum: 28.02.2018
 *
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		int tests = 1;

		for (int i = 0; i < tests; i++) {

			File file = generateRandomInput();
			// File file = new File("test5.txt");

			Musterlosung solution = new Musterlosung(file);
			solution.start();
			MySolution solution2 = new MySolution(file);
			solution2.start();
			solution.join();
			solution2.join();

			// Checks if Zielknoten ist von start erreichbar
			if (solution.correct) {
				// Falls erreichbar und beide Lösungen übereinstimmen: print "true"
				if (solution.size == solution2.size) {

					System.out.println("true");

					// Falls erreichbar und ungeleich, gib fehler aus
				} else {

					System.out.println("false");
					System.out.println();
					break;
				}
			}

		}

	}

	// Generates Random Input
	// Form:It starts with a line containing two integers n m, separated by space,
	// denoting the number
	// of vertices of G and number of edges of G
	// The next m lines contain three integers u v w, separated by space, indicating
	// that {u, v} is
	// an edge of the graph G of weight w
	private static File generateRandomInput() throws FileNotFoundException {
		int nMax = 100;
		int mMax = 1000;
		File file = new File("RandomInput");
		PrintStream aus = new PrintStream(file);
		Random R = new Random();
		int n = R.nextInt(nMax);
		int m = R.nextInt(mMax);
		if (n == 0) {
			n = 10;
		}
		if (m == 0) {
			m = 10;
		}
		aus.print(n);
		aus.print(" ");
		aus.print(m);
		aus.println();
		for (int i = 0; i < m; i++) {
			aus.print(R.nextInt(n));
			aus.print(" ");
			aus.print(R.nextInt(n));
			aus.print(" ");
			int weight = R.nextInt(100);
			if (weight == 0) {
				weight = 1;
			}
			aus.print(weight);
			aus.print(" ");
			aus.println();
		}
		aus.close();
		return file;
	}
}
