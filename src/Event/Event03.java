package Event;

import Main.GameManager;

public class Event03 {
	GameManager gm;

	public Event03(GameManager gm) {
		this.gm = gm;
	}

	public void lookMap() {
		gm.ui.messageText.setText("This place looks pretty welcoming for a cat...");
	}

	public void travelMap1() {
		gm.ui.messageText.setText("You've traveled to map 1!");
		gm.ui.createButton(3, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[3].add(gm.ui.bgLabel[3]);
		gm.sChanger.showScene(4);
	}

	public void travelMap2() {
		gm.ui.messageText.setText("You've traveled to map 2!");
		gm.ui.createButton(4, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[4].add(gm.ui.bgLabel[4]);
		gm.sChanger.showScene(5);
	}

	public void travelMap3() {
		gm.ui.messageText.setText("You've traveled to map 3!");
		gm.ui.createButton(5, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[5].add(gm.ui.bgLabel[5]);
		gm.sChanger.showScene(6);
	}

	public void travelMap4() {
		gm.ui.messageText.setText("You've traveled to map 4!");
		gm.ui.createButton(6, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[6].add(gm.ui.bgLabel[6]);
		gm.sChanger.showScene(7);
	}

	public void travelMap5() {
		gm.ui.messageText.setText("You've traveled to map 5!");
		gm.ui.createButton(7, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[7].add(gm.ui.bgLabel[7]);
		gm.sChanger.showScene(8);
	}

	public void travelMap6() {
		gm.ui.createButton(8, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[8].add(gm.ui.bgLabel[8]);
		if (gm.ev10.asteroid[0] == 0)
			gm.ui.messageText.setText(
					"Oh no! These astoroids are heading towards all these planets! You have to do something about it!");
		else
			gm.ui.messageText.setText("You saved those planets!");
		gm.sChanger.showScene(9);
	}

	public void travelMap7() {
		gm.ui.createButton(9, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[9].add(gm.ui.bgLabel[9]);
		gm.ui.messageText
				.setText("You: If I'm not mistaken, this is the Equestrial Land. Here you can find most horses...");
		gm.ui.editObject(20, gm.ui.auxmenu[3], "Look", "lookGuard", 0);
		gm.ui.editObject(20, gm.ui.auxmenu[3], "Talk", "talkGuard", 1);
		gm.ui.editObject(20, gm.ui.auxmenu[3], "Attack", "attackGuard", 2);
		gm.sChanger.showScene(10);
	}

	public void travelMap8() {
		gm.ui.createButton(10, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.messageText.setText(
				"You: I've heard about this place! It is said that anyone who takes a swim into these waters, heals of any ache they might have...");
		gm.ui.bgPanel[10].add(gm.ui.bgLabel[10]);
		gm.sChanger.showScene(11);
	}

	public void travelMap9() {
		gm.ui.messageText.setText("You've traveled to map 9!");
		gm.ui.editObject(29, gm.ui.auxmenu[7], "Look", "lookWolf", 0);
		gm.ui.editObject(29, gm.ui.auxmenu[7], "Talk", "talkWolf", 1);
		gm.ui.editObject(29, gm.ui.auxmenu[7], "Hit", "hitWolf", 2);
		gm.ui.createButton(11, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[11].add(gm.ui.bgLabel[11]);
		gm.sChanger.showScene(12);
	}

	public void travelMap10() {
		gm.ui.messageText.setText("You've traveled to map 10!");
		gm.ui.createButton(12, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[12].add(gm.ui.bgLabel[12]);
		gm.sChanger.showScene(13);
	}

	public void travelMap11() {
		gm.ui.createButton(13, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		if (gm.player.hasLighter == 0 && gm.player.hasTorch == 0) {
			gm.ui.messageText.setText(
					"This is a black hole... I can't see anything... I need a light source in order to see something!\n"
							+ "I can smell a strong smell of fish though...");
		} else if (gm.player.hasLighter == 0 && gm.player.hasTorch == 1)
			gm.ui.messageText.setText("You need a lighter in order to lit up your torch!");
		else if (gm.player.hasLighter == 1 && gm.player.hasTorch == 0)
			gm.ui.messageText.setText("You need a torch to lit up using your lighter!");
		else {
			gm.player.mainQuest = 1;
			gm.ui.auxmenu[6] = gm.ui.createObject(13, 0, 0, 1280, 800, "jail.png", "Look", "Talk", "Try to break free", "lookBrother",
					"talkBrother", "tryBrother");
			gm.ui.createObject(13, 400, 200, 400, 482, "brother.png", "Look", "Talk", "Try to break free", "lookBrother",
					"talkBrother", "tryBrother");
			gm.ui.createObject(13, 100, 400, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
			gm.ui.createObject(13, 950, 400, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
			gm.ui.createObject(13, 0, 400, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
			gm.ui.createObject(13, 850, 400, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
			gm.ui.createObject(13, 50, 250, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
			gm.ui.createObject(13, 950, 250, 289, 172, "fish.png", "Look", " ", " ", "lookFish",
					" ", " ");
		}
		gm.ui.bgPanel[13].add(gm.ui.bgLabel[13]);
		gm.sChanger.showScene(14);
	}

	public void travelMap12() {
		gm.ui.messageText.setText("You've traveled to map 12!");
		gm.ui.createButton(14, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[14].add(gm.ui.bgLabel[14]);
		gm.sChanger.showScene(15);
	}

	public void travelMap13() {
		gm.ui.messageText.setText("You've traveled to map 13!");
		gm.ui.createButton(15, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[15].add(gm.ui.bgLabel[15]);
		gm.sChanger.showScene(16);
	}

	public void travelMap14() {
		gm.ui.messageText.setText("You've traveled to map 14!");
		gm.ui.createButton(16, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[16].add(gm.ui.bgLabel[16]);
		gm.sChanger.showScene(17);
	}

	public void travelMap15() {
		gm.ui.messageText.setText("You've traveled to map 15!");
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Look", "lookVeve", 0);
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Talk", "talkVeve", 1);
		gm.ui.editObject(17, gm.ui.auxmenu[5], "Pet", "petVeve", 2);
		gm.ui.createButton(17, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[17].add(gm.ui.bgLabel[17]);
		gm.sChanger.showScene(18);
	}

	public void travelMap16() {
		gm.ui.messageText.setText("You've traveled to map 16!");
		gm.ui.createButton(18, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		gm.ui.bgPanel[18].add(gm.ui.bgLabel[18]);
		gm.sChanger.showScene(19);
	}
}
