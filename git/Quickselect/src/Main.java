import java.util.Random;

/**
 * @author Neville Walo
 *
 * Datum: 27.06.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 45, 6, 8, 4 };
		int i = quickselect(array, 7);
		System.out.println(i);
		// TODO Auto-generated method stub

	}

	static int quickselect(int[] array, int key) {
		return quickselect(array, 0, array.length - 1, key, new Random());
	}

	static int quickselect(int[] Array, int links, int rechts, int key, Random random) {
		if (links == rechts) {
			return Array[links];
		}
		int pivotstelle = pivot(Array, links, rechts, random);
		if (key == pivotstelle) {
			return Array[pivotstelle];
		} else if (key < pivotstelle) {
			return quickselect(Array, links, pivotstelle - 1, key, random);
		} else {
			return quickselect(Array, pivotstelle + 1, rechts, key, random);
		}



	}

	/**
	 * @param array
	 * @param links
	 * @param rechts
	 * @param random
	 * @return
	 */
	private static int pivot(int[] array, int links, int rechts, Random random) {
		int pivot = random.nextInt(rechts - links + 1) + links;
		int value = array[pivot];
		swap(array, pivot, rechts);
		int i = links;
		int j = rechts - 1;
		while (i <= j) {
			if (array[i] > value) {
				while (j > i && array[j] > value) {
					j--;
				}
				swap(array, i, j);
				j--;
			} else {
				i++;
			}
		}
		swap(array, i, rechts);
		return i;
	}

	/**
	 * @param array
	 * @param pivot
	 * @param rechts
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

	}

}
