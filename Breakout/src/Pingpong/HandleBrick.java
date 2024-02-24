package Pingpong;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleBrick {
	
	private ArrayList<Brick> bricks;
	private int startVärdeY = 10;
	private int startVärdeX = 50;
	Random rand = new Random();
	
	private Timer timer;
	
	public HandleBrick() {
		
		bricks = new ArrayList<>();
		
		timer = new Timer(2100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		for(int i = 0; i < Const.Nivå1; i++) {
			int row = i / Const.brickperRad;
			int col = i % Const.brickperRad;
			int y = row * (Const.brickSpace);
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
		}	
	}
	//itererar med en iterator som 
	public int update(Keyboard keyboard, HandleBall balls, int points) {
	    Iterator<Brick> iterator = bricks.iterator();
	    while (iterator.hasNext()) {
	        Brick brick = iterator.next();
	        brick.update(keyboard);
	        int powerUp = rand.nextInt(0,3);
	        
	        //iteratorn för bollistan
	        List<Ball> ballsCopy = new ArrayList<>(balls.getBalls());
	        
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
	                	points += brick.setPoints(+brick.getPoints());

	                	if(powerUp == 1) {
		                	//skapar en ny array för att hantera de nya bollarna
		                	ArrayList<Ball> newBalls = new ArrayList<>();

		                    newBalls.add(new Ball(ball.getX(), ball.getY(), Const.ballWidth, Const.ballHeight, Color.white));
		                    //och lägger till den nya listan i den gamla arrayen
		                    balls.getBalls().addAll(newBalls);
		                }
	                	break; 
	                }
	                //break; 
	            }
	        }
	    }
	    return points;
	}
	
	public void draw(Graphics2D graphics, int points) {
		for(Brick brick : bricks) {
			brick.draw(graphics);
		}
		String poäng = "Poäng: "+ points;
		graphics.setColor(Color.white);
		graphics.drawString(poäng, 700,570);
		
		if(bricks.isEmpty()) {
			String string = "Du vann,Poäng: " + poäng;
			Font stringFont = new Font("SansSerif", Font.BOLD, Const.fontSize);
			graphics.setFont(stringFont);
			graphics.drawString(string, Const.vinstStringposX, Const.vinstStringposY);
			Game.gameRunning = false;
			timer.start();
		}
	}
}
