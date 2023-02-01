import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
    JFrame gameScreen = new JFrame();
    gameScreen.setSize(750,750);
    //==================================
    JPanel startMenu = new JPanel();
    startMenu.setBackground(Color.blue);
    //==================================
        JPanel mainGamePanel = new JPanel();
        mainGamePanel.setBackground(Color.green);
        //==================================

        //Adding panels=====================
        gameScreen.add(startMenu);
        //==================================
        startMenu.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getY()>=350 & e.getX()>=125 & e.getX()<=625){
                    System.out.println("Game started");
                    startMenu.setVisible(false);
                    gameScreen.add(mainGamePanel);
                }
                else{
                    System.out.println("Game not started");
                }

            }
        });

    gameScreen.setVisible(true);
    }
}