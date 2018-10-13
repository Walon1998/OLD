
public class NightModeButton implements Drawable, Hoverable, Clickable {
	SwissMap SwissMap;
	boolean mouse;

	NightModeButton(SwissMap SwissMap) {
		this.SwissMap = SwissMap;
	}

	@Override
	public Rectangle getBoundingBox() {
		// TODO Auto-generated method stub
		return new Rectangle(5, 5, 50, 10);
	}

	@Override
	public void onLeftClick(double x, double y) {
		if (mouse && !SwissMap.nightMode) {
			SwissMap.nightMode = true;

		} else if (mouse) {
			SwissMap.nightMode = false;

		}
		// TODO Auto-generated method stub

	}

	@Override
	public void onRightClick(double x, double y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseEnter() {
		mouse = true;

		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseExit() {
		mouse = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Window window) {
		window.setColor(111, 111, 111);
		window.fillRect(5, 5, 50, 10);

		// TODO Auto-generated method stub

	}

}
