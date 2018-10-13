package ethz.ch.pp.assignment2;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		taskA();

		int[] input1 = generateRandomInput(1000);
		int[] input2 = generateRandomInput(10000);
		int[] input3 = generateRandomInput(100000);
		int[] input4 = generateRandomInput(10000000);

		// Sequential version
		// taskB(input1);
		// taskB(input2);
		// taskB(input3);
		// taskB(input4);

		// Parallel version
		// taskE(input1, 4);
		// taskE(input2, 4);
		// taskE(input3, 4);
		taskE(input4, 4);

		long threadOverhead = taskC();
		System.out.format("Thread overhead on current system is: %d nano-seconds\n", threadOverhead);
	}

	private final static Random rnd = new Random(42);

	public static int[] generateRandomInput() {
		return generateRandomInput(rnd.nextInt(10000) + 1);
	}

	public static int[] generateRandomInput(int length) {
		int[] values = new int[length];
		for (int i = 0; i < values.length; i++) {
			values[i] = rnd.nextInt(99999) + 1;
		}
		return values;
	}

	public static int[] computePrimeFactors(int[] values) {
		int[] factors = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			factors[i] = numPrimeFactors(values[i]);
		}
		return factors;
	}

	public static int numPrimeFactors(int number) {
		int primeFactors = 0;
		int n = number;
		for (int i = 2; i <= n; i++) {
			while ((n % i) == 0) {
				primeFactors++;
				n /= i;
			}
		}
		return primeFactors;
	}

	public static class ArraySplit {
		public final int startIndex;
		public final int length;

		ArraySplit(int startIndex, int length) {
			this.startIndex = startIndex;
			this.length = length;

		}
	}

	/*
	 * Good
	 * -Tyler
	 */
	// TaskD
	public static ArraySplit[] PartitionData(int length, int numPartitions) {
		// Splits everything in "most" equal parts
		// Alternative way...?
		ArraySplit[] array = new ArraySplit[numPartitions];
		int rest = length % numPartitions;
		int divide = length / numPartitions;
		int stelle = 0;
		for (int i = 0; i < numPartitions; i++) {

			if (rest > 0) {
				array[i] = new ArraySplit(stelle, divide + 1);
				rest--;
				stelle += divide + 1;

			} else {
				array[i] = new ArraySplit(stelle, divide);
				stelle += divide;
			}

		}
		return array;
	}

	/*
	 * OK, but instead of throwing an exception, you should catch it
	 */
	public static void taskA() throws InterruptedException {
		// To Test we can make two loops in each thread and if they are both doing stuff
		// at the same time, they are parallel
		Hellothread thread = new Hellothread();
		// System.out.println(thread.getId());
		thread.start();
		thread.join();
		//Do this instead of throwing an exception:
		/*
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
	}

	/*
	 * OK, but instead of throwing an exception, you should catch it
	 */
	public static int[] taskB(int[] values) throws InterruptedException {
		long time = System.nanoTime();
		ComputePrime thread = new ComputePrime(values);
		thread.start();
		thread.join();
		System.out.println(System.nanoTime() - time);
		return (thread.result);

	}

	/*
	 * Good, but instead of throwing an exception, you should catch it
	 */
	// Returns overhead of creating thread in nano-seconds
	public static long taskC() throws InterruptedException {
		int instances = 1000;
		long time = System.nanoTime();
		for (int i = 0; i < instances; i++) {
			Test thread = new Test();
			thread.run();
			thread.join();
		}
		return System.nanoTime() - time;
	}

	/*
	 * You should not throw an exception from this method. Use a try-catch block instead!
	 * Otherwise, good.
	 * -Tyler
	 */
	public static int[] taskE(final int[] values, final int numThreads)/* throws InterruptedException */{
		long time = System.nanoTime();
		int[] result = new int[values.length];
		int cores = Runtime.getRuntime().availableProcessors();
		PrimeFromTo[] threads = new PrimeFromTo[cores];
		ArraySplit[] split = PartitionData(values.length, cores);

		for (int i = 0; i < cores; i++) {
			threads[i] = new PrimeFromTo(values, split[i].startIndex, split[i].length, result);
			threads[i].start();
		}
		for (int i = 0; i < cores; i++) {
		//	threads[i].join();
			//This is better!
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println(System.nanoTime() - time);
		return result;
	}

}
