import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 24.02.2018
 *
 */
public class MSTPrim {
	int adjlist[];
	int eltern[];
	int abstand[];
	PriorityQueue<Edge> que = new PriorityQueue<>();

	MSTPrim(int knotenmenge) {
		this.abstand = new int[knotenmenge];
		Arrays.fill(this.abstand, Integer.MAX_VALUE);
		this.abstand[0] = 0;
		this.eltern = new int[knotenmenge];
		Arrays.fill(this.eltern, -1);
	}

}
