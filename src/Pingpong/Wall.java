package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends Sprite {

	private boolean isTop;
	private boolean isRight;
	private boolean isLeft;
	private Color color;
	
	public Wall(int x, int y, int width, int height, boolean isTop, boolean isRight,boolean isLeft, Color color) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.isTop = isTop;
		this.isRight = isRight;
		this.isLeft = isLeft;
		this.color = color;
	}
	
	public boolean isTopWall() {
        return isTop;
    }

	public boolean isRightWall() {
        return isRight;
    }
	public boolean isLeftWall() {
        return isLeft;
    }
	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(color);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
		
	}

}
