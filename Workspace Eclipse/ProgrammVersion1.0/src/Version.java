import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Version {

	public static void main(String[] args) throws FileNotFoundException {
		File Me = new File("Me.txt");
		File You = new File("You.txt");
		PrintStream Meout = new PrintStream(Me);
		PrintStream Youout = new PrintStream(You);
		Scanner scanner = new Scanner(System.in);
		LinkedList<String> MyHobbys = new LinkedList<String>();
		LinkedList<String> YourHobbys = new LinkedList<String>();
		LinkedList<String> MyAdvantagesOfDatingMe = new LinkedList<String>();
		LinkedList<String> YourAdvantagesOfDatingMe = new LinkedList<String>();
		LinkedList<String> MyDisadvantagesOfDatingMe = new LinkedList<String>();
		LinkedList<String> YourDisadvantagesOfDatingMe = new LinkedList<String>();
		MyHobbys.add("Hanball / Sport");
		MyHobbys.add("Gutes Essen (Pringles)");
		MyHobbys.add("Informatik ;)");
		MyHobbys.add("Schlafen");
		MyAdvantagesOfDatingMe.add(
				"My hand doesnt fit into the pringles box, so whenever i am going to eat some Pringles, you will get some to.");
		MyAdvantagesOfDatingMe.add("I am very good at cuddling.");
		MyDisadvantagesOfDatingMe.add(
				"I am probably stronger than you, so whenever we are going to fight over the last Pringles i am probably going to win :)");

		Person person1 = new Person("Neville", true, 180, 85, "0765266177", new Color(89, 60, 31),
				new Color(216, 192, 120), MyHobbys, MyAdvantagesOfDatingMe, MyDisadvantagesOfDatingMe);

		// TODO Fill in your information
		int yourHeight = 0;
		int yourWeight = 0;
		String yourPhonenumber = null;
		Color yourEyecolor = new Color(0, 0, 0);
		Color yourHaircolor = new Color(0, 0, 0);
		YourHobbys.add("");
		YourAdvantagesOfDatingMe.add("");
		YourDisadvantagesOfDatingMe.add("");

		System.out.println("Please enter your name: ");
		String name = scanner.nextLine();

		System.out.println("Are you single? ");
		System.out.println("Please answer with yes or no: ");
		String singleString = scanner.nextLine();

		while (!singleString.equals("yes") && !singleString.equals("no")) {
			System.out.println("Please answer with yes or no: ");
			singleString = scanner.nextLine();
		}
		if (singleString.equals("no")) {
			scanner.close();
			Meout.close();
			Youout.close();
			throw new RuntimeException("ABORT MISSION!!!");
		}
		boolean single = true;
		Person person2 = new Person(name, single, yourHeight, yourWeight, yourPhonenumber, yourEyecolor, yourHaircolor,
				YourHobbys, YourAdvantagesOfDatingMe, YourDisadvantagesOfDatingMe);
		System.out.println(person1.name + " thought about having launch or dinner with " + person2.name
				+ " in the following weeks?");
		System.out.println("Are you interested?");
		System.out.print("Please answer with yes or no: ");

		String antwort = scanner.nextLine();

		while (!antwort.equals("yes") && !antwort.equals("no")) {
			System.out.println("Please answear with yes or no: ");
			antwort = scanner.nextLine();
		}
		if (antwort.equals("no")) {
			scanner.close();
			Meout.close();
			Youout.close();
			throw new RuntimeException("Schade...");
		}
		System.out.println("Juhu :) Now you have two possibilities to get in contact with me: ");
		System.out.println("A: You can take my phonenumber: " + person1.phoneNumber + " and contact me or...");
		System.out.println(
				"B: You can finish the TODO task in this main Method and upload the \"You\" File into the Onedrive folder i gave you and I'll contact you :)");
		Meout.print(person1.toString(Me));
		Youout.print(person2.toString(You));

	}

}
