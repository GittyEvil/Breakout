package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ball extends Sprite{

	public int speed;
	private int dx;
	private int dy;
	private Color color;
	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		this.speed = 10;
		this.color = color;
		dx = 10;
		dy = 5;
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
	
	public int multiball() {
		int amountBalls = Game.balls.ballAmount();
		return 2 * amountBalls;
	}
	
	@Override
	public void update(Keyboard keyboard) {
		setY(getY() + dy);
		setX(getX() + dx);
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		graphics.fillOval(getX(), getY(), getWidth(), getHeight());
	}

}
