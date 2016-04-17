//package assignment;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main {
	public static void main(String[] args){
		
		//Create frame
		JFrame frame = new JFrame("My App");
		
		//mathod for close frame "setDefaultCloseOperation()"
		//arqument "EXIT_ON_CLOSE"
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 650); //Set size for frame
		
		//Object for create Bigbog
		BigBox bb = new BigBox(180, 530, 30, 30); //Set x-axis=180(CENTER), y-axis=530, width=30 and height=30
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp, bb);
		engine.start();
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(gp, BorderLayout.CENTER);//Set position for background frame
		
		frame.setVisible(true);//Show frame
	}
}