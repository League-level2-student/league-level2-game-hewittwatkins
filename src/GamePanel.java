import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Timer frameDraw;
    NumSquare[][] board = new NumSquare[4][4];
    int gamesLost = 0;
    public static BufferedImage image1;
    public static BufferedImage image2;	

    public GamePanel() {
        titleFont = new Font("Arial", Font.PLAIN, 30);
        intializeBoard();
        frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        image1 =loadImage ("2048HSv3.jpg");
        image2 =loadImage ("endState.jpg");
  
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
		if (image1 != null) {
			g.drawImage(image1, 0, 0, 800, 800, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Better2048.WIDTH, Better2048.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.WHITE);
			g.drawString("2048 - With a Few Twists", 200, 200);
		}
		
	}
	
	BufferedImage loadImage(String imageFile) {
	    BufferedImage bufferedImage;
		
        try {
            bufferedImage = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
            return bufferedImage;
	   
        } catch (Exception e) {
            
        }
        return null;
    	
	}
	
	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Better2048.WIDTH, Better2048.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.RED);
		//g.drawString("GAME STATE", 200, 200);
		drawBoard(g);
	}
	
	public void drawEndState(Graphics g) {
		if (image2 != null) {
			g.drawImage(image2, 0, 0, 800, 800, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Better2048.WIDTH, Better2048.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.BLUE);
			g.drawString("END STATE", 200, 200);
		}
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
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean changedBoard = false;
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		    
		} else {
			if (e.getKeyCode()==KeyEvent.VK_UP) {
				changedBoard = moveUp();
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
				changedBoard = moveDown();
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				changedBoard = moveRight();
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				changedBoard = moveLeft();
			}
			if (changedBoard == false) {
				System.out.println("game over");
				gamesLost++;
				System.out.println(gamesLost);
			}
		}
		if (gamesLost == 1) {
			currentState++;
		} else {
			addRandom();
		}
		
		if (currentState == END) {
			intializeBoard();
			gamesLost = 0;
		}

	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void intializeBoard() {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				board[y][x] = new NumSquare(x, y, Better2048.WIDTH / 4, (Better2048.HEIGHT-24) / 4);
			}
		}
	}
	
	public void drawBoard(Graphics g) {
		// loops through 2d array to draw board
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (board[y][x].getValue() != 0) {
					board[y][x].draw(g);
				}
			}
		}
	}
	
	public boolean moveDown() {
		boolean changedBoard = false;
		for (int x = 0; x < (board.length); x++) {
			for (int y = 0; y < (board.length - 1); y++) {
				if (board[y][x].getValue() == board[y+1][x].getValue()) { // don't want to check for zeros
					board[y+1][x].combineSquare();
					if (board[y][x].getValue() != 0) {
						changedBoard = true;
					}
					board[y][x].clearSquare();
					
				} else if (board[y+1][x].getValue() == 0) {
					board[y+1][x].setValue(board[y][x].getValue());
					if (board[y][x].getValue() != 0) {
						changedBoard = true;
					}
					board[y][x].clearSquare();
					
					
				}
			}
		}
		
		return changedBoard;
	}
	
	public boolean moveUp() {
		boolean changedBoard = false;
		for (int x = 0; x < (board.length); x++) {
			for (int y = board.length - 1; y > 0; y--) {
				if (board[y][x].getValue() == board[y-1][x].getValue() && board[y][x].getValue() != 0) {
					board[y-1][x].combineSquare(); 
					board[y][x].clearSquare();
					changedBoard = true;
					
				} else if (board[y-1][x].getValue() == 0 && board[y][x].getValue() != 0) {
					board[y-1][x].setValue(board[y][x].getValue());
					board[y][x].clearSquare();
					changedBoard = true;
				}
			}
		}
		
		return changedBoard;
	}

	public boolean moveRight() {
		boolean changedBoard = false;
		for (int y = 0; y < (board.length); y++) {
			for (int x = 0; x < (board.length - 1); x++) {
				if (board[y][x].getValue() == board[y][x+1].getValue() && board[y][x].getValue() != 0) {
					board[y][x+1].combineSquare(); 
					board[y][x].clearSquare();
					changedBoard = true;
					
				} else if (board[y][x+1].getValue() == 0 && board[y][x].getValue() != 0) {
					board[y][x+1].setValue(board[y][x].getValue());
					board[y][x].clearSquare();
					changedBoard = true;
					
				}
			}
		}
		
		return changedBoard;
	}
	
	public boolean moveLeft() {
		boolean changedBoard = false;
		for (int y = 0; y < (board.length); y++) {
			for (int x = board.length -1; x > 0; x--) {
				if (board[y][x].getValue() == board[y][x-1].getValue() && board[y][x].getValue() != 0) {
					board[y][x-1].combineSquare(); 
					board[y][x].clearSquare();
					changedBoard = true;
					
				} else if (board[y][x-1].getValue() == 0 && board[y][x].getValue() != 0) {
					board[y][x-1].setValue(board[y][x].getValue());
					board[y][x].clearSquare();
					changedBoard = true;
					
				}
			}
		}
		
		return changedBoard;
	}
	
	public void addRandom() {
		ArrayList<NumSquare> blanks = new ArrayList<NumSquare>();
		for (int y = 0; y < (board.length); y++) {
			for (int x = 0; x < (board.length - 1); x++) {
				if (board[y][x].getValue() == 0) {
					blanks.add(board[y][x]);
				}
			}
		}
		if (blanks.size() > 0) {
			Random genRandom = new Random();
			int num = genRandom.nextInt(blanks.size());
			blanks.get(num).randomValue();
		}
	}
	
	/*public boolean checkBoard(KeyEvent e) {
		boolean gamePlay = false;
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    boolean newBoard = moveLeft();//moveUp();
		    if (newBoard == true) {
		    	gamePlay = true;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    boolean newBoard = moveLeft();//moveDown();
		    if (newBoard == true) {
		    	gamePlay = true;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    boolean newBoard = moveLeft();
		    if (newBoard == true) {
		    	gamePlay = true;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    boolean newBoard = moveRight();
		    if (newBoard == true) {
		    	gamePlay = true;
		    }
		}
		return gamePlay;
	} */
	
} 
