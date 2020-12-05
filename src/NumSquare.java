import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class NumSquare extends GameObject {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public int value = 0;

	public NumSquare (int X, int Y, int W, int H) {
		super(X, Y, W, H);
		speed = 20;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
		randomValue();
	}
	
	public void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x*width, y*height, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x*width, y*height, width, height);
			g.setColor(Color.ORANGE);
			g.drawRect(x*width, y*height, width, height);
			g.setColor(Color.WHITE);
			g.drawString(value+"", x*width, y*height+height);
		}
	}
	
	// new real code
	
	public void randomValue() {
		Random genRandom = new Random();
		int num = genRandom.nextInt(3);
		value = num+num;
	}
	
	public int getValue() {
		return value;
	}
	
	public void combineSquare( ) {
		value = value*2;
	}
	
	public void clearSquare() {
		value = 0;
	}
	
	public void setValue(int num) {
		value = num;
	}
	
	
	// new suedo code sort of stuff
	
	public void drawBoard() {
		
	}
	
	public void checkBoard() {
		
	}
	
	
	public void addNewNum() {
		
	}
	
	public void updateBoard() {
		
	}
	
	// code for og 
	
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
