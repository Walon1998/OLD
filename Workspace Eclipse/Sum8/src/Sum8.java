import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sum8 {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ausgabe = new PrintStream(new File("C:\\Users\\Neville\\Downloads\\results"));
		for (int k = 0; k < 100; k++) {
			List<Integer> list = new ArrayList<Integer>();
			List<Integer> solution = new ArrayList<Integer>();
			Random R = new Random();
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				int random = R.nextInt(256);
				list.add(random);
				sum += random;
			}
			sum = sum % 256;
			// System.out.println(list);
			// System.out.println(sum);
			for (int i = 0; i < list.size(); i++) {
				// System.out.print(printZeros(Integer.toBinaryString(list.get(i))));
				ausgabe.print(printZeros(Integer.toBinaryString(list.get(i))));
			}
			// System.out.println();
			ausgabe.print(printZeros(Integer.toBinaryString(sum)));
			ausgabe.println();
		}
	}

	public static String printZeros(String zahl) {
		String real = "";
		for (int i = zahl.length(); i < 8; i++) {
			zahl = "0" + zahl;
		}
		for (int i = 0; i < 8; i++) {
			real = real + zahl.substring(i, i + 1) + " ";
		}

		return real;

	}

}
