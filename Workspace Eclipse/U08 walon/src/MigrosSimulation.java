import java.util.Random;

public class MigrosSimulation {

	private int anzahlKassen;
	private double[] Kasseneffiezenz;
	@SuppressWarnings("unchecked")
	private LinkedPersonList[] Kassen;

	private double erscheinwahrscheinlichkeit;
	private int faulheit;
	private int maxWarenkorbgroesse;
	private LinkedPersonList finishers;
	double[] avgQLength;
	int[] maxQLength;
	int steps;

	MigrosSimulation(int anzahlKassen, int maxWarenkorbgroesse, int faulheit, double erscheinwahrscheinlichkeit) {
		// Lese alle wichtige Sachen ein
		Random R = new Random();
		this.anzahlKassen = anzahlKassen;
		this.Kasseneffiezenz = new double[anzahlKassen];
		this.Kassen = new LinkedPersonList[anzahlKassen];
		for (int i = 0; i < anzahlKassen; i++) {
			this.Kasseneffiezenz[i] = R.nextDouble();
			this.Kassen[i] = new LinkedPersonList();
		}

		this.erscheinwahrscheinlichkeit = erscheinwahrscheinlichkeit;
		this.faulheit = faulheit;
		this.maxWarenkorbgroesse = maxWarenkorbgroesse;
		this.finishers = new LinkedPersonList();
		this.maxQLength = new int[anzahlKassen];
		this.avgQLength = new double[anzahlKassen];
	}

	void run(int steps) {

		this.steps = steps;

		Random R = new Random();

		for (int i = 0; i <= steps; i++) {
			int kuerzeste = sucheKuerzeste();
			calculateAvg();
			calculateMax();
			// Fügt mit Erscheinwahrscheinlichkeit eine neu Person an zufälliger Kasse hinzu
			if (erscheinwahrscheinlichkeit > R.nextDouble()) {
				Kassen[R.nextInt(anzahlKassen)].addLast(new Person(faulheit, maxWarenkorbgroesse));

			}

			for (int j = 0; j < anzahlKassen; j++) {
				if (!Kassen[j].isEmpty()) {
					// Mit Kassierereffizienz wird der Warenkorb der erstems um 1 kleiner
					if (Kasseneffiezenz[j] > R.nextDouble()) {
						Kassen[j].first.value.warenkorbgroesse--;
					}
					// Falls der warenkorb leer ist, geht der Kundeb bzw. wird zu den finishers
					// hinzuugefügt
					if (Kassen[j].first.value.warenkorbgroesse == 0) {
						finishers.addFirst(Kassen[j].removeFirst());
					}
				}
			}

			for (int j = 0; j < anzahlKassen; j++) {

				for (int k = Kassen[j].size; k > 0; k--) {
					// tausche kunden, falls nicht zu faul
					if ((k - 1 - faulheit) > Kassen[kuerzeste].size) {
						Kassen[kuerzeste].addLast(Kassen[j].getNode(k - 1).value);
						Kassen[j].removeNode(Kassen[j].getNode(k - 1));
						kuerzeste = sucheKuerzeste();
					}

				}
			}
			// Erhöhe zeit für alle Kunden
			for (int j = 0; j < anzahlKassen; j++) {
				for (int k = 0; k < Kassen[j].size; k++) {
					Kassen[j].getNode(k).value.zeit++;
				}

			}

		}

	}

	// Sucht jeweils die Kürzeste schlange
	private int sucheKuerzeste() {
		int kasse = 0;
		int size = Kassen[0].size;
		for (int i = 1; i < anzahlKassen; i++) {
			if ((Kassen[i].size < size)) {
				size = Kassen[i].size;
				kasse = i;
			}
		}
		return kasse;
	}

	// Berechnet für jede Schlange den max.Wert
	private void calculateMax() {

		for (int i = 0; i < anzahlKassen; i++) {
			if (Kassen[i].size > maxQLength[i]) {
				maxQLength[i] = Kassen[i].size;
			}
		}

	}

	// Fügt in jeder Runde, die momenate Länge dazu. Beim Getter wird noch durch die
	// steps geteilt.
	private void calculateAvg() {
		for (int i = 0; i < anzahlKassen; i++) {
			avgQLength[i] += Kassen[i].size;
		}

	}

	LinkedPersonList getFinished() {
		return finishers;

	}

	double[] getAvgQueueLengths() {

		for (int i = 0; i < anzahlKassen; i++) {
			avgQLength[i] = avgQLength[i] / steps;
		}

		return avgQLength;
	}

	int[] getMaxQueueLengths() {
		return maxQLength;

	}

}
