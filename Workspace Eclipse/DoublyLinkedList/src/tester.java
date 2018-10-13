import java.util.Arrays;

public class tester {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(1001);
		list.addLast(5);
		// list.removeFirst();
		// list.removeLast();
		list.removeInt(list.getNode(0));
		System.out.print(Arrays.toString(list.toArray()));

	}

}
