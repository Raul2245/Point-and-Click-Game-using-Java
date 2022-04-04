package Event;

import java.util.Random;

import Main.GameManager;

public class Event12 {
	GameManager gm;
	public int enemyLife = 10;
	int transaction = 0;
	int transaction1 = 0;
	int enemyHits = 0;
	int playerHits = 0;
	int playerHits2 = 0;
	int playerHits1 = 0;

	public Event12(GameManager gm) {
		this.gm = gm;
	}

	public void lookCivil() {
		if (gm.player.mainQuest == 1)
			gm.ui.messageText.setText("This city looks massive! It shouldn't be that hard to get in, right...?");
		else
			gm.ui.messageText.setText("I really shouldn't be heading this way.");
	}

	public void exploreCivil() {
		if (gm.player.mainQuest == 1) {
			Random rand = new Random();
			if (rand.nextInt() % 2 == 0) {
				gm.ui.messageText.setText(
						"You get seen by a few guards and get chased for a few miles. You hit your leg in the process but you manage to lose the guards.\n(-1 Life)");
				gm.player.playerLife--;
				gm.player.updatePlayerStatus();
				gm.sChanger.showScene(26);
			} else {
				if (gm.player.hasShield == 1) {
					gm.ui.messageText.setText("You get seen by a few guards and get chased for a few miles. "
							+ "You hit your leg in the process and the guards catch you, but you use your shield and escape.\n(-1 Shield)\n");
					gm.player.hasShield = 0;
					gm.player.updatePlayerStatus();
				} else {
					gm.ui.messageText.setText(
							"You get seen by a few guards and get chased for a few miles. You hit your leg in the process and the guards caught you.\n");
					gm.player.playerLife = 0;
					gm.player.updatePlayerStatus();
				}
			}
		} else
			gm.ui.messageText.setText("I really shouldn't be heading this way.");
	}

	public void sneakCivil() {
		if (gm.player.mainQuest == 1) {
			gm.ui.messageText.setText("As expected, it wasn't too hard.");
			gm.sChanger.showScene(26);
		} else
			gm.ui.messageText.setText("I really shouldn't be heading this way.");
	}

	public void lookChurch() {
		gm.ui.messageText.setText("This must be the church I'm looking for.");
	}

	public void investigateChurch() {
		gm.ui.messageText.setText("The lights seem to be off. I hope there's nobody inside.");
	}

	public void sneakChurch() {
		gm.ui.messageText.setText("All the doors look the same! How will I know which one to choose?");
		gm.sChanger.showScene(27);
	}

	public void returnChurch() {
		gm.sChanger.showScene(27);
	}

	public void enterDoor1() {
		gm.sChanger.showScene(28);
	}

	public void enterDoor2() {
		gm.sChanger.showScene(29);
	}

	public void enterDoor3() {
		gm.sChanger.showScene(30);
	}

	public void lookCats() {
		gm.ui.messageText.setText("Oh no! They have more prisoners!");
	}

	public void talkCats() {
		gm.ui.messageText.setText("You: Don't make any noise! Don't worry you'll be set free soon!");
	}

	public void lookWolf() {
		if (enemyLife > 0) {
			gm.ui.messageText.setText("He must be responsible for all of this!\nEnemy HP: " + enemyLife);
		} else
			gm.ui.messageText.setText("He's dead.");
	}

	public void talkWolf() {
		if (enemyLife > 0) {
			gm.ui.messageText.setText(
					"Werewolf: What are you doing here!? You'd better leave if you don't want to get hurt!\nEnemy HP: "
							+ enemyLife);
			gm.ui.editObject(29, gm.ui.auxmenu[7], "I know what you've done!", "convoWolf", 1);
		} else
			gm.ui.messageText.setText("He's dead.");
	}

	public void convoWolf() {
		gm.ui.messageText
				.setText("Werewolf: Fair well then! You leave me no choice...\n(-1 Life)\nEnemy HP: " + enemyLife);

		if (transaction1 == 0) {
			transaction1 = 1;
			gm.player.playerLife--;
			gm.player.updatePlayerStatus();
		}

	}

	public void hitWolf() {
		if (enemyLife > 0) {
			if (gm.player.hasSword == 1) {
				Random rand = new Random();
				int rand_int = rand.nextInt();
				if (rand_int % 2 == 0) {
					enemyHits++;
					if (enemyHits == 2) {
						if (enemyLife - 2 > 0)
							enemyLife -= 2;
						else
							enemyLife = 0;

						gm.ui.messageText
								.setText("Critical hit on your enemy!\n(-2 Enemy Life)\nEnemy HP: " + enemyLife);
						enemyHits = 0;
					}
				} else {
					enemyHits++;
					if (enemyHits == 2) {
						enemyLife--;
						gm.ui.messageText.setText("You hit your enemy!\n(-1 Enemy Life)\nEnemy HP: " + enemyLife);
						enemyHits = 0;
					}
				}
			} else {
				Random rand = new Random();
				int rand_int = rand.nextInt();
				if (rand_int % 3 == 0) {
					enemyLife--;
					gm.ui.messageText.setText("You hit your enemy!\n(-1 Enemy Life)\nEnemy HP: " + enemyLife);
				} else
					gm.ui.messageText.setText(
							"It's really hard fighting without a sword...\n(-0 Enemy Life)\nEnemy HP: " + enemyLife);
			}
		} else
			gm.ui.messageText.setText("He's dead.");

		if (enemyLife <= 0) {
			gm.ui.messageText.setText("You killed your enemy!\n(+1 Key)");
			gm.player.hasKey = 1;
			gm.player.updatePlayerStatus();
			gm.ui.editObject(29, gm.ui.auxmenu[7], "Return", "returnChurch", 1);
			gm.ui.editObject(13, gm.ui.auxmenu[6], "Break free", "freeBrother", 0);
		}

		if (enemyLife > 0) {
			if (gm.player.hasShield == 0) {
				Random rand = new Random();
				int rand_int = rand.nextInt();
				if (rand_int % 2 == 0) {
					gm.ui.messageText.setText("Auch...\n(-2 Life)\nEnemy HP: " + enemyLife);
					playerHits++;
					if (playerHits == 2) {
						if (gm.player.playerLife - 2 > 0)
							gm.player.playerLife -= 2;
						else
							gm.player.playerLife = 0;

						gm.player.updatePlayerStatus();
						playerHits = 0;
					}
				} else {
					gm.ui.messageText.setText("Auch...\n(-1 Life)\nEnemy HP: " + enemyLife);
					playerHits++;
					if (playerHits == 2) {
						gm.player.playerLife--;
						gm.player.updatePlayerStatus();
						playerHits = 0;
					}
				}
			} else {
				Random rand = new Random();
				int rand_int = rand.nextInt();
				if (rand_int % 5 == 0) {
					gm.ui.messageText.setText("Auch...\n(-1 Life)\nEnemy HP: " + enemyLife);
					playerHits++;
					if (playerHits == 2) {
						gm.player.playerLife--;
						gm.player.updatePlayerStatus();
						playerHits = 0;
					} else
						gm.ui.messageText.setText(
								"Werewolf tried to attack you, but you used your shield!\nEnemy HP: " + enemyLife);
				}
			}
		} else
			gm.ui.messageText.setText("He's dead.");
	}

}