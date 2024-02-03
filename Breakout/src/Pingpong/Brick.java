package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Sprite{

	public Brick(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.red);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
