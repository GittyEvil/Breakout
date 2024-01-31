package Pingpong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	
	public static Ball boll;
	private HandleWall walls;
	public static PlayerBoard boards;
	public static HandleBall balls;
	
	public Game(GameBoard board) {
		walls = new HandleWall();
		boards = new PlayerBoard(350,500,100,20);
		boll = new Ball(boards.getX() + 40,boards.getY() - 20,20,20);
		balls = new HandleBall();
	}

	public void update(Keyboard keyboard) {
		//boll.update(keyboard);
		walls.update(keyboard);
		balls.getBalls();
		boards.update(keyboard);
		balls.update(keyboard);
	}

	public void draw(Graphics2D graphics) {
		//boll.draw(graphics);
		walls.draw(graphics);
		boards.draw(graphics);
		balls.draw(graphics);
	}
}
