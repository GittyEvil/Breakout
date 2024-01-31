package Pingpong;

import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerBoard extends Sprite{
	
	private int speed = 5;

	public PlayerBoard(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		if(keyboard.isKeyDown(Key.Right)) {
			setX(getX() + this.speed);
		}
		if(keyboard.isKeyDown(Key.Left)) {
			setX(getX() - this.speed);
		}
		for (Ball ball : Game.balls.getBalls()) {
            if (Game.boards.getBounds().intersects(ball.getBounds())) {
                //bollen studsar men inte rätt går bara fixerat
                ball.setDx(-ball.getDx());
                ball.setDy(-ball.getDy());
            }
        }
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.gray);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}

}
