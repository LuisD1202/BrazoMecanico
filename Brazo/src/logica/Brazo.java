/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.Random;

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
        w = 100;
        h = 100;
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
    public void drawBase(Graphics2D lapiz,int g){
      
        
        double r = Math.toRadians(g); //se convierte a radianes lo grados
        AffineTransform at = new AffineTransform();
        at.rotate(r, 100, 200); //se asigna
        ((Graphics2D) lapiz).setTransform(at);
        lapiz.setColor(Color.GRAY);
        lapiz.fillRect(100, 200, 20, 60);
        
       
        at.preConcatenate(at); //se asigna
        at.rotate(10, 111, 205);
        ((Graphics2D) lapiz).setTransform(at);
        
        lapiz.setColor(Color.red);
        lapiz.fillRect(111, 205, 10, 50);
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
