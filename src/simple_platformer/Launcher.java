package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;

public class Launcher extends BaseLauncher {
	GoldHit goldhit;
	public boolean isGold = true;

	public Launcher(PApplet p) {
		super(p);
	}

	public void StartGame() {
		splash_screen();
	}

	public void splash_screen() {
		super.LaunchGame();
		SplashScreen splash = new SplashScreen(parent, this);
		this.gameManager.addObject(splash);
		this.gameManager.addPlayerGameObjects(splash);
	}

	public void info_screen() {
		super.LaunchGame();
		InfoScreen info = new InfoScreen(parent, this);
		this.gameManager.addObject(info);
		this.gameManager.addPlayerGameObjects(info);
	}

	public void load_game() {
		super.LaunchGame();
		Player player = new Player(parent, parent.width / 2, parent.height / 2, 60, 60);
		player.start();

		this.gameManager.addObject(player);
		this.gameManager.addPlayerGameObjects(player);
		int platforms = 20;
		Tile platform;
		Gold gold;
		int golds = 1;
		// Bottom row of platforms
		// for(int i = 0; i < platforms; i++) {
		// platform = new Tile(parent, 50 + i *55, parent.height-50,50,20);
		// platform.start();
		// this.gameManager.addObject(platform);
		// this.gameManager.addGameBoundingBoxes(platform);;
		//
		// }

		// single gold block on bottom row
		// for(int o = 0; o < golds; o++) {
		// gold = new Gold(parent, 50 + o *55, parent.height-50,50,20);
		// gold.start();
		// this.gameManager.addObject(gold);
		// this.gameManager.addGameBoundingBoxes(gold);;
		// }
		// random gold block placement
		for (int o = 0; o < golds; o++) {
			gold = new Gold(parent, parent.random(parent.width), parent.random(parent.height), 50, 20);
			gold.start();
			this.gameManager.addObject(gold);
			;
			this.gameManager.addGameGoldBoundingBoxes(gold);
			;
		}

		// Random block placement
		for (int i = 0; i < platforms; i++) {
			platform = new Tile(parent, parent.random(parent.width), parent.random(parent.height), 30, 30);
			platform.start();
			this.gameManager.addObject(platform);
			;
			this.gameManager.addGameBoundingBoxes(platform);
			;
		}
		// block staircase
		// for (int i = 0; i < platforms; i++) {
		// platform = new Tile(parent, 26+ i * 50, 40 + 15 * i, 50, 20);
		// platform.start();
		// this.gameManager.addObject(platform);
		// this.gameManager.addGameBoundingBoxes(platform);
		// }

		// static square block
		// platform = new Tile(parent, parent.width/2, parent.height - 100,50,50);
		// platform.start();
		// this.gameManager.addObject(platform);
		// this.gameManager.addGameBoundingBoxes(platform);

		// static standard block
		// platform = new Tile(parent, (parent.width*0.75f),
		// (parent.height*0.65f),60,20);
		// platform.start();
		// this.gameManager.addObject(platform);
		// this.gameManager.addGameBoundingBoxes(platform);

		// static square block
		// platform = new Tile(parent, (float) (parent.width*0.65),
		// (parent.height*0.45f),50,50);
		// platform.start();
		// this.gameManager.addObject(platform);
		// this.gameManager.addGameBoundingBoxes(platform);

		// base border
		platform = new Tile(parent, parent.width / 2, parent.height - 10, parent.width, 20);
		platform.start();
		platform.secondaryColour = parent.color(0, 233, 255);
		platform.primaryColour = parent.color(0, 233, 255);
		this.gameManager.addObject(platform);
		this.gameManager.addGameBoundingBoxes(platform);

		// top border
		platform = new Tile(parent, parent.width / 2, 0, parent.width, 20);
		platform.start();
		platform.secondaryColour = parent.color(0, 233, 255);
		platform.primaryColour = parent.color(0, 233, 255);
		this.gameManager.addObject(platform);
		this.gameManager.addGameBoundingBoxes(platform);

		// left border
		platform = new Tile(parent, 0, parent.height / 2, 20, parent.height);
		platform.start();
		platform.secondaryColour = parent.color(0, 233, 255);
		platform.primaryColour = parent.color(0, 233, 255);
		this.gameManager.addObject(platform);
		this.gameManager.addGameBoundingBoxes(platform);

		// right border
		platform = new Tile(parent, parent.width, parent.height / 2, 20, parent.height);
		platform.start();
		platform.secondaryColour = parent.color(0, 233, 255);
		platform.primaryColour = parent.color(0, 233, 255);
		this.gameManager.addObject(platform);
		this.gameManager.addGameBoundingBoxes(platform);

	}

	public void UpdateAll() {
		super.UpdateAll();
	}

}
