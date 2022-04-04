package Event;

import Main.GameManager;

public class Event08 {
	GameManager gm;

	public Event08(GameManager gm) {
		this.gm = gm;
	}

	public void lookTree() {
		gm.ui.messageText.setText("Is that a Tree? I though Earth was the only planet capable of growing plants...");
	}

	public void exploreTree() {
		if (gm.player.hasShield == 1) {
			gm.ui.messageText.setText(
					"You've been caught by a guard. Be more careful next time! This time you've been saved by your shield.\n(-1 Shield)");
			gm.player.hasShield = 0;
			gm.player.updatePlayerStatus();
		} else {
			gm.ui.messageText.setText("You've been caught by a guard. Be more careful next time!");
			gm.player.playerLife = 0;
			gm.player.updatePlayerStatus();
		}
	}

	public void sneakTree() {
		gm.ui.messageText.setText("Good thing I've snuck in... those guards would have eaten me alive!");
		gm.sChanger.showScene(24);
	}

	public void lookTreeClose() {
		gm.ui.messageText.setText(
				"This is beautiful... It's even better than on Earth...\nThere are plenty of acorns all over the ground. They could come in handy at some point...");
	}

	public void pickAcorn() {
		gm.player.hasAcorn++;
		gm.ui.messageText.setText("You have " + gm.player.hasAcorn + " acorns.");
		gm.player.updatePlayerStatus();
	}

	public void climbTree() {
		gm.ui.messageText.setText("The tree is pretty tall. I wonder what's at the top.");
		gm.sChanger.showScene(25);
	}

	public void lookLab() {
		gm.ui.messageText.setText("It seems to be a laboratory of some sort...");
	}

	public void investigateLab() {
		gm.ui.messageText.setText(
				"The laboratory is used to grow some sort of creatures and the tree is used as a cover up so nobody will come closer and discover "
						+ "what they've been hiding. That's why there were so many guards around...\nThis smells fishy.");
	}

	public void fireLab() {
		if (gm.player.hasLighter == 1)
			gm.ui.messageText.setText(
					"I lit up this sponge. It will quickly spread from here. I should probably get out of here before somebody sees me though...\nI hope I did the right thing...");
		else
			gm.ui.messageText.setText(
					"You can't do that! You don't have a lighter.\n(Hint: You need flint, metal and lighter fluid to build a lighter.");
	}
}