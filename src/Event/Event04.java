package Event;

import Main.GameManager;
import java.util.Random;

public class Event04 {
	GameManager gm;
	public int alienLife = 1;

	public Event04(GameManager gm) {
		this.gm = gm;
	}

	public void lookAlien() {
		if (alienLife > 0)
			gm.ui.messageText.setText("Maybe he has seen the cat I'm looking for...");
		else
			gm.ui.messageText.setText("He's dead.");
	}

	public void talkAlien() {
		if (alienLife > 0)
			gm.ui.messageText.setText("Alien: Afio mai i lo'u lalolagi. Ou te faamoemoe e te sau ma le filemu");
		else
			gm.ui.messageText.setText("He's dead.");
	}

	public void attackAlien() {
		if (alienLife > 0) {
			if (gm.player.hasSword == 1) {
				if (gm.player.playerLife < gm.player.playerMaxLife) {
					gm.ui.messageText.setText("You've killed the alien!\n(+1 Life)");
					gm.player.playerLife++;
					gm.player.updatePlayerStatus();
				}
			} else {
				if (gm.player.hasShield == 1) {
					Random rand = new Random();
					int rand_int = rand.nextInt();
					if (rand_int % 5 == 0)
						{
						gm.ui.messageText.setText("Auch...\n(-1 Life)");
						gm.player.playerLife--;
						gm.player.updatePlayerStatus();
					}
					else 
						gm.ui.messageText.setText("Alien tried to attack you, but you used your shield!");
				} else {
					gm.ui.messageText.setText("Auch...\nMaybe a sword would help.\n(-1 Life)");
					gm.player.playerLife--;
					gm.player.updatePlayerStatus();
				}
			}
		} else
			gm.ui.messageText.setText("He's dead.");
	}

	public void leaveMap() {
		gm.sChanger.showScene(3);
	}

}
