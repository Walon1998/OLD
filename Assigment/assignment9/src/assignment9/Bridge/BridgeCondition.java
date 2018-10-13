package assignment9.Bridge;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BridgeCondition extends Bridge {

	final Lock bridgeLock = new ReentrantLock();
	final Condition notFull = bridgeLock.newCondition();
	int besetzt = 0;

	@Override
	public void enterCar() throws InterruptedException {
		bridgeLock.lock();
		while (besetzt == 3) {
			notFull.await();
		}
		besetzt++;
		bridgeLock.unlock();
	}

	@Override
	public void leaveCar() {
		bridgeLock.lock();
		besetzt--;
		notFull.signalAll();
		bridgeLock.unlock();


	}

	@Override
	public void enterTruck() throws InterruptedException {
		bridgeLock.lock();
		while (besetzt > 0) {
			notFull.await();
		}
		besetzt += 3;
		bridgeLock.unlock();
	}

	@Override
	public void leaveTruck() {
		bridgeLock.lock();
		besetzt -= 3;
		notFull.signalAll();
		bridgeLock.unlock();

	}

	public static void main(String[] args) {
		Random r = new Random();
		BridgeCondition b = new BridgeCondition();
		for (int i = 0; i < 100; ++i) {
			if (r.nextBoolean()) {
				new Car().driveTo(b);
			} else {
				new Truck().driveTo(b);
			}
		}
	}

}
