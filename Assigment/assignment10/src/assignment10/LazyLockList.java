package assignment10;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class LazyLockList<T extends Comparable<T>> implements SortedListInterface<T> {

	/** Represents the start of the list. */
	private Node head;

	/** Represents the end of the list. */
	private Node tail;

	public LazyLockList() {
		head = new Node(Integer.MIN_VALUE);
		head.next = new Node(Integer.MAX_VALUE);
		tail = head.next;
	}

	@Override
	public boolean add(T item) {
		int key = item.hashCode();
		while (true) { // optmistic, retry
			Node pred = this.head;
			Node curr = head.next;
			while (curr.key < key) {
				pred = curr;
				curr = curr.next;
			}
			pred.lock.lock();
			try {
				curr.lock.lock();
				try {
					if (!pred.marked && !curr.marked && pred.next == curr) {
						if (curr.key == key) { // present
							return false;
						} else { // not present
							Node entry = new Node(item);
							entry.next = curr;
							pred.next = entry;
							return true;
						}
					}

				} finally {
					curr.lock.unlock();
				}
			} finally {
				pred.lock.unlock();
			}
		}

	}

	@Override
	public boolean remove(T item) {
		int key = item.hashCode();
		while (true) { // optmistic, retry
			Node pred = this.head;
			Node curr = head.next;
			while (curr.key < key) {
				pred = curr;
				curr = curr.next;
			}
			pred.lock.lock();
			try {
				curr.lock.lock();
				try {
					if (!pred.marked && !curr.marked && pred.next == curr) {
						if (curr.key != key) {
							return false;
						} else {
							curr.marked = true; // logically remove
							pred.next = curr.next; // physically remove
							return true;
						}
					}
				} finally {
					curr.lock.unlock();
				}
			} finally {
				pred.lock.unlock();
			}
		}
	}


	@Override
	public boolean contains(T item) {
		int key = item.hashCode();
		Node curr = this.head;
		while (curr.key < key) {
			curr = curr.next;
		}
		return curr.key == key && !curr.marked;
	}


	@Override
	public LinkedList<T> toLinkedList() {
		LinkedList<T> list = new LinkedList<T>();
		Node curr = this.head.next;
		while (curr != tail) {
			list.add(curr.item);
			curr = curr.next;
		}
		return list;
	}

	/** list node */
	class Node {
		ReentrantLock lock = new ReentrantLock();
		boolean marked;
		/** actual item */
		T item;

		/** item's hash code */
		int key;

		/** next entry in list */
		Node next;

		/**
		 * Constructor for usual entry
		 *
		 * @param item
		 *            element in list
		 */
		Node(T item) {
			this.item = item;
			this.key = item.hashCode();
			this.marked = false;
		}

		/**
		 * Constructor for sentinel entry
		 *
		 * @param key
		 *            should be min or max int value
		 */
		Node(int key) {
			this.key = key;
		}
	}
}