package game_engine2D;
import processing.core.PApplet;

public class BaseLauncher {
	public PApplet parent;
	
	public BaseLauncher(PApplet p) {
		parent = p;
	}
	
	public GameManager gameManager;
	public void UpdateAll() {
		gameManager.UpdateAll();
	}
	public void LaunchGame() {
		gameManager = new GameManager(parent);
	}
	public void keyReleased(char key, int keyCode) {
		gameManager.keyReleased(key, keyCode);
	}
	public void keyPressed(char key, int keyCode) {
		gameManager.keyPressed(key, keyCode);
	}
	

}
