package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Brick extends Sprite{

	private Color color;
	private int hp;
	public Brick(int x, int y, int width, int height, Color color) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.hp = 1;
		this.color = color;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int setHp(int hp) {
		return this.hp = hp;
	}
	
	public Color setColor(Color color) {
		return this.color = color;
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
