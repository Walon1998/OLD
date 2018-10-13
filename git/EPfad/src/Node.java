
/**
 * @author Neville Walo
 *
 *         Datum: 14.04.2018
 */
public class Node {
	int id;
	Node next;
	Node prev;
	boolean visited;

	Node(int id) {
		visited = false;
		this.id = id;

	}
}
