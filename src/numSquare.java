import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class numSquare extends GameObject {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	public numSquare (int X, int Y, int W, int H) {
		super(X, Y, W, H);
		speed = 20;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
	}
	
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void right() {
        if (x < (Quadro6561.WIDTH - width))
        	x+=speed;
    }
	
	public void left() {
		if (x > 0)
			x-=speed;
    }
	
	public void up() {
		if (y > 0)
			y-=speed;
    }
	
	public void down() {
		if (y < (Quadro6561.HEIGHT - height - 23))
			y+=speed;
    }
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
}
