import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Michał on 29.06.2017.
 */
public class Snake {
    private int lenght;
    private ArrayList<Point> points;
    private Random rand;
    private Point applePoint;
    private int x;
    private int y;

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        initGame(x, y);
    }

    public void initGame(int x, int y) {
        points.add(new Point(x / 2, y / 2));
        points.add(new Point(x / 2 + 1, y / 2));
        points.add(new Point(x / 2 + 2, y / 2));
        lenght = 3;
    }

    public void apple() {
        do {
            applePoint = new Point(rand.nextInt(x - 4) + 4, rand.nextInt(y - 4) + 4);
        } while (points.contains(applePoint));
    }

    public void move(int x, int y) {

    }

    public Point getLastPoint(){
        return points.get(lenght-1);
    }

}
