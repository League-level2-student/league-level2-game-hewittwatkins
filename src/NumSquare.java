import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;

public class NumSquare extends GameObject {
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	public int value = 0;
	public HashMap <Integer, Color> colors = new HashMap<Integer, Color>();
	
	public NumSquare (int X, int Y, int W, int H) {
		super(X, Y, W, H);
		speed = 20;
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
		randomValue();
		colors.put(2, new Color(0, 255, 155));
		colors.put(4, new Color(0, 255, 255));
		colors.put(8, new Color(0, 155, 255));
		colors.put(16, new Color(0, 55, 25));
		colors.put(32, new Color(0, 0, 255));
		colors.put(64, new Color(0, 0, 155));
		colors.put(128, new Color(0, 0, 55));
	}
	
	public void draw(Graphics g) {
		if (value >= 128) {
			g.setColor(colors.get(128));
		} else {
			g.setColor(colors.get(value));
		}
		g.fillRect(x*width, y*height, width, height);
		g.setColor(Color.ORANGE);
		g.drawRect(x*width, y*height, width, height);
		g.setColor(Color.WHITE);
		g.drawString(value+"", (x*width) + (width/2), (y*height) + (height/2));
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
	
	// code for og 
	
	public void right() {
        if (x < (Better2048.WIDTH - width))
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
		if (y < (Better2048.HEIGHT - height - 23))
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
