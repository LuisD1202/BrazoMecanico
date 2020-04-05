
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
        jArt2.addChangeListener((ChangeListener) getControl());
        jArt3.addChangeListener((ChangeListener) getControl());
        jArt4.addChangeListener((ChangeListener) getControl());
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
        jArt2 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jArt3 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jArt4 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);
        getContentPane().add(lienzo);
        lienzo.setBounds(20, 250, 670, 400);

        jPinza.setMajorTickSpacing(10);
        jPinza.setMinimum(-10);
        jPinza.setOrientation(javax.swing.JSlider.VERTICAL);
        jPinza.setPaintLabels(true);
        jPinza.setPaintTicks(true);
        jPinza.setValue(5);
        jPinza.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPinzaStateChanged(evt);
            }
        });
        getContentPane().add(jPinza);
        jPinza.setBounds(700, 290, 100, 360);

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
        jArt1.setBounds(20, 80, 380, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Articulación 1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 100, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pinzas");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(720, 250, 70, 22);

        jArt2.setMajorTickSpacing(50);
        jArt2.setMaximum(180);
        jArt2.setMinimum(-180);
        jArt2.setMinorTickSpacing(5);
        jArt2.setPaintLabels(true);
        jArt2.setPaintTicks(true);
        jArt2.setToolTipText("");
        jArt2.setValue(0);
        jArt2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jArt2StateChanged(evt);
            }
        });
        getContentPane().add(jArt2);
        jArt2.setBounds(410, 80, 370, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Articulación 2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(410, 60, 100, 17);

        jArt3.setMajorTickSpacing(50);
        jArt3.setMaximum(180);
        jArt3.setMinimum(-180);
        jArt3.setMinorTickSpacing(5);
        jArt3.setPaintLabels(true);
        jArt3.setPaintTicks(true);
        jArt3.setToolTipText("");
        jArt3.setValue(0);
        jArt3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jArt3StateChanged(evt);
            }
        });
        getContentPane().add(jArt3);
        jArt3.setBounds(20, 180, 380, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Articulación 3");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 150, 100, 17);

        jArt4.setMajorTickSpacing(50);
        jArt4.setMaximum(180);
        jArt4.setMinimum(-180);
        jArt4.setMinorTickSpacing(5);
        jArt4.setPaintLabels(true);
        jArt4.setPaintTicks(true);
        jArt4.setToolTipText("");
        jArt4.setValue(0);
        jArt4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jArt4StateChanged(evt);
            }
        });
        getContentPane().add(jArt4);
        jArt4.setBounds(410, 180, 370, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Articulación de la Pinza");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 150, 160, 17);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("Control Brazo Mecanico");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 10, 210, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPinzaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPinzaStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPinzaStateChanged

    private void jArt1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jArt1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jArt1StateChanged

    private void jArt2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jArt2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jArt2StateChanged

    private void jArt3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jArt3StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jArt3StateChanged

    private void jArt4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jArt4StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jArt4StateChanged

  
    public Modelo getModelo() {
        return modelo;
    }
    public JSlider getSliderArt() {
        return jArt1;
    }
    public JSlider getSliderArt2() {
        return jArt2;
    }
    public JSlider getSliderArt3() {
        return jArt3;
    }
    public JSlider getSliderArt4() {
        return jArt4;
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
    private javax.swing.JSlider jArt2;
    private javax.swing.JSlider jArt3;
    private javax.swing.JSlider jArt4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jPinza;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    

    
}
