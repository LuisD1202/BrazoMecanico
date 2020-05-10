
package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controlador {

    private Vista ventana;
    private Modelo modelo;
    
    public Controlador(Vista v) {
        ventana = v;
        modelo = v.getModelo();
    }

   
    
}
