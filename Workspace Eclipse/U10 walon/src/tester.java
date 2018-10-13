
public class tester {

	public static void main(String[] args) {
		Koordinate koordinate = new Koordinate(1, 2);
		Punkt punkt = new Punkt(koordinate);
		Rechteck rechteck = new Rechteck(koordinate, 10, 20);
		Quadrat quadrat = new Quadrat(koordinate, 42);
		Kreis kreis = new Kreis(koordinate, 55);
		Zweidimensional[] objekte = new Zweidimensional[] { punkt, rechteck, quadrat, kreis };
		Form[] formen = new Form[] { rechteck, quadrat, kreis };
		Rechteck[] rechtecke = new Rechteck[] { rechteck, quadrat };
		System.out.println(koordinate);
		for (Zweidimensional obj : objekte) {
			System.out.println(obj);
		}
		System.out.println("--");
		for (Form f : formen) {
			System.out.println(f + ", Flaeche: " + f.flaeche());
		}
		System.out.println("--");
		for (Rechteck r : rechtecke) {
			System.out.println(r + ", Flaeche: " + r.flaeche() + ", Diagonale: " + r.diagonale());
		}

	}

}
