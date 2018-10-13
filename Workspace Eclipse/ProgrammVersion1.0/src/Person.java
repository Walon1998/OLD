import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;

public class Person {
	String name;
	boolean single;
	int height;
	int weight;
	String phoneNumber;
	Color eyecolor;
	Color Haircolor;

	LinkedList<String> hobbys;
	LinkedList<String> AdvantagesOfDatingMe;
	LinkedList<String> DisadvantagesOfDatingMe;

	Person(String name, boolean single, int height, int weight, String phoneNumber, Color eyecolor, Color Haircolor,
			LinkedList<String> hobbys, LinkedList<String> AdvantagesOfDatingMe,
			LinkedList<String> DisadvantagesOfDatingMe) {
		this.name = name;
		this.single = single;
		this.height = height;
		this.weight = weight;
		this.phoneNumber = phoneNumber;
		this.eyecolor = eyecolor;
		this.Haircolor = Haircolor;
		this.hobbys = hobbys;
		this.AdvantagesOfDatingMe = AdvantagesOfDatingMe;
		this.DisadvantagesOfDatingMe = DisadvantagesOfDatingMe;

	}

	Person(String name) {
		this.name = name;

	}

	public String toString(File output) throws FileNotFoundException {
		PrintStream ausgabe = new PrintStream(output);

		ausgabe.println("Name: " + this.name);
		ausgabe.println("Single: " + this.single);
		ausgabe.println("Height: " + this.height + " cm");
		ausgabe.println("Weight: " + this.weight + " kg");
		ausgabe.println("Phonenumber: " + this.phoneNumber);
		ausgabe.println("Eyecolor : " + this.eyecolor.getRed() + "," + this.eyecolor.getGreen() + ","
				+ this.eyecolor.getBlue());

		ausgabe.println("Haircolor : " + this.Haircolor.getRed() + "," + this.Haircolor.getGreen() + ","
				+ this.Haircolor.getBlue());
		ausgabe.println("Hobbys: ");
		for (int i = 0; i < this.hobbys.size(); i++) {
			ausgabe.println(hobbys.get(i).toString());
		}
		ausgabe.println("Advantages Of Dating Me: ");
		for (int i = 0; i < this.AdvantagesOfDatingMe.size(); i++) {
			ausgabe.println(AdvantagesOfDatingMe.get(i).toString());
		}
		ausgabe.println("Disadvantages Of Dating Me: ");
		for (int i = 0; i < this.DisadvantagesOfDatingMe.size(); i++) {
			ausgabe.println(DisadvantagesOfDatingMe.get(i).toString());
		}
		ausgabe.println();
		return "";

	}
}
