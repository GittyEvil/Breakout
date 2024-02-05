package Pingpong;

import java.util.*;
import java.awt.Color;
import java.awt.Graphics2D;

public class HandleBrick {
	
	private ArrayList<Brick> bricks;
	private int brickPerRow = 0;
	int startVärdeY = 20;
	int startVärdeX = 100;
	Random rand = new Random();
	
	public HandleBrick() {
		
		bricks = new ArrayList<>();
		
		for(int i = 0; i < Const.Nivå1; i++) {
			int row = i / 10;
			int col = i % 10;
			int y = row * (Const.brickWidth + Const.brickSpace);
			int x = col * (Const.brickHeight + Const.brickSpace);
			int byteAvBrick = rand.nextInt(1,4);
			
			if(byteAvBrick == 1) {
				bricks.add(new Brick(startVärdeX + x,startVärdeY + y,Const.brickWidth,Const.brickHeight, Color.yellow));
			}
			if(byteAvBrick == 2) {
				bricks.add(new lvl2Brick(startVärdeX + x,startVärdeY + y,Const.brickWidth,Const.brickHeight));
			}
			if(byteAvBrick == 3) {
				bricks.add(new lvl3Brick(startVärdeX + x,startVärdeY + y,Const.brickWidth,Const.brickHeight));
			}
			
			brickPerRow++;
		}	
	}
	//itererar med en iterator som 
	public void update(Keyboard keyboard) {
	    Iterator<Brick> iterator = bricks.iterator();
	    while (iterator.hasNext()) {
	        Brick brick = iterator.next();
	        brick.update(keyboard);
	        int powerUp = rand.nextInt(0,3);
	        
	        //iteratorn för bollistan
	        List<Ball> ballsCopy = new ArrayList<>(Game.balls.getBalls());
	        
	        for (Ball ball : ballsCopy) {
	            if (brick.getBounds().intersects(ball.getBounds())) {
	                ball.setDx(ball.getDx());
	                ball.setDy(-ball.getDy());
	                
	                brick.setHp(brick.getHp() - 1);
	                if(brick.getHp() == 2) {
	                	brick.setColor(Color.orange);
	                }
	                if(brick.getHp() == 1) {
	                	brick.setColor(Color.yellow);
	                }
	          
	                if(brick.getHp() <= 0) {
	                	iterator.remove();
	                	if(powerUp == 1) {
		                	//skapar en ny array för att hantera de nya bollarna
		                	ArrayList<Ball> newBalls = new ArrayList<>();

		                    newBalls.add(new Ball(ball.getX(), ball.getY(), 12, 12, Color.white));
		                    //och lägger till dem i den gamla arrayen
		                    Game.balls.getBalls().addAll(newBalls);
		                }
	                	break; 
	                }
	                //break; 
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
