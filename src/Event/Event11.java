package Event;

import Main.GameManager;

public class Event11 {
	GameManager gm;

	public Event11(GameManager gm) {
		this.gm = gm;
	}
	
	public void lookWater() {
		gm.ui.messageText.setText("You: The water actually seems safe. I wonder what temperature it has...");
	}
	
	public void exploreWater() {
		gm.ui.messageText.setText("You: After taking a closer look, I concluded that the water is safe. It also is pretty clear when you get closer to it.");
	}
	
	public void swimWater() {
		gm.ui.messageText.setText("I feel so much better!\n(+" + (gm.player.playerMaxLife - gm.player.playerLife - 1) + " Lives.)");
		gm.player.playerLife = gm.player.playerMaxLife - 1;
		gm.player.updatePlayerStatus();
	}
}