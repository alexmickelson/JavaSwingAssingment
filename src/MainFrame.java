import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private MyPanel myPanel;

    public MainFrame(){
        myPanel = new MyPanel();


        var once = new appendOnce();
        var twice = new appendTwice();
        myPanel.setAppend(once, twice);

        add(myPanel, BorderLayout.NORTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class appendOnce implements IAppend{

        @Override
        public void appendAction() {
            myPanel.appendOutput(myPanel.getInput());
        }
        
    }
    class appendTwice implements IAppend{

        @Override
        public void appendAction() {
            myPanel.appendOutput(myPanel.getInput());
            myPanel.appendOutput(myPanel.getInput());
        }
        
    }
}