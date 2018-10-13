public class theisland {
	public static void main(String[] args) {
		long a, b, c, x, y, z;
		x = 0;
		while (x <= 250) {
			x++;
			a = (x % 8);
			b = (x % 7);
			c = (x % 5);
			if (a == 1 && b == 2 && c == 3) {

				System.out.println("Kokosnüsse gesamt: " + x + "");
				y = (x - 3) / 5;
				System.out.println("Jeder Pirat erhählt " + y + " Kokosnüsse");
			}
		}
	}
}
