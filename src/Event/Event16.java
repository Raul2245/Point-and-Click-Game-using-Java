package Event;

import Main.GameManager;

public class Event16 {
	GameManager gm;

	public Event16(GameManager gm) {
		this.gm = gm;
	}

	public void lookFluid() {
		gm.ui.messageText.setText(
				"You: This fluid looks very slimy. There's a strong smell around here, but I can't figure out what smell it is...");
	}

	public void exploreFluid() {
		gm.ui.messageText.setText("You spend a lot of time exploring the lands and figure out that the "
				+ "smell you feel is lighter fluid, then realize all the planet is covered in lighter fluid, "
				+ "but the strong smell gets to your head.\nYou faint.\n(-1 Life)");
		gm.player.playerLife--;
		gm.player.updatePlayerStatus();
	}

	public void pickFluid() {
		if (gm.player.hasBottle == 0)
			gm.ui.messageText.setText("You don't have anything to pick up fluid with!");
		else
		{
			gm.ui.messageText.setText("You pick up lighter fluid.");
			gm.player.hasFluid = 1;
			gm.player.updatePlayerStatus();
		}
	}
}