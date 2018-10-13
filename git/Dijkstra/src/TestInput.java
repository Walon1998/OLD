import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 03.03.2018
 *
 */
public class TestInput {
	// Testinput für Dijkstra
	// Form:It starts with a line containing two integers n m, separated by space,
	// denoting the number
	// of vertices of G and number of edges of G
	// The next m lines contain three integers u v w, separated by space, indicating
	// that {u, v} is
	// an edge of the graph G of weight w

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Node> Nodes = new ArrayList<>();
		File file = new File("test.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		// Initialise the graph
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Edge>());
			Nodes.add(new Node(i));
		}

		// Read the graph
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int weight = sc.nextInt();

			// Store the weighted edges into the graph
			graph.get(u).add(new Edge(u, v, weight));
		}
		Dijkstra d = new Dijkstra(graph, 0, Nodes);
		d.start();
		d.join();
		System.out.println(Arrays.toString(d.abstand));

	}

}
