package Event;

import Main.GameManager;

public class Event19 {
	GameManager gm;
	int transaction = 0;

	public Event19(GameManager gm) {
		this.gm = gm;
	}

	public void lookVeve() {
		gm.ui.messageText.setText("Is that a floating squirrel? The Universe is weird.");
		transaction = 0;
	}

	public void talkVeve() {
		gm.ui.messageText.setText(
				"Hello there, wanderer! I'm the Wandering Trander Squirrel! I can trade you something you might need, in exchange for acorns!");
		gm.ui.editObject(17, gm.ui.auxmenu[5], "What do you have in stock?", "optionsVeve", 1);
		transaction = 0;
	}

	public void petVeve() {
		gm.ui.messageText.setText("*squirrel noises*");
		transaction = 0;
	}

	public void optionsVeve() {
		gm.ui.messageText.setText(
				"Glad you asked! I have a variety of things, but my most popular ones are:\n1.A torch, comes in handy in dark places -- 5 acorns"
						+ "\n2.A potion of life (it gives you 1 life) -- 3 acorns"
						+ "\n3.A shield, great against enemies. -- 10 acorns\nSo, tell me, does anything peak your interest? (You have "
						+ gm.player.hasAcorn + " acorns.)");
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Torch", "torchVeve", 0);
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Potion", "potionVeve", 1);
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Shield", "shieldVeve", 2);
	}

	public void torchVeve() {
		if (transaction == 0) {
			if (gm.player.hasAcorn >= 5) {
				gm.player.hasTorch = 1;
				gm.player.hasAcorn -= 5;
				gm.player.updatePlayerStatus();
				gm.ui.messageText.setText("Here you go!\n(+1 Torch)\nYou have " + gm.player.hasAcorn + " acorns left.");
				transaction = 1;
			} else {
				gm.ui.messageText
						.setText("You don't have enough acorns.\n(You have " + gm.player.hasAcorn + " acorns.)");
			}
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Look", "lookVeve", 0);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Talk", "talkVeve", 1);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Pet", "petVeve", 2);
		}
	}

	public void potionVeve() {
		if (transaction == 0) {
			if (gm.player.hasAcorn >= 3) {
				if (gm.player.playerLife + 1 < gm.player.playerMaxLife)
					gm.player.playerLife++;
				gm.player.hasAcorn -= 3;
				gm.player.updatePlayerStatus();
				gm.ui.messageText.setText("Here you go!\n(+1 Life)\nYou have " + gm.player.hasAcorn + " acorns left.");
				transaction = 1;
			} else {
				gm.ui.messageText
						.setText("You don't have enough acorns.\n(You have " + gm.player.hasAcorn + " acorns.)");
			}
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Look", "lookVeve", 0);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Talk", "talkVeve", 1);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Pet", "petVeve", 2);
		}
	}

	public void shieldVeve() {
		if (transaction == 0) {
			if (gm.player.hasAcorn >= 10) {
				gm.player.hasShield = 1;
				gm.player.hasAcorn -= 10;
				gm.player.updatePlayerStatus();
				gm.ui.messageText
						.setText("Here you go!\n(+1 Shield)\nYou have " + gm.player.hasAcorn + " acorns left.");
				transaction = 1;
			} else {
				gm.ui.messageText
						.setText("You don't have enough acorns.\n(You have " + gm.player.hasAcorn + " acorns.)");
			}
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Look", "lookVeve", 0);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Talk", "talkVeve", 1);
			gm.ui.editObject(17, gm.ui.auxmenu[5], "Pet", "petVeve", 2);
		}
	}

}