package Pingpong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	
	public static Ball boll;
	private HandleWall walls;
	public static PlayerBoard boards;
	public static HandleBall balls;
	public static HandleBrick bricks;
	public static boolean gameRunning = true;
	
	public Game(GameBoard board) {
		walls = new HandleWall();
		boards = new PlayerBoard(Const.batStartx,Const.batStarty,Const.batWidth,Const.batHeight,Color.gray,800,0);
		bricks = new HandleBrick();
		balls = new HandleBall();
	}

	public void update(Keyboard keyboard) {
		if(gameRunning) {
			walls.update(keyboard);
			balls.getBalls();
			boards.update(keyboard);
			bricks.update(keyboard);
			balls.update(keyboard);
		}
	}

	public void draw(Graphics2D graphics) {
		walls.draw(graphics);
		boards.draw(graphics);
		bricks.draw(graphics);
		balls.draw(graphics);
	}
}
