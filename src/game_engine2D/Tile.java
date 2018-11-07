package game_engine2D;

import processing.core.PApplet;

public class Tile extends Sprite {
	
	int strokeColour;
	int fillColour;
	
	public Tile(PApplet p, int x, int y, int w, int h) {
		super(p, x, y);
		this.size.x = w;
		this.size.y = h;
		this.strokeColour = parent.color(255,255,255);
		this.fillColour = parent.color(0, 0, 0);
	}
	
	public void start() {
		super.start();
		
		this.transform.boundingBox.fromSize(size);
	}
	
	public void update() {}
	
	public void render() {
		super.render();
		parent.pushMatrix();
		parent.translate(this.transform.position.x,  this.transform.position.y);
		parent.stroke(this.strokeColour);
		parent.fill(this.fillColour);
		parent.rect(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
		
	}

}
