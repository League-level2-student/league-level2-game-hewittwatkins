import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Timer frameDraw;
    NumSquare[][] board = new NumSquare[4][4];

    public GamePanel() {
        titleFont = new Font("Arial", Font.PLAIN, 48);
        intializeBoard();
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
    }
		
    		
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
		g.setColor(Color.RED);
		g.fillRect(0, 0, Quadro6561.WIDTH, Quadro6561.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.GREEN);
		g.drawString("start", 200, 200);
		
		
	}
	
	public void drawGameState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Quadro6561.WIDTH, Quadro6561.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("GAME STATE", 200, 200);
		drawBoard(g);
	}
	
	public void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Quadro6561.WIDTH, Quadro6561.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("END STATE", 200, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		    
		} 
		/*
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    sq1.up();
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    sq1.down();
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    sq1.left();
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    sq1.right();
		}
	*/	
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void intializeBoard() {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = new NumSquare(x, y, 100, 100);
			}
		}
	}
	
	public void drawBoard(Graphics g) {
		// loops through 2d array to draw board
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x].draw(g);
			}
		}
	}
}
