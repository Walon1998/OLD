import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedIntListTest {

	public LinkedIntList toList(int... elems) {
		LinkedIntList res = new LinkedIntList();

		if (elems.length == 1) {
			res.first = res.last = new IntNode(elems[0]);
			res.size = 1;
		} else if (elems.length > 1) {
			IntNode newNode = new IntNode(elems[0]);
			res.first = newNode;

			for (int i = 1; i < elems.length; i++) {
				newNode.next = new IntNode(elems[i]);
				newNode.next.prev = newNode;
				newNode = newNode.next;
			}
			res.last = newNode;
			res.size = elems.length;
		}
		assertConsistency(res);
		return res;
	}

	public void assertConsistency(LinkedIntList list) {
		assertEquals(list.first == null, list.last == null);
		assertEquals(list.first == null, list.isEmpty());
		assertEquals(list.first == null, list.size == 0);

		if (!list.isEmpty()) {
			assertTrue(list.first.prev == null);
			assertTrue(list.last.next == null);
		}
		
		int count = 0;
		for (IntNode n = list.first; n != null; n = n.next) {
			count++;
			if (n.next != null) {
				assertTrue(n.next.prev == n);
			} else {
				assertTrue(n == list.last);
			}
			
			if (n.prev != null) {
				assertTrue(n.prev.next == n);
			} else {
				assertTrue(n == list.first);
			}
		}
		
		assertEquals(count, list.size);
	}
    
	@Test
	public void testGet() {
		assertEquals(1, toList(1).get(0));

		LinkedIntList list = toList(1, 2);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));

		list = toList(1, 2, 3);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(3, list.size);
	}
    
    @Test
    public void testGetIndexOutOfBounds() {
       RuntimeException caught = null;
        try {
            new LinkedIntList().get(0);
        } catch(RuntimeException e) {
            caught = e;
        }
        
        assertNotNull(caught);
        assertEquals("index out of bounds: 0", caught.getMessage());
    }

	@Test
	public void testSet() {
		LinkedIntList list = toList(1);
		list.set(0, 7);
		assertEquals(7, list.get(0));

		list = toList(1, 2);
		list.set(1, 7);
		assertArrayEquals(new int[] { 1, 7 }, list.toArray());
		list.set(0, 8);
		assertArrayEquals(new int[] { 8, 7 }, list.toArray());

		list = toList(1, 2, 3);
		list.set(0, 7);
		list.set(1, 8);
		list.set(2, 9);
		assertArrayEquals(new int[] { 7, 8, 9 }, list.toArray());
		assertEquals(3, list.size);
	}
    
    @Test
    public void testSetIndexOutOfBounds() {
       RuntimeException caught = null;
        try {
            new LinkedIntList().set(0, 0);
        } catch(RuntimeException e) {
            caught = e;
        }
        
        assertNotNull(caught);
        assertEquals("index out of bounds: 0", caught.getMessage());
    }

	@Test
	public void testIsEmpty() {
		assertEquals(true, new LinkedIntList().isEmpty());
		assertEquals(false, toList(1).isEmpty());
		assertEquals(false, toList(1, 2, 3).isEmpty());
	}

	@Test
	public void testAddFirst() {
		LinkedIntList list = new LinkedIntList();
		list.addFirst(7);
		assertEquals(7, list.get(0));
		assertEquals(1, list.size);
		assertConsistency(list);

		list = toList(1);
		list.addFirst(7);
		assertArrayEquals(new int[] { 7, 1 }, list.toArray());
		assertEquals(2, list.size);
		assertConsistency(list);
		list.addFirst(8);
		assertArrayEquals(new int[] { 8, 7, 1 }, list.toArray());
		assertEquals(3, list.size);
		assertConsistency(list);
	}

	@Test
	public void testAddLast() {
		LinkedIntList list = new LinkedIntList();
		list.addLast(7);
		assertEquals(7, list.get(0));
		assertEquals(1, list.size);
		assertConsistency(list);

		list = toList(1);
		list.addLast(7);
		assertArrayEquals(new int[] { 1, 7 }, list.toArray());
		assertEquals(2, list.size);
		assertConsistency(list);
		list.addLast(8);
		assertArrayEquals(new int[] { 1, 7, 8 }, list.toArray());
		assertEquals(3, list.size);
		assertConsistency(list);
	}

	@Test
	public void testRemoveFirst() {
		LinkedIntList list = toList(1);
		assertEquals(1, list.removeFirst());
		assertEquals(0, list.size);
		assertConsistency(list);

		list = toList(1, 2, 3);
		assertEquals(1, list.removeFirst());
		assertEquals(2, list.size);
		assertConsistency(list);
		assertEquals(2, list.removeFirst());
		assertEquals(1, list.size);
		assertConsistency(list);
		assertEquals(3, list.removeFirst());
		assertEquals(0, list.size);
		assertConsistency(list);
	}
    
    @Test
    public void testRemoveFirstEmpty() {
       RuntimeException caught = null;
        try {
            new LinkedIntList().removeFirst();
        } catch(RuntimeException e) {
            caught = e;
        }
        
        assertNotNull(caught);
        assertEquals("nothing to remove", caught.getMessage());
    }

	@Test
	public void testRemoveLast() {
		LinkedIntList list = toList(1);
		assertEquals(1, list.removeLast());
		assertEquals(0, list.size);
		assertConsistency(list);

		list = toList(1, 2, 3);
		assertEquals(3, list.removeLast());
		assertEquals(2, list.size);
		assertConsistency(list);
		assertEquals(2, list.removeLast());
		assertEquals(1, list.size);
		assertConsistency(list);
		assertEquals(1, list.removeLast());
		assertEquals(0, list.size);
		assertConsistency(list);
	}
    
    @Test
    public void testRemoveLastEmpty() {
       RuntimeException caught = null;
        try {
            new LinkedIntList().removeLast();
        } catch(RuntimeException e) {
            caught = e;
        }
        
        assertNotNull(caught);
        assertEquals("nothing to remove", caught.getMessage());
    }

	@Test
	public void testRemoveNode() {
		LinkedIntList list = toList(1);
		list.removeNode(list.first);
		assertEquals(0, list.size);
		assertConsistency(list);
		
		list = toList(1, 2, 3);
		list.removeNode(list.first.next);
		assertEquals(2, list.size);
		assertArrayEquals(new int[] { 1, 3 }, list.toArray());
		assertConsistency(list);
		
		list.removeNode(list.last);
		assertEquals(1, list.size);
		assertArrayEquals(new int[] { 1 }, list.toArray());
		assertConsistency(list);
	}
	
	@Test
	public void testClear() {
		LinkedIntList list = new LinkedIntList();
		list.clear();
		assertEquals(0, list.size);
		assertConsistency(list);

		list = toList(1);
		list.clear();
		assertEquals(0, list.size);
		assertConsistency(list);

		list = toList(1, 2);
		list.clear();
		assertEquals(0, list.size);
		assertConsistency(list);

		list = toList(1, 2, 3);
		list.clear();
		assertEquals(0, list.size);
		assertConsistency(list);
	}

	@Test
	public void testToArray() {
		LinkedIntList list = new LinkedIntList();
		assertArrayEquals(new int[] {}, list.toArray());
		assertArrayEquals(new int[] { 1 }, toList(1).toArray());
		assertArrayEquals(new int[] { 1, 2 }, toList(1, 2).toArray());
		assertArrayEquals(new int[] { 1, 2, 3 }, toList(1, 2, 3).toArray());
	}

}
