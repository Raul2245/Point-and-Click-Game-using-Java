package Event;

import Main.GameManager;

public class Event09 {
	GameManager gm;
	int tries = 0;
	
	public Event09(GameManager gm) {
		this.gm = gm;
	}
	
	public void lookHorseQuest() {
		gm.ui.messageText.setText("Looks pretty dangerous... I should be careful.");
	}
	
	public void exploreHorseQuest() {
		gm.ui.createButton(9, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.sChanger.showScene(20);
		gm.ui.messageText.setText("I hope I'm going the right way...");
	}
	
	public void lookCastle() {
		gm.ui.messageText.setText("I didn't know horses lived in castles.");
	}
	
	public void enterCastle() {
		gm.ui.createButton(9, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.sChanger.showScene(21);
	}
	
	public void checkPassword1() {
			gm.ui.messageText.setText("That's correct. You may see the king.");
			gm.sChanger.showScene(22);
	}
	
	public void checkPassword0() {
			gm.ui.messageText.setText("That is not correct. You have one more try. Otherwise you die.");
			tries++;
			if (tries == 8)
				{
				gm.player.playerLife = 0;
				gm.player.updatePlayerStatus();
				}
	}
	
	public void lookGuard() {
		gm.ui.messageText.setText("This guard does not seem the nicest.");
	}
	
	public void attackGuard() {
		gm.ui.messageText.setText("Guard: I've warned you...");
		gm.player.playerLife = 0;
		gm.player.updatePlayerStatus();
	}
	
	public void talkGuard() {
		if (gm.player.horseQuest == 0)
			gm.ui.messageText.setText("Guard: You're not welcome here! Leave or you shall suffer.");
		else
			{
			gm.ui.messageText.setText("Guard: What brings you here? Do you know the password?");
			gm.ui.editObject(20, gm.ui.auxmenu[3], "3624", "checkPassword0", 0);
			gm.ui.editObject(20, gm.ui.auxmenu[3], "4263", "checkPassword0", 1);
			gm.ui.editObject(20, gm.ui.auxmenu[3], "4362", "checkPassword1", 2);
			}	
	}
	
	public void lookKingHorse() {
		gm.ui.messageText.setText("That must be the King.");
	}
	
	public void talkKingHorse(){
		gm.ui.messageText.setText("King: What brings you here, on my land?");
		gm.ui.editObject(21, gm.ui.auxmenu[4], "Your son is stuck", "stuckSon", 1);
	}
	
	public void sendMessage() {
		gm.ui.messageText.setText("You: Your son wanted me to tell you something. <<MPAI>> He said you'd understand.\nKing: Yes, thank you good sir.");
		gm.player.horseQuest = 2;
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Claim reward", "claimReward", 0);
		gm.ui.editObject(6, gm.ui.auxmenu[2], "Tell about task", "talkHorseFinish", 1);
	}
	
	public void stuckSon() {
		gm.ui.messageText.setText("You: I accidentally met your son, he's stuck on a nearby planet but he kindly asked me to send you a message.\n");
	}
}