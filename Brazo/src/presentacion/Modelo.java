package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JSlider;

import logica.Brazo;
import logica.ControlMovimiento;


public class Modelo implements Runnable{
    
    private Vista ventanaInicial;
   
    private Brazo miBrazo;
    private boolean activo;
    private Thread hiloDibujo;

    int w=getBrazo().getW();  
    int h=getBrazo().getH();
    int gA1=getBrazo().getgA1();  
    int gA2=getBrazo().getgA2();
    int gA3=getBrazo().getgA3();
    int gA4=getBrazo().getgA4();
    int gP=getBrazo().getGp();
    int basex = w+40;
    int basey = h+28;
    int art1x = w+40;
    int art1y = h-80;
    int art2x = w+120;
    int art2y = h-73;
    int art3x = w+124;
    int art3y = h;
    int art4x = w+123;
    int art4y = h+65;
    int ma1x1, ma1y1; 
    int ma2x1, ma2y1;
    int ma3x1, ma3y1;    
    int ma4x1, ma4y1;    
    int ma2x2, ma2y2; 
    int ma3x2, ma3y2;
    int ma4x2, ma4y2;
    int ma3x3, ma3y3;
    int ma4x3, ma4y3;
    int ma4x4, ma4y4;
      
    JLabel arti1 = getVentanaInicial().getLArt1();
    JLabel arti2 = getVentanaInicial().getLArt2();
    JLabel arti3 = getVentanaInicial().getLArt3();
    JLabel artiPinza = getVentanaInicial().getLArtPinza();
    JLabel pinzaL = getVentanaInicial().getLPinza();

    ControlMovimiento mart1 = new ControlMovimiento();
    ControlMovimiento mart2 = new ControlMovimiento();
    ControlMovimiento mart3 = new ControlMovimiento();
    ControlMovimiento mart4 = new ControlMovimiento();
          
   public Modelo() {
        activo = true;
        hiloDibujo = new Thread(this);
    }
   
   public Vista getVentanaInicial() {
        if(ventanaInicial == null){
            ventanaInicial = new Vista(this);
        }
        return ventanaInicial;
    }

   public Brazo getBrazo() {
        if(miBrazo == null){
            miBrazo = new Brazo();
        }
        return miBrazo;
    }
    
   public void iniciar(){
        getVentanaInicial().setSize(1200,720);
        getVentanaInicial().setVisible(true);
        hiloDibujo.start();
    }
    
   public void controlar(Object e) throws IOException{ 
       
    
       // control de eventos de los slider
       if(e == this.ventanaInicial.getSliderArt()){
           gA1=this.getVentanaInicial().getSliderArt().getValue();
          
           
     ma1x1=((int) ((basex + (art1x-basex) * Math.cos(Math.toRadians(gA1))) - ((art1y-basey)* Math.sin(Math.toRadians(gA1)))));
     ma1y1=((int) ((basey + (art1x-basex) * Math.sin(Math.toRadians(gA1))) + ((art1y-basey)* Math.cos(Math.toRadians(gA1)))));
      
      mart1.setX(ma1x1);
      mart1.setY(ma1y1);
      
     ma2x1=((int) ((basex + (art2x-basex) * Math.cos(Math.toRadians(gA1))) - ((art2y-basey)* Math.sin(Math.toRadians(gA1)))));
     ma2y1=((int) ((basey+ (art2x-basex) * Math.sin(Math.toRadians(gA1))) + ((art2y-basey)* Math.cos(Math.toRadians(gA1)))));
      
      mart2.setX(ma2x1);
      mart2.setY(ma2y1);
     ma3x1=((int) ((basex + (art3x-basex) * Math.cos(Math.toRadians(gA1))) - ((art3y-basey)* Math.sin(Math.toRadians(gA1)))));
     ma3y1=((int) ((basey+ (art3x-basex) * Math.sin(Math.toRadians(gA1))) + ((art3y-basey)* Math.cos(Math.toRadians(gA1))))); 
       
        mart3.setX(ma3x1);
        mart3.setY(ma3y1);
        
     ma4x1=((int) ((basex + (art4x-basex) * Math.cos(Math.toRadians(gA1))) - ((art4y-basey)* Math.sin(Math.toRadians(gA1)))));
     ma4y1=((int) ((basey+ (art4x-basex) * Math.sin(Math.toRadians(gA1))) + ((art4y-basey)* Math.cos(Math.toRadians(gA1)))));   
     
        mart4.setX(ma4x1);
        mart4.setY(ma4y1);
           dibujar();
           
  
       }else if(e == this.ventanaInicial.getSliderArt2()){
               
            gA2=this.getVentanaInicial().getSliderArt2().getValue();
      ma2x2 = (int) ((ma1x1 + (ma2x1-ma1x1) * Math.cos(Math.toRadians(-gA2))) - ((ma2y1-ma1y1)* Math.sin(Math.toRadians(-gA2))));
      ma2y2= (int) ((ma1y1+ (ma2x1-ma1x1) * Math.sin(Math.toRadians(-gA2))) + ((ma2y1-ma1y1)* Math.cos(Math.toRadians(-gA2))));
      
        mart2.setX(ma2x2);
        mart2.setY(ma2y2);
      
      ma3x2 =((int) ((ma1x1 + (ma3x1-ma1x1) * Math.cos(Math.toRadians(-gA2))) - ((ma3y1-ma1y1)* Math.sin(Math.toRadians(-gA2)))));
      ma3y2=((int) ((ma1y1+ (ma3x1-ma1x1) * Math.sin(Math.toRadians(-gA2))) + ((ma3y1-ma1y1)* Math.cos(Math.toRadians(-gA2)))));   
      
        mart3.setX(ma3x2);
        mart3.setY(ma3y2);
        
      ma4x2=((int) ((ma1x1+ (ma4x1-ma1x1) * Math.cos(Math.toRadians(-gA2))) - ((ma4y1-ma1y1)* Math.sin(Math.toRadians(-gA2)))));
      ma4y2=((int) ((ma1y1+ (ma4x1-ma1x1) * Math.sin(Math.toRadians(-gA2))) + ((ma4y1-ma1y1)* Math.cos(Math.toRadians(-gA2)))));    
       
        mart4.setX(ma4x2);
        mart4.setY(ma4y2);
      
      dibujar();
       }
       else if(e == this.ventanaInicial.getSliderArt3()){
            gA3=this.getVentanaInicial().getSliderArt3().getValue();
        
      ma3x3 =((int) ((ma2x2 + (ma3x2-ma2x2) * Math.cos(Math.toRadians(-gA3))) - ((ma3y2-ma2y2)* Math.sin(Math.toRadians(-gA3)))));
      ma3y3=((int) ((ma2y2+ (ma3x2-ma2x2) * Math.sin(Math.toRadians(-gA3))) + ((ma3y2-ma2y2)* Math.cos(Math.toRadians(-gA3)))));   
      
        mart3.setX(ma3x3);
        mart3.setY(ma3y3);
      
      ma4x3=((int) ((ma2x2+ (ma4x2-ma2x2) * Math.cos(Math.toRadians(-gA3))) - ((ma4y2-ma2y2)* Math.sin(Math.toRadians(-gA3)))));
      ma4y3=((int) ((ma2y2+ (ma4x2-ma2x2) * Math.sin(Math.toRadians(-gA3))) + ((ma4y2-ma2y2)* Math.cos(Math.toRadians(-gA3)))));    
      
        mart4.setX(ma4x3);
        mart4.setY(ma4y3);
      
      dibujar();
       }
       else if(e == this.ventanaInicial.getSliderArt4()){
            gA4=this.getVentanaInicial().getSliderArt4().getValue();
            
      ma4x4=((int) ((ma3x3+ (ma4x3-ma3x3) * Math.cos(Math.toRadians(-gA4))) - ((ma4y3-ma3y3)* Math.sin(Math.toRadians(-gA4)))));
      ma4y4=((int) ((ma3y3+ (ma4x3-ma3x3) * Math.sin(Math.toRadians(-gA4))) + ((ma4y3-ma3y3)* Math.cos(Math.toRadians(-gA4)))));    
          
        mart4.setX(ma4x4);
        mart4.setY(ma4y4); 
      
      dibujar();
       }
       else if(e == this.ventanaInicial.getSliderPinza()){
            gP=this.getVentanaInicial().getSliderPinza().getValue();
            dibujar();
       }
    }

   private void dibujar() throws IOException {
 
        Canvas papel = getVentanaInicial().getLienzo();
        
        Graphics lienzo = papel.getGraphics();
        BufferedImage dobleBuffer = new BufferedImage(papel.getWidth(), papel.getHeight(), BufferedImage.TYPE_INT_RGB); 
        Graphics lapiz = dobleBuffer.getGraphics();
        lapiz.clearRect(0, 0, papel.getWidth(), papel.getHeight());

        Image Base = ImageIO.read(this.getClass().getResource("../src/Base.png"));
        Image Art = ImageIO.read(this.getClass().getResource("../src/art1.png"));
        Image Art2 = ImageIO.read(this.getClass().getResource("../src/art2.png"));
        Image Art4 = ImageIO.read(this.getClass().getResource("../src/art5.png"));
        Image pinza1 = ImageIO.read(this.getClass().getResource("../src/pinza1.png"));
        Image pinza2 = ImageIO.read(this.getClass().getResource("../src/pinza2.png"));
        
      
         arti1.setText(String.valueOf(mart1.getX()) + "," + String.valueOf(mart1.getY()) + "  " + gA1+"°");
         arti2.setText(String.valueOf(mart2.getX()) + "," + String.valueOf(mart1.getY()) + "  " + gA2+"°");
         arti3.setText(String.valueOf(mart3.getX()) + "," + String.valueOf(mart3.getY()) + "  " + gA3+"°");
         artiPinza.setText(String.valueOf(mart4.getX()) + "," + String.valueOf(mart4.getY()) + "  " + gA4+"°");
     //Base
        AffineTransform at0= new AffineTransform();
        at0.setToTranslation(0,0); //desplazar el brazo
        ((Graphics2D) lapiz).setTransform(at0);
        lapiz.drawImage(Base, w, h, Base.getWidth(null), Base.getHeight(null), null);
     //Articuación 1    

        AffineTransform at1= new AffineTransform();
        at1.preConcatenate(at0); 
   
        at1.rotate(Math.toRadians(gA1),w+40,h+28);
        ((Graphics2D) lapiz).setTransform(at1);
        lapiz.drawImage(Art, w+20,h-95, 50, 150, null);

     //Articuación 2   
         AffineTransform at2 = new AffineTransform();
        
     
          at2.preConcatenate(at1); 
         at2.rotate(Math.toRadians(-gA2),w+44,h-74);
        ((Graphics2D) lapiz).setTransform(at2);
         lapiz.drawImage(Art2, w+26,h-90, 100, 40, null);  

         //Articuación 3      
        AffineTransform at3 = new AffineTransform();
        at3.preConcatenate(at2);
        at3.rotate(Math.toRadians(-gA3),w+120,h-73);
        ((Graphics2D) lapiz).setTransform(at3);   
        lapiz.drawImage(Art, w+100,h-85, 40, 100, null);       

       //Articuación 4    
         AffineTransform at4 = new AffineTransform();
         at4.preConcatenate(at3); 
         at4.rotate(Math.toRadians(-gA4),w+124,h);
        ((Graphics2D) lapiz).setTransform(at4);
        lapiz.drawImage(Art4, w+110,h-5, 30, 40, null);  
                
      //Pinzas   
         AffineTransform at5 = new AffineTransform();
         at5.preConcatenate(at4); 
         at5.rotate(Math.toRadians(gP),w+115,h+31);
        ((Graphics2D) lapiz).setTransform(at5);
         lapiz.drawImage(pinza1, w+100,h+25, 20, 50, null);
          
        AffineTransform at6 = new AffineTransform();
        at6.preConcatenate(at4); 
        at6.rotate(Math.toRadians(-gP),w+127,h+32);
        ((Graphics2D) lapiz).setTransform(at6);
        lapiz.drawImage(pinza2, w+125,h+25, 20, 50, null);
        
        AffineTransform at7 = new AffineTransform();
        ((Graphics2D) lapiz).setTransform(at7);
        
        
        lienzo.drawImage(dobleBuffer, 0, 0, papel);       
    }

    @Override
    public void run() {
         while(activo){            
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {                
            }
             try {
                 
                 dibujar();
             } catch (IOException ex) {
                 Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
         
      
  
    

}
