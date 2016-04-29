//package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	private Image Background;
	
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		Background = Toolkit.getDefaultToolkit().getImage("background.jpg");
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		big.drawImage(Background, 0, 0, 400, 600,null);
	}

	public void updateGameUI(GameReporter reporter){
		//big.clearRect(0, 0, 400, 600);
		big.drawImage(Background, 0, 0, 400, 600,null);
		big.setColor(Color.WHITE);		
		big.drawString(String.format("Score: %05d", reporter.getScore()), 300, 20);
		//big.drawString(String.format("HP: %02d", reporter.getHP()), 250, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
