import java.util.LinkedList;
import java.util.List;

/**
 * @author Neville Walo Datum: 28.02.2018
 *
 */
public class Node implements Comparable<Node> {
	int node;
	int weight;
	List<Node> vorgaegner;

	Node(int node) {
		this.node = node;
		weight = 999999;
		vorgaegner = new LinkedList<>();

	}

	@Override
	public int compareTo(Node that) {
		return Integer.valueOf(weight).compareTo(Integer.valueOf(that.weight));
	}
}
