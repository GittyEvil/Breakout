package Pingpong;

import java.awt.Graphics2D;
import java.util.*;

public class HandleWall {
	private ArrayList<Wall> Walls;

	public HandleWall() {
		Walls = new ArrayList<>();
		for(int i = 0; i < Const.antalVäggar;i++) {
			Walls.add(new Wall(0,0,2,600));
			Walls.add(new Wall(799,0,2,600));
			Walls.add(new Wall(0,0,800,2));
		}
 		
	}
	
	public void update(Keyboard keyboard) {
		for(Wall wall: Walls) {
			wall.update(keyboard);
			for (Ball ball : Game.balls.getBalls()) {
                if (wall.getBounds().intersects(ball.getBounds())) {
                    //bollen studsar men inte rätt går bara fixerat
                    ball.setDx(+ball.getDx());
                    ball.setDy(+ball.getDy());
                }
            }
		}
	}
	
	public void draw(Graphics2D graphics) {
		for(Wall wall: Walls) {
			wall.draw(graphics);
		}
 	}
}
