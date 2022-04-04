package Main;

public class SceneChanger {
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		this.gm = gm;
	}
	
	public void showScene(int sceneNum) {
		for (int i = 0; i < 32; i++)
		{
			gm.ui.bgPanel[i].setVisible(false);
			gm.ui.bgLabel[i].setVisible(false);
		}
		gm.ui.bgPanel[sceneNum - 1].setVisible(true);
		gm.ui.bgLabel[sceneNum - 1].setVisible(true);
	}
}