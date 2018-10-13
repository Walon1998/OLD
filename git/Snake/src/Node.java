import java.util.Random;

public class Node {
	int x;
	int y;
	Node next;
	Node prev;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(Window window, int speed) {
		Random R = new Random();
		this.x = speed * R.nextInt((int) window.getWidth() / speed);
		this.y = speed * R.nextInt((int) window.getHeight() / speed);

	}

}
