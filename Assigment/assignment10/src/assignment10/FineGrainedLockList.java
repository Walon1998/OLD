package assignment10;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FineGrainedLockList<T extends Comparable<T>> implements SortedListInterface<T> {

	/** Represents the start of the list. */
	private Node head;

	/** Represents the end of the list. */
	private Node tail;

	public FineGrainedLockList() {
		head = new Node(Integer.MIN_VALUE);
		head.next = new Node(Integer.MAX_VALUE);
		tail = head.next;
	}

	@Override
	public boolean add(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		head.lock.lock();
		try {
			pred = head;
			curr = pred.next;
			curr.lock.lock();
			try {
				while (curr.key < key) {
					pred.lock.unlock();
					pred = curr; // pred still locked
					curr = curr.next;
					curr.lock.lock(); // lock hand over hand
				}
				if (curr.key == key) { // present
					return false;
				} else { // not present
					Node entry = new Node(item);
					entry.next = curr;
					pred.next = entry;
					return true;
				}
			} finally {
				curr.lock.unlock();
			}
		} finally {
			pred.lock.unlock();
		}

	}

	@Override
	public boolean remove(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		head.lock.lock();
		try {
			pred = head;
			curr = pred.next;
			curr.lock.lock();
			try {
				while (curr.key < key) {
					pred.lock.unlock();
					pred = curr; // pred still locked
					curr = curr.next;
					curr.lock.lock(); // lock hand over hand
				}
				if (curr.key == key) {
					pred.next = curr.next; // delete
					return true;
				}
				return false;

			} finally {
				curr.lock.unlock();
			}
		} finally {
			pred.lock.unlock();
		}
	}

	@Override
	public boolean contains(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		head.lock.lock();
		try {
			pred = head;
			curr = pred.next;
			curr.lock.lock();
			try {
				while (curr.key < key) {
					pred.lock.unlock();
					pred = curr; // pred still locked
					curr = curr.next;
					curr.lock.lock(); // lock hand over hand
				}

				return curr.key == key;
			} finally {
				curr.lock.unlock();
			}
		} finally {
			pred.lock.unlock();
		}
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
