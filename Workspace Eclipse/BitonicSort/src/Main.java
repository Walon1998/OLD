import java.util.Arrays;
import java.util.Random;

/**
 * @author Neville Walo
 *
 *         Datum: 13.06.2018
 */
public class Main {


	public static void main(String[] args) {
		int size = 1700000;
		Random R = new Random();
		int[] array = new int[size];
		int[] array2 = new int[size];
		int[] array3 = new int[size];

		for (int i = 0; i < array.length; i++) {
			int a = R.nextInt(Integer.MAX_VALUE);
			array[i] = a;
			array2[i] = a;
			array3[i] = a;
		}
		// System.out.println("printed");
		long starttime = System.currentTimeMillis();
		sort(array);
		long endtime = System.currentTimeMillis();
		System.out.println(endtime - starttime);
		long time = System.currentTimeMillis();
		Arrays.sort(array2);
		System.out.println(System.currentTimeMillis() - time);
		for (int i = 0; i < array.length; i++) {
			if (array[i] != array2[i]) {
				System.out.println(false);
			}
		}
		time = System.currentTimeMillis();

		BitonicSort s2 = new BitonicSort(array3);
		System.out.println(System.currentTimeMillis() - time);
		// System.out.println(Arrays.toString(array));
		// System.out.println(Arrays.toString(array2));

	}

	/**
	 * @param array
	 */
	private static void sort(int[] array) {
		// BitonicSorter s = new BitonicSorter(array, 0, array.length, true);
		Last s = new Last(array);

		// s.run();
		// final ForkJoinPool POOL = new
		// ForkJoinPool(Runtime.getRuntime().availableProcessors());
		// POOL.invoke(new BitonicSorter(array, 0, array.length, true));
		// POOL.shutdown();
		// System.out.println("shutdown");
	}

}
