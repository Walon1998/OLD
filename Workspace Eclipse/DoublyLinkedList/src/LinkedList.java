/**
 * A singly-linked list of {@link Person}s with fast {@link #addFirst(Person)}
 * and {@link #addLast(Person)} methods.
 */
public class LinkedList {

	Node first;
	Node last;
	int size;

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
		Node newNode = new Node(value);
		newNode.prev = null;
		newNode.next = first;

		if (first != null) {
			first.prev = newNode;
		}
		first = newNode;

		if (last == null) {
			last = newNode;
		}
		size++;
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		newNode.next = null;
		newNode.prev = last;
		if (isEmpty()) {
			first = newNode;

		} else {

			last.next = newNode;

		}

		last = newNode;
		size++;
	}

	int removeFirst() {
		if (isEmpty()) {
			throw new AssertionError();
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
			throw new AssertionError();
		}

		int value = last.value;
		if (first == last) {
			// List has only one element, so just clear it
			clear();
		} else {
			// List has more than one element

			last = last.prev;
			last.next = null;

			size--;
		}
		return value;
	}

	void clear() {
		first = last = null;
		size = 0;
	}

	int[] toArray() {
		int[] array = new int[size];
		int i = 0;
		for (Node n = first; n != null; n = n.next, i++) {
			array[i] = n.value;
		}
		return array;
	}

	/**
	 * For internal use only.
	 */
	Node getNode(int index) {
		if (index >= size) {
			throw new AssertionError();
		}

		Node current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	public void removeInt(Node node) {
		Node nachfolger = node.next;
		Node vorgaenger = node.prev;
		if (node == first) {
			removeFirst();
		} else if (node == last) {
			removeLast();
		} else {
			vorgaenger.next = nachfolger;
			nachfolger.prev = vorgaenger;
			size--;
		}

	}

}
