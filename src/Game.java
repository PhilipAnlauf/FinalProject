import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Game extends JLayeredPane{
    ImageIcon rockImage = new ImageIcon("rock.png");
    ImageIcon treeImage = new ImageIcon("tree.png");
    ArrayList<JLabel> rocks = new ArrayList<JLabel>();
    ArrayList<JLabel> trees = new ArrayList<JLabel>();
    public void createTrees(){
        for(int i = 0; i<30; i++) {
            trees.add(new JLabel(treeImage));
        }
    }

    public void createRocks(){
        for(int i = 0; i<30; i++) {
            rocks.add(new JLabel(rockImage));
        }
    }
}
