import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JLayeredPane layeredPane = new JLayeredPane();

        

        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1440, 900));
        frame.setLayout(null);
        frame.setVisible(true);
    }

}