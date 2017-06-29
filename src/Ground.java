import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Michał on 29.06.2017.
 */
public class Ground extends JPanel implements KeyListener{
    public Ground(){
        setPreferredSize(new Dimension(900,640));
        setBackground(new Color(109, 183, 104));
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        drawBorder(g2d);



    }

    public void drawBorder(Graphics2D g2d){
        g2d.setStroke(new BasicStroke(8));

        // vertical
        g2d.drawLine(4,4,896,4);
        g2d.drawLine(4,636,896,636);


        // horizontal
        g2d.drawLine(4,8,4,632);
        g2d.drawLine(896,8,896,632);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
