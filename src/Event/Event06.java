package Event;

import Main.GameManager;

public class Event06 {
	GameManager gm;

	public Event06(GameManager gm) {
		this.gm = gm;
	}

	public void lookChest() {
		gm.ui.messageText
				.setText("That's a chest! I wonder if it has anything helpful in it...\nI bet it's locked though...");
	}

	public void breakChest() {
		gm.ui.messageText.setText("Auch! The chest is too hard to break!\n(-1 Life)");
		gm.player.playerLife--;
		gm.player.updatePlayerStatus();
	}

	public void tryChest() {
		gm.ui.messageText.setText("As I thought...it's locked! There must be a key around here...");
	}

	public void takeKey1() {
		gm.ui.messageText.setText("I found a key...\nUnfortunately it does not open the chest. There must be another!");
	}

	public void takeKey2() {
		gm.ui.messageText.setText("I found a key...\nUnfortunately it does not open the chest. There must be another!");
	}

	public void takeKey3() {
		gm.ui.messageText.setText("I found a key...\nIt opened the chest!\n(+1 Sword)");
		gm.player.hasSword = 1;
		gm.player.updatePlayerStatus();
	}

	public void takeKey4() {
		gm.ui.messageText.setText("I found a key...\nUnfortunately it does not open the chest. There must be another!");
	}

	public void takeKey5() {
		gm.ui.messageText.setText("I found a key...\nUnfortunately it does not open the chest. There must be another!");
	}

	public void takeKey6() {
		gm.ui.messageText.setText("I found a key...\nUnfortunately it does not open the chest. There must be another!");
	}
}
