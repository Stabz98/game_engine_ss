package game_engine2D;

public class GoldBoxCollider2D extends ProcessingEntity {

	public Transform transform = new Transform();

	public GoldBoxCollider2D(GameObject g) {
		super(g.parent);
		this.transform = g.transform;
	}

	// This is the box collider for my gold blocks.
	public HitInfo checkCollision(HitInfo hitInfo) {
		GoldBoundingBox new_gbb;
		new_gbb = this.transform.NewWorldGoldBoundingBox();
		GoldBoundingBox prev_gbb;
		prev_gbb = this.transform.PreviousWorldGoldBoundingBox();
		GoldBoundingBox tile_gbb = hitInfo.goldBoundingBox;
		if (this.transform.position.y > tile_gbb.top && this.transform.position.y < tile_gbb.base) {

			if (new_gbb.left < tile_gbb.right && new_gbb.right > tile_gbb.right) {
				hitInfo.hitSide = SIDES.RIGHT;
				hitInfo.beenHit = true;
			} // here i am defining the sides
			if (new_gbb.left < tile_gbb.left && new_gbb.right > tile_gbb.left) {
				hitInfo.hitSide = SIDES.LEFT;
				hitInfo.beenHit = true;
			}
		}
		if (new_gbb.right > tile_gbb.left && new_gbb.left < tile_gbb.right) {
			if (new_gbb.base > tile_gbb.top && prev_gbb.top < tile_gbb.top) {
				hitInfo.hitSide = SIDES.BASE;
				hitInfo.beenHit = true;
			}
			if (new_gbb.top < tile_gbb.base && prev_gbb.base > tile_gbb.base) {
				hitInfo.hitSide = SIDES.TOP;
				hitInfo.beenHit = true;
			}
		} else {

		}
		return hitInfo;
	}

}