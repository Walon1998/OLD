
/**
 * @author Neville Walo
 *
 * Datum: 28.06.2018
 */
public class Tupel {
	int from;
	int to;
	double probability;

	Tupel(int from, int to, double probability) {
		this.from = from;
		this.to = to;
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "" + from + ", " + to + ", " + probability + "";
	}

}
