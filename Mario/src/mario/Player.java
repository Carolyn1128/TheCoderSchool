/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kevinyamamoto
 */
public class Player extends ObjPos implements Observer {
    BufferedImage img;
    int x,y;
    public Player(BufferedImage img, int x, int y) {
        super(img, x, y);
        this.img = img;
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw (Graphics w, ImageObserver obs){
        System.out.println(x+"and"+y);
        w.drawImage(img, x, y, obs);
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
