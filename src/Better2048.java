import java.awt.Dimension;

import javax.swing.JFrame;

public class Better2048 {
	
	JFrame jf1;
	static final int WIDTH = 800;
	static final int HEIGHT = 800;
	GamePanel gamePanel;

	public static void main(String[] args) {
		Better2048 quadro = new Better2048();
		quadro.setup();
	}
	
	public Better2048() {
		jf1 = new JFrame();
		gamePanel = new GamePanel();
	}
	
	public void setup() {
		jf1.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		jf1.setVisible(true);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.add(gamePanel);
		jf1.pack();
		jf1.addKeyListener(gamePanel);
	}
	
}
