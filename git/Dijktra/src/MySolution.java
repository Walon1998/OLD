import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Neville Walo Datum: 02.03.2018
 *
 */

// Löst das Problem wie von mir beschrieben
public class MySolution extends Thread {

	File file;
	int size;

	MySolution(File file) {
		this.file = file;

	}

	@Override
	public void run() {
		ArrayList<Integer> wichtig = new ArrayList<>();
		ArrayList<Node> Nodes = new ArrayList<>();
		// Startknoten =0
		// Zielknoten=n-1
		// Lese file ein
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
			// Kommt ohne dualen Graphen aus
			graph.get(u).add(new Edge(u, v, weight));
		}
		// Starte Dijkstra von Knoten 0 aus
		Dijkstra(graph, 0, Nodes);

		// Starte Backtracking von Knoten n-1 aus
		Backtracking(Nodes.get(n - 1), wichtig);
		// System.out.println(wichtig);
		size = wichtig.size();
		System.out.println(wichtig);
		sc.close();
	}

	private void Dijkstra(ArrayList<ArrayList<Edge>> graph, int start, ArrayList<Node> Nodes) {
		// Initialisere Heap
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		// Setze alle Knotengewichte =unendlich
		for (Node n : Nodes) {
			n.weight = 99999;
		}
		// Setze Knotengewicht startknoten=0 und fügen ihn in den Heap ein
		Nodes.get(start).weight = 0;
		minHeap.add(Nodes.get(start));

		while (!minHeap.isEmpty()) {
			Node min = minHeap.remove();
			// Falls neuer kürzsester Weg gefunden wird, aktualisiere Knotengewicht und
			// lösche bisherige Vorgönger und füge neuer Knoten welcher auf neuem kürzsten
			// Weg liegt zu Vorgänger von v hinzu
			for (Edge e : graph.get(min.node)) {
				if ((min.weight + e.weight) < Nodes.get(e.v).weight) {
					minHeap.remove(Nodes.get(e.v));
					Nodes.get(e.v).weight = min.weight + e.weight;
					minHeap.add(Nodes.get(e.v));
					Nodes.get(e.v).vorgaegner.clear();
					Nodes.get(e.v).vorgaegner.add(min);
					// Falls ein gleich schneller WEg gefunden wird, für den Vorgänger zu v hinzu
				} else if ((min.weight + e.weight) == Nodes.get(e.v).weight) {
					Nodes.get(e.v).vorgaegner.add(min);
				}
			}
		}
	}

	// Backtracking und füge die Knoten die auf einem kürzesten Pfad liegen in
	// "wichtig"
	private void Backtracking(Node node, ArrayList<Integer> wichtig) {

		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node i = stack.pop();
			if (!wichtig.contains(i.node)) {
				wichtig.add(i.node);
			}
			for (Node a : i.vorgaegner) {
				if (!stack.contains(a) && !wichtig.contains(a.node)) {
					stack.add(a);
				}

			}

		}

	}

}
