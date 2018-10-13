import java.util.List;

public class Repetition {

	public static boolean consistsOf(List<Integer> list1, List<Integer> list2) {
		try {
			if ((list1.size() == 0) | (list2.size() == 0)) {
				throw new RuntimeException("invalid lists");
			}
		} catch (Exception e) {
			throw new RuntimeException("invalid lists");
		}

		int j = 0;
		while (j < list1.size()) {
			for (int i = 0; i < list2.size(); i++, j++) {

				try {
					if (!list1.get(j).equals(list2.get(i))) {
						return false;
					}
				} catch (Exception e) {
					return false;
				}

			}
		}

		return true;

	}

}
