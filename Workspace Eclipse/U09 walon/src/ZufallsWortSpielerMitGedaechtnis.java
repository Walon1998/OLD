import java.util.Random;

public class ZufallsWortSpielerMitGedaechtnis extends ZufallsWortSpieler {
	boolean[] gedaechntis;

	@Override
	public void neuesSpiel(String[] verwendeteWoerter) {
		super.woerter = verwendeteWoerter;
		gedaechntis = new boolean[verwendeteWoerter.length];

	}

	@Override
	public int zufallsWortIndex(String[] woerter) {
		Random random = new Random();
		int index;
		do {
			index = random.nextInt(woerter.length);
		} while (gedaechntis[index]);
		gedaechntis[index] = true;
		return index;

	}

	@Override
	public String name() {
		return "ZufallsWortSpielerMitGedaechtnis";
	}

}
