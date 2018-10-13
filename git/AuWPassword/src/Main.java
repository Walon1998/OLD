import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 22.02.2018
 *
 */
class Main {
	public static void main(final String[] args) throws FileNotFoundException {
		// Create a new Scanner object for reading the input
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("test2.in"));

		// Read the number of testcases to follow
		int t = sc.nextInt();

		// Iterate over the testcases and solve the problem
		for (int i = 0; i < t; i++) {
			Main.testCase(sc);
		}
	}

	public static void testCase(final Scanner sc) {
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Node> map = new HashMap<String, Node>();

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String paper = sc.next();
			String sub1 = paper.substring(0, 2);
			String sub2 = paper.substring(1, 3);
			if (!map.containsKey(sub1)) {
				Node node = new Node(sub1);

				map.put(sub1, node);
				list.add(sub1);


			}



			if (!map.containsKey(sub2)) {
				Node node2 = new Node(sub2);
				map.put(sub2, node2);
				list.add(sub2);

			}

			map.get(sub2).vorgaenger++;
			map.get(sub1).nachfolger++;
			map.get(sub1).nachfolgerlist.add(sub2);

		}
		int wenigerVorganger = 0;
		int wenigerNachfolger = 0;



		for (Map.Entry<String, Node> entry : map.entrySet()) {
			if (entry.getValue().nachfolger == entry.getValue().vorgaenger) {

			} else if (entry.getValue().nachfolger == (entry.getValue().vorgaenger - 1)) {
				wenigerVorganger++;
			} else if ((entry.getValue().nachfolger - 1) == entry.getValue().vorgaenger) {
				wenigerNachfolger++;
			} else {
				wenigerVorganger += 10;
				break;
			}




		}
		if (zusammenhanged(map, list)) {
			if ((wenigerVorganger > 1) || (wenigerNachfolger > 1)) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		} else {
			System.out.println("no");
		}
		for (Map.Entry<String, Node> entry : map.entrySet()) {
			// System.out.println(entry.getValue().name);
			// System.out.println(entry.getValue().komponente);
		}

	}

	/**
	 * @param map
	 * @param list
	 * @return
	 */
	private static boolean zusammenhanged(HashMap<String, Node> map, ArrayList<String> list) {
		String sub = null;
		boolean zero = false;
		Stack<String> stack = new Stack<String>();
		for (Map.Entry<String, Node> entry : map.entrySet()) {
			if (entry.getValue().vorgaenger == 0) {
				// System.out.println(entry.getValue().name);
				sub = entry.getValue().name;
				zero = true;
				break;
			}
		}
		if (zero) {
			// System.out.println("zero");
			// System.out.println(sub);
			stack.add(sub);
			while (!stack.isEmpty()) {
				String i = stack.pop();
				list.remove(i);
				map.get(i).besucht = true;
				// System.out.println(map.get(i).nachfolgerlist);
				// System.out.println(map.get(i).nachfolger);
				for (String s : map.get(i).nachfolgerlist) {
					// System.out.println(map.get(i).nachfolgerlist);
					if (!map.get(s).besucht) {
						stack.add(s);
					}
				}
			}
			if(!list.isEmpty()) {
				return false;
			}


		} else {
			int komponente = 0;
			while (!list.isEmpty()) {
				stack.add(list.get(0));
				while (!stack.isEmpty()) {
					String i = stack.pop();
					list.remove(i);
					map.get(i).besucht = true;
					map.get(i).komponente = komponente;

					for (String s : map.get(i).nachfolgerlist) {
						// System.out.println(map.get(i).nachfolgerlist);
						if (!map.get(s).besucht) {
							stack.add(s);
						}
					}

				}
				komponente++;
				for (Map.Entry<String, Node> entry : map.entrySet()) {
					entry.getValue().besucht = false;
				}

			}
			for (Map.Entry<String, Node> entry : map.entrySet()) {
				if (entry.getValue().komponente != (komponente - 1)) {
					return false;
				}
			}
		}

		return true;
	}

}



