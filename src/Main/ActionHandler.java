package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	
	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		this.gm = gm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();
		
		switch(yourChoice) {
		//Scene 1
		case "lookShip":  gm.ev1.lookShip(); break;
		case "inspectShip": gm.ev1.inspectShip(); break;
		case "enterShip":  gm.ev1.enterShip(); break;
		//Scene2
		case "lookCat": gm.ev2.lookCat(); break;
		case "talkCat": gm.ev2.talkCat(); break;
		case "petCat": gm.ev2.petCat(); break;
		case "askCat": gm.ev2.askCat(); break;
		case "hintCat": gm.ev2.hintCat(); break;
		case "leaveShip": gm.ev2.leaveShip(); break;
		case "talkFinish": gm.ev2.talkFinish(); break;
		//Scene3
		case "lookMap": gm.ev3.lookMap(); break;
		case "travelMap1": gm.ev3.travelMap1(); break;
		case "travelMap2": gm.ev3.travelMap2(); break;
		case "travelMap3": gm.ev3.travelMap3(); break;
		case "travelMap4": gm.ev3.travelMap4(); break;
		case "travelMap5": gm.ev3.travelMap5(); break;
		case "travelMap6": gm.ev3.travelMap6(); break;
		case "travelMap7": gm.ev3.travelMap7(); break;
		case "travelMap8": gm.ev3.travelMap8(); break;
		case "travelMap9": gm.ev3.travelMap9(); break;
		case "travelMap10": gm.ev3.travelMap10(); break;
		case "travelMap11": gm.ev3.travelMap11(); break;
		case "travelMap12": gm.ev3.travelMap12(); break;
		case "travelMap13": gm.ev3.travelMap13(); break;
		case "travelMap14": gm.ev3.travelMap14(); break;
		case "travelMap15": gm.ev3.travelMap15(); break;
		case "travelMap16": gm.ev3.travelMap16(); break;
		//Scene4
		case "lookAlien": gm.ev4.lookAlien(); break;
		case "talkAlien": gm.ev4.talkAlien(); break;
		case "attackAlien": gm.ev4.attackAlien(); break;
		case "leaveMap": gm.ev4.leaveMap(); break;
		//Scene5
		case "lookPortal1": gm.ev5.lookPortal1(); break;
		case "lookPortal2": gm.ev5.lookPortal2(); break;
		case "enterPortal1": gm.ev5.enterPortal1(); break;
		case "enterPortal2":gm.ev5.enterPortal2(); break;
		//Scene6
		case "lookChest": gm.ev6.lookChest(); break;
		case "breakChest": gm.ev6.breakChest(); break;
		case "tryChest": gm.ev6.tryChest(); break;
		case "takeKey1": gm.ev6.takeKey1(); break;
		case "takeKey2": gm.ev6.takeKey2(); break;
		case "takeKey3": gm.ev6.takeKey3(); break;
		case "takeKey4": gm.ev6.takeKey4(); break;
		case "takeKey5": gm.ev6.takeKey5(); break;
		case "takeKey6": gm.ev6.takeKey6(); break;
		//Scene7
		case "lookHorse":gm.ev7.lookHorse(); break;
		case "talkHorse": gm.ev7.talkHorse(); break;
		case "attackHorse": gm.ev7.attackHorse(); break;
		case "yesHorse": gm.ev7.yesHorse(); break;
		case "noHorse": gm.ev7.noHorse(); break;
		case "claimReward": gm.ev7.claimReward(); break;
		case "talkHorseFinish": gm.ev7.talkHorseFinish(); break;
		//Scene8
		case "lookTree": gm.ev8.lookTree(); break;
		case "sneakTree": gm.ev8.sneakTree(); break;
		case "exploreTree": gm.ev8.exploreTree(); break;
		case "lookTreeClose": gm.ev8.lookTreeClose(); break;
		case "lookLab": gm.ev8.lookLab(); break;
		case "fireLab": gm.ev8.fireLab(); break;
		case "investigateLab": gm.ev8.investigateLab(); break;
		case "pickAcorn": gm.ev8.pickAcorn(); break;
		case "climbTree": gm.ev8.climbTree(); break;
		//Scene9
		case "lookHorseQuest": gm.ev9.lookHorseQuest(); break;
		case "exploreHorseQuest": gm.ev9.exploreHorseQuest(); break;
		case "lookCastle": gm.ev9.lookCastle(); break;
		case "enterCastle": gm.ev9.enterCastle(); break;
		case "lookGuard": gm.ev9.lookGuard(); break;
		case "attackGuard": gm.ev9.attackGuard(); break;
		case "talkGuard": gm.ev9.talkGuard(); break;
		case "checkPassword0": gm.ev9.checkPassword0(); break;
		case "checkPassword1": gm.ev9.checkPassword1(); break;
		case "lookKingHorse": gm.ev9.lookKingHorse(); break;
		case "talkKingHorse": gm.ev9.talkKingHorse(); break;
		case "sendMessage": gm.ev9.sendMessage(); break;
		case "stuckSon": gm.ev9.stuckSon(); break;
		//Scene10
		case "jumpAsteroid1": gm.ev10.jumpAsteroid(1); break;
		case "jumpAsteroid2": gm.ev10.jumpAsteroid(2); break;
		case "jumpAsteroid3": gm.ev10.jumpAsteroid(3); break;
		case "jumpAsteroid4": gm.ev10.jumpAsteroid(4); break;
		case "jumpAsteroid5": gm.ev10.jumpAsteroid(5); break;
		case "jumpAsteroid6": gm.ev10.jumpAsteroid(6); break;
		case "jumpAsteroid7": gm.ev10.jumpAsteroid(7); break;
		case "jumpAsteroid8": gm.ev10.jumpAsteroid(8); break;
		case "jumpAsteroid9": gm.ev10.jumpAsteroid(9); break;
		case "jumpAsteroid10": gm.ev10.jumpAsteroid(10); break;
		//Scene11
		case "lookWater": gm.ev11.lookWater();break;
		case "exploreWater": gm.ev11.exploreWater(); break;
		case "swimWater": gm.ev11.swimWater(); break;
		//Scene12
		case "lookCivil": gm.ev12.lookCivil(); break;
		case "exploreCivil": gm.ev12.exploreCivil(); break;
		case "sneakCivil": gm.ev12.sneakCivil(); break;
		case "lookChurch": gm.ev12.lookChurch(); break;
		case "investigateChurch": gm.ev12.investigateChurch(); break;
		case "sneakChurch": gm.ev12.sneakChurch(); break;
		case "returnChurch": gm.ev12.returnChurch(); break;
		case "enterDoor1": gm.ev12.enterDoor1(); break;
		case "enterDoor2": gm.ev12.enterDoor2(); break;
		case "enterDoor3": gm.ev12.enterDoor3(); break;
		case "lookCats": gm.ev12.lookCats(); break;
		case "talkCats": gm.ev12.talkCats(); break;
		case "lookWolf": gm.ev12.lookWolf(); break;
		case "talkWolf": gm.ev12.talkWolf(); break;
		case "hitWolf": gm.ev12.hitWolf(); break;
		case "convoWolf": gm.ev12.convoWolf(); break;
		//Scene13
		case "lookMetal": gm.ev13.lookMetal(); break;
		case "exploreMetal": gm.ev13.exploreMetal(); break;
		case "pickMetal": gm.ev13.pickMetal(); break;
		//Scene14
		case "lookBrother": gm.ev14.lookBrother(); break;
		case "talkBrother": gm.ev14.talkBrother(); break;
		case "tryBrother": gm.ev14.tryBrother(); break;
		case "lookFish": gm.ev14.lookFish(); break;
		case "lookJail": gm.ev14.lookJail(); break;
		case "brotherConvo1": gm.ev14.brotherConvo1(); break;
		case "brotherConvo2": gm.ev14.brotherConvo2(); break;
		case "brotherConvo3": gm.ev14.brotherConvo3(); break;
		case "freeBrother": gm.ev14.freeBrother(); break;
		//Scene15
		case "lookBottle": gm.ev15.lookBottle(); break;
		case "exploreBottle": gm.ev15.exploreBottle(); break;
		case "pickBottle": gm.ev15.pickBottle(); break;
		
		//Sceme16
		case "lookFluid": gm.ev16.lookFluid(); break;
		case "exploreFluid": gm.ev16.exploreFluid(); break;
		case "pickFluid": gm.ev16.pickFluid(); break;
		
		//Scene17
		case "lookCraft": gm.ev17.lookCraft(); break;
		case "exploreCraft": gm.ev17.exploreCraft(); break;
		case "craftLighter": gm.ev17.craftLighter(); break;
		//Scene 18
		case "lookView": gm.ev18.lookView(); break;
		case "screamView": gm.ev18.screamView(); break;
		case "approachView": gm.ev18.approachView(); break;
		
		//Scene19 
		case "lookVeve": gm.ev19.lookVeve(); break;
		case "talkVeve": gm.ev19.talkVeve(); break;
		case "petVeve": gm.ev19.petVeve(); break;
		case "optionsVeve": gm.ev19.optionsVeve(); break;
		case "torchVeve": gm.ev19.torchVeve(); break;
		case "potionVeve": gm.ev19.potionVeve(); break;
		case "shieldVeve": gm.ev19.shieldVeve(); break;
		
		//Game Over
		case "replayGame": gm.gameOver.replay(); break;
		}
	
		
	}
		
}
