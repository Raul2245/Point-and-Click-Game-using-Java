package Event;

import Main.GameManager;

public class Event13 {
	GameManager gm;

	public Event13(GameManager gm) {
		this.gm = gm;
	}

	public void lookMetal() {
		gm.ui.messageText.setText("This seems to be a planet covered in rocks and other scraps.");
	}

	public void exploreMetal() {
		if (gm.player.hasShield == 1)
			gm.ui.messageText.setText(
					"An unexpected creature jumps at you from behind a rock while exploring but you defend yourself with the shield.");
		else {
			gm.player.playerLife--;
			gm.player.updatePlayerStatus();
		}
	}
	
	public void pickMetal() {
		gm.ui.messageText.setText("These scraps of metal could be useful.\n(+1 Metal)");
		gm.player.hasMetal = 1;
		gm.player.updatePlayerStatus();
	}
}