package Pingpong;

import java.awt.Graphics2D;
import java.util.*;

public class HandleWall {
	private ArrayList<Wall> Walls;

	public HandleWall() {
		Walls = new ArrayList<>();
		
			Wall vänsterVägg = new Wall(0,0,1,600,false);
			Wall högerVägg = new Wall(800,0,1,600,false);
			Wall toppVägg = new Wall(0,0,800,1,true);
			Walls.add(vänsterVägg); //vänster vägg
			Walls.add(högerVägg); //höger vägg
			Walls.add(toppVägg); //topp vägg
 		
	}
	/*
	public void update(Keyboard keyboard) {
	    for(Wall wall: Walls) {
	        wall.update(keyboard);
	        for (Ball ball : Game.balls.getBalls()) {
	            if (wall.getBounds().intersects(ball.getBounds())) {
	            	//toppvägg
	                if (ball.getY() <= wall.getY() + wall.getHeight()) {
	                    ball.setDy(-ball.getDy());
	                }
	                //vänster vägg
	                else if (ball.getX() <= wall.getX() + wall.getWidth()) {
	                    ball.setDx(-ball.getDx());
	                } 
	                //höger vägg
	                else if (ball.getX() >= wall.getX() - ball.getWidth()) {
	                    ball.setDx(-ball.getDx());
	                }
	            }
	        }
	    }
	}*/
	
	public void update(Keyboard keyboard) {
	    for(Wall wall: Walls) {
	        wall.update(keyboard);
	        for (Ball ball : Game.balls.getBalls()) {
	            if (wall.getBounds().intersects(ball.getBounds())) {
	                if(wall.isTopWall()) {
	                   
	                    if (ball.getDy() < 0 && ball.getY() <= wall.getY() + wall.getHeight()) {
	                        ball.setDy(-ball.getDy());
	                    }
	                } else {
		                    //högervägg har problem
		                	if (ball.getDx() > 0 || ball.getX() + ball.getWidth() >= wall.getX()) {
		                	    ball.setDx(-ball.getDx());
		                	}
		                    //vänstervägg
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
