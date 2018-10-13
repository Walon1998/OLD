import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		for (int i = 0; i < testcases; i++) {
			int numbercount = sc.nextInt();
			int sum = 0;
			for (int j = 0; j < numbercount; j++) {
				sum += sc.nextInt();
			}
			System.out.println(sum);
		}

	}

}
