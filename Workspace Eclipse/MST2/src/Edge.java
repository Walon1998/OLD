
/**
 * @author Neville Walo
 *
 * Datum: 14.08.2018
 */
public class Edge implements Comparable{
	int from;
	int to;
	Integer weight;

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Edge e = (Edge) o;
		return weight.compareTo(e.weight);
	}


}
