package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Sprite extends GameObject {
	GoldHit goldhit;
	public PVector size = new PVector(12, 12);

	public Sprite(PApplet p) {
		super(p);
	}

	public Sprite(PApplet p, float x, float y) {
		super(p);
		this.transform.position.x = x;
		this.transform.position.y = y;
	}

	public void update() {
		for (int i = this.components.size() - 1; i >= 0; i--) {
			GameComponent comp = this.components.get(i);
			comp.update();
			comp.render();
			// This puts a score counter on the main game screen
			parent.fill(230, 46, 36);
			parent.stroke(255);
			parent.rect(70, 40, 80, 30);
			parent.fill(255);
			parent.noStroke();
			parent.text("Score: " + 0, 50, 42);
		}
	}

	public abstract void render();

	public void start() {
		for (int i = this.components.size() - 1; i >= 0; i--) {
			GameComponent comp = this.components.get(i);
			comp.start();
		}

	}

}
