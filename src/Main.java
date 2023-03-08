import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        //Initializing images and misc.
        ImageIcon treeImage = new ImageIcon("tree.png");
        treeImage.setImage(treeImage.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
        ImageIcon rockImage = new ImageIcon("rock.png");
        rockImage.setImage(rockImage.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));

        ImageIcon treeAnimation1 = new ImageIcon("treeAnimation1.png");
        treeAnimation1.setImage(treeAnimation1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
        ImageIcon treeAnimation2 = new ImageIcon("treeAnimation2.png");
        treeAnimation2.setImage(treeAnimation2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(1440, 900);
        //============================================
        //=========== General Game Values ============
        int rockCount = 30;
        int treeCount = 16;

        int maxCreatures = 25;
        int creatureHealth = 30;
        int treeSpeed = 1;
        int skinChoice = 1;

        int axeHealth = 4; //# of hits before breaking
        int axeDamage = 10; //Damage per axe hit
        int sharpenerSpawnRate = 20; //Amount of cycles before new axe sharpener spawn

        int gameInterval = 50*treeSpeed; //in milliseconds
        //============================================
        //Adding Sprites
        ArrayList<JLabel> rocks = new ArrayList<>();
        ArrayList<JLabel> trees = new ArrayList<>();
        ArrayList<JLabel> monsters = new ArrayList<>();

        for(int i = 0; i<rockCount; i++){
            rocks.add(new JLabel(rockImage));
        }
        for(JLabel hold: rocks){
            hold.setBounds((int)(Math.random()*1440),(int)(Math.random()*900),60,60);
            layeredPane.add(hold, Integer.valueOf(0));
        }

        for(int i = 0; i<treeCount; i++){
            trees.add(new JLabel(treeImage));
        }
        for(JLabel hold: trees){
            hold.setBounds((int)(Math.random()*1440),(int)(Math.random()*900),120,120);
            layeredPane.add(hold, Integer.valueOf(2));
        }

        monsters.add(new JLabel(treeAnimation1));
        for(JLabel hold: monsters){
            hold.setBounds(50,50,120,120);
            layeredPane.add(hold, Integer.valueOf(2));
        }

        //=======================
        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1440, 900));
        frame.setLayout(null);
        frame.setVisible(true);
        //======================
        //===== Game Start =====
        while(true){
            treeSpeed++;
            for(JLabel hold: monsters){
                skinChoice = skinChoice*-1;
                if(skinChoice == -1){
                    hold.setIcon(treeAnimation1);
                }
                if(skinChoice == 1){
                    hold.setIcon(treeAnimation2);
                }
                hold.setBounds(hold.getX()+treeSpeed, hold.getY()+treeSpeed,120,120);
            }

            try
            {
                Thread.sleep(gameInterval);
            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }

    }

}