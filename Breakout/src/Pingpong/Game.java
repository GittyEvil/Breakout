package Pingpong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private GameBoard game;
	
	private int points;
	private int totalpoints = 0;
	private HandleWall walls;
	private PlayerBoard boards;
	private HandleBall balls;
	private HandleBrick bricks;
	HighScores<String> highscore;
	LatestRuns<Integer> latestRuns;
	
	//fixar med enum(game states)
	private States status = States.running;
	
	public int GetTotalPoints() {
		return totalpoints;
	}
	public int getLatestRoundP() {
		return points;
	}
	
	public void setGameBoard(GameBoard game) {
        this.game = game;
    }
	
	public Game(GameBoard board, HighScores<String> highscore2, LatestRuns<Integer> runs) {
		walls = new HandleWall();
		boards = new PlayerBoard(Const.batStartx,Const.batStarty,Const.batWidth,Const.batHeight,Color.gray,800,0);
		bricks = new HandleBrick();
		balls = new HandleBall(boards);
		
		highscore = highscore2;
		latestRuns = runs;
		status.setStatus(States.running);
	}

	public void update(Keyboard keyboard) {
		if(status.getStatus() == States.running) {
			walls.update(keyboard,balls);
			balls.getBalls();
			boards.update(keyboard,balls,boards); 
			points = bricks.update(keyboard,balls,points);
			balls.update(keyboard,balls,boards);
		} else if(status.getStatus() == States.paused) {
			if(keyboard.isKeyDown(Key.Enter)) {
				totalpoints += points;
				//här ska du resetta spelet
				status.setStatus(States.running);
				game.restart();
				
			}
		}
	}

	public void draw(Graphics2D graphics) {
		walls.draw(graphics);
		boards.draw(graphics);
		bricks.draw(graphics,points,status);
		balls.draw(graphics,status);
		
		if(status.getStatus() == States.paused) {
			String string = "Tryck på enter -> starta om";
			Font stringFont = new Font("SansSerif", Font.BOLD, 50);
			graphics.setFont(stringFont);
			graphics.drawString(string, Const.försökStringposX, Const.försökStringposY);
		}
	}
}
