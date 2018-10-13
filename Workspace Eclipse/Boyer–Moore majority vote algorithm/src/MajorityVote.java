//The Boyer–Moore majority vote algorithm is an algorithm for finding the majority of a sequence of elements using linear time and constant space.
//However, it is possible to perform a second pass over the same input sequence in order to count the number of times the reported element occurs
//and determine whether it is actually a majority. This second pass is needed, as it is not possible for a sublinear-space algorithm to determine whether
//there exists a majority element in a single pass through the input.
public class MajorityVote {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int m = 0;
		int i = 0;
		for (int j = 0; j < array.length; j++) {
			if (i == 0) {
				m = array[j];
				i = 1;
			} else if (m == array[j]) {
				i++;
			} else {
				i--;
			}

		}
		System.out.print(m);

	}

}
