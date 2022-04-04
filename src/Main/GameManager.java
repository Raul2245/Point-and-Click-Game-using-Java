package Main;

import Event.Event01;
import Event.Event02;
import Event.Event03;
import Event.Event04;
import Event.Event05;
import Event.Event06;
import Event.Event07;
import Event.Event08;
import Event.Event09;
import Event.Event10;
import Event.Event11;
import Event.Event12;
import Event.Event13;
import Event.Event14;
import Event.Event15;
import Event.Event16;
import Event.Event17;
import Event.Event18;
import Event.Event19;
import Event.GameOver;

public class GameManager {
	
	ActionHandler aHandler = new ActionHandler(this);
	
	public UI ui = new UI(this);
	
	public Player player = new Player(this);
	
	public SceneChanger sChanger = new SceneChanger(this);
	
	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	public Event03 ev3 = new Event03(this);
	public Event04 ev4 = new Event04(this);
	public Event05 ev5 = new Event05(this);
	public Event06 ev6 = new Event06(this);
	public Event07 ev7 = new Event07(this);
	public Event08 ev8 = new Event08(this);
	public Event09 ev9 = new Event09(this);
	public Event10 ev10 = new Event10(this);
	public Event11 ev11 = new Event11(this);
	public Event12 ev12 = new Event12(this);
	public Event13 ev13 = new Event13(this);
	public Event14 ev14 = new Event14(this);
	public Event15 ev15 = new Event15(this);
	public Event16 ev16 = new Event16(this);
	public Event17 ev17 = new Event17(this);
	public Event18 ev18 = new Event18(this);
	public Event19 ev19 = new Event19(this);
	public GameOver gameOver = new GameOver(this);
	
	public static void main(String[] args) {
		
		new GameManager();
	}
	
	public GameManager() {
		player.setPlayerDefaultStatus();
		this.sChanger.showScene(1);
	}
}
