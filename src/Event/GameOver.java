package Event;

import Main.GameManager;

public class GameOver {
	GameManager gm;
	
	public GameOver(GameManager gm) {
		this.gm = gm;
	}
	
	public void replay() {
		gm.ui.messageText.setText("Welcome wonderer! Are you ready for an adventure?\n If so, look around the scenery... I'm sure you'll find the adventure you're looking for! ");
		gm.player.setPlayerDefaultStatus();
		gm.sChanger.showScene(1);
		for (int i = 0; i < 10; i++)
			gm.ev10.asteroid[i] = 0;
	}
}
