import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Neville Walo Datum: 02.03.2018
 *
 */
// Löst das Problem wie in der Musterlösung beschrieben
public class Musterlosung extends Thread {
	File file;
	boolean correct;
	int size;

	Musterlosung(File file) {
		this.file = file;
		correct = true;
	}

	@Override
	public void run() {
		// Lese Graph ein
		// Startknoten =0
		// Zielknoten=n-1
		ArrayList<Integer> wichtig = new ArrayList<>();
		ArrayList<Node> Nodes = new ArrayList<>();
		Scanner sc = null;

		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] abstand1 = new int[n];
		int[] abstand2 = new int[n];
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		ArrayList<ArrayList<Edge>> graph2 = new ArrayList<>();
		// Initialise the graph
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Edge>());
			graph2.add(new ArrayList<Edge>());
			Nodes.add(new Node(i));
		}

		// Read the graph
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int weight = sc.nextInt();

			// Store the weighted edges into the graph
			// Speichert den Dualen Graphen
			graph.get(u).add(new Edge(u, v, weight));
			graph2.get(v).add(new Edge(v, u, weight));
		}
		// Berechne Abstand von Start 0 und Endknoten n-1
		abstand1 = Dijkstra(graph, 0, Nodes);
		abstand2 = Dijkstra(graph2, n - 1, Nodes);

		// Prüfe ob Bedieungen gegeben ist und füge die Knoten welche auf kürzestem Weg
		// liegen zu wichtig hinzu
		int distance = abstand1[n - 1];
		for (int i = 0; i < n; i++) {
			if ((abstand1[i] + abstand2[i]) == distance) {
				wichtig.add(i);
			}

		}
		// Prüfe ob das Ziel überhaupt von Start erreichbar ist
		if (abstand1[n - 1] == Integer.MAX_VALUE) {
			correct = false;
		} else {
			size = wichtig.size();
		}
		System.out.println(wichtig);
	}

	// Führt Dijkstra aus
	private int[] Dijkstra(ArrayList<ArrayList<Edge>> graph, int start, ArrayList<Node> Nodes) {
		int[] abstand = new int[Nodes.size()];
		Arrays.fill(abstand, Integer.MAX_VALUE);
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		for (Node n : Nodes) {
			n.weight = 99999;
		}
		Nodes.get(start).weight = 0;
		minHeap.add(Nodes.get(start));
		while (!minHeap.isEmpty()) {
			Node min = minHeap.remove();
			abstand[min.node] = min.weight;

			for (Edge e : graph.get(min.node)) {
				if ((min.weight + e.weight) < Nodes.get(e.v).weight) {
					minHeap.remove(Nodes.get(e.v));
					Nodes.get(e.v).weight = min.weight + e.weight;
					minHeap.add(Nodes.get(e.v));
				}
			}
		}
		return abstand;
	}

}
