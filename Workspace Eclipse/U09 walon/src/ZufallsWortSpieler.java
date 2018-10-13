import java.util.Random;

public class ZufallsWortSpieler extends Spieler {
	String[] woerter;

	@Override
	public void neuesSpiel(String[] verwendeteWoerter) {
		woerter = verwendeteWoerter;

	}

	@Override
	public String gibTipp() {

		int index = zufallsWortIndex(woerter);

		return woerter[index];
	}

	public int zufallsWortIndex(String[] woerter) {
		Random random = new Random();
		return random.nextInt(woerter.length);
	}

	@Override
	public String name() {
		return "ZufallsWortSpieler";
	}

}
