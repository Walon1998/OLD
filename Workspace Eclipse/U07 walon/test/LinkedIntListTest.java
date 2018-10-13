import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Random;

import org.junit.Test;

public class LinkedIntListTest {

	@Test
	public void testRandom() {
		Random rand = new Random(42);
		LinkedIntList ll = new LinkedIntList();
		for (int n = 0; n < 9721; n++) {
			int choice = rand.nextInt(6);
			int value = rand.nextInt();
			if (choice == 0) {
				ll.addFirst(value);
			} else if (choice == 1) {
				ll.addLast(value);
			} else if ((choice == 2) && !ll.isEmpty()) {
				ll.removeFirst();
			} else if ((choice == 3) && !ll.isEmpty()) {
				ll.removeLast();
			} else if ((choice == 4) && !ll.isEmpty()) {
				ll.set(rand.nextInt(ll.size), value);
			} else if ((choice == 5) && ((value % 5) == 0)) {
				ll.clear();
			}
		}

		String msg = "There is a bug in your LinkedIntList";
		assertFalse(msg, ll.isEmpty());
		assertEquals(msg, 5, ll.size);
		int[] expect = new int[] { -1759285598, -424345731, -1746103561, -1623993329, -1831395423 };
		assertArrayEquals(msg, expect, ll.toArray());
	}

	@Test
	public void testLinkedIntList() {
		// fail("Not yet implemented");
	}

	@Test
	public void testAddLast() {
		// fail("Not yet implemented");
	}

	@Test
	public void testAddFirst() {
		// fail("Not yet implemented");
	}

	@Test
	public void testRemoveFirst() {
		// fail("Not yet implemented");
	}

	@Test
	public void testRemoveLast() {
		// fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		// fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		// fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		// fail("Not yet implemented");
	}

	@Test
	public void testSet() {
		// fail("Not yet implemented");
	}

	@Test
	public void testToArray() {
		// fail("Not yet implemented");
	}

}
