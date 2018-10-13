public class PongGui {

	public static void main(String[] args) {
		int width = 800;
		int height = 400;

		PongGame game = new PongGame(width, height);

		Window window = new Window("Pong", width, height);

		int balkenlange = game.Player1.balkenlaenge;

		window.open();
		while (window.isOpen()) {
			// Zeichnet Balken und Punkte und Ball
			int balken1y = game.Player1.positionY - (balkenlange / 2);
			int balken2y = game.Player2.positionY - (balkenlange / 2);
			window.fillRect(game.Player1.positionX, balken1y, 5, balkenlange);
			window.fillRect(game.Player2.positionX, balken2y, 5, balkenlange);
			window.fillCircle(game.ball.positionX, game.ball.positionY, 3);
			window.drawString("" + game.Player1.punkte + "", 10, 10);
			window.drawString("" + game.Player2.punkte + "", width - 10, 10);

			// Verschiebt Balken
			if (window.isKeyPressed("up")) {
				game.Player2.positionY--;
			} else if (window.isKeyPressed("down")) {
				game.Player2.positionY++;
			}
			if (window.isKeyPressed("w")) {
				game.Player1.positionY--;

			} else if (window.isKeyPressed("s")) {
				game.Player1.positionY++;
			}

			game.step();
			window.refreshAndClear(20);
		}
	}

}
