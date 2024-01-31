package Pingpong;

import java.awt.Graphics2D;
import java.util.*;

public class HandleBall {
	
	private ArrayList<Ball> balls;
	
	public HandleBall() {
		balls = new ArrayList<>();
		
		for(int i = 0; i < Const.antalBollar;i++) {
			balls.add(new Ball(Game.boards.getX() + 40,Game.boards.getY() - 20,20,20));
			//balls.add(new Ball(250,350,20,20));
		}
	}
//Game.boards.getX() + 40  , Game.boards.getY() - 20
	
	public ArrayList<Ball> getBalls() {
	    return balls;
	}
	
	public void update(Keyboard keyboard) {
		for(Ball ball : balls) {
			ball.update(keyboard);
		}
	}
	
	public void draw(Graphics2D graphics) {
		for(Ball ball : balls) {
			ball.draw(graphics);
		}
	}
}
