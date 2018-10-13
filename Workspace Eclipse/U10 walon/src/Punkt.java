
public class Punkt extends Zweidimensional {

	public Punkt(Koordinate koordinate) {
		super(koordinate);

	}

	@Override
	public String toString() {
		return "Punkt(" + koordinate.toString() + ")";

	}

}
