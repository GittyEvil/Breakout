package Pingpong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private int points ;
	private HandleWall walls;
	private PlayerBoard boards;
	private HandleBall balls;
	private HandleBrick bricks;
	public static boolean gameRunning = true;
	
	HighScores<Integer> highscore;
	LatestRuns<Integer> runs;
	
	//fixar med enum(game states)
	private States status = States.running;
	
	public States getStatus() {
		return status;
		
	}
	
	public void setStatus(States newStatus) {
		status = newStatus;
	}
	
	public Game(GameBoard board, HighScores<Integer> highscore2, LatestRuns<Integer> runs) {
		walls = new HandleWall();
		boards = new PlayerBoard(Const.batStartx,Const.batStarty,Const.batWidth,Const.batHeight,Color.gray,800,0);
		bricks = new HandleBrick();
		balls = new HandleBall(boards);
		highscore = new HighScores<Integer>();
	}

	public void update(Keyboard keyboard) {
		if(gameRunning) {
			walls.update(keyboard,balls);
			balls.getBalls();
			boards.update(keyboard,balls,boards); 
			points = bricks.update(keyboard,balls,points);
			balls.update(keyboard,balls,boards);
		}
		highscore.add(points);
	}

	public void draw(Graphics2D graphics) {
		walls.draw(graphics);
		boards.draw(graphics);
		bricks.draw(graphics,points);
		balls.draw(graphics);
	}
}
