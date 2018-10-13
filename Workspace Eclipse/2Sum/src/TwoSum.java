/*Gegeben seien ein Array A = (A[1], . . . , A[n]) ganzzahliger Schlussel sowie eine weitere ganze ¨
Zahl z. Geben Sie fur die folgenden beiden Probleme einen m ¨ ¨oglichst effizienten Algorithmus
an, und analysieren Sie seine Laufzeit (in O-Notation) im schlechtesten Fall.
a) Es soll entschieden werden, ob das Array zwei Schlussel ¨ A[i] und A[j] enth¨alt, deren Summe
z ergibt.

*/
class TwoSum {

	public static void main(String[] args) {
		int x = 13;
		int[] array = { -2, 0, 1, 2, 4, 5, 6, 7 };

		int j = array.length - 1;
		int i = 0;
		for (int k = 0; k < (j + 1); k++) {
			if ((array[i] + array[j]) == x) {

				System.out.println("" + array[i] + " + " + array[j]);
				break;
			} else if ((array[i] + array[j]) > x) {
				j--;

			} else if ((array[i] + array[j]) < x) {
				i++;
			}
		}
		System.out.print(x);

	}

}
// }
