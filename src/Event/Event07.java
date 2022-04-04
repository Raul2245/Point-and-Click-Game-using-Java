package Event;

import Main.GameManager;

public class Event07 {
	GameManager gm;

	public Event07(GameManager gm) {
		this.gm = gm;
	}

	public void lookHorse() {
		gm.ui.messageText.setText("He might be helpful...");
	}

	public void talkHorse() {
		gm.ui.messageText.setText(
				"Hello there! I'm glad to see you!\nI got hurt trying to leave this place and I have a very important message to send."
						+ "\nCould you do it for me? I'll make sure to give you a reward if so!");
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Yes", "yesHorse", 0);
		gm.ui.editObject(6, gm.ui.auxmenu[2], "No", "noHorse", 1);
	}

	public void attackHorse() {
		gm.ui.messageText.setText("I wouldn't do that again if I were you!\n(-2 Lives)");
		if(gm.player.playerLife - 2 <= 0)
			gm.player.playerLife = 0;
		else
			gm.player.playerLife -= 2;
		
		gm.player.updatePlayerStatus();
	}

	public void yesHorse() {
		gm.ui.messageText.setText(
				"Awesome!\nYou'll have to find my father and tell him this: MPAI\nHe'll know what it means don't worry!\nAlso, this should help you enter the castle, so remember: 4362"
						+ "\nCome back after you've done it and I shall reward you!");
		gm.player.horseQuest = 1;
		gm.player.updatePlayerStatus();
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Look", "lookHorse", 0);
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Talk", "talkHorse", 1);
	}
	
	public void noHorse() {
		gm.ui.messageText.setText("Fair well! Good luck in your adventure!");
		gm.player.horseQuest = 0;
		gm.player.updatePlayerStatus();
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Look", "lookHorse", 0);
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Talk", "talkHorse", 1);
	}
	
	public void claimReward() {
		gm.ui.messageText.setText("For your act of kindness I shall reward you with my shield!\n(+1 Shield)");
		gm.player.hasShield = 1;
		gm.player.updatePlayerStatus();
	}
	
	public void talkHorseFinish() {
		gm.ui.messageText.setText("I see you've finished my task...");
	}
}
