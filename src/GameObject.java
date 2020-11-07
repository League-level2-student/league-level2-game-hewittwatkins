import java.awt.Rectangle;

public class GameObject {
	
	int x;
	int y;
	int width;
	int height;
	int speed;
	boolean isActive;
	Rectangle collisionBox;
	
	public GameObject(int X, int Y, int W, int H) {
		this.x = X;
		this.y = Y;
		this.width = W;
		this.height = H;
		speed = 0;
		isActive = true;
		collisionBox = new Rectangle(this.x, this.y, this.width, this.height);
	}
	
	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
