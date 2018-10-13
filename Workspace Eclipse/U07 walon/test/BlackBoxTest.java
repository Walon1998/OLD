import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class BlackBoxTest {

	@Test
	public void testSimple() {
		int[] elevations = new int[] { 3, 1, 2, 5, 3, 6, 5, 6 };
		int[] result1 = new int[] { 3, 0, 3, 5, 5, -1, 5, -1 };
		int[] result2 = new int[] { 3, 0, 3, 5, 5, -1, 7, -1 };
		int[] dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1) || Arrays.equals(dominators, result2));

		elevations = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		result1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 9, 9, 9, 9, 9, 9, 9 };
		result1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -9, -9, -9, -9, -9, -9, -9 };
		result1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 9, 9, 9, 10, 9, 9, 9 };
		result1 = new int[] { 3, 3, 3, -1, 3, 3, 3 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -9, -9, -9, -10, -9, -9, -9 };
		result1 = new int[] { -1, -1, -1, 2, -1, -1, -1 };
		result2 = new int[] { -1, -1, -1, 4, -1, -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1) || Arrays.equals(dominators, result2));

		elevations = new int[] { 0 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 99 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -55 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] {};
		result1 = new int[] {};
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 99, 99 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 99, 98 };
		result1 = new int[] { -1, 0 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 97, 99 };
		result1 = new int[] { 1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -99, 99 };
		result1 = new int[] { 1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 99, -99 };
		result1 = new int[] { -1, 0 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -99, -99 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 0, 0 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 1, 2, 3 };
		result1 = new int[] { 1, 2, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 3, 2, 1 };
		result1 = new int[] { -1, 0, 1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 2, 1, 2 };
		result1 = new int[] { -1, 0, -1 };
		result2 = new int[] { -1, 2, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1) || Arrays.equals(dominators, result2));

		elevations = new int[] { 2, -1, 2 };
		result1 = new int[] { -1, 0, -1 };
		result2 = new int[] { -1, 2, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1) || Arrays.equals(dominators, result2));

		elevations = new int[] { 2, 0, 2 };
		result1 = new int[] { -1, 0, -1 };
		result2 = new int[] { -1, 2, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1) || Arrays.equals(dominators, result2));

		elevations = new int[] { -2, 1, -2 };
		result1 = new int[] { 1, -1, 1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -2, -1, -2 };
		result1 = new int[] { 1, -1, 1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 0 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));
		elevations = new int[] { 1 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -1 };
		result1 = new int[] { -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 0, 0 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 0, 1 };
		result1 = new int[] { 1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 1, 0 };
		result1 = new int[] { -1, 0 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 1, 1 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -1, 0 };
		result1 = new int[] { 1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { 0, -1 };
		result1 = new int[] { -1, 0 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		elevations = new int[] { -1, -1 };
		result1 = new int[] { -1, -1 };
		dominators = BlackBox.dominators(elevations);
		assertTrue(Arrays.equals(dominators, result1));

		for (int n = 3; n < 13; n++) {

			elevations = createArray(-1, n - 1);
			switch (n) {
			case 3:
				result1 = new int[] { 2, 2, -1 };
				break;
			case 4:
				result1 = new int[] { 2, 2, -1, 2 };
				break;
			case 5:
				result1 = new int[] { 2, 2, 4, 4, -1 };
				break;
			case 6:
				result1 = new int[] { 2, 2, 4, 4, -1, 4 };
				break;
			case 7:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, -1 };
				break;
			case 8:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, -1, 6 };
				break;
			case 9:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, 8, 8, -1 };
				break;
			case 10:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, 8, 8, -1, 8 };
				break;
			case 11:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, -1 };
				break;
			case 12:
				result1 = new int[] { 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, -1, 10 };
				break;

			}
			dominators = BlackBox.dominators(elevations);
			assertTrue(Arrays.equals(dominators, result1));

		}

		int size = 10000000;
		int[] array = new int[size];

		Random R = new Random();
		for (int i = 1; i < size; i++) {
			array[i] = R.nextInt((int) Math.pow(2, 31) - 5);
			if ((array[i] % 2) == 0) {
				array[i] = -array[i];
			}

		}
		array[0] = (int) Math.pow(2, 31);

		dominators = BlackBox.dominators(array);
		// dominators[5] = -1;
		assertEquals(dominators[0], -1);
		for (int i = 1; i < size; i++) {

			assertNotLesser(dominators[i], 0);
		}

	}

	private void assertNotLesser(int i, int j) {

		if (i < j) {
			throw new RuntimeException("" + i + " is smaller than " + j + "");
		}

	}

	static private int[] createArray(int start, int end) {
		int size = end - start;
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			if ((i % 2) == 0) {
				res[i] = start + i;
			} else {
				res[i] = start - i;
			}

		}
		return res;
	}

	@Test
	public void testReturnsNull() {
		/*
		 * Dieser Test schlägt fehl und zeigt somit, dass sich die gegebene
		 * BlackBox-Implementierung nicht an die Spezifikation hält. Die Beschreibung
		 * von 'dominators' verlangt, dass 'null' zurückgegeben wird, wenn 'null' als
		 * Argument übergeben wurde.
		 */
		assertEquals(null, BlackBox.dominators(null));
	}
}
