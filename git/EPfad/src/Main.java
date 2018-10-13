import java.util.Random;

/**
 * @author Neville Walo
 *
 *         Datum: 14.04.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testcases = 1000000;
		double sum = 0;
		for (int i = 0; i < testcases; i++) {
			int a = test();
			// System.out.println(a);
			sum += a;
		}

		System.out.println(sum / testcases);

	}

	/**
	 * @return
	 */
	private static int test() {
		Random R = new Random();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		int counter = 0;
		Node currentNode = node1;
		while (!node1.visited || !node2.visited || !node3.visited || !node4.visited) {
			currentNode.visited = true;
			if (currentNode == node1) {
				currentNode = node2;
			} else if (currentNode == node2) {
				int next = R.nextInt(2);
				if (next == 0) {
					currentNode = node1;

				} else if (next == 1) {
					currentNode = node3;
				}
			} else if (currentNode == node3) {
				int next = R.nextInt(2);
				if (next == 0) {
					currentNode = node2;

				} else if (next == 1) {
					currentNode = node4;
				}
			} else if (currentNode == node4) {
				currentNode = node3;
			}
			counter++;
		}
		return counter;
	}

}
