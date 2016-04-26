//package assignment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D g2d;
	ArrayList<Sprite> sprite = new ArrayList<Sprite>();

	//Background
	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB); //x-axis=400, y-axis=600
		g2d = (Graphics2D) bi.getGraphics();
		g2d.setBackground(Color.BLACK); 
	}
	
	
	public void updateGameUI(Report reporter){
		
		//Set property for big
		g2d.clearRect(0, 0, 400, 600);
		
		//Show big box
		for(Sprite s : sprite){
			s.draw(g2d);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gd = (Graphics2D) g;
		gd.drawImage(bi, null, 0, 0);
	}

}