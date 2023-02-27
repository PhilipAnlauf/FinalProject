import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        JLayeredPane layeredPane = new JLayeredPane();
        //==========================================================

        

        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1440, 900));
        frame.setVisible(true);


        }



    }

