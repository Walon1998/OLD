//Es soll entschieden werden, ob das Array drei Schlussel ¨ A[i], A[j] sowie A[k] enthaelt, deren
//Summe x ergibt.
//Array muss zuerst sortiert werden.
class threeSum {

	public static void main(String[] args) {
		double x = 20;
		double[] array = { -2, 0, 1, 2, 4, 5, 6, 7, 10 };

		for (int i = 0; i < (array.length - 3); i++) {
			double a = array[i];
			int start = i + 1;
			int end = array.length - 1;

			while (start < end) {
				double b = array[start];
				double c = array[end];
				if ((a + b + c) == x) {
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					System.out.print("\n");
					if (b == array[start + 1]) {
						start++;
					}
					break;
				} else if ((a + b + c) > 0) {
					end--;
				} else {
					start++;
				}
			}
		}

	}

}
