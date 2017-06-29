import java.awt.*;

/**
 * Created by Michał on 29.06.2017.
 */
public class Run {
    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
