import java.util.ArrayList;

/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 01.03.2018
 *
 */
public class Car {
	int currentX;
	int currentY;
	int currentTime;
	int number;
	ArrayList<Ride> carRides = new ArrayList<>();

	Car(int number) {
		this.number = number;
	}

}
