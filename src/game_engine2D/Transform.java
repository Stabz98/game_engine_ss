package game_engine2D;

import processing.core.PVector;

public class Transform {

	public Transform() {

	}

	public PVector prev_position = new PVector(0, 0);
	public PVector position = new PVector(0, 0);
	public PVector rotation = new PVector(0, 0);
	public PVector scale = new PVector(0, 0);
	public BoundingBox boundingBox = new BoundingBox(-1, 1, -1, 1);

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

	public GoldBoundingBox goldBoundingBox = new GoldBoundingBox(-1, 1, -1, 1);

	public GoldBoundingBox PreviousWorldGoldBoundingBox() {
		GoldBoundingBox gbb = new GoldBoundingBox();
		gbb.mid_x = prev_position.x;
		gbb.mid_y = prev_position.y;
		gbb.left = prev_position.x + goldBoundingBox.left;
		gbb.right = prev_position.x + goldBoundingBox.right;
		gbb.top = prev_position.y + goldBoundingBox.top;
		gbb.base = prev_position.y + goldBoundingBox.base;
		return gbb;

	}

	public GoldBoundingBox NewWorldGoldBoundingBox() {
		GoldBoundingBox gbb = new GoldBoundingBox();
		gbb.mid_x = position.x;
		gbb.mid_y = position.y;
		gbb.left = position.x + goldBoundingBox.left;
		gbb.right = position.x + goldBoundingBox.right;
		gbb.top = position.y + goldBoundingBox.top;
		gbb.base = position.y + goldBoundingBox.base;
		return gbb;
	}

}
