
package presentacion;

import java.awt.Canvas;
import javax.swing.*;
import javax.swing.event.ChangeListener;


public class Vista extends javax.swing.JFrame {

    private Controlador control;
    private Modelo modelo;
    
    public Vista(Modelo m) {
        modelo = m;
        initComponents();
        asignarEventos();
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    private void asignarEventos() {
        
        jArt1.addChangeListener((ChangeListener) getControl());
        jPinza.addChangeListener((ChangeListener) getControl());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lienzo = new java.awt.Canvas();
        jPinza = new javax.swing.JSlider();
        jArt1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(lienzo);
        lienzo.setBounds(300, 10, 450, 430);

        jPinza.setMajorTickSpacing(10);
        jPinza.setMinimum(-10);
        jPinza.setPaintLabels(true);
        jPinza.setPaintTicks(true);
        jPinza.setValue(5);
        jPinza.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPinzaStateChanged(evt);
            }
        });
        getContentPane().add(jPinza);
        jPinza.setBounds(30, 140, 240, 50);

        jArt1.setMajorTickSpacing(50);
        jArt1.setMaximum(180);
        jArt1.setMinimum(-180);
        jArt1.setMinorTickSpacing(5);
        jArt1.setPaintLabels(true);
        jArt1.setPaintTicks(true);
        jArt1.setToolTipText("");
        jArt1.setValue(0);
        jArt1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jArt1StateChanged(evt);
            }
        });
        getContentPane().add(jArt1);
        jArt1.setBounds(30, 50, 240, 50);

        jLabel2.setText("Articulación 1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 30, 80, 14);

        jLabel4.setText("Pinzas");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 120, 120, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPinzaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPinzaStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPinzaStateChanged

    private void jArt1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jArt1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jArt1StateChanged

  
    public Modelo getModelo() {
        return modelo;
    }

    public JSlider getSliderArt() {
       
        return jArt1;
    }
    public JSlider getSliderPinza() {
       
        return jPinza;
    }
   
    public Canvas getLienzo() {
        return lienzo;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSlider jArt1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jPinza;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    

    
}
