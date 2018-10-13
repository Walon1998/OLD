/**
 * A doubly-linked list of {@link int}s with fast {@link #addFirst(int)},
 * {@link #addLast(int)}, {@link #removeFirst()}, and {@link #removeLast()}
 * methods. Removal in the interior of the list is supported as well.
 */
public class LinkedIntList {

	IntNode first;
	IntNode last;
	int size;

	void insertAt(int position, LinkedIntList other) {
		if (other.equals(this) || (this == other)) {
			throw new RuntimeException("cannot insert list into itself");
		}
		if ((position < 0) || (position > this.size)) {
			throw new RuntimeException("index out of bounds:" + position + "");
		}
		if ((other == null) || other.isEmpty()) {
			return;
		}

		for (IntNode n = other.last; n != null; n = n.prev) {
			this.insert(position, n.value);
		}

	}

	void insert(int position, int value) {
		if ((position < 0) || (position > size)) {
			throw new RuntimeException("index out of bounds: " + position);
		} else if (position == 0) {
			this.addFirst(value);
		} else if (position == (size)) {
			this.addLast(value);
		} else {
			IntNode Node = new IntNode(value);
			Node.next = this.getNode(position - 1).next;
			this.getNode(position - 1).next = Node;
			Node.prev = this.getNode(position - 1);
			size++;
		}
	}

	int get(int index) {
		return getNode(index).value;
	}

	void set(int index, int value) {
		getNode(index).value = value;
	}

	boolean isEmpty() {
		return size == 0;
	}

	void addFirst(int value) {
		IntNode newNode = new IntNode(value);
		if (isEmpty()) {
			last = newNode;
		} else {
			first.prev = newNode;
			newNode.next = first;
		}

		first = newNode;
		size++;
	}

	void addLast(int value) {
		IntNode newNode = new IntNode(value);
		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
		}

		last = newNode;
		size++;
	}

	int removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("nothing to remove");
		}

		int value = first.value;
		if (first == last) {
			// List has only one element, so just clear it
			clear();
		} else {
			first = first.next;
			first.prev = null;
			size--;
		}

		return value;
	}

	int removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("nothing to remove");
		}

		int value = last.value;
		if (first == last) {
			// List has only one element, so just clear it
			clear();
		} else {
			last = last.prev;
			last.next = null;
			size--;
		}
		return value;
	}

	void removeNode(IntNode node) {
		if (node == first) {
			removeFirst();
		} else if (node == last) {
			removeLast();
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
		}
	}

	void clear() {
		first = last = null;
		size = 0;
	}

	/**
	 * Returns a new int-array with the same contents as the list.
	 */
	int[] toArray() {
		System.out.println(this.size);
		int[] array = new int[size];
		int i = 0;
		for (IntNode n = first; n != null; n = n.next, i++) {
			array[i] = n.value;
		}
		return array;
	}

	/**
	 * For internal use only.
	 */
	IntNode getNode(int index) {
		if ((index < 0) || (index >= size)) {
			throw new RuntimeException("index out of bounds: " + index);
		}

		IntNode current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}
}
