/**
 * A doubly-linked list of {@link Ball}s with fast {@link #addFirst(Ball)},
 * {@link #addLast(Ball)}, {@link #removeFirst()}, and {@link #removeLast()} methods. Removal in
 * the interior of the list is supported as well.
 */
public class LinkedBallList {
    
    BallNode first;
    BallNode last;
    int size;
    
    Ball get(int index) {
        return getNode(index).ball;
    }
    
    void set(int index, Ball value) {
        getNode(index).ball = value;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    void addFirst(Ball value) {
        BallNode newNode = new BallNode(value);
        if(isEmpty())
            last = newNode;
        else {
            first.prev = newNode;
            newNode.next = first;
        }
        
        first = newNode;
        size++;
    }
    
    void addLast(Ball value) {
        BallNode newNode = new BallNode(value);
        if(isEmpty())
            first = newNode;
        else {
            last.next = newNode;
            newNode.prev = last;
        }
        
        last = newNode;
        size++;
    }
    
    Ball removeFirst() {
        if(isEmpty())
            throw new AssertionError();
        
        Ball value = first.ball;
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            first = first.next;
            first.prev = null;
            size--;
        }
        
        return value;
    }
    
    Ball removeLast() {
        if(isEmpty())
            throw new AssertionError();
        
        Ball value = last.ball;
        if(first == last) {
            // List has only one element, so just clear it
            clear();
        }
        else {
            last = last.prev;
            last.next = null;
            size--;
        }
        return value;
    }
    
    void removeNode(BallNode node) {
        if(node == first)
            removeFirst();
        else if(node == last)
            removeLast();
        else {
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
     * Returns a new Ball-array with the same contents as the list.
     */
    Ball[] toArray() {
        Ball[] array = new Ball[size];
        int i = 0;
        for(BallNode n = first; n != null; n = n.next, i++)
            array[i] = n.ball;
        return array;
    }
    
    /**
     * For internal use only.
     */
    BallNode getNode(int index) {
        if(index >= size)
            throw new AssertionError();
        
        BallNode current = first;
        for(int i = 0; i < index; i++)
            current = current.next;
        return current;
    }
}
