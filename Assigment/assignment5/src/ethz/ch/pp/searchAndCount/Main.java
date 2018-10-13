package ethz.ch.pp.searchAndCount;

import java.util.concurrent.ExecutionException;

import ethz.ch.pp.util.DatasetGenerator;
import ethz.ch.pp.util.Workload;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		DatasetGenerator dg = new DatasetGenerator(1024 * 1024);
		int[] input = dg.generate();

		System.out.println("warm-up cache for more precise measurements");
		sequential(input, Workload.Type.HEAVY);

		System.out.println("we should see a speed-up of the parallel implementation");
		sequential(input, Workload.Type.HEAVY);
		taskA(input, Workload.Type.HEAVY);
		taskB(input, Workload.Type.HEAVY, 100, 4);
		taskC(input, Workload.Type.LIGHT, 100, 4);
		taskD(input, Workload.Type.HEAVY, 100, 4);
	}

	public static void sequential(int[] input, Workload.Type wt) {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			SearchAndCountSeq.countNoAppearances(input, wt);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("\tFor (inputsize=" + input.length + ",workload=" + wt + ") SearchAndCountSeq takes "
				+ ((t1 - t0) / 5) + " msec");
	}

	public static void taskA(int[] input, Workload.Type wt) {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			SearchAndCountSeqDivideAndConquer.countNoAppearances(input, wt);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("\tFor (inputsize=" + input.length + ",workload=" + wt
				+ ") SearchAndCountSeqDivideAndConquer takes " + ((t1 - t0) / 5) + " msec");
	}

	public static void taskB(int[] input, Workload.Type wt, int cutOff, int numThreads)
			throws InterruptedException, ExecutionException {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			SearchAndCountParDivideAndConquer.countNoAppearances(input, wt, cutOff, numThreads);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("\tFor (inputsize=" + input.length + ",workload=" + wt + ",cutoff=" + cutOff + ",nothreads="
				+ numThreads + ") SearchAndCountParDivideAndConquer takes " + ((t1 - t0) / 5) + " msec");
	}

	public static void taskC(int[] input, Workload.Type wt, int cutOff, int numThreads)
			throws InterruptedException, ExecutionException {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			SearchAndCountParDivideAndConquer.countNoAppearances(input, wt, cutOff, numThreads);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("\tFor (inputsize=" + input.length + ",workload=" + wt + ",cutoff=" + cutOff + ",nothreads="
				+ numThreads + ") SearchAndCountParDivideAndConquer takes " + ((t1 - t0) / 5) + " msec");
	}

	public static void taskD(int[] input, Workload.Type wt, int cutOff, int numThreads) {
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			SearchAndCountForkJoin.countNoAppearances(input, wt, cutOff, numThreads);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("\tFor (inputsize=" + input.length + ",workload=" + wt + ",cutoff=" + cutOff + ",nothreads="
				+ numThreads + ") SearchAndCountForkJoin takes " + ((t1 - t0) / 5) + " msec");
	}

}
