import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

        ImageIcon playerImage = new ImageIcon("treeAnimation1.png");
        playerImage.setImage(playerImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        ImageIcon backgroundImage = new ImageIcon("background.png");
        playerImage.setImage(playerImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(1440, 900);

        //============================================
        //=========== General Game Values ============
        int rockCount = 30;
        int treeCount = 16;

        int playerSpeed = 35;

        int maxCreatures = 25;
        int creatureHealth = 30;
        int treeSpeed = 20;
        int skinChoice = 1;

        int axeHealth = 4; //# of hits before breaking
        int axeDamage = 10; //Damage per axe hit
        int sharpenerSpawnRate = 20; //Amount of cycles before new axe sharpener spawn

        int gameInterval = 85; //in milliseconds
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
            layeredPane.add(hold, Integer.valueOf(1));
        }

        for(int i = 0; i<maxCreatures; i++){
            monsters.add(new JLabel(treeAnimation1));
        }

        for(JLabel hold: monsters){
            hold.setBounds((int)(Math.random()*1440),-200,60,60);
            layeredPane.add(hold, Integer.valueOf(1));
        }

        for(int i = 0; i<treeCount; i++){
            trees.add(new JLabel(treeImage));
        }
        for(JLabel hold: trees){
            hold.setBounds((int)(Math.random()*1440),(int)(Math.random()*900),120,120);
            layeredPane.add(hold, Integer.valueOf(3));
        }

        JLabel player = new JLabel(playerImage);
        layeredPane.add(player, Integer.valueOf(3));
        player.setBounds(500, 500,50,50);

        JLabel background = new JLabel(backgroundImage);
        layeredPane.add(background, Integer.valueOf(0));
        background.setBounds(0, 0,1440,900);


        //=======================
        JFrame frame = new JFrame("JLayeredPane");
        frame.add(layeredPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1440, 900));
        frame.setLayout(null);
        frame.setVisible(true);
        //================================
        //===== Other Initialization =====
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
              if(e.getKeyCode() == 87){
                  player.setBounds(player.getX(), player.getY()-playerSpeed,50,50);
              }

              if(e.getKeyCode() == 65){
                    player.setBounds(player.getX()-playerSpeed, player.getY(),50,50);
              }

              if(e.getKeyCode() == 83){
                    player.setBounds(player.getX(), player.getY()+playerSpeed,50,50);
              }

              if(e.getKeyCode() == 68){
                    player.setBounds(player.getX()+playerSpeed, player.getY(),50,50);
              }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        //======================
        //===== Game Start =====
        while(true){

            Point cursor = MouseInfo.getPointerInfo().getLocation();

            if(player.getX() <= cursor.getX()){player.setBounds(player.getX()+playerSpeed, player.getY(),120,120);}
            if(player.getX() >= cursor.getX()){player.setBounds(player.getX()-playerSpeed, player.getY(),120,120); }
            if(player.getY() <= cursor.getY()){player.setBounds(player.getX(), player.getY()+playerSpeed,120,120);}
            if(player.getY() >= cursor.getY()){player.setBounds(player.getX(), player.getY()-playerSpeed,120,120); }


            for(JLabel hold: monsters){
                skinChoice = skinChoice*-1;
                if(skinChoice == -1){
                    hold.setIcon(treeAnimation1);
                }
                if(skinChoice == 1){
                    hold.setIcon(treeAnimation2);
                }
                if(hold.getX() <= player.getX()){hold.setBounds(hold.getX()+treeSpeed, hold.getY(),120,120);}
                if(hold.getX() >= player.getX()){hold.setBounds(hold.getX()-treeSpeed, hold.getY(),120,120); }
                if(hold.getY() <= player.getY()){hold.setBounds(hold.getX(), hold.getY()+treeSpeed,120,120);}
                if(hold.getY() >= player.getY()){hold.setBounds(hold.getX(), hold.getY()-treeSpeed,120,120); }
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