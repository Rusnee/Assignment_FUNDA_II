//package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;


import java.awt.Toolkit;
import java.awt.Image;

public class SpaceShip extends Sprite{

	int hp = 10;
	boolean alive = true;
	int step = 8;
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, 50, 40);
		
	}

	@Override
	public void draw(Graphics2D g) {
		/*g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);*/
		Image pic = Toolkit.getDefaultToolkit().getImage("Space.png");
        g.drawImage(pic, x, y, width, height, null);
		
	}

	public void move(int directionX, int directionY){
		if(directionX != 0 && directionY == 0 ){
			x += (step * directionX);
			if(x < 0)
				x = 0;
			if(x > 400 - width)
				x = 400 - width;
		}
		if(directionX == 0 && directionY != 0 ){
			y += (step * directionY);
			if(y < 0)
				y = 0;
			if(y > 600 - height)
				y = 600	- height;
		}	
	}
	
	
	public void hit() {
		//hp = 100;
		hp--;
		if(hp <= 0) {
			alive = false;
			hp = 0;
			
			}		
	}

	
	
	public boolean isAlive(){
		return alive;
	}

}
