package assignment9.Database;

public class MyBarrier {
	private volatile int start;
	private volatile int goal;

	MyBarrier(int n){
		goal = n;
		start = 0;
	}

	synchronized void await() throws InterruptedException {
		start++;
		if (start < goal) {
			wait();
		} else {
			notifyAll();
			start = 0;
		}
	}
}