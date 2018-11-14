package game_engine2D;
import java.util.ArrayList;

import processing.core.*;

public class GameManager extends ProcessingEntity {
	
	public int background = 0;
	private ArrayList<GameObject> gameObjects;
	private ArrayList<GameObject> playerGameObjects;
	public static ArrayList<BoundingBox> gameBoundingBoxes;
	
	
	public GameManager(PApplet p) {
		super(p);
		this.name = "GameManager";
		gameObjects = new ArrayList<GameObject>();
		playerGameObjects = new ArrayList<GameObject>();
		gameBoundingBoxes = new ArrayList<BoundingBox>();
	}
	public void addGameBoundingBoxes(GameObject b) {
		gameBoundingBoxes.add(b.transform.NewWorldBoundingBox());
	}
	public void addPlayerGameObjects(GameObject b) {
		playerGameObjects.add(b);
	}	
	
	public void addObject(GameObject g) {
		gameObjects.add(g);
	}
	public void removeObject(GameObject g) {
		gameObjects.remove(gameObjects.lastIndexOf(g));
	}
	public void StartAll() {
		
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.start();
		}
	}
	
	public void UpdateAll() {
		
		parent.background(background);
		for(int i = 0; i < gameObjects.size(); i++) {
			
			GameObject g = gameObjects.get(i);
			g.update();
			g.render();
		}
	}
	public void keyPressed(char key, int keyCode) {
		for(int i = 0; i < playerGameObjects.size(); i++) {
			
			GameObject g = playerGameObjects.get(i);
			g.keyPressed(key, keyCode);
		}
	}
	
	public void keyReleased(char key, int keyCode) {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			GameObject g = playerGameObjects.get(i);
			g.keyReleased(key, keyCode);
		}
	}

}
