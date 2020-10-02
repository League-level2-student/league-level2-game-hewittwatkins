import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}

	}
	
	public void updateMenuState() {
		
	}

	public void updateGameState() {
		
	}
	
	public void updateEndState() {
		
	}
	
	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Quadro6561.WIDTH, Quadro6561.HEIGHT);
		
		
	}
	
	public void drawGameState(Graphics g) {
		
	}
	
	public void drawEndState(Graphics g) {
		
	}
}
