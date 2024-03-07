package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class HandleWall {
	private ArrayList<Wall> Walls;

	public HandleWall() {
		Walls = new ArrayList<>();
		
			Wall vänsterVägg = new Wall(0,0,1,Const.gameboardHeight,false,false,true,Color.red);
			Wall högerVägg = new Wall(Const.gameboardWidth - 1 ,0,1,Const.gameboardHeight,false,true,false,Color.red);
			Wall toppVägg = new Wall(0,0,Const.gameboardWidth,1,true,false,false,Color.red);
			Walls.add(vänsterVägg); //vänster vägg
			Walls.add(högerVägg); //höger vägg
			Walls.add(toppVägg); //topp vägg
 		
	}
	public void update(Keyboard keyboard, HandleBall balls) {
	    for(Wall wall: Walls) {
	        wall.update(keyboard);
	        for (Ball ball : balls.getBalls()) {
	            if (wall.getBounds().intersects(ball.getBounds())) {
	            	//toppvägg
	                if(wall.isTopWall()) {
	                    if (ball.getDy() < 0 && ball.getY() <= wall.getY() + wall.getHeight()) {
	                        ball.setDy(-ball.getDy());
	                    }
	                } 
		            //högervägg
                	if (wall.isRightWall()) {
                	    if (ball.getDx() > 0 && ball.getX() >= wall.getX() - ball.getWidth() ) {
                	        ball.setDx(-ball.getDx());
                	    }
                	}
	                //vänstervägg
                	if(wall.isLeftWall()) {
                		if (ball.getDx() < 0 && ball.getX() <= wall.getX() + wall.getWidth()) {
	                        ball.setDx(-ball.getDx());
	                    }
                	}
	                
	            }
	        }
	    }
	}



	public void draw(Graphics2D graphics) {
		for(Wall wall: Walls) {
			wall.draw(graphics);
		}
 	}
}
