import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlackBoxTest {

	@Test
	public void testRotateArray() {
		int[] values = new int[] { 1, 2 };
		int[] expected = new int[] { 2, 1 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);

		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expected = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);

		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expected = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		BlackBox.rotateArray(values, -1);
		assertArrayEquals(expected, values);

		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expected = new int[] { 9, 1, 2, 3, 4, 5, 6, 7, 8 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);

		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expected = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		BlackBox.rotateArray(values, 3);
		assertArrayEquals(expected, values);

		values = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		expected = new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		BlackBox.rotateArray(values, -3);
		assertArrayEquals(expected, values);

		values = new int[] { 0, 0, 0, 1, 0, 0, };
		expected = new int[] { 0, 1, 0, 0, 0, 0, };
		BlackBox.rotateArray(values, 100000000);
		assertArrayEquals(expected, values);

		values = new int[] { -1, -2, -3, 4, -5, -6, -7, -8, -9 };
		expected = new int[] { -1, -2, -3, 4, -5, -6, -7, -8, -9 };
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);

		values = new int[] { -1, -2, -3, 4, -5, -6, -7, -8, -9 };
		expected = new int[] { -9, -1, -2, -3, 4, -5, -6, -7, -8 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);

		values = new int[] { -1, -2, -3, 4, -5, -6, -7, -8, -9 };
		expected = new int[] { -2, -3, 4, -5, -6, -7, -8, -9, -1 };
		BlackBox.rotateArray(values, -1);
		assertArrayEquals(expected, values);

		values = new int[] {};
		expected = new int[] {};
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);

		values = new int[] {};
		expected = new int[] {};
		BlackBox.rotateArray(values, 5);
		assertArrayEquals(expected, values);

		values = new int[] {};
		expected = new int[] {};
		BlackBox.rotateArray(values, -5);
		assertArrayEquals(expected, values);

		BlackBox.rotateArray(null, 0);
		BlackBox.rotateArray(null, 1);
		BlackBox.rotateArray(null, -1);

		expected = new int[] {};
		values = new int[] {};
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);

		expected = new int[] { 1 };
		values = new int[] { 1 };
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);
		BlackBox.rotateArray(values, -1);
		assertArrayEquals(expected, values);

		expected = new int[] { 1, 2 };
		values = new int[] { 1, 2 };
		BlackBox.rotateArray(values, 0);
		assertArrayEquals(expected, values);
		BlackBox.rotateArray(values, 2);
		assertArrayEquals(expected, values);
		BlackBox.rotateArray(values, -2);
		assertArrayEquals(expected, values);
		expected = new int[] { 2, 1 };
		values = new int[] { 1, 2 };
		BlackBox.rotateArray(values, 1);
		assertArrayEquals(expected, values);
		values = new int[] { 1, 2 };
		BlackBox.rotateArray(values, -1);
		assertArrayEquals(expected, values);

		int[] rotations = createRangeArray(-42, 43);
		for (int n = 0; n < 13; n++) {
			for (int steps : rotations) {
				expected = createRangeArray(-1, n - 1);
				values = expected.clone();
				BlackBox.rotateArray(values, steps);
				for (int i = 0; i < values.length; i++) {
					assertEquals(expected[(((i - steps) % n) + n) % n], values[i]);
				}
			}
		}

	}

	static private int[] createRangeArray(int start, int end) {
		int size = end - start;
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = start + i;
		}
		return res;
	}

}
