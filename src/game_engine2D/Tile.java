package game_engine2D;

import processing.core.PApplet;

public class Tile extends Sprite {
	
	public int secondaryColour;
	public int primaryColour;
	
	public Tile(PApplet p, float x, float y, float w, float h) {
		super(p, x, y);
		this.size.x = w;
		this.size.y = h;
		this.secondaryColour = parent.color(255,255,255);
		this.primaryColour = parent.color(0, 0, 0);
	}
	
	

	public void start() {
		super.start();
		
		this.transform.boundingBox.fromSize(size);
	}
	
	public void update() {
		super.update();
	}
	
	public void render() {
		
		parent.pushMatrix();
		parent.translate(this.transform.position.x,  this.transform.position.y);
		parent.stroke(this.secondaryColour);
		parent.fill(this.primaryColour);
		parent.rectMode(PApplet.CENTER);
		parent.rect(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
		
	}

}
