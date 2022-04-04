package Event;

import Main.GameManager;

public class Event05 {
	GameManager gm;

	public Event05(GameManager gm) {
		this.gm = gm;
	}

	public void lookPortal1() {
		gm.ui.messageText.setText("Where does this portal lead to?");
	}

	public void lookPortal2() {
		gm.ui.messageText.setText("Both portals look the same...");
	}

	public void enterPortal1() {
		if (gm.player.hasShield == 1) {
			gm.ui.messageText.setText("That portal should have killed you, but you used your shield!\n(-1 Shield)");
			gm.player.hasShield = 0;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("That was the wrong portal...");
			gm.player.playerLife = 0;
			gm.player.updatePlayerStatus();
		}
	}

	public void enterPortal2() {
		gm.gameOver.replay();
		gm.ui.messageText.setText("Good job! You've traveled back in time!");
		gm.player.mainQuest = 0;
		gm.player.horseQuest = 0;
		
		gm.ev4.alienLife = 1;
		gm.ev12.enemyLife = 2;
		gm.player.updatePlayerStatus();
	}
}
