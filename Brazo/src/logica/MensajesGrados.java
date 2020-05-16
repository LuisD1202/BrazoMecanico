
package logica;

import java.util.Observable;


public class MensajesGrados extends Observable{

    private String mensaje;
     private String idSocket;

   
    public MensajesGrados(){
    }

    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mensaje,String idSocket){
        this.mensaje = mensaje+"&"+idSocket;
     
        this.setChanged();
       
        this.notifyObservers(this.getMensaje());
         
    }
}