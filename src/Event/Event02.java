package Event;

import Main.GameManager;

public class Event02 {
	GameManager gm;
	
	public Event02(GameManager gm) {
		this.gm = gm;
	}

	public void lookCat() {
		gm.ui.messageText.setText("Is that a... cat?");
	}

	public void talkCat() {
		gm.ui.messageText.setText("Thank God you're here! I've been waiting for someone to show up.\nI have a quest for you.");
		gm.ui.editObject(1, gm.ui.auxmenu[0], "Ask about quest", "askCat", 1);
	}

	public void petCat() {
		gm.ui.messageText.setText("Purr...Purr...Purr...");
	}

	public void askCat() {
		gm.ui.messageText.setText(
				"I'll take your question as a 'Yes' to my quest.\nYou see... I've been traveling through space with my brother looking for"
						+ " the best toy in the Universe, but my brother has dissapeared... you know how cats are, he must of been distracted by something and then got lost.\n"
						+ "You need to find him, I've looked everywhere...");

		gm.ui.editObject(1, gm.ui.auxmenu[0], "Hint", "hintCat", 1);
	}

	public void hintCat() {
		gm.ui.messageText.setText(
				"He really likes fish.\nYou must go now! Find him or we'll never get to find that toy...\n");
	}

	public void leaveShip() {
		gm.sChanger.showScene(3);
		gm.ui.messageText.setText("If I were a cat... where would I go?");
	}
	
	public void talkFinish() {
		gm.ui.messageText.setText("You've done it! You've reunited me with my brother! Thank you so much! I knew you could do it!");
		gm.sChanger.showScene(32);
	}
}
