import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michał on 29.06.2017.
 */
public class Snake {
    private int length;
    private ArrayList<Point> points;
    private Random rand;
    private Point applePoint;
    private int x;
    private int y;
    private final int STROKE;
    private final int PIXEL;
    private int life;

    public Snake(int x, int y, int stroke, int pixel) {
        this.x = x;
        this.y = y;
        this.STROKE = stroke;
        this.PIXEL = pixel;
        points = new ArrayList<>();
        rand = new Random();

        initGame(x, y);
    }

    public void initGame(int x, int y) {
        points.add(new Point(x / 2, y / 2));
        points.add(new Point(x / 2 + PIXEL, y / 2));
        points.add(new Point(x / 2 + 2* PIXEL, y / 2));
        points.add(new Point(x / 2 + 3* PIXEL, y / 2));
        points.add(new Point(x / 2 + 4* PIXEL, y / 2));
        points.add(new Point(x / 2 + 5* PIXEL, y / 2));

        length = 6;
        life = 3;

        apple();
    }

    public void apple() {
        int x;
        int y;
        do {
            do {
                x = rand.nextInt(this.x - (1+ PIXEL +2* STROKE)) + PIXEL;
            } while (x % PIXEL != 0);

            do {
                y = rand.nextInt(this.y - (1+ PIXEL +2* STROKE)) + PIXEL;
            } while (y % PIXEL != 0);

            applePoint = new Point(x, y);
        } while (points.contains(applePoint));
    }

    public boolean move(int x, int y) {
        if (!checkCollision(x, y)) {
            points.remove(length - 1);
            points.add(0, new Point(x, y));
            if (applePoint.x == x && applePoint.y == y) {
                apple();
                points.add(applePoint);
                length++;
                Navigate.score.setText("Your score " + String.valueOf(length - 6));
            }
        } else {
            life--;
            return true;
        }
        return false;
    }

    public boolean checkCollision(int _x, int _y) {
        if (_x <=  0|| _y <= 0 || _x >= x - (PIXEL + STROKE) || _y >= y - (PIXEL + STROKE) || points.contains(new Point(_x, _y))) {
            return true;
        }
        return false;
    }

    public Point getFirstPoint() {
        return points.get(0);
    }

    public ArrayList<Point> getPoint() {
        return points;
    }

    public Point getApplePoint() {
        return applePoint;
    }

    public int getLife() {
        return life;
    }

    public int getLength() {
        return length;
    }

}
