package game_engine2D;

import processing.core.PApplet;
import simple_platformer.Launcher;

public class GoldHit extends GameComponent {
	Launcher launcher;
	public GoldBoxCollider2D goldBoxCollider2D;
	public boolean hasGold = false;
	public int Score = 0;

	public GoldHit(GameObject g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	// this class is to detect a collision with my gold blocks, reklay the
	// information and reset the board
	@Override
	public void start() {
		// TODO Auto-generated method stub
		this.goldBoxCollider2D = new GoldBoxCollider2D(this.gameObject);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (hasGold) {

			this.launcher.StartGame();

		}
	}

	public void goldCollision() {
		if (PApplet.abs(this.transform.prev_position.x - this.transform.position.x) < 0.1f) {
			if (PApplet.abs(this.transform.prev_position.y - this.transform.position.y) < 0.1f) {
				return;
			}
		}
		for (int i = 0; i < GameManager.gameGoldBoundingBoxes.size(); i++) {

			HitInfo hitInfo = new HitInfo();
			hitInfo.goldBoundingBox = GameManager.gameGoldBoundingBoxes.get(i);
			hitInfo = this.goldBoxCollider2D.checkCollision(hitInfo);
			PApplet.println(Score);
			if (hitInfo.beenHit) {
				PApplet.println(Score);
				PApplet.println(hasGold);
				switch (hitInfo.hitSide) {
				case TOP:
					hasGold = true;

					break;
				case BASE:
					hasGold = true;

					break;
				case LEFT:
					hasGold = true;
					break;
				case RIGHT:
					hasGold = true;
					break;
				case NONE:
					hasGold = false;
					break;
				}
				Score++;
				PApplet.println(Score);
				// this is where the game would reset
			}

		}
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub

	}

}
