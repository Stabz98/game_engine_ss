package game_engine2D;

public class BoxCollider2D extends ProcessingEntity {
	
	public Transform transform = new Transform();
	public BoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}
	 public HitInfo checkCollision(HitInfo hitInfo) {
		 BoundingBox new_bb;
		 new_bb = this.transform.NewWorldBoundingBox();
		 BoundingBox prev_bb;
		 prev_bb = this.transform.PreviousWorldBoundingBox();
		 BoundingBox tile_bb = hitInfo.boundingBox;
		 if (this.transform.position.y > tile_bb.top && this.transform.position.y < tile_bb.base) {
			 
			 if(new_bb.left < tile_bb.right && new_bb.right > tile_bb.right) {
				 hitInfo.hitSide = SIDES.RIGHT;
				 hitInfo.beenHit = true;
			 }
			 if (new_bb.left < tile_bb.left && new_bb.right > tile_bb.left ) {
				 hitInfo.hitSide = SIDES.LEFT;
				 hitInfo.beenHit = true;
			 }
		 }
		 if (new_bb.right > tile_bb.left && new_bb.left < tile_bb.right) {
			 if (new_bb.base > tile_bb.top && prev_bb.top < tile_bb.top) {
				 hitInfo.hitSide = SIDES.BASE;
				 hitInfo.beenHit = true;
			 }
			 if (new_bb.top < tile_bb.base && prev_bb.base > tile_bb.base) {
				 hitInfo.hitSide = SIDES.TOP;
				 hitInfo.beenHit = true;
			 }
		 }else {
			 
		 }
		 return hitInfo;
	 }

}
