package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class lvl3Brick extends Brick{

	private int hp;
	private Color color;
	public lvl3Brick(int x, int y, int width, int height) {
		super(x, y, width, height, Color.red);
		// TODO Auto-generated constructor stub
		this.hp = 3;
		setHp(hp);
	}
}
