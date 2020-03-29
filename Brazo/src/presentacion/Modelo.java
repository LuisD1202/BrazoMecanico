package presentacion;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.ControlMovimiento;
import logica.Brazo;


public class Modelo {
    
    private Vista ventanaInicial;
    private ControlMovimiento miSistema;
    private Brazo miBrazo;
    private boolean activo;
    private Thread hiloDibujo;

   
    
    public Vista getVentanaInicial() {
        if(ventanaInicial == null){
            ventanaInicial = new Vista(this);
        }
        return ventanaInicial;
    }

    public ControlMovimiento getMiSistema() {
        if(miSistema == null){
            miSistema = new ControlMovimiento();
        }
        return miSistema;
    }

   public Brazo getBrazo() {
        if(miBrazo == null){
            miBrazo = new Brazo();
        }
        return miBrazo;
    }
    
    
    public void iniciar(){
        getVentanaInicial().setSize(800, 400);
        getVentanaInicial().setVisible(true);
        hiloDibujo.start();
    }
    
    public void controlar(Object e){ // Representa un requerimiento funcional
      int g=0;
         if(e ==this.ventanaInicial.getbtnArt1add()){
          
         
          g= getBrazo().Movimiento(true);
         dibujar(g);
         }if(e ==this.ventanaInicial.getbtnArt1sus()){
      
          g= getBrazo().Movimiento(false);
          dibujar(g);
         }else{
         
         }
       
    }

    private void dibujar(int g) {
        Canvas lienzo = getVentanaInicial().getLienzo();
        Graphics2D lapiz = (Graphics2D) lienzo.getGraphics();
       lienzo.paint(lapiz);
  
        
        getMiSistema().getBrazo().drawBase(lapiz,g);
     
       //  getMiSistema().getBrazo().drawArt1(lapiz,0);
         
        
    }
    

}
