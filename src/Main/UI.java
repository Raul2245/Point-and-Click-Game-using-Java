package Main;

import java.awt.Color;

import javax.swing.*;
import javax.swing.JPopupMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI {
	GameManager gm;
	JFrame window;

	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[32];
	public JLabel bgLabel[] = new JLabel[32];
	public JPopupMenu[] auxmenu = new JPopupMenu[10];

	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel swordLabel, shieldLabel, torchLabel, acornLabel, lighterLabel, flintLabel, metalLabel, bottleLabel,
			keyLabel;

	public UI(GameManager gm) {
		this.gm = gm;

		createMainField();
		generateScene();
		createPlayerField();

		window.setVisible(true);
	}

	public void createMainField() {
		window = new JFrame("Stelar Adventure Game");
		window.setSize(1280, 820);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		messageText = new JTextArea(
				"Welcome wanderer! Are you ready for an adventure?\n If so, look around the scenery... I'm sure you'll find the adventure you're looking for! ");
		messageText.setBounds(0, 600, 1280, 720);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		window.add(messageText);
	}

	public void createBackground(int bgnb, String bgName, int delayX, int delayY) {

		bgPanel[bgnb] = new JPanel();
		bgPanel[bgnb].setBounds(delayX, delayY + 40, 1280, 620);
		bgPanel[bgnb].setBackground(Color.black);
		bgPanel[bgnb].setLayout(null);
		window.add(bgPanel[bgnb]);

		bgLabel[bgnb] = new JLabel();
		bgLabel[bgnb].setBounds(delayX, delayY, 1280, 620);

		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgName));
		bgLabel[bgnb].setIcon(bgIcon);

	}

	public JPopupMenu createObject(int bgnb, int obx, int oby, int obw, int obh, String obName, String choice1,
			String choice2, String choice3, String choice1Command, String choice2Command, String choice3Command) {

		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem[] = new JMenuItem[3];

		menuItem[0] = new JMenuItem(choice1);
		menuItem[0].addActionListener(gm.aHandler);
		menuItem[0].setActionCommand(choice1Command);
		popMenu.add(menuItem[0]);

		if (choice2 != " ") {
			menuItem[1] = new JMenuItem(choice2);
			menuItem[1].addActionListener(gm.aHandler);
			menuItem[1].setActionCommand(choice2Command);
			popMenu.add(menuItem[1]);
		}

		if (choice3 != " ") {
			menuItem[2] = new JMenuItem(choice3);
			menuItem[2].addActionListener(gm.aHandler);
			menuItem[2].setActionCommand(choice3Command);
			popMenu.add(menuItem[2]);
		}

		JLabel obLabel = new JLabel();
		obLabel.setBounds(obx, oby, obw, obh);
		obLabel.setOpaque(false);

		ImageIcon obImage = new ImageIcon(getClass().getClassLoader().getResource(obName));
		obLabel.setIcon(obImage);
		// obLabel.setOpaque(true);

		obLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(obLabel, e.getX(), e.getY());
				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});

		bgPanel[bgnb].add(obLabel);

		return popMenu;
	}

	public void editObject(int bgnb, JPopupMenu ob, String choice, String choiceCommand, int index) {
		JMenuItem p = (JMenuItem) ob.getComponentAtIndex(index);
		p.setActionCommand(choiceCommand);
		p.setLabel(choice);
		p.addActionListener(gm.aHandler);
	}

	public void createButton(int bgnb, int x, int y, int w, int h, String name, String command) {
		ImageIcon bttnImg = new ImageIcon(getClass().getClassLoader().getResource(name));

		JButton bttn = new JButton();
		bttn.setBounds(x, y, w, h);
		bttn.setBackground(null);
		bttn.setContentAreaFilled(false);
		bttn.setFocusPainted(false);
		bttn.setIcon(bttnImg);
		bttn.addActionListener(gm.aHandler);
		bttn.setActionCommand(command);
		bttn.setBorderPainted(false);

		bgPanel[bgnb].add(bttn);
	}

	public void createPlayerField() {
		lifePanel = new JPanel();
		lifePanel.setBounds(5, 0, 250, 50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1, 5));
		window.add(lifePanel);

		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("heart.png"));
		Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
		lifeIcon = new ImageIcon(image);

		int i = 0;
		while (i < 6) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;
		}

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(800, 0, 315, 35);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1, 9));
		window.add(inventoryPanel);

		// Create items
		swordLabel = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("sword.png"));
		swordLabel.setIcon(swordIcon);
		inventoryPanel.add(swordLabel);

		shieldLabel = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("shield.png"));
		shieldLabel.setIcon(shieldIcon);
		inventoryPanel.add(shieldLabel);

		torchLabel = new JLabel();
		ImageIcon torchIcon = new ImageIcon(getClass().getClassLoader().getResource("torch.png"));
		torchLabel.setIcon(torchIcon);
		inventoryPanel.add(torchLabel);

		acornLabel = new JLabel();
		ImageIcon acornIcon = new ImageIcon(getClass().getClassLoader().getResource("acorn.png"));
		acornLabel.setIcon(acornIcon);
		inventoryPanel.add(acornLabel);

		lighterLabel = new JLabel();
		ImageIcon lighterIcon = new ImageIcon(getClass().getClassLoader().getResource("lighter.png"));
		lighterLabel.setIcon(lighterIcon);
		inventoryPanel.add(lighterLabel);

		flintLabel = new JLabel();
		ImageIcon flintIcon = new ImageIcon(getClass().getClassLoader().getResource("flint.png"));
		flintLabel.setIcon(flintIcon);
		inventoryPanel.add(flintLabel);

		metalLabel = new JLabel();
		ImageIcon metalIcon = new ImageIcon(getClass().getClassLoader().getResource("metal.png"));
		metalLabel.setIcon(metalIcon);
		inventoryPanel.add(metalLabel);

		bottleLabel = new JLabel();
		ImageIcon bottleIcon = new ImageIcon(getClass().getClassLoader().getResource("bottle.png"));
		bottleLabel.setIcon(bottleIcon);
		inventoryPanel.add(bottleLabel);

		keyLabel = new JLabel();
		ImageIcon keyIcon = new ImageIcon(getClass().getClassLoader().getResource("key_inv.png"));
		keyLabel.setIcon(keyIcon);
		inventoryPanel.add(keyLabel);
	}

	public void generateScene() {
		// Scene 1
		createBackground(0, "bg1.jpg", 0, 0);
		createObject(0, 800, 300, 350, 200, "ship.png", "Look", "Inspect", "Enter", "lookShip", "inspectShip",
				"enterShip");
		bgPanel[0].add(bgLabel[0]);

		// Scene 2
		createBackground(1, "bg2.jpg", 0, 0);
		auxmenu[0] = createObject(1, 450, 120, 400, 400, "cat.png", "Look", "Talk", "Pet", "lookCat", "talkCat",
				"petCat");
		createButton(1, 1100, 110, 100, 70, "bttn.png", "leaveShip");
		bgPanel[1].add(bgLabel[1]);

		// Scene 3
		createBackground(2, "bg3.jpg", 80, 0);
		createObject(2, 115, 260, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap1", " ");
		createObject(2, 115, 410, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap2", " ");
		createObject(2, 250, 190, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap3", " ");
		createObject(2, 250, 340, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap4", " ");
		createObject(2, 380, 100, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap5", " ");
		createObject(2, 380, 260, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap6", " ");
		createObject(2, 380, 420, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap7", " ");
		createObject(2, 510, 190, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap8", " ");
		createObject(2, 510, 340, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap9", " ");
		createObject(2, 640, 100, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap10", " ");
		createObject(2, 640, 260, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap11", " ");
		createObject(2, 640, 420, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap12", " ");
		createObject(2, 770, 190, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap13", " ");
		createObject(2, 770, 340, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap14", " ");
		createObject(2, 900, 260, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap15", " ");
		createObject(2, 900, 410, 100, 100, "blank.png", "Look", "Travel here", " ", "lookMap", "travelMap16", " ");
		bgPanel[2].add(bgLabel[2]);

		// Scene 4
		createBackground(3, "bg4.jpg", 0, 0);
		auxmenu[1] = createObject(3, 540, 350, 200, 200, "alien.png", "Look", "Talk to", "Attack", "lookAlien",
				"talkAlien", "attackAlien");
		bgPanel[3].add(bgLabel[3]);

		// Scene 5
		createBackground(4, "bg5.jpg", 0, 0);
		createObject(4, 200, 170, 300, 288, "portal.png", "Look", "Enter", " ", "lookPortal1", "enterPortal1", " ");
		createObject(4, 700, 170, 300, 288, "portal.png", "Look", "Enter", " ", "lookPortal2", "enterPortal2", " ");
		bgPanel[4].add(bgLabel[4]);

		// Scene 6
		createBackground(5, "bg6.jpg", 0, 0);
		createObject(5, 20, 320, 200, 140, "chest.png", "Look", "Break", "Try to open", "lookChest", "breakChest",
				"tryChest");
		createObject(5, 640, 200, 50, 50, "key.png", "Take", " ", " ", "takeKey1", " ", " ");
		createObject(5, 1200, 250, 50, 50, "key.png", "Take", " ", " ", "takeKey2", " ", " ");
		createObject(5, 300, 400, 50, 50, "key.png", "Take", " ", " ", "takeKey3", " ", " ");
		createObject(5, 20, 150, 50, 50, "key.png", "Take", " ", " ", "takeKey4", " ", " ");
		createObject(5, 900, 250, 50, 50, "key.png", "Take", " ", " ", "takeKey5", " ", " ");
		createObject(5, 400, 500, 50, 50, "key.png", "Take", " ", " ", "takeKey6", " ", " ");
		bgPanel[5].add(bgLabel[5]);

		// Scene 7
		createBackground(6, "bg7.jpg", 0, 0);
		auxmenu[2] = createObject(6, 540, 340, 400, 250, "horse.png", "Look", "Talk", "Attack", "lookHorse",
				"talkHorse", "attackHorse");
		bgPanel[6].add(bgLabel[6]);

		// Scene 8
		createBackground(7, "bg8.jpg", 0, 0);
		createObject(7, 0, 0, 1080, 720, "blank.png", "Look", "Sneak in", "Explore", "lookTree", "sneakTree",
				"exploreTree");
		bgPanel[7].add(bgLabel[7]);

		// Scene 9
		createBackground(8, "bg9.jpg", 0, 0);
		createObject(8, 50, 100, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid1", " ", " ");
		createObject(8, 40, 410, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid2", " ", " ");
		createObject(8, 300, 200, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid3", " ", " ");
		createObject(8, 500, 250, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid4", " ", " ");
		createObject(8, 700, 300, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid5", " ", " ");
		createObject(8, 900, 350, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid6", " ", " ");
		createObject(8, 250, 400, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid7", " ", " ");
		createObject(8, 400, 400, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid8", " ", " ");
		createObject(8, 600, 400, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid9", " ", " ");
		createObject(8, 150, 250, 120, 134, "asteroid.png", "Move", " ", " ", "jumpAsteroid10", " ", " ");

		bgPanel[8].add(bgLabel[8]);

		// Scene 10
		createBackground(9, "bg10.jpg", 0, 0);
		createObject(9, 0, 0, 1080, 720, "blank.png", "Look", "Explore", " ", "lookHorseQuest", "exploreHorseQuest",
				" ");
		bgPanel[9].add(bgLabel[9]);

		// Scene 11
		createBackground(10, "bg11.png", 0, 0);
		createObject(10, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Take a swim", "lookWater", "exploreWater",
				"swimWater");
		bgPanel[10].add(bgLabel[10]);

		// Scene 12 --final Fight
		createBackground(11, "bg12.jpg", 0, 0);
		createObject(11, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Sneak in", "lookCivil", "exploreCivil",
				"sneakCivil");
		bgPanel[11].add(bgLabel[11]);

		// Scene 13
		createBackground(12, "bg13.jpg", 0, 0);
		createObject(12, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Pick up metals", "lookMetal", "exploreMetal",
				"pickMetal");
		bgPanel[12].add(bgLabel[12]);

		// Scene 14 --Black hole
		createBackground(13, "bg14.png", 0, 0);
		bgPanel[13].add(bgLabel[13]);

		// Scene 15
		createBackground(14, "bg15.jpg", 0, 0);
		createObject(14, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Pick up bottle", "lookBottle",
				"exploreBottle", "pickBottle");
		bgPanel[14].add(bgLabel[14]);

		// Scene 16
		createBackground(15, "bg16.jpg", 0, 0);
		createObject(15, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Pick up fluid", "lookFluid", "exploreFluid",
				"pickFluid");
		bgPanel[15].add(bgLabel[15]);

		// Scene 17
		createBackground(16, "bg17.jpg", 0, 0);
		createObject(16, 0, 0, 1080, 720, "blank.png", "Look", "Explore", "Craft lighter", "lookCraft", "exploreCraft",
				"craftLighter");
		bgPanel[16].add(bgLabel[16]);

		// Scene 18
		createBackground(17, "bg18.jpg", 0, 0);
		auxmenu[5] = createObject(17, 500, 0, 299, 720, "veve.png", "Look", "Talk", "Pet", "lookVeve", "talkVeve",
				"petVeve");
		bgPanel[17].add(bgLabel[17]);

		// Scene 19
		createBackground(18, "bg19.jpg", 0, 0);
		createObject(18, 0, 0, 1100, 720, "blank.png", "Look", "Scream", "Approach ledge", "lookV1iew", "screamView",
				"approachView");
		bgPanel[18].add(bgLabel[18]);

		// Horse Castle Scene
		createBackground(19, "castleHorse.jpg", 0, 0);
		createButton(19, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		createObject(19, 0, 0, 1280, 720, "blank.png", "Look", "Explore", " ", "lookCastle", "enterCastle", " ");
		bgPanel[19].add(bgLabel[19]);

		// Horse Guard Scene
		createBackground(20, "guard.jpg", 0, 0);
		createButton(20, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		auxmenu[3] = createObject(20, 0, 0, 1280, 720, "blank.png", "Look", "Talk", "Attack", "lookGuard", "talkGuard",
				"attackGuard");
		bgPanel[20].add(bgLabel[20]);

		// Horse Throne
		createBackground(21, "castleRoom.jpg", 0, 0);
		auxmenu[4] = createObject(21, 50, 200, 832, 434, "kingHorse.png", "Look", "Talk", "Send message",
				"lookKingHorse", "talkKingHorse", "sendMessage");
		createButton(21, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		bgPanel[21].add(bgLabel[21]);

		// Planet View Scene
		createBackground(22, "planetview.jpg", 0, 0);
		createButton(22, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		bgPanel[22].add(bgLabel[22]);

		// Tree Scene
		createBackground(23, "tree.jpg", 0, 0);
		createButton(23, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		createObject(23, 0, 0, 1080, 720, "blank.png", "Look", "Pick up acorn", "Climb", "lookTreeClose", "pickAcorn",
				"climbTree");
		bgPanel[23].add(bgLabel[23]);

		// Tree Lab Scene
		createBackground(24, "lab.jpg", 0, 0);
		createButton(24, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		createObject(24, 0, 0, 1080, 720, "blank.png", "Look", "Investigate", "Start fire", "lookLab", "investigateLab",
				"fireLab");
		bgPanel[24].add(bgLabel[24]);

		// Civil Scene
		createBackground(25, "civil.jpg", 0, 0);
		createButton(25, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		createObject(25, 500, 150, 200, 300, "blank.png", "Look", "Investigate", "Sneak in", "lookChurch",
				"investigateChurch", "sneakChurch");
		bgPanel[25].add(bgLabel[25]);

		// Church wall Scene
		createBackground(26, "wall.jpg", 0, 0);
		createButton(26, 1150, 20, 100, 70, "bttn.png", "leaveMap");
		createObject(26, 100, 50, 250, 637, "door.png", "Enter", " ", " ", "enterDoor1", " ", " ");
		createObject(26, 500, 50, 250, 637, "door.png", "Enter", " ", " ", "enterDoor2", " ", " ");
		createObject(26, 900, 50, 250, 637, "door.png", "Enter", " ", " ", "enterDoor3", " ", " ");
		bgPanel[26].add(bgLabel[26]);

		// Door1 Scene
		createBackground(27, "wall.jpg", 0, 0);
		createObject(27, 0, 0, 1080, 720, "blank.png", "Look", "Return", " ", "lookFish", "returnChurch", " ");
		createObject(27, 450, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 550, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 650, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 500, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 600, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 550, 220, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		
		createObject(27, 1000, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 1100, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 1200, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 1050, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 1050, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		
		createObject(27, 0, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 100, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 0, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(27, 50, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		bgPanel[27].add(bgLabel[27]);
		
		//Door2 Scene
		createBackground(28, "wall.jpg", 0, 0);
		createObject(28, 0, 0, 1280, 720, "jail.png", "Look", "Return", "Talk", "lookCats", "returnChurch", "talkCats");
		createObject(28, 350, 200, 600, 387, "cats.png", "Look", "Return", "Talk", "lookCats", "returnChurch", "talkCats");
		createObject(28, 1000, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 1100, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 1200, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 1050, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 1050, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		
		createObject(28, 0, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 100, 450, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 0, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		createObject(28, 50, 320, 289, 172, "fish.png", "Look", " ", " ", "lookFish", " ", " ");
		
		//Door3 Scene
		createBackground(29, "mainRoom.jpg", 0, 0);
		auxmenu[7] = createObject(29, 350, 150, 298, 500, "wolf.png", "Look", "Talk", "Hit", "lookWolf", "talkWolf", "hitWolf");
		bgPanel[29].add(bgLabel[29]);
		
		// Game Over Scene
		createBackground(30, "gameover.png", 20, 50);
		createButton(30, 460, 250, 300, 94, "replay.png", "replayGame");
		bgPanel[30].add(bgLabel[30]);
		
		//Winning Scene
		createBackground(31, "winbg.png", 0, 0);
		createButton(31, 560, 250, 300, 94, "replay.png", "replayGame");
		bgPanel[31].add(bgLabel[31]);

	}
}
