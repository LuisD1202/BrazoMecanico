
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
       
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lienzo = new java.awt.Canvas();
        jLabel7 = new javax.swing.JLabel();
        lArticulacion1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lArticulacion2 = new javax.swing.JLabel();
        lArticulacion3 = new javax.swing.JLabel();
        lArtPinza = new javax.swing.JLabel();
        lPinza = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);
        getContentPane().add(lienzo);
        lienzo.setBounds(0, 0, 670, 420);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Articulación 1: ");
        jLabel7.setMaximumSize(new java.awt.Dimension(93, 17));
        jLabel7.setMinimumSize(new java.awt.Dimension(93, 17));
        jLabel7.setPreferredSize(new java.awt.Dimension(93, 17));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(700, 30, 110, 20);

        lArticulacion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lArticulacion1);
        lArticulacion1.setBounds(820, 30, 160, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Articulación 2: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(700, 90, 110, 17);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Articulación 3: ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(700, 140, 110, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Pinza: ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(700, 190, 100, 20);

        lArticulacion2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lArticulacion2);
        lArticulacion2.setBounds(820, 90, 160, 20);

        lArticulacion3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lArticulacion3);
        lArticulacion3.setBounds(820, 140, 170, 20);

        lArtPinza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lArtPinza);
        lArtPinza.setBounds(820, 190, 180, 20);

        lPinza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(lPinza);
        lPinza.setBounds(1080, 440, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public Modelo getModelo() {
        return modelo;
    }
    
    public Canvas getLienzo() {
        return lienzo;
    }

    public JLabel getLArt1(){
        return lArticulacion1;
    }
    
    public JLabel getLArt2(){
        return lArticulacion2;
    }
    
    public JLabel getLArt3(){
        return lArticulacion3;
    }
    
    public JLabel getLArtPinza(){
        return lArtPinza;
    }
    
    public JLabel getLPinza(){
        return lPinza;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lArtPinza;
    private javax.swing.JLabel lArticulacion1;
    private javax.swing.JLabel lArticulacion2;
    private javax.swing.JLabel lArticulacion3;
    private javax.swing.JLabel lPinza;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    

    
}
