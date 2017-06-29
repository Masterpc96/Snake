import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Michał on 29.06.2017.
 */
public class Ground extends JPanel implements KeyListener {

    private final int KEY_LEFT = 37;
    private final int KEY_UP = 38;
    private final int KEY_RIGHT = 39;
    private final int KEY_DOWN = 40;
    private int WIDTH = 900;
    private int HEIGHT = 640;
    private Snake snake;

    public Ground() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(109, 183, 104));
        new Snake(WIDTH, HEIGHT);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBorder(g2d);


    }

    public void drawBorder(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(8));

        // vertical
        g2d.drawLine(4, 4, 896, 4);
        g2d.drawLine(4, 636, 896, 636);


        // horizontal
        g2d.drawLine(4, 8, 4, 632);
        g2d.drawLine(896, 8, 896, 632);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Point lastPoint = snake.getLastPoint();
        char previousKey = 'L';
        switch (keyCode) {
            case KEY_LEFT:
                if (previousKey != 'R') {
                    previousKey = 'L';
                    snake.move(lastPoint.x-1,lastPoint.y);
                }

            case KEY_UP:
                if (previousKey != 'D') {
                    previousKey = 'U';
                    snake.move(lastPoint.x,lastPoint.y-1);

                }

            case KEY_RIGHT:
                if (previousKey != 'L') {
                    previousKey = 'R';
                    snake.move(lastPoint.x+1,lastPoint.y);

                }

            case KEY_DOWN:
                if (previousKey != 'U') {
                    previousKey = 'D';
                    snake.move(lastPoint.x,lastPoint.y+1);

                }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
