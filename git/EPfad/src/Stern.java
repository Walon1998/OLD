import java.util.Random;

/**
 * @author Neville Walo
 *
 *         Datum: 14.04.2018
 */
public class Stern {

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
		Node center = new Node(0);
		Node out1 = new Node(1);
		Node out2 = new Node(2);
		Node out3 = new Node(3);
		Node out4 = new Node(4);
		Node out5 = new Node(5);

		int counter = 0;
		Node currentNode = out1;
		while (!center.visited || !out1.visited || !out2.visited || !out3.visited || !out4.visited || !out5.visited) {
			currentNode.visited = true;
			// System.out.println(currentNode.id);
			if (currentNode == out1 || currentNode == out2 || currentNode == out3 || currentNode == out4
					|| currentNode == out5) {
				currentNode = center;
			} else {
				int next = R.nextInt(5);
				switch (next) {
				case 0:
					currentNode = out1;
					break;
				case 1:
					currentNode = out2;
					break;
				case 2:
					currentNode = out3;
					break;
				case 3:
					currentNode = out4;
					break;
				case 4:
					currentNode = out5;
					break;
				}

			}

			counter++;
		}

		return counter;
	}

}
