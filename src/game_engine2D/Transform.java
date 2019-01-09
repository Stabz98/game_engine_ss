package game_engine2D;

import processing.core.PVector;

public class Transform {
	
	public Transform() {
		
	}
	public PVector prev_position = new PVector(0,0);
	public PVector position = new PVector(0,0);
	public PVector rotation = new PVector(0,0);
	public PVector scale = new PVector(0,0);
	public BoundingBox boundingBox = new BoundingBox(-1,1,-1,1);
	public BoundingBox PreviousWorldBoundingBox() {
		BoundingBox bb = new BoundingBox();
		bb.mid_x = prev_position.x;
		bb.mid_y = prev_position.y;
		bb.left = prev_position.x + boundingBox.left;
		bb.right = prev_position.x + boundingBox.right;
		bb.top = prev_position.y + boundingBox.top;
		bb.base = prev_position.y + boundingBox.base;
		return bb;
		
	}
	public BoundingBox NewWorldBoundingBox() {
		BoundingBox bb = new BoundingBox();
		bb.mid_x = position.x;
		bb.mid_y = position.y;
		bb.left = position.x + boundingBox.left;
		bb.right = position.x + boundingBox.right;
		bb.top = position.y + boundingBox.top;
		bb.base = position.y + boundingBox.base;
		return bb;
	}
	

}
