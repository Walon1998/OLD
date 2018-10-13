package test;

/**
 * @author Neville Walo
 *
 * Datum: 09.09.2018
 */
public class Pair implements Comparable<Pair> {
	double points;
	double grade;

	Pair(double points, double grade) {
		this.points = points;
		this.grade = grade;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return Double.compare(points, o.points);
	}

}
