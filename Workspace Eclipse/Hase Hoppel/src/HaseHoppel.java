import java.util.Arrays;

//Alles Falsch
public class HaseHoppel {

	public static void main(String[] args) {
		// Initialisere Arrays und sortiere Hoppels
		int[] hoppels = { 5, 4 };
		int S = 1;
		Arrays.sort(hoppels);
		boolean[][] T = new boolean[hoppels.length + 1][S + 1];
		// Erste Spalte = true
		for (int i = 0; i <= hoppels.length; i++) {
			T[i][0] = true;
		}
		// Erste Zeile ab 1 = false
		for (int i = 1; i <= S; i++) {
			T[0][i] = false;
		}

		for (int i = 1; i <= hoppels.length; i++) {
			// Falls oben schon erreichbar, jetzt auch
			for (int j = 1; j <= S; j++) {
				if (T[i - 1][j] == true) {
					T[i][j] = true;
				} else {
					// Allenfalls berechne überzähliges stück
					int outOfBound = j - hoppels[i - 1];
					// Falls dies nicht out of bound, suche in Zeile darüber an Stelle j minus
					// aktuelle Hoppellaenge
					if (outOfBound >= 0) {
						T[i][j] = T[i - 1][j - hoppels[i - 1]];
					} else {
						// Falls outofbound, nehme Betrag von überzähligem Stück
						int outBound2 = Math.abs(outOfBound);
						// falls grösser als gesuchter Wert
						if (outBound2 > S) {
							T[i][j] = false;
							// Falls kleiner als gescuhter Wert
						} else {
							T[i][j] = T[i - 1][outBound2];
						}
					}

				}

			}
		}
		System.out.println(Arrays.deepToString(T));
		System.out.print(T[hoppels.length][S]);

	}

}
