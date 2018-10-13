
public class MaximumSubarraySum {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, 12, 13, 14, 15, -16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
				27, 28, 29, 30, -1000 };
		int sum = maxsum(array);
		System.out.print(sum);

	}

	private static int maxsum(int[] array) {
		int randmax = 0;
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			randmax = randmax + array[i];
			if (randmax > max) {
				max = randmax;
			}
			if (randmax < 0) {
				randmax = 0;
			}
		}
		return max;

	}

}
