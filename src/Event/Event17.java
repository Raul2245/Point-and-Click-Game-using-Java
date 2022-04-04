package Event;

import Main.GameManager;

public class Event17 {
	GameManager gm;

	public Event17(GameManager gm) {
		this.gm = gm;
	}

	public void lookCraft() {
		gm.ui.messageText.setText("It looks like a bunch of old machinery.");
	}

	public void exploreCraft() {
		gm.ui.messageText.setText(
				"You can use these old machineries to help you craft something as long as you have all the materials needed.");
	}

	public void craftLighter() {
		if (gm.player.hasMetal == 1 && gm.player.hasBottle == 1 && gm.player.hasFlint == 1 && gm.player.hasFluid == 1) {
			gm.ui.messageText.setText("You have all the materials to craft lighter!\n(+1 Lighter)");
			gm.player.hasLighter = 1;
			gm.player.hasBottle = 0;
			gm.player.hasFlint = 0;
			gm.player.hasMetal = 0;
			gm.player.hasFluid = 0;
			gm.player.updatePlayerStatus();
		}
		else 
			gm.ui.messageText.setText("You do not have all the materials to craft a lighter!");
	}
}