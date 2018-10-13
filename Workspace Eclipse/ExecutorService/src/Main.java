import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Neville Walo
 *
 * Datum: 12.06.2018
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exs = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		// if we want until finished:
		Future f = exs.submit(new ExampleThread()); // spawns new thread
		try {
			f.get(); // Waits until Thread finishes and get result
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		exs.shutdown();
	}

}
