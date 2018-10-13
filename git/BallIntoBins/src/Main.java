import java.util.ArrayList;
import java.util.Random;

/**
 * @author Neville Walo
 *
 * Datum: 04.05.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random R = new Random();
		final int N = 100000000;

		ArrayList<Bin> list = new ArrayList<Bin>();
		for (int i = 1; i <= N; i++) {
			list.add(new Bin());
		}
		for (int i = 1; i <= N; i++) {
			int a = R.nextInt(N);
			list.get(a).counter++;
		}
		int counter = 0;
		for (Bin i : list) {
			if (i.counter == 0) {
				counter++;
			}
		}
		double ratio = (double) counter / (double) N;
		System.out.print("Empty Bins: ");
		System.out.println(ratio);

	}

}
