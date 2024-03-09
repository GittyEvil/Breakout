package Pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;
import java.lang.Thread;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleBall {
	
	private ArrayList<Ball> balls;
	Random rand = new Random();
	 private Timer timer;
	
	public HandleBall(PlayerBoard boards) {
		balls = new ArrayList<>();
		
		for(int i = 0; i < Const.antalBollar;i++) {
			balls.add(new Ball(boards.getX() + Const.batHeight,boards.getY() - 20,Const.ballWidth,Const.ballHeight,Color.white));
		}
		
		timer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });

	}
	//hämtar bara bollarna
	public ArrayList<Ball> getBalls() {
	    return balls;
	}
	
	public int ballAmount() {
		return balls.size();
	}
	public void update(Keyboard keyboard, HandleBall balls2, PlayerBoard boards) {
		//skapar iterator för att ta bort bollar
		Iterator<Ball> Iterator = balls.iterator();
		while(Iterator.hasNext()) {
			Ball ball = Iterator.next();
			ball.update(keyboard);
				if(ball.getY() > Const.gameboardHeight) {
					Iterator.remove();
				}
		}
	}
	
	public void draw(Graphics2D graphics, States status) {
		for(Ball ball : balls) {
			ball.draw(graphics);
			int ballCount = balls.size();
			String text= "Antal bollar:"+ballCount; 
			graphics.drawString(text, 10, 570);
		}
		if(balls.isEmpty()) {
			status.setStatus(States.paused);
			//status = States.paused;
			String string = "du förlora jo";
			Font stringFont = new Font("SansSerif", Font.BOLD, 50);
			graphics.setFont(stringFont);
			graphics.drawString(string, Const.förloraStringposX, Const.förloraStringposY);
			//System.out.println(status.getStatus());
			//timer.start();
			//System.exit(0);
		}
	}
}
