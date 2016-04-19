//ckage assignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class GameEngine implements Report{
	GamePanel panel;
	private BigBox bb;	
	private Timer time;
	
	public GameEngine(GamePanel panel, BigBox bb) {
		this.panel = panel;
		this.bb = bb;		
		
		panel.sprite.add(bb); //Show big box
		
		time = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		
		time.setRepeats(true);
	}
	
	public void start(){
		time.start();
	}
	
	private void process(){
		panel.updateGameUI(this);
	}
}