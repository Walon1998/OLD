import java.util.LinkedList;
import java.util.Random;

public class Snake {
	final static int SIZE = 400;
	final static int SPEED = 5;

	public static void main(String[] args) {
		Random R = new Random();
		Node neuerKnoten = null;
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(new Node(200, 200));
		boolean makeNew = true;
		int direction = R.nextInt(4); // 0=right, 1=left, 2=up, 3=down

		Window window = new Window("Snake", SIZE, SIZE);
		window.open();

		while (window.isOpen()) {
			window.drawRect(0, 0, SIZE, SIZE);

			if (makeNew) {
				boolean gut = true;
				do {
					neuerKnoten = new Node(window, SPEED);

					for (int i = 0; i < list.size(); i++) {
						if ((neuerKnoten.x == list.get(i).x) && (neuerKnoten.y == list.get(i).y)) {
							gut = false;
						}
					}

				} while (!gut);
				makeNew = false;
			} else {

				window.setColor(255, 0, 0);
				window.fillRect(neuerKnoten.x, neuerKnoten.y, 4, 4);

				if ((list.getFirst().x == neuerKnoten.x) && (list.getFirst().y == neuerKnoten.y)) {
					makeNew = true;
					addNew(list, direction);
				}
			}

			direction = checkKeyInput(window, direction);
			list = changePosition(direction, list);
			draw(window, list);
			checkCollision(list, window);

			window.refreshAndClear(100);
		}
	}

	private static LinkedList<Node> addNew(LinkedList<Node> list, int direction) {

		int x = list.getFirst().x;
		int y = list.getFirst().y;
		if (direction == 0) {
			x += SPEED;

		} else if (direction == 1) {
			x -= SPEED;

		} else if (direction == 2) {
			y -= SPEED;

		} else if (direction == 3) {
			y += SPEED;

		}
		list.addFirst(new Node(x, y));

		return list;
	}

	private static void checkCollision(LinkedList<Node> list, Window window) {
		if ((list.getFirst().x == -5) || (list.getFirst().x == window.getWidth()) || (list.getFirst().y == -5)
				|| (list.getFirst().y == window.getHeight())) {
			lost(list, window);

		} else {
			for (int i = 1; i < list.size(); i++) {
				if ((list.getFirst().x == list.get(i).x) && (list.getFirst().y == list.get(i).y)) {
					lost(list, window);
				}
			}

		}

	}

	private static void lost(LinkedList<Node> list, Window window) {
		window.setColor(0, 0, 0);
		window.setFontSize(20);
		while (window.isOpen()) {
			window.drawString("You Lost", (window.getWidth() / 2) - 40, window.getHeight() / 2);
			window.drawString("Score: " + list.size() + "", (window.getWidth() / 2) - 40,
					(window.getHeight() / 2) + 30);
			window.refreshAndClear(20);
		}

	}

	private static LinkedList<Node> changePosition(int direction, LinkedList<Node> list) {

		for (int i = list.size() - 1; i > 0; i--) {

			list.get(i).x = list.get(i - 1).x;

			list.get(i).y = list.get(i - 1).y;

		}

		if (direction == 0) {
			list.getFirst().x += SPEED;

		} else if (direction == 1) {
			list.getFirst().x -= SPEED;

		} else if (direction == 2) {
			list.getFirst().y -= SPEED;

		} else if (direction == 3) {
			list.getFirst().y += SPEED;

		}

		return list;

	}

	private static void draw(Window window, LinkedList<Node> list) {
		window.setColor(0, 0, 0);
		for (int i = 0; i < list.size(); i++) {
			window.fillRect(list.get(i).x, list.get(i).y, 4, 4);
		}

	}

	private static int checkKeyInput(Window window, int direction) {

		if (window.isKeyPressed("up") && (direction != 3)) {
			return 2;
		} else if (window.isKeyPressed("down") && (direction != 2)) {
			return 3;
		} else if (window.isKeyPressed("left") && (direction != 0)) {
			return 1;
		} else if (window.isKeyPressed("right") && (direction != 1)) {
			return 0;
		}
		return direction;

	}

}
