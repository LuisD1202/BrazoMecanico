/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Oswaldo
 */
public class Brazo {
    private int x, y, r;
    private int w, h; 
    private int gEje0; 
    boolean ix, iy;
     


    public Brazo() {
        w = 30;
        h = 200;
        gEje0 =10;
    }
    public int Movimiento(boolean direc){
    
      if(direc==true){
      gEje0=gEje0-10;
      }else {
      gEje0=gEje0+10;
      }
       return gEje0;
    }
    public void drawBase(Graphics2D lapiz,int g) throws IOException{
     
          Image Base = ImageIO.read(this.getClass().getResource("../src/Base.png"));
        
          Image Art = ImageIO.read(this.getClass().getResource("../src/art1.png"));
          
          double r = Math.toRadians(g); //se convierte a radianes lo grados
       
        lapiz.drawImage(Base, 30, 200, Base.getWidth(null), Base.getHeight(null), null);
                     
        AffineTransform at1 = new AffineTransform();
         at1.rotate(0,75,230); //se asigna
        ((Graphics2D) lapiz).setTransform(at1);
          lapiz.drawImage(Art, w+20,h-100, 50, 150, null);
          
       AffineTransform at2 = new AffineTransform();
         at2.preConcatenate(at1); //se asigna
         at2.rotate(-1,73,125);
        ((Graphics2D) lapiz).setTransform(at2);
        
         lapiz.drawImage(Art, w+30,h-90, 40, 100, null);  
         
        AffineTransform at3 = new AffineTransform();
         at3.preConcatenate(at2); //se asigna
         at3.rotate(r,85,200);
        ((Graphics2D) lapiz).setTransform(at3);
        
        lapiz.drawImage(Art, w+35,h-15, 40, 100, null);  
    }
//    public void drawArt1(Graphics2D lapiz, int g){
//     
//        double r = Math.toRadians(g); //se convierte a radianes lo grados
// 
//        AffineTransform at = new AffineTransform();
//        at.preConcatenate(at); //se asigna
//        ((Graphics2D) lapiz).setTransform(at);
//        
//        lapiz.setColor(Color.red);
//        lapiz.fillRect(111, 205, 10, 50);
//          
//     
//        
//    }
       
}
