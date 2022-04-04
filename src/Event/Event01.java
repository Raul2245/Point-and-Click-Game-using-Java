package Event;

import Main.GameManager;

public class Event01 {
	GameManager gm;
	
	public Event01(GameManager gm) {
		this.gm = gm;
	}
	
	public void lookShip() {
		gm.ui.messageText.setText("This is a star ship flying through space.");
	}
	
	public void inspectShip() {
		gm.ui.messageText.setText("The ship seems familiar, I wonder if I know the pilot.");
	}
	
	public void enterShip() {
		gm.ui.messageText.setText("Is that the pilot...!?");
		gm.sChanger.showScene(2);
	}
}
