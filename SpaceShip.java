//package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;

public class SpaceShip extends Sprite{
	
	int hp = 3;
	int step = 8;
	boolean alive = true;
	
	public SpaceShip(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	@Override
	public void draw(Graphics2D g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
	
	public void move(int directionX , int directionY){
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
	
	public int gethp(){
		return hp;
	}
	
	public void hit(){
		hp--;
		if(hp < 0){
			hp = 0;
			alive = false;
			//hp = 0;
		}		
	}
		
	public boolean isAlive(){
		return alive;
	}
}