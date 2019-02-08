import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MyPanel extends JPanel implements ActionListener {
    private JTextArea input;
    private JTextArea output;
    private JButton add1;
    private JButton add2;
    private IAppend once;
    private IAppend twice;

    public MyPanel() {
        super();
        input = new JTextArea("Type Your Text Here");
        output = new JTextArea(10, 20);
        output.setEditable(false);
        add1 = new JButton("Add 1");
        add2 = new JButton("Add 2");
        add1.addActionListener(this);
        add2.addActionListener(this);
        //output.setPreferredSize(new Dimension(100, 100));


        var scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setMinimumSize(new Dimension(100, 100));


        //scroll.setBounds(30, 30, 500, 600);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.anchor=GridBagConstraints.NORTH;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        c.insets = new Insets(10,10,10,10);
        c.ipadx=100;
        c.ipady=10;
        c.anchor=GridBagConstraints.EAST;
        c.fill=GridBagConstraints.HORIZONTAL;
        add(input, c);

        c.anchor=GridBagConstraints.WEST;
        c.gridwidth=1;
        c.gridy=1;
        add(add1, c);

        c.gridx=1;
        add(add2, c);

        c.gridx=0;
        c.gridy=2;
        c.ipadx=0;
        c.ipady=0;
        c.gridwidth=2;
        c.fill=GridBagConstraints.BOTH;
        add(scroll, c);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if (once != null && twice != null){
            if (clicked == add1){
                once.appendAction();
            } else if (clicked == add2){
                twice.appendAction();
            }
        }
    }

    public String getInput(){
        return input.getText();
    }

    public void appendOutput(String string){
        output.append(string + "\n");
    }

    public void setAppend(IAppend once, IAppend twice){
        this.once = once;
        this.twice = twice;
    }
} 