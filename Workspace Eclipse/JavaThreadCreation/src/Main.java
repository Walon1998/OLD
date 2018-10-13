
/**
 * @author Neville Walo
 *
 * Datum: 12.06.2018
 */
public class Main {

	public static void main(String[] args) {

		Thread t = new Thread(new ExampleThread());
		t.start(); // creates new thread
		try {
			t.join(); // waits until t returns;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
