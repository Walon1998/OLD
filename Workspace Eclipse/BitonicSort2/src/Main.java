import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * @author Neville Walo
 *
 * Datum: 14.06.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 50000000;

		int[] array = RandomArray(size);
		int[] array2 = Arrays.copyOf(array, size);

		ForkJoinPool POOL = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		long stime = System.currentTimeMillis();
		POOL.invoke(new BitonicSort(array));
		long etime = System.currentTimeMillis();
		System.out.println(etime - stime);
		POOL.shutdown();
		long time = System.currentTimeMillis();
		Arrays.sort(array2);
		System.out.println(System.currentTimeMillis() - time);
		// checkArrays(array, array2);
		// System.out.println(Arrays.toString(array));
		// System.out.println(Arrays.toString(array2));

	}

	/**
	 * @param array2
	 * @param array
	 *
	 */
	private static void checkArrays(int[] array, int[] array2) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array2[i]) {
				System.out.println(false);
				break;
			}
		}

	}

	/**
	 * @param i
	 * @return
	 */
	private static int[] RandomArray(int i) {
		int[] array = new int[i];
		Random R = new Random();
		for (int j = 0; j < i; j++) {
			array[j] = R.nextInt();

		}

		return array;
	}

}
