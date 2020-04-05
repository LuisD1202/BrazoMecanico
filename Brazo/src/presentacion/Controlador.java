
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements ActionListener{

    private Vista ventana;
    private Modelo modelo;
    
    public Controlador(Vista v) {
        ventana = v;
        modelo = v.getModelo();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        try {
            modelo.controlar(e.getSource()); // Redireccionamos el evento causado por la vista a la funcionalidad del modelo
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
