package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class PlayerBoard extends Sprite{
	
	private int speed = 10;
	private String text = "AS";
	private Color color;
	private int rightBoundary;
	private int leftBoundary;

	public PlayerBoard(int x, int y, int width, int height,Color color,int rightBoundary, int leftBoundary) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.color = color;
		this.rightBoundary = rightBoundary;
		this.leftBoundary = leftBoundary;
	}

	@Override
	public void update(Keyboard keyboard, HandleBall balls, PlayerBoard boards) {
		// TODO Auto-generated method stub
		int currentX = getX();
		if(keyboard.isKeyDown(Key.Right) && currentX < rightBoundary - Const.batWidth) {
			setX(getX() + this.speed);
		}
		if(keyboard.isKeyDown(Key.Left)&& currentX > leftBoundary) {
			setX(getX() - this.speed);
		}
		for (Ball ball : balls.getBalls()) {
	        if (boards.getBounds().intersects(ball.getBounds())) {
	        	//gör värdet positiv
	            ball.setDy(-Math.abs(ball.getDy()));
	            //tar alltså brädans mitt - bollens x för att få avstånd från brädmitt
	            double positionBoll = (getX() + (getWidth() / 2)) - ball.getX();
	            //gör om värdet för position på boll till 0,-1,1
	            double normaliseradvärdeBoll = (positionBoll / (getWidth() / 2));
	            //tar ut vinkeln,
	            double angle = normaliseradvärdeBoll * Math.PI / Const.batBounceAngle;
	            //nya hastigheten beroende på vilken
	            ball.setDx((int) (-ball.speed * Math.sin(angle)));
	            ball.setDy((int) (-ball.speed * Math.cos(angle)));
	        }
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		graphics.setColor(Color.white);
		graphics.drawString(text, getX() + Const.brickWidth, getY() + Const.brickHeight/2);
	}
	
	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

}
