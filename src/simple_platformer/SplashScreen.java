package simple_platformer;

import processing.core.PApplet;
import game_engine2D.Sprite;

public class SplashScreen extends Sprite {
	Launcher launcher;

	public SplashScreen(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	public SplashScreen(PApplet p, float x, float y) {
		super(p, x, y);
		// TODO Auto-generated constructor stub
	}

	public SplashScreen(PApplet p, Launcher l) {
		super(p);
		launcher = l;
	}

	@Override
	public void render() {
		color(0, 255, 12);
		int w = 160;
		int h = 30;

		parent.fill(230, 46, 36);
		parent.stroke(255);
		parent.rect(200, 10 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.fill(248, 144, 31);
		parent.stroke(255);
		parent.rect(200, 7 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.fill(58, 153, 69);
		parent.stroke(255);
		parent.rect(200, 4 * h, w, h);
		parent.fill(255);
		parent.noStroke();

		parent.text("Esc: Quit!", 250, 320);
		parent.text("I: Info!", 250, 230);
		parent.text("Space: Begin!", 250, 140);

	}

	private void color(int i, int j, int k) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(char key, int keyCode) {
		if (key == ' ') {

			this.launcher.load_game();
		}
		if (key == 'i') {

			this.launcher.info_screen();
		}
		if (keyCode == PApplet.LEFT) {

		}
		if (keyCode == PApplet.RIGHT) {

		}
	}

	public void keyReleased(char key, int keyCode) {

	}

}
