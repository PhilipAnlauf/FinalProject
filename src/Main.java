import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {

    public static void main(String[] args) {
        //Initializing images and misc.
        ImageIcon treeImage = new ImageIcon("tree.png");
        treeImage.setImage(treeImage.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT));

        ImageIcon rockImage = new ImageIcon("rock.png");
        rockImage.setImage(rockImage.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));

        ImageIcon treeAnimation1 = new ImageIcon("treeAnimation1.png");
        treeAnimation1.setImage(treeAnimation1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
        ImageIcon treeAnimation2 = new ImageIcon("treeAnimation2.png");
        treeAnimation2.setImage(treeAnimation2.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));

        ImageIcon playerImage = new ImageIcon("treeAnimation1.png");
        playerImage.setImage(playerImage.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));

        ImageIcon backgroundImage = new ImageIcon("background.png");
        backgroundImage.setImage(backgroundImage.getImage().getScaledInstance(1440,900,Image.SCALE_DEFAULT));

        ImageIcon axeImage = new ImageIcon("axe.png");
        axeImage.setImage(axeImage.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setSize(1440,900);


        //============================================
        //=========== General Game Values ============
        int rockCount = 30;
        int treeCount = 23;

        int playerSpeed = 35;

        int maxCreatures = 0;
        int creatureHealth = 30;

        Variables treeSpeed = new Variables();

        int skinChoice = 1;

        int axeHealth = 4; //# of hits before breaking
        int axeDamage = 10; //Damage per axe hit
        int sharpenerSpawnRate = 20; //Amount of cycles before new axe sharpener spawn

        int gameInterval = 75; //in milliseconds

        int dontWorryAboutIt = 0;

        int maxAxes = 99999;

        Variables playerDirection = new Variables();

        //============================================
        //Adding Sprites

        ArrayList<JLabel> rocks = new ArrayList<>();
        ArrayList<JLabel> trees = new ArrayList<>();
        ArrayList<JLabel> monsters = new ArrayList<>();
        ArrayList<JLabel> axes = new ArrayList<>();

        axeCoords[] axeC = new axeCoords[maxAxes];

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
            layeredPane.add(hold, Integer.valueOf(2));
        }

        JLabel player = new JLabel(playerImage);
        layeredPane.add(player, Integer.valueOf(3));
        player.setBounds(500, 500,50,50);

        int testing = 4;

        trees.add(new JLabel(treeImage));
        for(int i = 1; i<treeCount; i++){
            trees.add(new JLabel(treeImage));
            for(int i2 = 0; i2<trees.size(); i2++){
                if((trees.get(i).getX() <= trees.get(i2).getX()+200) && (trees.get(i).getY() <= trees.get(i2).getY()+200)){
                    trees.get(i).setBounds((int)(Math.random()*1350),(int)(Math.random()*850),160,160);
                }
            }
            layeredPane.add(trees.get(i), Integer.valueOf(testing));
            testing++;
        }


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
                //System.out.println(e.getKeyCode());
                    if(e.getKeyCode() ==  65){
                        playerDirection.setLeft(true);
                    }
                    if(e.getKeyCode() ==  68){
                        playerDirection.setRight(true);
                    }
                    if(e.getKeyCode() ==  87){
                        playerDirection.setUp(true);
                    }
                    if(e.getKeyCode() ==  83){
                        playerDirection.setDown(true);
                    }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==32 && (axes.size()<maxAxes)){
                    axes.add(new JLabel(axeImage));
                    layeredPane.add(axes.get(axes.size()-1), Integer.valueOf(3));
                    axes.get(axes.size()-1).setBounds(player.getX()+25,player.getY()+25,40,40);
                    axeC[axes.size()-1] = new axeCoords( (int)MouseInfo.getPointerInfo().getLocation().getX(), (int)MouseInfo.getPointerInfo().getLocation().getY());
                }
                if(e.getKeyCode() ==  65){
                    playerDirection.setLeft(false);
                }
                if(e.getKeyCode() ==  68){
                    playerDirection.setRight(false);
                }
                if(e.getKeyCode() ==  87){
                    playerDirection.setUp(false);
                }
                if(e.getKeyCode() ==  83){
                    playerDirection.setDown(false);
                }
            }
        });

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                super.mousePressed(e);
                for(int i  = 0; i<trees.size(); i++){
                    if(player.getX() >= trees.get(i).getX()-50 && player.getX() <= trees.get(i).getX()+50){
                        if(player.getY() >= trees.get(i).getY()-50 && player.getY() <= trees.get(i).getY()+50){
                            trees.get(i).setBounds(5000,5000,160,160);

                            monsters.add(new JLabel(treeAnimation1));
                            monsters.get(monsters.size()-1).setBounds((int)(Math.random()*1440),-200,60,60);
                            layeredPane.add(monsters.get(monsters.size()-1), Integer.valueOf(2));

                            break;
                        }
                    }
                }
            }
        });


        //======================
        //===== Game Start =====
        while(true){



            if(playerDirection.getLeft() == true){
                player.setBounds(player.getX()-25, player.getY(), 50,50);
            }
            if(playerDirection.getRight() == true){
                player.setBounds(player.getX()+25, player.getY(), 50,50);
            }
            if(playerDirection.getUp() == true){
                player.setBounds(player.getX(), player.getY()-25, 50,50);
            }
            if(playerDirection.getDown() == true){
                player.setBounds(player.getX(), player.getY()+25, 50,50);
            }


            Point cursor = MouseInfo.getPointerInfo().getLocation();


            //if(player.getX()+50 <= cursor.getX()){player.setBounds(player.getX()+playerSpeed, player.getY(),120,120);}
            //if(player.getX()+50 >= cursor.getX()){player.setBounds(player.getX()-playerSpeed, player.getY(),120,120); }
            //if(player.getY()+75 <= cursor.getY()){player.setBounds(player.getX(), player.getY()+playerSpeed,120,120);}
            //if(player.getY()+75 >= cursor.getY()){player.setBounds(player.getX(), player.getY()-playerSpeed,120,120); }


            for(int i = dontWorryAboutIt; i<monsters.size();i++){
                skinChoice = skinChoice*-1;
            if(skinChoice == -1){
                monsters.get(i).setIcon(treeAnimation1);
            }
            if(skinChoice == 1){
                monsters.get(i).setIcon(treeAnimation2);
            }
            if(monsters.get(i).getX() <= player.getX()){monsters.get(i).setBounds((int)(monsters.get(i).getX()+treeSpeed.getTreeSpeed()), monsters.get(i).getY(),120,120);}
            if(monsters.get(i).getX() >= player.getX()){monsters.get(i).setBounds((int)(monsters.get(i).getX()-treeSpeed.getTreeSpeed()), monsters.get(i).getY(),120,120); }
            if(monsters.get(i).getY() <= player.getY()){monsters.get(i).setBounds(monsters.get(i).getX(), (int)(monsters.get(i).getY()+treeSpeed.getTreeSpeed()),120,120);}
            if(monsters.get(i).getY() >= player.getY()){monsters.get(i).setBounds(monsters.get(i).getX(), (int)(monsters.get(i).getY()-treeSpeed.getTreeSpeed()),120,120);}

            if(monsters.get(i).getX()<= player.getX()+25 && monsters.get(i).getX()+120 >= player.getX()+25){
                if(monsters.get(i).getY() <= player.getY()+25 && monsters.get(i).getY()+120 >= player.getY()+25){
                    playerSpeed = 0;
                    treeSpeed.setSpeed(0);
                    player.setBounds(5000,5000, 0, 0);
                }
            }

            if(axes.size()>0){
                for(int a = 0; a<axes.size(); a++){
                    if(monsters.get(i).getX() <= axes.get(a).getX()+20 && monsters.get(i).getX()+60 >= axes.get(a).getX()+20){
                        if(monsters.get(i).getY() <= axes.get(a).getY()+20 && monsters.get(i).getY()+60 >= axes.get(a).getY()+20){
                            //System.out.println(treeSpeed.getTreeSpeed());
                            treeSpeed.increaseSpeed();
                            axeC[a] = new axeCoords(5000,5000);
                            axes.get(a).setBounds(5000,5000,0,0);
                            monsters.get(i).setIcon(rockImage);
                            monsters.remove(i);
                            axes.get(a).setBounds(5000,5000,0,0);
                            break;
                        }
                    }
                }
            }



            }
            dontWorryAboutIt = 0;

            if(axes.size() > 0){
                for(int i = 0; i<axes.size(); i++){
                    axeCoords hold = new axeCoords(axes.get(i).getX(), axes.get(i).getY());
                    if(axes.get(i).getX() < axeC[i].getX()){
                        axes.get(i).setBounds(axes.get(i).getX()+playerSpeed, axes.get(i).getY(), 40, 40);
                    }
                    if(axes.get(i).getY() < axeC[i].getY()-50){
                        axes.get(i).setBounds(axes.get(i).getX(), axes.get(i).getY()+playerSpeed, 40, 40);
                    }

                    if(axes.get(i).getX() > axeC[i].getX()){
                        axes.get(i).setBounds(axes.get(i).getX()-playerSpeed, axes.get(i).getY(), 40, 40);
                    }
                    if(axes.get(i).getY() > axeC[i].getY()-50){
                        axes.get(i).setBounds(axes.get(i).getX(), axes.get(i).getY()-playerSpeed, 40, 40);
                    }
                    axeCoords hold2 = new axeCoords(axes.get(i).getX(), axes.get(i).getY());
                    if(hold.getX() == hold2.getX() && hold2.getY() == hold2.getY()){
                        axeC[i] = new axeCoords(5000,5000);
                        axes.get(i).setBounds(5000,5000,0,0);
                    }
                }
            }

            /*for(int i  = 0; i<trees.size(); i++){
                if(player.getX() >= trees.get(i).getX()-50 && player.getX() <= trees.get(i).getX()+50){
                    if(player.getY() >= trees.get(i).getY()-50 && player.getY() <= trees.get(i).getY()+50){
                        trees.get(i).setBounds(5000,5000,160,160);
                    }
                }
            }*/

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