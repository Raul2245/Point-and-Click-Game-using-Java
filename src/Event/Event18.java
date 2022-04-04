package Event;

import Main.GameManager;

public class Event18 {
	GameManager gm;

	public Event18(GameManager gm) {
		this.gm = gm;
	}

	public void lookView() {
		gm.ui.messageText.setText("That seems to be a ledge.\n");
	}

	public void screamView() {
		gm.ui.messageText.setText(
				"You: I WISH I FOUND WHAT I'M LOOKING FOR!\nEcho: I wish I found what I'm looking for\nEcho: I wish I found what I'm looking for"
						+ "\nEcho: I wish I found what I'm looking for");
	}

	public void approachView() {
		gm.sChanger.showScene(23);
		if (gm.player.playerLife + 1 < gm.player.playerMaxLife) {
			gm.ui.messageText.setText("The view is breath taking. I already feel better.\n(+1 Life)");
			gm.player.playerLife++;
			gm.player.updatePlayerStatus();
		} else
			gm.ui.messageText.setText("The view is breath taking. I already feel better.\n");
	}
}