package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Sprite{

	private int speed;
	private int dx;
	private int dy;
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = 5;
		dx = 5;
		dy = -5;
	}
	//tog getDx - setDy från canvas
	public int getDx()
	{
		return dx;
	}

	public void setDx(int dx)
	{
		this.dx = dx;
	}

	public int getDy()
	{
		return dy;
	}

	public void setDy(int dy)
	{
		this.dy = dy;
	}
	
	@Override
	public void update(Keyboard keyboard) {
		
		//fixa movement så den inte kör samma spår hela tiden
		setY(getY() + dy);
		setX(getX() + dx);
		
		if(getY() == 0) {
			setDy(1);
		}
		if(getX() == 0) {
			setDx(1);
		}
		if(getX() == 800 - 20) {
			setDx(-1);
		}
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.blue);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
