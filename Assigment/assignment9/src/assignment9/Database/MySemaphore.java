package assignment9.Database;

public class MySemaphore {

	private volatile int count;

	public MySemaphore(int maxCount) {
		count = maxCount;
	}

	public synchronized void acquire() throws InterruptedException {

		while (count == 0) {
			this.wait();
		}
		count--;

	}

	public synchronized void release() {
		count++;
		// notifyAll();
		notify();


	}

}
