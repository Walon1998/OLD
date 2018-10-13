import java.util.Random;

public class PongGame {

	int width;
	int height;
	Player Player1;
	Player Player2;
	Ball ball;

	PongGame(int width, int height) {
		this.width = width;
		this.height = height;
		int balkenlaenge = 100;
		this.Player1 = new Player(10, height / 2, balkenlaenge, 0);
		this.Player2 = new Player(width - 10, height / 2, balkenlaenge, 0);

		int vx = generateV();
		int vy = generateV();

		this.ball = new Ball(width / 2, height / 2, vx, vy);

	}

	void step() {
		// Verschiebung Ball
		ball.positionX += ball.vx;
		ball.positionY += ball.vy;
		// Abfrage mit Spielerkollsion
		if ((ball.positionX == Player1.positionX)
				&& (ball.positionY >= (Player1.positionY - (Player1.balkenlaenge / 2)))
				&& (ball.positionY <= (Player1.positionY + (Player1.balkenlaenge / 2)))) {
			ball.vx = -ball.vx;
		} else if ((ball.positionX == Player2.positionX)
				&& (ball.positionY >= (Player2.positionY - (Player2.balkenlaenge / 2)))
				&& (ball.positionY <= (Player2.positionY + (Player2.balkenlaenge / 2)))) {
			ball.vx = -ball.vx;
		}
		// Abfrage mir Wand links
		else if (ball.positionX == 0) {
			Player2.punkte++;
			ball.positionX = width / 2;
			ball.vx = generateV();
			ball.vy = generateV();
			ball.positionY = height / 2;
			// Abfrage mit Wand rechts
		} else if (ball.positionX == width) {
			Player1.punkte++;
			ball.vx = generateV();
			ball.vy = generateV();
			ball.positionX = width / 2;
			ball.positionY = height / 2;
		}

		// Abfrage mit Oben und unten
		else if ((ball.positionY == 0) || (ball.positionY == height)) {
			ball.vy = -ball.vy;
		}
	}

	// generiere Richtung
	private int generateV() {
		Random R = new Random();
		int a = R.nextInt(100);
		if ((a % 2) == 0) {
			return 1;
		}

		return -1;
	}

}
