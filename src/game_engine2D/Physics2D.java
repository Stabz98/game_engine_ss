package game_engine2D;

import processing.core.PApplet;
import processing.core.PVector;
import simple_platformer.Launcher;

public class Physics2D extends GameComponent {
	Launcher launcher;
	int frameWait = 0;
	int frameDelay = 2;
	private PVector velocity = new PVector(0, 0);
	public BoxCollider2D boxCollider2D;
	float gravity = 0.1f;
	float friction = 0.9f;
	float frictionOveride = 1.0f;
	float frictionNormal = 0.9f;
	boolean isGrounded = false;
	public float speed = 3f;
	public float maxSpeed = 5f;

	public Physics2D(GameObject g) {
		super(g);
	}

	public void start() {
		this.boxCollider2D = new BoxCollider2D(this.gameObject);
	}

	public void update() {

		frameWait++;

		if (frameWait > frameDelay) {
			frameWait = 0;
			checkCollisions();
		}

		this.transform.prev_position.x = this.transform.position.x;
		this.transform.prev_position.y = this.transform.position.y;
		gravityEffect();
		if (isGrounded) {
			this.velocity.x *= friction;
		}
		if (PApplet.abs(velocity.x) >= maxSpeed) {
			if (velocity.x > 0)
				velocity.x = maxSpeed;
			else
				velocity.x = -maxSpeed;
		}
		if (isGrounded && PApplet.abs(velocity.x) <= 0.1f) {
			velocity.x = 0f;
		}
		this.transform.position.add(velocity);
		;
	}

	public void render() {
	}

	// this is the collision check for my tiles
	public void checkCollisions() {
		if (PApplet.abs(this.transform.prev_position.x - this.transform.position.x) < 0.1f) {
			if (PApplet.abs(this.transform.prev_position.y - this.transform.position.y) < 0.1f) {
				return;
			}
		}
		for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++) {

			HitInfo hitInfo = new HitInfo();
			hitInfo.boundingBox = GameManager.gameBoundingBoxes.get(i);
			hitInfo = this.boxCollider2D.checkCollision(hitInfo);
			if (hitInfo.beenHit) {
				switch (hitInfo.hitSide) {
				case TOP:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.base + this.transform.boundingBox.base;

					break;
				case BASE:
					this.velocity.y = 0f;
					this.transform.position.y = hitInfo.boundingBox.top + this.transform.boundingBox.top;
					if (!isGrounded) {
						isGrounded = true;
						velocity.x = 0f;
						jumpcount = 0;
					}

					break;
				case LEFT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.left + this.transform.boundingBox.left;
					break;
				case RIGHT:
					this.velocity.x *= -1f;
					this.transform.position.x = hitInfo.boundingBox.right + this.transform.boundingBox.right;
					break;
				case NONE:
					isGrounded = false;
					break;
				}
			}
		}
	}

	// This next section is an attempt at a double jump mechanic
	int jumpcount = 0;
	int maxjumps = 2;

	public void Jump() {
		if (jumpcount >= maxjumps) {
			return;
		}
	}

	public void jump1(int force) {
		if (isGrounded) {
			velocity.y = -force;
			isGrounded = false;
		}

		jumpcount = jumpcount + 1;
		if (isGrounded) {
			jumpcount = 0;
		}
	}

	public void jump(int force) {
		if (isGrounded || jumpcount <= maxjumps) {
			PApplet.println("jumpcount " + jumpcount);
			velocity.y = -force;
			isGrounded = false;
			jumpcount += 1;
		}
	}

	private void gravityEffect() {
		velocity.y += gravity;
		if (PApplet.abs(velocity.y) >= maxSpeed) {
			velocity.y = maxSpeed;
		}
	}

	public void move(float force) {
		if (isGrounded) {
			this.friction = this.frictionOveride;
			velocity.x += force;
		}
	}

	public void keyUp() {
		if (isGrounded || jumpcount <= maxjumps) {

			this.friction = this.frictionNormal;
		}

	}

}
