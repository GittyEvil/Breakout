package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends Sprite {

	private boolean isTop;
	
	public Wall(int x, int y, int width, int height, boolean isTop) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.isTop = isTop;
	}
	
	public boolean isTopWall() {
        return isTop;
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
