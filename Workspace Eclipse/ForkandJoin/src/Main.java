import java.util.concurrent.ForkJoinPool;

/**
 * @author Neville Walo
 *
 * Datum: 12.06.2018
 */
public class Main {
	public static ForkJoinPool POOL = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
	static int CUTOFF;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		V result = POOL.invoke(new ExampleThread());
	}

}
