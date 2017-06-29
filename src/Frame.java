import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Michał on 29.06.2017.
 */
public class Frame extends JFrame{

    public Frame(){
        super("Snake v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String name= "Your name";//JOptionPane.showInputDialog(null,"Enter your name ","Name",JOptionPane.QUESTION_MESSAGE);
        if(name==null || name.equals("")) System.exit(0);

        setResizable(false);

        add(new Navigate(name),BorderLayout.EAST);
        add(new Ground(),BorderLayout.WEST);
        setVisible(true);
        pack();
    }

}
