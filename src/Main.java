import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //================= Rock Image Build =======================
        ImageIcon rockImage = new ImageIcon("rock.png");
        rockImage.setImage(rockImage.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
        //==========================================================

        //================= Tree Image Build =======================
        ImageIcon treeImage = new ImageIcon("tree.png");
        treeImage.setImage(treeImage.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
        //==========================================================
        JLabel rock1 = new JLabel(rockImage);
        rock1.setBounds(50,50,60,60);

        JLabel tree1 = new JLabel(treeImage);
        tree1.setBounds(100,100,120,120);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,650,650);

        layeredPane.add(rock1, Integer.valueOf(0));
        layeredPane.add(tree1, Integer.valueOf(0));

        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);
        frame.setVisible(true);
    }

}