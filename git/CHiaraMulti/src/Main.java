import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Neville Walo
 *
 * Datum: 10.06.2018
 */
public class Main {
	static ExecutorService exs = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	final static int TESTS = 1;
	final static int SIZE = 10;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] array = new int[SIZE];
		Future<Integer>[] list = new Future[TESTS];


		for (int i = 0; i < TESTS; i++) {
			list[i] = exs.submit(new Counter(SIZE));
		}
		for (int i = 0; i < TESTS; i++) {
			array[list[i].get()]++;
		}

		System.out.println(Arrays.toString(array));
		exs.shutdown();


	}

}
