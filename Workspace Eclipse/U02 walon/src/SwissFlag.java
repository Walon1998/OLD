/*
* Author: Neville Walo; Herbst 2017, Uebung 2
* Entwurf uebernommen von einer Assistentin
*/
public class SwissFlag {

	public static void abstand() {
		for (int i = 0; i < 3; i++) {
			System.out.println("|                                 |");
		}

	}

	public static void kreuz() {
		for (int i = 0; i < 3; i++) {
			System.out.println("|             +++++++             |");
		}
	}

	public static void kreuz2() {
		for (int i = 0; i < 3; i++) {
			System.out.println("|      +++++++++++++++++++++      |");
		}
	}

	public static void main(String[] args) {
		striche();
		abstand();
		kreuz();
		kreuz2();
		kreuz();
		abstand();
		striche();

	}

	public static void striche() {
		System.out.println("-----------------------------------");
	}
}
