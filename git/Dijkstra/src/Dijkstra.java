import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//Runs Dijkstra in a normal Heap
// abstand contains the abstand von start zu i
/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 03.03.2018
 *
 */
public class Dijkstra extends Thread {
	ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	ArrayList<Node> Nodes = new ArrayList<>();
	int[] abstand;
	int start;
	Dijkstra(ArrayList<ArrayList<Edge>> graph, int start, ArrayList<Node> Nodes) {
		this.graph = graph;
		this.Nodes = Nodes;
		abstand = new int[Nodes.size()];
		this.start = start;

	}

	@Override
	public void run() {

		Arrays.fill(abstand, Integer.MAX_VALUE);
		PriorityQueue<Node> minHeap = new PriorityQueue<>();
		for (Node n : Nodes) {
			n.weight = 999999;
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
					// Nodes.get(e.v).vorgaegner.clear();
					// Nodes.get(e.v).vorgaegner.add(min);

				} else if ((min.weight + e.weight) == Nodes.get(e.v).weight) {
					// Nodes.get(e.v).vorgaegner.add(min);
				}
			}
		}
	}

}
