import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michał on 29.06.2017.
 */
public class Navigate extends JPanel{
    private JLabel name;
    private JLabel score;
    private JLabel life;
    private JButton close;
    private JLabel highScore;
    public Navigate(String user){

        setPreferredSize(new Dimension(150,640));
        setBackground(new Color(255, 255, 255));

        setLayout(new FlowLayout());

        name=new JLabel("Name: " + user);
        score=new JLabel("Your score 0");
        highScore=new JLabel("Your high score");

        life= new JLabel();
        life.setIcon(new ImageIcon("D:\\JAVA\\Snake\\src\\images\\3Life.png"));

        close=new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        close.setSelected(false);

        add(name);
        add(score);
        add(highScore);
        add(life);
        add(close);

    }
}
