/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JApplet;

/**
 *
 * @author kevinyamamoto
 */
public class Mario extends JApplet implements Runnable{
    Thread thread;
    /**
     * @param args the command line arguments
     */

    Graphics2D gfx;
    BufferedImage bgd;
    BufferedImage playerimg,imge,goomba;
    Player player;
            
            
    @Override
    public void init(){
        try {
           bgd = ImageIO.read(Mario.class.getResource("img/plain-blue-background.jpg"));
           playerimg = ImageIO.read(Mario.class.getResource("img/Marior.png"));
           goomba = ImageIO.read(Mario.class.getResource("img/goomba.PNG"));
           player = new Player(playerimg, 150,250);
           
           
        } catch (IOException ex) {
            Logger.getLogger(Mario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setSize(900,500);
        setBackground(Color.white);
        setFocusable(true);
        //System.out.println("Hello Worldi")
    }

    @Override
    public void run() {
        Thread game = Thread.currentThread();
        System.out.println("Hello Worldr");
        while(thread == game){
            repaint();
            try{
                thread.sleep(25);
            }   catch(InterruptedException e){
                break;
            }
        }
    }
    
   
    @Override
    public void paint(Graphics g){

      
        if(bgd != null){
           g.drawImage(bgd, 0,0,900,500, this);
        }
        else{
            System.out.println("bgd broke");
        }
        g.setColor(Color.white);
        g.drawString("It's a me, Mario", 100,50);
        player.draw(g,this);
        g.drawImage(goomba, 500,200, 200,200, this);
    }
 
    
    @Override
    public void start(){
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
       
    }
    
    
}

