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
    private int PIXEL = 10;
    private char previousKey = 'L';
    private Snake snake;

    public Ground() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(109, 183, 104));
        snake = new Snake(WIDTH, HEIGHT);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBorder(g2d);
        g2d.setStroke(new BasicStroke(1));

        boolean first = true;


        for (Point p : snake.getPoint()) {
            if (first) {
                g2d.fillRect(p.x, p.y, PIXEL + 1, PIXEL + 1);
                first = false;
            } else {
                g2d.drawRect(p.x, p.y, PIXEL, PIXEL);
            }
        }

        g2d.fillRect(snake.getApplePoint().x, snake.getApplePoint().y, PIXEL + 1, PIXEL + 1);


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
        Point firstPoint = snake.getFirstPoint();

        if (keyCode == KEY_LEFT && previousKey != 'R') {
            previousKey = 'L';
            if (snake.move(firstPoint.x - PIXEL, firstPoint.y)) {
                setLife();
            }

        } else if (keyCode == KEY_UP && previousKey != 'D') {
            previousKey = 'U';
            if (snake.move(firstPoint.x, firstPoint.y - PIXEL)) {
                setLife();
            }

        } else if (keyCode == KEY_RIGHT && previousKey != 'L') {
            previousKey = 'R';
            if (snake.move(firstPoint.x + PIXEL, firstPoint.y)) {
                setLife();
            }

        } else if (keyCode == KEY_DOWN && previousKey != 'U') {
            previousKey = 'D';
            if (snake.move(firstPoint.x, firstPoint.y + PIXEL)) {
                setLife();
            }

        }
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void setLife() {
        if (snake.getLife() == 2) {
            Navigate.life.setIcon(new ImageIcon("D:\\JAVA\\Snake\\src\\images\\2Life.png"));
        } else if (snake.getLife() == 1) {
            Navigate.life.setIcon(new ImageIcon("D:\\JAVA\\Snake\\src\\images\\1Life.png"));
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Game Over your score is " + String.valueOf(snake.getLength() - 6), "Game Over", JOptionPane.OK_OPTION);
            if (option == JOptionPane.OK_OPTION) System.exit(0);
        }
    }
}
