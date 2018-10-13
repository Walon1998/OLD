import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizza {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("big.in"));
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		int min = scanner.nextInt();
		int max = scanner.nextInt();
		String[][] pizza = new String[R][C];
		for (int i = 0; i < R; i++) {
			String string = scanner.next();
			for (int j = 0; j < C; j++) {
				pizza[i][j] = string.substring(j, j + 1);

			}

		}

		scanner.close();
		boolean[][] pizzaslice = new boolean[R][C];
		List<Slice> list = new ArrayList<Slice>();
		list = solve(min, max, pizza, C, R, pizzaslice, list);
		list = biggerSlice(pizza, pizzaslice, list, max, C, R);
		list = mergeRight(list, max);
		list = mergeRight(list, max);
		list = deleteToSmall(pizza, max, min, list, pizzaslice);
		list = solve(min, max, pizza, C, R, pizzaslice, list);
		list = biggerSlice(pizza, pizzaslice, list, max, C, R);
		list = deleteToSmall(pizza, max, min, list, pizzaslice);
		printSolution(list);
		predictScore(list);
	}

	private static void predictScore(List<Slice> list) {
		int score = 0;
		for (int i = 0; i < list.size(); i++) {
			score += list.get(i).getSize();
		}
		System.out.println("Predicted Score: " + score);
	}

	private static List<Slice> mergeUnder(List<Slice> list, int max) {
		List<Integer> delete = new ArrayList<Integer>();

		int size = list.size();
		for (int i = 0; i < (size - 1); i++) {

			if ((list.get(i).fromX == list.get(i + 1).fromX) && (list.get(i).toX == list.get(i + 1).toX)
					&& (list.get(i).toY == (list.get(i + 1).fromY - 1))) {
				System.out.println("hi");
				Slice temp = new Slice(list.get(i).fromY, list.get(i).fromX, list.get(i + 1).toY, list.get(i).toX);
				if (temp.getSize() <= max) {
					System.out.println("hi2");
					delete.add(i);
					delete.add(i + 1);
					list.add(temp);
					i++;
				}

			}

		}
		size = delete.size();
		for (int i = size - 1; i >= 0; i--) {
			list.remove((int) delete.remove(i));
		}
		return list;

	}

	private static List<Slice> mergeRight(List<Slice> list, int max) {
		List<Integer> delete = new ArrayList<Integer>();

		int size = list.size();
		for (int i = 0; i < (size - 1); i++) {

			if ((list.get(i).fromY == list.get(i + 1).fromY) && (list.get(i).toY == list.get(i + 1).toY)
					&& (list.get(i).toX == (list.get(i + 1).fromX - 1))) {

				Slice temp = new Slice(list.get(i).fromY, list.get(i).fromX, list.get(i).toY, list.get(i + 1).toX);
				if (temp.getSize() <= max) {
					delete.add(i);
					delete.add(i + 1);
					list.add(temp);
					i++;
				}

			}

		}
		size = delete.size();
		for (int i = size - 1; i >= 0; i--) {
			list.remove((int) delete.remove(i));
		}
		return list;
	}

	private static List<Slice> solve(int min, int max, String[][] pizza, int C, int R, boolean[][] pizzaslice,
			List<Slice> list) throws FileNotFoundException {

		int i = 0;
		int j = 0;

		while ((i * j) < (R * C)) {
			if (j == (C)) {
				j = 0;
				i++;
			}

			if (i == R) {
				break;
			}

			while (pizzaslice[i][j] == true) {
				j++;
				if (j == (C)) {
					j = 0;
					i++;
				}
				if (i == R) {
					break;
				}
			}
			boolean gefunden = false;
			Slice temp = new Slice(i, j);
			int grenze = Integer.MAX_VALUE;
			if (i == R) {
				break;
			}
			if (pizza[i][j].equals("M")) {
				list = biggerSlice(pizza, pizzaslice, list, max, C, R);
				for (int k = i; ((k - 1) < max) && (k < R); k++) {
					for (int l = j; (l < C) && ((((l - j) + 1) * ((k - i) + 1)) <= max) && (l < grenze); l++) {
						if (pizzaslice[k][l] == true) {
							grenze = l;
						} else {
							if (pizza[k][l].equals("T")) {

								gefunden = true;
								temp.toY = k;
								temp.toX = l;
								list.add(temp);
								for (int i1 = i; i1 <= k; i1++) {
									for (int j1 = j; j1 <= l; j1++) {
										pizzaslice[i1][j1] = true;
									}
								}
								j = l + 1;
								k = R;
								l = C;
								if (j == (C)) {
									j = 0;
									i++;
								}
							}
						}
					}
				}

				if (!gefunden) {
					j++;
				}
			} else if (pizza[i][j].equals("T")) {

				for (int k = i; ((k - i) < max) && (k < R); k++) {
					for (int l = j; (l < C) && ((((l - j) + 1) * ((k - i) + 1)) <= max) && (l < grenze); l++) {
						if (pizzaslice[k][l] == true) {
							grenze = l;
						} else {
							if (pizza[k][l].equals("M")) {
								gefunden = true;
								temp.toY = k;
								temp.toX = l;

								list.add(temp);
								for (int i1 = i; i1 <= k; i1++) {
									for (int j1 = j; j1 <= l; j1++) {
										pizzaslice[i1][j1] = true;
									}
								}
								j = l + 1;
								k = R;
								l = C;
								if (j == (C)) {
									j = 0;
									i++;
								}
							}
						}
					}

				}
				if (!gefunden) {
					j++;
				}

			}

		}

		return list;
	}

	private static List<Slice> deleteToSmall(String[][] pizza, int max, int min, List<Slice> list,
			boolean[][] pizzaslice) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if ((list.get(i).getBreite() * list.get(i).getHoehe()) > max) {
				System.out.println("error");
			}
			int tomatoes = 0;
			int mushrooms = 0;
			for (int j = list.get(i).fromY; j <= list.get(i).toY; j++) {
				for (int k = list.get(i).fromX; k <= list.get(i).toX; k++) {
					if (pizza[j][k].equals("T")) {
						mushrooms++;
					} else {
						tomatoes++;
					}
				}
			}
			if ((tomatoes < min) || (mushrooms < min)) {
				for (int j = list.get(i).fromY; j <= list.get(i).toY; j++) {
					for (int k = list.get(i).fromX; k <= list.get(i).toX; k++) {
						pizzaslice[j][k] = false;
					}
				}

				list.remove(i);
				i--;
				size--;
			}
		}
		return list;

	}

	private static List<Slice> biggerSlice(String[][] pizza, boolean[][] pizzaslice, List<Slice> list, int max, int C,
			int R) {

		for (int i = 0; i < list.size(); i++) {

			boolean gut = false;
			do {
				gut = false;
				if (rechts(list.get(i), pizza, pizzaslice, max, C)) {
					gut = true;
					for (int i1 = list.get(i).fromY; i1 <= list.get(i).toY; i1++) {
						pizzaslice[i1][list.get(i).toX + 1] = true;
					}
					list.get(i).toX++;

				}
				if (unten(list.get(i), pizza, pizzaslice, max, R)) {
					gut = true;
					for (int i1 = list.get(i).fromX; i1 <= list.get(i).toX; i1++) {
						pizzaslice[list.get(i).toY + 1][i1] = true;
					}
					list.get(i).toY++;

				}
				if (oben(list.get(i), pizza, pizzaslice, max, R)) {
					gut = true;
					for (int i1 = list.get(i).fromX; i1 <= list.get(i).toX; i1++) {
						pizzaslice[list.get(i).fromY - 1][i1] = true;
					}
					list.get(i).fromY--;

				}
				// if (links(list.get(i), pizza, pizzaslice, max, C)) {
				// gut = true;
				// for (int i1 = list.get(i).fromY; i1 <= list.get(i).toY; i1++) {
				// pizzaslice[i1][list.get(i).fromX - 1] = true;
				// }
				// list.get(i).fromX--;

				// }

			} while (gut);
		}
		return list;
	}

	private static boolean links(Slice slice, String[][] pizza, boolean[][] pizzaslice, int max, int C) {
		if (((slice.getBreite() + 1) * slice.getHoehe()) > max) {
			return false;
		}
		if ((slice.fromX - 1) >= 0) {
			for (int i = slice.fromY; i <= slice.toY; i++) {
				if (pizzaslice[i][slice.fromX - 1] == true) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;
	}

	private static boolean oben(Slice slice, String[][] pizza, boolean[][] pizzaslice, int max, int R) {
		if (((slice.getHoehe() + 1) * slice.getBreite()) > max) {
			return false;
		}

		if ((slice.fromY - 1) >= 0) {
			for (int i = slice.fromX; i <= slice.toX; i++) {
				if (pizzaslice[slice.fromY - 1][i] == true) {
					return false;
				}
			}

		} else {
			return false;
		}

		return true;
	}

	private static boolean unten(Slice slice, String[][] pizza, boolean[][] pizzaslice, int max, int R) {

		if (((slice.getHoehe() + 1) * slice.getBreite()) > max) {
			return false;
		}
		if ((slice.toY + 1) < R) {
			for (int i = slice.fromX; i <= slice.toX; i++) {
				if (pizzaslice[slice.toY + 1][i] == true) {
					return false;
				}
			}

		} else {
			return false;
		}

		return true;

	}

	private static boolean rechts(Slice slice, String[][] pizza, boolean[][] pizzaslice, int max, int C) {
		if (((slice.getBreite() + 1) * slice.getHoehe()) > max) {
			return false;
		}
		if ((slice.toX + 1) < C) {
			for (int i = slice.fromY; i <= slice.toY; i++) {
				if (pizzaslice[i][slice.toX + 1] == true) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;
	}

	public static void printSolution(List<Slice> list) throws FileNotFoundException {
		PrintStream ausgabe = new PrintStream(new File("Solution"));
		ausgabe.print(list.size());
		ausgabe.println();
		for (int i = 0; i < list.size(); i++) {
			ausgabe.print(list.get(i).fromY);
			ausgabe.print(" ");
			ausgabe.print(list.get(i).fromX);
			ausgabe.print(" ");
			ausgabe.print(list.get(i).toY);
			ausgabe.print(" ");
			ausgabe.print(list.get(i).toX);
			ausgabe.println();
		}
	}

}