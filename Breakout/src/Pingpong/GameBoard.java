package Pingpong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JComponent;

public class GameBoard extends JComponent {
	private final int FPS = 60; 
	private Game game;
	private Keyboard keyboard;
	private HighScores<String> highscore;
	private LatestRuns<Integer> runs;
	
	public GameBoard(HighScores<String> highscore2, LatestRuns<Integer> R, States status) {
		keyboard = new Keyboard();
		highscore = highscore2;
		runs = R;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		if(game != null) {
			game.draw(graphics);
		}
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		game = new Game(this, highscore, runs);
		game.setGameBoard(this);
		
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
	public void restart() {
		highscore.add(game.GetTotalPoints(),"RNG" );
		runs.add(game.getLatestRoundP());
		highscore.sort(highscore.getList());
		runs.sort(runs.getList());
		game = new Game(this, highscore, runs);
		game.setGameBoard(this);
	}
}