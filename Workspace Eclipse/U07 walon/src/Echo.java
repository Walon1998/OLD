
import java.util.Scanner;

public class Echo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedIntList list = new LinkedIntList();
		while (scanner.hasNextInt()) {
			int wert = scanner.nextInt();
			list.addLast(wert);

		}

		// list.addFirst(1000);

		// list.clear();

		// System.out.println("element" + list.get(5));
		// list.set(0, 100);
		// System.out.println(Arrays.toString(list.toArray()));
		for (IntNode n = list.first; n != null; n = n.next) {
			System.out.print(n.data + ",");

		}

	}

}
