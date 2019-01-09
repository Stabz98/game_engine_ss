package game_engine2D;
import processing.core.PVector;
public class BoundingBox {
	public BoundingBox() {
		
	}
	
	public float mid_x;
	public float mid_y;
	public float left;
	public float right;
	public float top;
	public float base;
	
	public void fromSize(PVector size) {
		this.left = -size.x/2f;
		this.right = size.x/2f;
		this.top = -size.y/2f;
		this.base = size.y/2f;
		this.mid_x = 0;
		this.mid_y = 0;
	}
	public BoundingBox(int _l, int _r, int _t, int _b) {
		this.left = _l;
		this.right =_r;
		this.top =_t;
		this.base = _b;
		this.mid_x = 0;
		this.mid_y = 0;
	}
	

}
