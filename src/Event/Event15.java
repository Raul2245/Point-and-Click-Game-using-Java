package Event;

import Main.GameManager;

public class Event15 {
	GameManager gm;

	public Event15(GameManager gm) {
		this.gm = gm;
	}
	
	public void lookBottle() {
		gm.ui.messageText.setText("This planet is very poluted. Look at all this junk...");
	}
	
	public void exploreBottle() {
		gm.ui.messageText.setText("You dive into the liquid found on this planet. Unfortunately, it is very toxic.\n(-2 Lives)");
		gm.player.playerLife -= 2;
		gm.player.updatePlayerStatus();
	}
	
	public void pickBottle() {
		gm.ui.messageText.setText("Through all the juck you see a bottle. It can be used to store all kinds of fluids.\n(+1 Bottle)");
		gm.player.hasBottle = 1;
		gm.player.updatePlayerStatus();
	}
}