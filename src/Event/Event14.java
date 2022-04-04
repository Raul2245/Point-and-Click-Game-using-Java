package Event;

import Main.GameManager;

public class Event14 {
	GameManager gm;

	public Event14(GameManager gm) {
		this.gm = gm;
	}

	public void lookBrother() {
		gm.ui.messageText.setText("That must be the pilot's brother! I've finally found him!");
	}

	public void talkBrother() {
		gm.ui.messageText.setText(
				"Thank God! Somebody has finally gotten here! I've been waiting for ages, my brother must be worried sick!");
		gm.ui.editObject(13, gm.ui.auxmenu[6], "Your brother sent me.", "brotherConvo1", 0);
		gm.ui.editObject(13, gm.ui.auxmenu[6], "How did you get here?", "brotherConvo2", 1);
		gm.ui.editObject(13, gm.ui.auxmenu[6], "I'm here to help!", "brotherConvo3", 2);
	}

	public void brotherConvo1() {
		gm.ui.messageText.setText(
				"I knew he would find me somehow! He's the best! He's always been the responsible one... as you can probably see...");
	}

	public void brotherConvo2() {
		gm.ui.messageText.setText("Well, I was looking for this magical toy with my brother, but then I got hungry."
				+ " So I went to the fridge to look for something to eat. I really like fish by the way!"
				+ " So imagine my delight when I look out the window and I see a whole bunch of fish just floating around!?"
				+ " I rushed out the spaceship towards the fish but somebody kiddnapped me! I heard them talking about cat fur being really expensive these days."
				+ " So here I am now, captured in this little cage... at least I have fish! But I wish I could return to my brother...");
	}

	public void brotherConvo3() {
		gm.ui.messageText.setText(
				"You think you can get me out of here? That would be amazing. I wish I could help you but all I know"
						+ " is that they pretend to be priests but are in fact werewolves! Also they hide inside an old church! That's where they keep the key."
						+ " They're not even priests! What a bunch of scammers...");
	}

	public void tryBrother() {
		gm.ui.messageText.setText("You need a key in order to open the cage.");
	}

	public void lookFish() {
		gm.ui.messageText.setText("This must be the bait used to catch other cats...");
	}

	public void lookJail() {
		gm.ui.messageText.setText(
				"These bars look pretty solid, I don't think I'd be able to break them. Must find another solution.");
	}
	
	public void freeBrother() {
		gm.ui.editObject(1, gm.ui.auxmenu[0], "Final Talk", "talkFinish", 0);
		gm.ui.messageText.setText("You've come back!");
		gm.sChanger.showScene(2);
	}

}