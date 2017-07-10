import javax.swing.*;
import java.awt.*;

/**
 * Created by Michał on 29.06.2017.
 */
public class Frame extends JFrame {

    public Frame() {
        super("Snake v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Toolkit kit = getToolkit();
        Dimension dim = kit.getScreenSize();

        String name = JOptionPane.showInputDialog(null, "Enter your name ", "Name", JOptionPane.QUESTION_MESSAGE);
        if (name == null || name.equals("")) System.exit(0);

        setResizable(false);

        setLocation(new Point((dim.width - 600) / 2, (dim.height - 600) / 2));

        add(new Navigate(name), BorderLayout.EAST);
        add(new Ground(), BorderLayout.WEST);
        setVisible(true);
        pack();
    }

}
