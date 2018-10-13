import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		int size = 1000000;
		int[] array = new int[size];
		int[] array2 = new int[size];
		Random R = new Random();
		for (int i = 0; i < size; i++) {
			int j = R.nextInt();
			array[i] = j;
			array2[i] = j;
		}
		// long start = System.currentTimeMillis();
		// Arrays.sort(array);

		// System.out.println(Arrays.toString(array));
		// System.out.println(System.currentTimeMillis() - start);
		long start = System.currentTimeMillis();
		Quicksort.quicksort(array, 0, array.length - 1);
		// System.out.println(Arrays.toString(array));
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void quicksort(int[] array, int links, int rechts) {

		if (links < rechts) {
			int pivot = Quicksort.teile(array, links, rechts);
			Quicksort.quicksort(array, links, pivot);
			Quicksort.quicksort(array, pivot + 1, rechts);

		}

	}

	private static int teile(int[] array, int links, int rechts) {
		int i = links;
		int j = rechts - 1;
		int pivot = array[rechts];

		while (i < j) {
			while ((array[i] < pivot) && (i < (rechts - 1))) {
				i++;
			}
			while ((array[j] > pivot) && (j > links)) {
				j--;
			}
			if (i < j) {
				Quicksort.swap(array, i, j);
				// int temp = array[i];
				// array[i] = array[j];
				// array[j] = temp;

			}

		}
		if (array[i] > pivot) {
			Quicksort.swap(array, i, rechts);
			// int temp = array[i];
			// array[i] = array[rechts];
			// array[rechts] = temp;
		}

		return i;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
