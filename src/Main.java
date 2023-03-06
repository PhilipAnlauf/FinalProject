import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Initializing images and misc.
        ImageIcon treeImage = new ImageIcon("tree.png");
        treeImage.setImage(treeImage.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
        ImageIcon rockImage = new ImageIcon("rock.png");
        rockImage.setImage(rockImage.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(1440, 900);
        //=======================
        //Adding Sprites
        ArrayList<JLabel> rocks = new ArrayList<>();
        ArrayList<TSprites> TSprites = new ArrayList<>();

        for(int i = 0; i<30; i++){
            rocks.add(new JLabel("rock.png"));
            
        }

        //=======================
        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1440, 900));
        frame.setLayout(null);
        frame.setVisible(true);
        //======================
    }

}