import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author Neville Walo
 *
 * Datum: 10.06.2018
 */
public class Counter implements Callable<Integer> {
	final int SIZE;
	public int longest;
	public Counter(int size) {
		SIZE = size;

	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {

		int[] array = new int[SIZE];
		Random R = new Random();
		boolean last = R.nextBoolean();
		int counter = 1;
		int max = 0;
		for (int j = 1; j < SIZE; j++) {
			boolean next = R.nextBoolean();
			if (next != last) {
				array[counter]++;
				max = Math.max(max, counter);
				counter = 0;
			}
			last = next;
			counter++;

		}
		max = Math.max(max, counter);
		array[counter]++;
		longest = max;

		System.out.println(Arrays.toString(array));
		return max;
	}

}
