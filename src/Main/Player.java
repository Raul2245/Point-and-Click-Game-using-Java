package Main;

public class Player {
	GameManager gm;
	public int playerMaxLife;
	public int playerLife;
	
	public int hasSword;
	public int hasShield;
	public int hasTorch;
	public int hasAcorn;
	public int hasLighter;
	public int hasFlint;
	public int hasMetal;
	public int hasBottle;
	public int hasFluid;
	public int hasKey;
	
	public int mainQuest;
	public int horseQuest;
	
	public Player(GameManager gm) {
		this.gm = gm;
	}
	
	public void setPlayerDefaultStatus() {
		playerMaxLife = 6;
		playerLife = 3;
		
		hasSword = 0;
		hasShield = 0;
		hasTorch = 0;
		hasAcorn = 0;
		hasLighter = 0;
		hasFlint = 0;
		hasMetal = 0;
		hasBottle = 0;
		hasFluid = 0;
		hasKey = 0;
		
		mainQuest = 0;
		horseQuest = 0;
		
		gm.ev4.alienLife = 1;
		gm.ev12.enemyLife = 10;
		updatePlayerStatus();
	}
	
	public void updatePlayerStatus() {
		//Remove all life icons
		int i = 0;
		while (i < 6) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		
		int lifeCount = playerLife;
		while (lifeCount != 0 && lifeCount > 0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
		}
		
		//items check
		if (hasSword == 0)
			gm.ui.swordLabel.setVisible(false);
		else
			gm.ui.swordLabel.setVisible(true);
		
		if (hasShield == 0)
			gm.ui.shieldLabel.setVisible(false);
		else
			gm.ui.shieldLabel.setVisible(true);
		
		if (hasTorch == 0)
			gm.ui.torchLabel.setVisible(false);
		else
			gm.ui.torchLabel.setVisible(true);
		
		if (hasAcorn == 0)
			gm.ui.acornLabel.setVisible(false);
		else
			gm.ui.acornLabel.setVisible(true);
		
		if (hasLighter == 0)
			gm.ui.lighterLabel.setVisible(false);
		else
			gm.ui.lighterLabel.setVisible(true);
		
		if (hasFlint == 0)
			gm.ui.flintLabel.setVisible(false);
		else
			gm.ui.flintLabel.setVisible(true);
		
		if (hasMetal == 0)
			gm.ui.metalLabel.setVisible(false);
		else
			gm.ui.metalLabel.setVisible(true);
		
		if (hasBottle == 0)
			gm.ui.bottleLabel.setVisible(false);
		else
			gm.ui.bottleLabel.setVisible(true);
		
		if (hasKey == 0)
			gm.ui.keyLabel.setVisible(false);
		else
			gm.ui.keyLabel.setVisible(true);
		
		if (gm.player.playerLife <= 0) {
			gm.sChanger.showScene(31);
			}
	}
}
