
public class Slice {
	int fromX, fromY;
	int toX, toY;

	Slice(int fromY, int fromX) {
		this.fromX = fromX;
		this.fromY = fromY;

	}

	Slice(int fromY, int fromX, int toY, int toX) {
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;

	}

	public int getBreite() {
		return (toX - fromX) + 1;
	}

	public int getHoehe() {
		return (toY - fromY) + 1;
	}

	public int getSize() {
		return getHoehe() * getBreite();
	}

}
