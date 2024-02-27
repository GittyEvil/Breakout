package Pingpong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private int points;
	private HandleWall walls;
	private PlayerBoard boards;
	private HandleBall balls;
	private HandleBrick bricks;
	public static boolean gameRunning = true;
	
	HighScores<Integer> highscore;
	LatestRuns<Integer> runs;
	
	//fixar med enum(game states)
	private States status = States.running;
	
	
	public Game(GameBoard board, HighScores<Integer> highscore2, LatestRuns<Integer> runs) {
		walls = new HandleWall();
		boards = new PlayerBoard(Const.batStartx,Const.batStarty,Const.batWidth,Const.batHeight,Color.gray,800,0);
		bricks = new HandleBrick();
		balls = new HandleBall(boards);
		highscore = highscore2;
		status.setStatus(States.running);
	}

	public void update(Keyboard keyboard) {
		if(status.getStatus() == States.running) {
			walls.update(keyboard,balls);
			balls.getBalls();
			boards.update(keyboard,balls,boards); 
			points = bricks.update(keyboard,balls,points);
			balls.update(keyboard,balls,boards);

		}else {
			highscore.add(points);
		}
		
		if(status.getStatus() == States.paused) {
			if(keyboard.isKeyDown(Key.Enter)) {
				//här ska du resetta spelet
				status.setStatus(States.running);
				//problemet är bara att du får upp flera rutor av spelet(försök stänga de gamla)
				Program program = new Program();
			}
		}
	}

	public void draw(Graphics2D graphics) {
		walls.draw(graphics);
		boards.draw(graphics);
		bricks.draw(graphics,points,status);
		balls.draw(graphics,status);
	}
}
