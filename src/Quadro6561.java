import javax.swing.JFrame;

public class Quadro6561 {
	
	JFrame jf1;
	static final int WIDTH = 500;
	static final int HEIGHT = 500;
	GamePanel gamePanel;

	public static void main(String[] args) {
		Quadro6561 quadro = new Quadro6561();
		quadro.setup();
	}
	
	public Quadro6561() {
		jf1 = new JFrame();
		gamePanel = new GamePanel();
	}
	
	public void setup() {
		jf1.setSize(WIDTH, HEIGHT);
		jf1.setVisible(true);
		jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf1.add(gamePanel);
	}
	
}
