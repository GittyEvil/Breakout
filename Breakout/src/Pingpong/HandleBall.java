package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class HandleBall {
	
	private ArrayList<Ball> balls;
	Random rand = new Random();
	
	public HandleBall() {
		balls = new ArrayList<>();
		
		for(int i = 0; i < Const.antalBollar;i++) {
			balls.add(new Ball(Game.boards.getX() + 40,Game.boards.getY() - 20,12,12,Color.white));
		}
		
	}
	//hämtar bara bollarna
	public ArrayList<Ball> getBalls() {
	    return balls;
	}
	
	public int ballAmount() {
		return balls.size();
	}
	public void update(Keyboard keyboard) {
		Iterator<Ball> Iterator = balls.iterator();
		while(Iterator.hasNext()) {
			Ball ball = Iterator.next();
			ball.update(keyboard);
				if(ball.getY() > 600) {
					Iterator.remove();
				}
				if(balls.isEmpty()) {
					
					System.exit(0);
				}
		}
	}
	
	public void draw(Graphics2D graphics) {
		for(Ball ball : balls) {
			ball.draw(graphics);
			int ballCount =balls.size();
			String text= "Antal bollar:"+ballCount; 
			graphics.drawString(text, 10, 570);
		}
	}
}
