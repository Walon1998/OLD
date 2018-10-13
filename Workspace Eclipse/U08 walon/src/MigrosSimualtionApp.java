import java.util.Arrays;

public class MigrosSimualtionApp {
	public static void main(String[] args) {

		int anzahlkassen = 2;
		int faulheit = 2;
		int maxWarenkorbgroesse = 10;
		double erscheinwahrscheinlichekeit = 0.5;

		MigrosSimulation simulation = new MigrosSimulation(anzahlkassen, maxWarenkorbgroesse, faulheit,
				erscheinwahrscheinlichekeit);
		simulation.run(100);
		System.out.println(Arrays.toString(simulation.getAvgQueueLengths()));
		System.out.println(Arrays.toString(simulation.getMaxQueueLengths()));

	}

}
