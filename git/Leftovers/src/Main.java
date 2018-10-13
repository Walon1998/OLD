import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Neville Walo
 *
 * Datum: 19.08.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Rezept> list = new ArrayList<Rezept>();
		HashSet<String> Zutaten1 = new HashSet<String>();
		Zutaten1.add("Zwiebeln");
		Zutaten1.add("Spaghetti");
		Zutaten1.add("Rahm");
		Zutaten1.add("Schinken");
		list.add(new Rezept("Spaghetti Carbonara", Zutaten1, 30));


		HashSet<String> Zutaten2 = new HashSet<String>();
		Zutaten2.add("Zwiebeln");
		Zutaten2.add("Spaghetti");
		Zutaten2.add("Tomatensauce");
		Zutaten2.add("Gehacktes");
		list.add(new Rezept("Spaghetti Bolognese", Zutaten2, 30));

		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		for (int i = 0; i < list.size(); i++) { // In Parallel
			if (list.get(i).Zutaten.contains(in)) {
				System.out.println(list.get(i));
			}
		}


	}

}
