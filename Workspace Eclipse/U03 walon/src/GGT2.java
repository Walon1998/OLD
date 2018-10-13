import java.util.Scanner;

public class GGT2 {

	public static void ggt(int x, int y) {

		while ((x < y) || ((x % y) != 0)) {

			int altX = x;
			x = y;
			y = altX % y;

		}
		System.out.print(y);
	}

	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);

		System.out.print("Zahl 1: ");
		int x = name.nextInt();

		System.out.print("Zahl 2: ");
		int y = name.nextInt();

		ggt(x, y);
	}

}
