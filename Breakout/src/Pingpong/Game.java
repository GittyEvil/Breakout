package Pingpong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	
	private HandleWall walls;
	private PlayerBoard boards;
	private HandleBall balls;
	private HandleBrick bricks;
	public static boolean gameRunning = true;
	
	//fixar med enum(game states)
	private States status = States.running;
	
	public States getStatus() {
		return status;
		
	}
	
	public void setStatus(States newStatus) {
		status = newStatus;
	}
	
	public Game(GameBoard board) {
		walls = new HandleWall();
		boards = new PlayerBoard(Const.batStartx,Const.batStarty,Const.batWidth,Const.batHeight,Color.gray,800,0);
		bricks = new HandleBrick();
		balls = new HandleBall(boards);
	}

	public void update(Keyboard keyboard) {
		if(gameRunning) {
			walls.update(keyboard,balls);
			balls.getBalls();
			boards.update(keyboard,balls,boards); //boards.update(keyboard, balls); och gör balls private igen
			bricks.update(keyboard,balls);
			balls.update(keyboard,balls,boards);
		}
	}

	public void draw(Graphics2D graphics) {
		walls.draw(graphics);
		boards.draw(graphics);
		bricks.draw(graphics);
		balls.draw(graphics);
	}
}
