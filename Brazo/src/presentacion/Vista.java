
package presentacion;

import java.awt.Canvas;
import javax.swing.*;


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
        btnArt1sus.addActionListener(getControl());
        btnArt1add.addActionListener(getControl());
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnArt1sus = new javax.swing.JButton();
        lienzo = new java.awt.Canvas();
        btnArt1add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnArt2sus = new javax.swing.JButton();
        btnArt2add = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnArt1sus.setBackground(new java.awt.Color(204, 204, 255));
        btnArt1sus.setText("<");
        btnArt1sus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArt1susActionPerformed(evt);
            }
        });
        getContentPane().add(btnArt1sus);
        btnArt1sus.setBounds(120, 20, 50, 40);
        getContentPane().add(lienzo);
        lienzo.setBounds(440, 20, 290, 290);

        btnArt1add.setBackground(new java.awt.Color(204, 204, 255));
        btnArt1add.setText(">");
        btnArt1add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArt1addActionPerformed(evt);
            }
        });
        getContentPane().add(btnArt1add);
        btnArt1add.setBounds(170, 20, 50, 40);

        jLabel1.setText("base");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 60, 30);

        btnArt2sus.setBackground(new java.awt.Color(204, 204, 255));
        btnArt2sus.setText("<");
        btnArt2sus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArt2susActionPerformed(evt);
            }
        });
        getContentPane().add(btnArt2sus);
        btnArt2sus.setBounds(120, 70, 50, 40);

        btnArt2add.setBackground(new java.awt.Color(204, 204, 255));
        btnArt2add.setText(">");
        btnArt2add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArt2addActionPerformed(evt);
            }
        });
        getContentPane().add(btnArt2add);
        btnArt2add.setBounds(170, 70, 50, 40);

        jLabel3.setText("Eje 1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 70, 60, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArt1susActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArt1susActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArt1susActionPerformed

    private void btnArt1addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArt1addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArt1addActionPerformed

    private void btnArt2susActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArt2susActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArt2susActionPerformed

    private void btnArt2addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArt2addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArt2addActionPerformed

   public JButton getbtnArt1add() {
       
        return btnArt1add;
    }
      public JButton getbtnArt1sus() {
       
        return btnArt1sus;
    }
    public Modelo getModelo() {
        return modelo;
    }

  

   
    public Canvas getLienzo() {
        return lienzo;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArt1add;
    private javax.swing.JButton btnArt1sus;
    private javax.swing.JButton btnArt2add;
    private javax.swing.JButton btnArt2sus;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private java.awt.Canvas lienzo;
    // End of variables declaration//GEN-END:variables

    

    
}
