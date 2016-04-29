import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MenuListener implements ActionListener{
    JMenuItem menuExit;
    //JMenuItem menuCredit;
    JMenuItem menuRestart;
    JMenuItem menuStop;
    GameEngine engine;
    
    public MenuListener(JMenuItem menuExit,JMenuItem menuRestart,JMenuItem menuStop,GameEngine engine){
        this.menuExit = menuExit;
        this.menuRestart = menuRestart;
        this.menuStop = menuStop;
        this.engine = engine;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        clickMenu(e);
    }
    
    private void clickMenu(ActionEvent e){
        if(e.getSource() == menuExit){
            System.exit(0);
        }
        if(e.getSource() == menuRestart){
            engine.start();
            //engine.setScore(0);
        }
        if(e.getSource() == menuStop){
            engine.die();
        }
    }
}
