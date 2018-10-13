/**
 *
 */

/**
 * @author Neville Walo
 * Datum: 01.03.2018
 *
 */
public class Ride implements Comparable<Ride> {
	int startX;
	int startY;
	int finishX;
	int finishY;
	int earliest;
	int latest;
	int score;
	int number;
	int distance;
	int latestStart;
	int wartezeit;

	Ride(int a, int b, int x, int y, int earliest, int latest, int number) {
		this.startX = a;
		this.startY = b;
		this.finishX = x;
		this.finishY = y;
		this.earliest = earliest;
		this.latest = latest;
		this.score = 0;
		this.number = number;
		int dis = Math.abs(this.startX - this.startY) + (this.finishY - this.finishX);
		this.distance = dis;
		this.latestStart = latest - dis;

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Ride that) {
		return Integer.valueOf(this.wartezeit).compareTo(Integer.valueOf((that.wartezeit)));
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Ride)) {
			return false;
		}

		Ride other = (Ride) o;

		return other.startX == startX &&
				other.startY == startY &&
				other.finishX == finishX &&
				other.finishY == finishY &&
				other.earliest == earliest &&
				other.latest == latest &&
				other.number == number &&
				other.distance == distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + startX;
		result = prime * result + startY;
		result = prime * result + finishX;
		result = prime * result + finishY;
		result = prime * result + earliest;
		result = prime * result + latest;
		result = prime * result + number;
		result = prime * result + distance;
		return result;
	}
}
