package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {




	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Notenskala_ohne_Bonuspunkte.txt");
		Scanner sc = new Scanner(file);
		PrintStream out = new PrintStream(new File("output"));
		ArrayList<Pair> list = new ArrayList<Pair>();
		while (sc.hasNext()) {
			double points = sc.nextDouble();
			double grade = sc.nextDouble();
			list.add(new Pair(points, grade));

		}
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i).points);

		}
		for (int i = 0; i < list.size(); i++) {

			out.println(list.get(i).grade);

		}
	}

}




