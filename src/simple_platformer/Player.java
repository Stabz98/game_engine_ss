package simple_platformer;

import game_engine2D.*;
import processing.core.PApplet;
import processing.core.PVector;

public class Player extends Sprite {
	float speedForce = 3f;
	float jumpForce = 2f;
	private PVector size = new PVector(12,12);
	private Physics2D physics;
	public int stroke = parent.color(320,120,225);
	public int fill = parent.color(20,55, 230);
	
	public Player(PApplet p) {
		super(p);
	}
	public Player(PApplet p, float x, float y, float w, float h) {
		super(p);
		
	}
	public void start() {
		this.transform.position.x = parent.width / 2;
		this.transform.position.y = parent.height / 2;
		this.transform.boundingBox.fromSize(size);
		this.physics = new Physics2D(this);
		this.physics.start();
		this.physics.speed = speedForce;
	}
	
	public void update() {
		super.update();
	}
	public void render() {
		
		parent.fill(this.fill);
		parent.stroke(this.stroke);
		parent.rect(this.transform.position.x,  this.transform.position.y,  this.size.x,  this.size.y);;
	}
	public void keyPressed(char key, int keyCode) {
		if (keyCode == PApplet.UP) {
			this.physics.jump(4);
		}
		if (keyCode == PApplet.LEFT) {
			this.physics.move(-speedForce);
		}
		if (keyCode == PApplet.RIGHT) {
			this.physics.move(speedForce);
		}
	}
	public void keyReleased(char key, int keyCode) {
		this.physics.keyUp();
	}

}
