package assignment10;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class OptimisticLockList<T extends Comparable<T>> implements SortedListInterface<T> {

	/** Represents the start of the list. */
	private Node head;

	/** Represents the end of the list. */
	private Node tail;

	public OptimisticLockList() {
		head = new Node(Integer.MIN_VALUE);
		head.next = new Node(Integer.MAX_VALUE);
		tail = head.next;
	}

	private Boolean validate(Node pred, Node curr) {
		Node node = head;
		while (node.key <= pred.key) { // reachable?
			if (node == pred) {
				return pred.next == curr; // correct?
			}
			node = node.next;
		}
		return false;
	}

	@Override
	public boolean add(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		while (true) {
			pred = this.head;
			curr = pred.next;
			while (curr.key < key) {
				pred = curr;
				curr = curr.next;
			}
			pred.lock.lock();
			curr.lock.lock();
			try {
				if (validate(pred, curr)) {
					if (curr.key == key) { // present
						return false;
					} else { // not present
						Node entry = new Node(item);
						entry.next = curr;
						pred.next = entry;
						return true;
					}}
			}finally {
				pred.lock.unlock();
				curr.lock.unlock();
			}

		}

	}

	@Override
	public boolean remove(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		while (true) {
			pred = this.head;
			curr = pred.next;
			while (curr.key < key) {
				pred = curr;
				curr = curr.next;
			}
			pred.lock.lock();
			curr.lock.lock();
			try {
				if (validate(pred, curr)) {
					if (curr.key == key) { // present
						pred.next = curr.next;
						return true;
					} else { // not present
						return false;
					}
				}
			} finally {
				pred.lock.unlock();
				curr.lock.unlock();
			}

		}

	}

	@Override
	public boolean contains(T item) {
		Node pred = null, curr = null;
		int key = item.hashCode();
		while (true) {
			pred = this.head;
			curr = pred.next;
			while (curr.key < key) {
				pred = curr;
				curr = curr.next;
			}
			pred.lock.lock();
			curr.lock.lock();
			try {
				if (validate(pred, curr)) {
					return (curr.key == key);
				}
			} finally {
				pred.lock.unlock();
				curr.lock.unlock();
			}

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