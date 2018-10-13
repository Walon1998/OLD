/**
 * A singly-linked list of {@link Person}s with fast {@link #addFirst(Person)}
 * and {@link #addLast(Person)} methods.
 */
public class LinkedPersonList {

	PersonNode first;
	PersonNode last;
	int size;

	Person get(int index) {
		return getNode(index).value;
	}

	void set(int index, Person value) {
		getNode(index).value = value;
	}

	boolean isEmpty() {
		return size == 0;
	}

	// Neu
	void addFirst(Person value) {
		PersonNode newNode = new PersonNode(value);

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

	// Neu, geht jetzt schneller
	void addLast(Person value) {

		PersonNode newNode = new PersonNode(value);
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

	// Neu
	Person removeFirst() {
		if (isEmpty()) {
			throw new AssertionError();
		}

		Person value = first.value;
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

	Person removeLast() {
		if (isEmpty()) {
			throw new AssertionError();
		}

		Person value = last.value;
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

	Person[] toArray() {
		Person[] array = new Person[size];
		int i = 0;
		for (PersonNode n = first; n != null; n = n.next, i++) {
			array[i] = n.value;
		}
		return array;
	}

	/**
	 * For internal use only.
	 */
	PersonNode getNode(int index) {
		if (index >= size) {
			throw new AssertionError();
		}

		PersonNode current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	// Neu Entfernt beliebigen Knoten aus Liste
	void removeNode(PersonNode Person) {
		PersonNode nachfolger = Person.next;
		PersonNode vorgaenger = Person.prev;
		if (Person == first) {
			removeFirst();
		} else if (Person == last) {
			removeLast();
		} else {
			vorgaenger.next = nachfolger;
			nachfolger.prev = vorgaenger;
			size--;
		}

	}
}
