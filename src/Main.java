import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
    JFrame gameScreen = new JFrame();
    gameScreen.setSize(750,750);

    JPanel startMenu = new JPanel();
    startMenu.setBackground(Color.blue);
    gameScreen.add(startMenu);

    gameScreen.setVisible(true);
    }
}