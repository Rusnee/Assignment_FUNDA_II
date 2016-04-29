//package f2.spw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Item> item = new ArrayList<Item>();
	private ArrayList<Enemy2> enemies2 = new ArrayList<Enemy2>();

	
	private SpaceShip v;
	
	private Timer timer;
	
	private long score = 0;
	private double difficulty = 0.1;
	
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
				process2();
				process3();
				chkSpaceShip();
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	private void generateEnemy2(){
		Enemy2 ee = new Enemy2((v.x) + (v.width/2),v.y);
		gp.sprites.add(ee);
		enemies2.add(ee);
	}
	
	private void generateItem(){
		Item i = new Item((int)(Math.random()*390), 30);
		gp.sprites.add(i);
		item.add(i);
	}
	
	private void process(){
		if(Math.random() < difficulty/2){
			generateEnemy();
		}
	
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				gp.sprites.remove(e);
				e_iter.remove();
				//score += 100;
			}
		}

		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		Rectangle2D.Double br;
		
		for(Enemy e : enemies){
			er = e.getRectangle();
			for(Enemy2 e2 : enemies2){
				br = e2.getRectangle();
				if(br.intersects(er)){
					score += 50;
					gp.sprites.remove(e);
					e.hit();
				}
			}
			
			if(er.intersects(vr)){
				//die();
				v.hit();
				e.hit();
				return;
			}
		}
	}
	private void process2(){
		if(Math.random() < difficulty){
			generateEnemy2();
		}
	
		Iterator<Enemy2> et_iter = enemies2.iterator();
		while(et_iter.hasNext()){
			Enemy2 et = et_iter.next();
			et.proceed();
			
			if(!et.isAlive()){
				et_iter.remove();
				gp.sprites.remove(et);
				//score += 200;
			}
		}

		gp.updateGameUI(this);
		
		
	}
	
	private void process3(){
		if(Math.random() < difficulty/10){
			generateItem();
		}
	
		Iterator<Item> i_iter = item.iterator();
		while(i_iter.hasNext()){
			Item i = i_iter.next();
			i.proceed();
			
			if(!i.isAlive()){
				gp.sprites.remove(i);
				i_iter.remove();
				
			}
		}

		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double ir;
		
		for(Item i : item){
			ir = i.getRectangle();
			if(ir.intersects(vr)){
				//die();
				//v.hit();
				i.hit();
				score += 100;
				return;
			}
		}
	}
	
	public void die(){
		timer.stop();
	}
	
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1,0);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1,0);
			break;
		case KeyEvent.VK_UP:
			v.move(0,-1);
			break;
		case KeyEvent.VK_DOWN:
			v.move(0,1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.1;
			break;
		
		}
	}

	public long getScore(){
		return score;
	}
	
	/*public int getHP(){
		return v.gethp();
	}*/
	
	public void chkSpaceShip(){
		if(!v.isAlive())
			die();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
}
