
package logica;

import java.util.Observable;


public class MensajesGrados extends Observable{

    private String mensaje;
    
    public MensajesGrados(){
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
       
        this.setChanged();
       
        this.notifyObservers(this.getMensaje());
    }
}