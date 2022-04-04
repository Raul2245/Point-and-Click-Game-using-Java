package Event;

import Main.GameManager;

public class Event10 {
	GameManager gm;

	int[] asteroid = new int[11];

	public Event10(GameManager gm) {
		this.gm = gm;
	}

	public void jumpAsteroid(int asteroidNum) {
		asteroid[asteroidNum - 1] = 1;
		gm.ui.messageText.setText("You moved asteroid " + asteroidNum);
		
		int flag = 1;
		for (int i = 0; i < 10; i++)
			if (asteroid[i] == 0)
				flag = 0;
		if (flag == 1) {
			gm.ui.messageText.setText(
					"Good job! You saved those planets!\nIn the process of moving the asteroids, a piece broke. You keep it.\n(+1 Flint)");
			gm.player.hasFlint = 1;
			gm.player.updatePlayerStatus();
		}
	}
}