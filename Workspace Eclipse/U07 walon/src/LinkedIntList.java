
public class LinkedIntList {

	static IntNode first;
	static int size;
	static IntNode last;

	public LinkedIntList() {
		first = null;
		size = 0;
		last = null;
	}

	// Adds the given value to the end of the list.
	public static void addLast(int value) {
		if (first == null) {
			// adding to an empty list
			first = new IntNode(value);
			last = first;
		} else {

			last.next = new IntNode(value);
			last = last.next;

		}
		size++;
	}

	public static void addFirst(int value) {

		if (first == null) {
			// adding to an empty list
			first = new IntNode(value);
			last = first;
		} else {
			// Adding at front if not empty
			IntNode Node = new IntNode(value, first);
			first = Node;

		}
		size++;
	}

	public static int removeFirst() {

		if (first == null) {
			Errors.error("Fehler! Liste ist leer  ");
			return -1;
		} else {
			IntNode newfront = first.next;
			int oldfirst = first.data;
			first = null;
			first = newfront;
			size--;
			return oldfirst;
		}

	}

	public static int removeLast() {

		if (first == null) {
			Errors.error("Fehler! Liste ist leer ");
			return -1;
		} else {
			IntNode current = first;

			for (int i = 0; i < (size - 2); i++) {
				current = current.next;
			}
			int last = current.next.data;
			current.next = null;

			size--;
			return last;
		}
	}

	public static void clear() {

		for (int i = 0; i < size; i++) {
			IntNode newfront = first;
			first = first.next;
			newfront = null;

		}
		size = 0;

	}

	public static boolean isEmpty() {

		if (size == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static int get(int index) {

		if ((index > (size - 1)) || (index < 0)) {
			Errors.error("Fehler! Index ist ausserhalb der Liste");
			return 0;
		} else {

			IntNode current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	public static void set(int index, int value) {
		if ((index > (size - 1)) || (index < 0)) {
			Errors.error("Fehler! Index ist ausserhalb der Liste");
		}

		IntNode current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		current.data = value;
	}

	public static int[] toArray() {
		int[] array = new int[size];
		IntNode current = first;
		for (int i = 0; i < size; i++) {
			array[i] = current.data;
			current = current.next;

		}
		return array;

	}

}
