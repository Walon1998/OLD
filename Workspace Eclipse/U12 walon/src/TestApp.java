import java.util.ArrayList;
import java.util.List;

public class TestApp {
	public static void main(String[] args) {
		List<Integer> L1 = new ArrayList();
		List<Integer> L2 = new ArrayList();
		for (int i = 0; i < 3; i++) {
			L1.add(i);
		}
		L1.add(1);
		L1.add(2);
		L1.add(4);

		boolean z = Repetition.consistsOf(null, L2);
		System.out.println(z + " Lösung = False");

	}
}
