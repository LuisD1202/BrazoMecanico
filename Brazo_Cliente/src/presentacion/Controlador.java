
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controlador implements ActionListener, ChangeListener{

    private Vista ventana;
    private Modelo modelo;
    
    public Controlador(Vista v) {
        ventana = v;
        modelo = v.getModelo();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        try {
            modelo.controlar(e.getSource()); 
            modelo.mlocal= true;
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
     
        try {
            modelo.controlar(e.getSource());
             modelo.mlocal= true;
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
