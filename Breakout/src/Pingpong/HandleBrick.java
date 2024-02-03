package Pingpong;

import java.util.*;
import java.awt.Graphics2D;

public class HandleBrick {
	
	private ArrayList<Brick> bricks;
	private int brickPerRow = 0;
	int startVärde = 20;
	
	public HandleBrick() {
		
		bricks = new ArrayList<>();
		
		for(int i = 0; i < Const.Nivå1; i++) {
			for(int j = 0; j < Const.Nivå1; j++) {
				int spacing = i*(Const.brickWidth + Const.brickSpace);
				//bricks.add(new Brick(40+(spacing),startVärde,Const.brickWidth,Const.brickHeight));
				brickPerRow++;
			}
			
			if(brickPerRow == Const.Nivå1) {
				startVärde += brickPerRow + Const.brickHeight;
				brickPerRow = 0;
			}
		}	
	}
	//itererar med en iterator som 
	public void update(Keyboard keyboard) {
	    Iterator<Brick> iterator = bricks.iterator();
	    while (iterator.hasNext()) {
	        Brick brick = iterator.next();
	        brick.update(keyboard);
	        for (Ball ball : Game.balls.getBalls()) {
	            if (brick.getBounds().intersects(ball.getBounds())) {
	                ball.setDx(-ball.getDx());
	                ball.setDy(-ball.getDy());
	                
	                iterator.remove(); 
	                break; 
	            }
	        }
	    }
	}
	
	public void draw(Graphics2D graphics) {
		for(Brick brick : bricks) {
			brick.draw(graphics);
		}
	}

}
