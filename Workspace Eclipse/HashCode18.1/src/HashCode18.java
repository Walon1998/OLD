import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Broccoli Datum: 01.03.2018
 *
 */
public class HashCode18 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	static int B = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("e_high_bonus.in"));
		final int R = sc.nextInt();
		final int C = sc.nextInt();
		final int F = sc.nextInt();
		final int N = sc.nextInt();
		B = sc.nextInt();
		final int T = sc.nextInt();

		ArrayList<Ride> Rides = new ArrayList<>();
		ArrayList<Car> Cars = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt();
			int f = sc.nextInt();
			Rides.add(new Ride(a, b, x, y, s, f,i));
		}
		for (int i = 0; i < F; i++) {
			Cars.add(new Car(i));
		}

		double p = 0.4;
		int cutoff = 10;

		//init
		//Remove Impossible/Garbage
		//Compute Earliest time
		for(int i = 0; i<Rides.size(); i++) {
			Ride curRide = Rides.get(i);
			if((curRide.latest - curRide.earliest) < curRide.distance) {
				Rides.remove(i);
			} else {
				curRide.wartezeit = calculateWartezeit(Cars.get(0), curRide);
			}
		}
		//Sort Ride
		sort(Rides);
		//assign to the first n cars
		int index = 0;
		for(Car c : Cars) {
			if(index > (Rides.size()-1)) {
				break;
			}
			c.carRides.add(Rides.get(index));
			Rides.remove(index);
			index++;
		}

		for(Car c : Cars){
			ArrayList<Ride> tempRides = (ArrayList<Ride>)Rides.clone();
			while (!tempRides.isEmpty()) {
				UpdateArray(tempRides, c);
				if (tempRides.isEmpty()){
					break;
				}
				//sort(tempRides)
				sort(tempRides);
				//take first p*tempRides;
				ArrayList<Ride> best = firstElemnts(tempRides,
						(tempRides.size() <= 25) ? 9 : (int) (p * tempRides.size()));
				//compute Score
				ComputeScore(best);
				//take best Score, add to solution
				Ride nextRide = best.get(maxScore(best));
				//Remove from orginal List and temprides
				tempRides.remove(nextRide);
				Rides.remove(nextRide);
				c.carRides.add(nextRide);
				//car update
				c.currentTime =	Math.max(c.currentTime + calculateDistanceToStart(c, nextRide), nextRide.earliest) + nextRide.distance;
				c.currentX = nextRide.finishX;
				c.currentY = nextRide.finishY;
			}
		}




		File output = new File("Solution_e.txt");
		PrintStream aus = new PrintStream(output);
		for (int i = 0; i < F; i++) {
			//aus.print(i+1);
			aus.print(Cars.get(i).carRides.size());
			for (int j = 0; j < Cars.get(i).carRides.size(); j++) {
				aus.print(" ");
				aus.print(Cars.get(i).carRides.get(j).number);
			}
			aus.println();
		}
		sc.close();
		aus.close();
	}

	public static ArrayList<Ride> firstElemnts(ArrayList<Ride> list, int n) {
		ArrayList<Ride> tmp = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if(i > (list.size()-1)) {
				break;
			}
			tmp.add(list.get(i));
		}
		return tmp;
	}

	public static void UpdateArray(ArrayList<Ride> tempRides, Car c) {
		// RemoveImpossible
		// Compute Earliest time
		for (int i = 0; i < tempRides.size(); i++) {
			if ((calculateDistanceToStart(c, tempRides.get(i)) + c.currentTime + tempRides.get(i).distance) < tempRides
					.get(i).latest) {
				//
				tempRides.get(i).wartezeit = calculateWartezeit(c, tempRides.get(i));


			} else {
				// Remove
				// Rides.get(j).score = 0;
				tempRides.remove(i);
			}
		}
	}

	public static int maxScore(ArrayList<Ride> tempRides) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < tempRides.size(); i++) {
			if (max < tempRides.get(i).score) {
				max = tempRides.get(i).score;
				index = i;
			}
		}
		return index;
	}

	public static void ComputeScore(ArrayList<Ride> tempRides) {
		// Compute Score
		for (int i = 0; i < tempRides.size(); i++) {
			tempRides.get(i).score = tempRides.get(i).distance + ((tempRides.get(i).wartezeit > 0) ? B : 0);
		}
	}

	static int calculateDistanceToStart(Car car, Ride ride) {
		// Distance
		return Math.abs(car.currentX - ride.startX) + Math.abs(car.currentY - ride.startY);

	}

	static int calculateWartezeit(Car car, Ride ride) {
		// Waiting time
		return ride.earliest - (car.currentTime + calculateDistanceToStart(car, ride));

	}

	public static void sort(ArrayList<Ride> tmp) {
		Comparator<Ride> criterium = new Comparator<Ride>() {
			@Override
			public int compare(Ride r1, Ride r2) {
				return r1.wartezeit - r2.wartezeit;
			}
		};
		Collections.sort(tmp, criterium);
	}

}

