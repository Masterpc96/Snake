import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

/**
 * Created by Michał on 29.06.2017.
 */
public class Ground extends JPanel implements KeyListener {

    private final int KEY_LEFT = 37;
    private final int KEY_UP = 38;
    private final int KEY_RIGHT = 39;
    private final int KEY_DOWN = 40;
    private final int WIDTH = 1000;
    private final int HEIGHT = 640;
    private final int TIME_INTERVAL = 150;
    private final int PIXEL = 20;
    private final int STROKE = 10;
    private java.util.Timer timer = new java.util.Timer();
    private TimerTask task;
    private Snake snake;

    private char previousKey = 'L';

    private boolean left = true;
    private boolean up = false;
    private boolean right = false;
    private boolean down = false;

    public Ground() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(109, 183, 104));
        snake = new Snake(WIDTH, HEIGHT, STROKE, PIXEL);
        addKeyListener(this);
        setFocusable(true);

        task = new TimerTask() {
            @Override
            public void run() {
                Point firstPoint = snake.getFirstPoint();
                if (left) {
                    if (snake.move(firstPoint.x - PIXEL, firstPoint.y)) {
                        setLife();
                    }
                } else if (up) {
                    if (snake.move(firstPoint.x, firstPoint.y - PIXEL)) {
                        setLife();
                    }
                } else if (right) {
                    if (snake.move(firstPoint.x + PIXEL, firstPoint.y)) {
                        setLife();
                    }
                } else if (down) {
                    if (snake.move(firstPoint.x, firstPoint.y + PIXEL)) {
                        setLife();
                    }
                }

                repaint();
            }
        };

        timer.scheduleAtFixedRate(task, TIME_INTERVAL, TIME_INTERVAL);
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
        g2d.setStroke(new BasicStroke(2 * STROKE));

        // vertical
        g2d.drawLine(STROKE, STROKE, WIDTH - STROKE, STROKE);
        g2d.drawLine(STROKE, HEIGHT - STROKE, WIDTH - STROKE, HEIGHT - STROKE);


        // horizontal
        g2d.drawLine(STROKE, 2 * STROKE, STROKE, HEIGHT - 2 * STROKE);
        g2d.drawLine(WIDTH - STROKE, 2 * STROKE, WIDTH - STROKE, HEIGHT - 2 * STROKE);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        Point firstPoint = snake.getFirstPoint();

        if (keyCode == KEY_LEFT && !right) {
            left = true;
            up = false;
            right = false;
            down = false;

        } else if (keyCode == KEY_UP && !down) {
            left = false;
            up = true;
            right = false;
            down = false;

        } else if (keyCode == KEY_RIGHT && !left) {
            left = false;
            up = false;
            right = true;
            down = false;

        } else if (keyCode == KEY_DOWN && !up) {
            left = false;
            up = false;
            right = false;
            down = true;

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
            task.cancel();
            timer.cancel();
            int option = JOptionPane.showConfirmDialog(null, "Game Over your score is " + String.valueOf(snake.getLength() - 6), "Game Over", JOptionPane.OK_OPTION);
            if (option == JOptionPane.OK_OPTION) System.exit(0);
        }
    }
}
