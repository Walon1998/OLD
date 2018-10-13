import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Neville Walo
 *
 * Datum: 12.06.2018
 */
public class Reentrantlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void consume() {
		lock.lock();
		while (!consumable()) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// release lock and wait for resource
		// have exclusive access to resource, can consume
		lock.unlock();
	}

	public void produce() {
		lock.lock();
		// do something to make consumable() return true
		notifyAll(); // tell waiting threads to try consuming
		// can also call notify() to notify one thread at a time
		lock.unlock();


	}

}
