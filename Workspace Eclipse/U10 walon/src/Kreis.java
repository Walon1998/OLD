
public class Kreis extends Form {
	int radius;

	public Kreis(Koordinate koordinate, int radius) {
		super(koordinate);
		this.radius = radius;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int flaeche() {
		return (int) (Math.PI * Math.pow(radius, 2));
	}

	@Override
	public String toString() {
		return "Kreis(" + koordinate.toString() + ", " + radius + ")";
	}

}
