package assignment9.Bridge;

import java.util.Random;


public class BridgeMonitor extends Bridge {
	int besetzt = 0;

	@Override
	public synchronized void enterCar() throws InterruptedException {
		while (besetzt == 3) {
			this.wait();
		}
		besetzt++;

	}

	@Override
	public synchronized void leaveCar() {
		besetzt--;
		notifyAll();
	}

	@Override
	public synchronized void enterTruck() throws InterruptedException {
		while (besetzt > 0) {
			this.wait();
		}
		besetzt += 3;
	}

	@Override
	public synchronized void leaveTruck() {
		besetzt -= 3;
		notifyAll();
	}

	public static void main(String[] args) {
		Random r = new Random();
		BridgeMonitor b = new BridgeMonitor();
		for (int i = 0; i < 100; ++i) {
			if (r.nextBoolean()) {
				new Car().driveTo(b);
			} else {
				new Truck().driveTo(b);
			}
		}
	}

}
