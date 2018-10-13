import java.util.Arrays;

public class testApp {

	public static void main(String[] args) {

		LinkedIntList list = new LinkedIntList();
		LinkedIntList other = new LinkedIntList();

		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(8);
		list.addFirst(9);
		other.addFirst(99);
		other.addFirst(88);

		list.insertAt(9, other);
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println(Arrays.toString(other.toArray()));

		// System.out.println(list.getNode(2).prev.value);

		// TODO Auto-generated method stub

	}

}
