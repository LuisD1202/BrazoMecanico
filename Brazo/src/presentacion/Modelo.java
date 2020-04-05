package presentacion;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import logica.Brazo;


public class Modelo implements Runnable{
    
    private Vista ventanaInicial;
   
    private Brazo miBrazo;
    private boolean activo;
    private Thread hiloDibujo;

    int w=getBrazo().w;  
    int h=getBrazo().h;
    int gA1=getBrazo().gA1;  
    int gA2=getBrazo().gA2;
    int gA3=getBrazo().gA3;
    int gA4=getBrazo().gA4;
    int gP=getBrazo().gp;
  
    
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
        getVentanaInicial().setSize(820,720);
        getVentanaInicial().setVisible(true);
        hiloDibujo.start();
    }
    
    public void controlar(Object e) throws IOException{ 
     
       // control de eventos de los slider
       if(e == this.ventanaInicial.getSliderArt()){
           gA1=this.getVentanaInicial().getSliderArt().getValue();
           dibujar();
       }else if(e == this.ventanaInicial.getSliderArt2()){
            gA2=this.getVentanaInicial().getSliderArt2().getValue();
           dibujar();
       }
       else if(e == this.ventanaInicial.getSliderArt3()){
            gA3=this.getVentanaInicial().getSliderArt3().getValue();
           dibujar();
       }
       else if(e == this.ventanaInicial.getSliderArt4()){
            gA4=this.getVentanaInicial().getSliderArt4().getValue();
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
        Image Art4 = ImageIO.read(this.getClass().getResource("../src/art5.png"));
        Image pinza1 = ImageIO.read(this.getClass().getResource("../src/pinza1.png"));
        Image pinza2 = ImageIO.read(this.getClass().getResource("../src/pinza2.png"));
           
     
     //Base
        AffineTransform at0= new AffineTransform();
        at0.setToTranslation(250,100); //desplazar el brazo
        ((Graphics2D) lapiz).setTransform(at0);
        lapiz.drawImage(Base, w, h, Base.getWidth(null), Base.getHeight(null), null);
     //Articuación 1              
        AffineTransform at1= new AffineTransform();
        at1.preConcatenate(at0); 
        at1.rotate(Math.toRadians(gA1),w+45,h+30); 
        ((Graphics2D) lapiz).setTransform(at1);
        lapiz.drawImage(Art, w+20,h-100, 50, 150, null);
     //Articuación 2   
         AffineTransform at2 = new AffineTransform();
         at2.preConcatenate(at1); 
         at2.rotate(Math.toRadians(-gA2),w+45,h-80);
        ((Graphics2D) lapiz).setTransform(at2);
         lapiz.drawImage(Art, w+25,h-95, 40, 100, null);  
      //Articuación 3      
        AffineTransform at3 = new AffineTransform();
         at3.preConcatenate(at2); 
         at3.rotate(Math.toRadians(-gA3),w+45,h-5);
        ((Graphics2D) lapiz).setTransform(at3);   
        lapiz.drawImage(Art, w+25,h-20, 40, 100, null);  
      
       //Articuación 4    
         AffineTransform at4 = new AffineTransform();
         at4.preConcatenate(at3); 
         at4.rotate(Math.toRadians(-gA4),w+45,h+65);
        ((Graphics2D) lapiz).setTransform(at4);
        lapiz.drawImage(Art4, w+32,h+60, 30, 40, null);  
            
      //Pinzas   
         AffineTransform at5 = new AffineTransform();
         at5.preConcatenate(at4); 
         at5.rotate(Math.toRadians(gP),w+39,h+95);
        ((Graphics2D) lapiz).setTransform(at5);
         lapiz.drawImage(pinza1, w+24,h+89, 20, 50, null);
          
        AffineTransform at6 = new AffineTransform();
        at6.preConcatenate(at4); 
        at6.rotate(Math.toRadians(-gP),w+52,h+96);
        ((Graphics2D) lapiz).setTransform(at6);
        lapiz.drawImage(pinza2, w+49,h+89, 20, 50, null);

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
