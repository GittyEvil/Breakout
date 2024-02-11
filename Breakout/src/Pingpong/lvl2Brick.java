package Pingpong;

import java.awt.Graphics2D;
import java.awt.Color;

public class lvl2Brick extends Brick{

	private int hp;
	private Color color;
	public lvl2Brick(int x, int y, int width, int height) {
		super(x, y, width, height, Color.orange);
		// TODO Auto-generated constructor stub
		this.hp = 2;
		setHp(hp);
	}
}
