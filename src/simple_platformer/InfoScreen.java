package simple_platformer;

import game_engine2D.Sprite;
import processing.core.PApplet;

public class InfoScreen extends Sprite {
	Launcher launcher;

	public InfoScreen(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public InfoScreen(PApplet p, float x, float y) {
		super(p, x, y);
		// TODO Auto-generated constructor stub
	}

	public InfoScreen(PApplet p, Launcher l) {
		super(p);
		launcher = l;
	}

	@Override
	public void render() {

		int w = 160;
		int h = 30;

		parent.fill(230, 46, 36);
		parent.stroke(255);
		parent.rect(100, 10 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.fill(248, 144, 31);
		parent.stroke(255);
		parent.rect(100, 7 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.fill(58, 153, 69);
		parent.stroke(255);
		parent.rect(100, 4 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.text("Esc: Quit!", 150, 320);
		parent.text("M: Main Menu!", 150, 230);
		parent.text("Space: Begin!", 150, 140);

		parent.text("Arrow keys to move!", 385, 140);
		parent.text("You can TRIPLE jump!", 380, 185);
		parent.text("Each time you collect a gold brick", 360, 230);
		parent.text("the board will reset!", 385, 265);
		parent.text("How many gold bricks can you collect?", 350, 320);

	}

	private void background(int i) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(char key, int keyCode) {
		if (key == ' ') {

			this.launcher.load_game();
		}
		if (key == 'm') {

			this.launcher.StartGame();
		}

	}

	public void keyReleased(char key, int keyCode) {

	}

}
