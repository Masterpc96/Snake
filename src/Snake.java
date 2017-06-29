import javax.swing.*;
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

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        points=new ArrayList<>();
        rand=new Random();

        initGame(x, y);
    }

    public void initGame(int x, int y) {
        points.add(new Point(x / 2, y / 2));
        points.add(new Point(x / 2 + 10, y / 2));
        points.add(new Point(x / 2 + 20, y / 2));
        points.add(new Point(x / 2 + 30, y / 2));
        points.add(new Point(x / 2 + 40, y / 2));
        points.add(new Point(x / 2 + 50, y / 2));
        length = 6;
    }

    public void apple() {
        do {
            applePoint = new Point(rand.nextInt(x - 8) + 8, rand.nextInt(y - 8) + 8);
        } while (points.contains(applePoint));
    }

    public void move(int x, int y) {
        if(!checkWallCollision(x,y)){
            points.add(new Point(x,y));
            points.remove(0);
        }
        else{
            int option=JOptionPane.showConfirmDialog(null,"Game Over your score is " + length,"Game Over", JOptionPane.OK_OPTION);
            if(option==JOptionPane.OK_OPTION) System.exit(0);
        }
    }

    public boolean checkWallCollision(int x, int y){
        if(x<=0 || y<=0 || this.x<=x || this.y<=y){
            return true;
        }
        return false;
    }

    public Point getLastPoint(){
        return points.get(length -1);
    }

    public ArrayList<Point> getPoint(){
        return points;
    }

}
