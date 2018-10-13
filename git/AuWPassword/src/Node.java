import java.util.ArrayList;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 08.03.2018
 *
 */
public class Node {
	String name;
	boolean besucht;
	public int komponente;
	public int vorgaenger;
	public int nachfolger;
	ArrayList<String> nachfolgerlist = new ArrayList<>();

	Node(String name) {
		this.name = name;
		besucht = false;
	}

}
