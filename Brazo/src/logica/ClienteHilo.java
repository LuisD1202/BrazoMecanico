
package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Brazo;
import presentacion.Modelo;

public class ClienteHilo extends Thread implements Observer{

    private Socket host;
    private DataOutputStream datosSalida;
    private DataInputStream datosEntrada;
    private MensajesGrados mensajes;
    public static int NUM_CLIENTES = 0;
    private int clienteNo;
    
    private Brazo miBrazo;

   
    public ClienteHilo(Socket c,MensajesGrados mensajes) {
        host = c;
        NUM_CLIENTES++;
        clienteNo = NUM_CLIENTES;
        this.mensajes = mensajes;
        try {
            datosEntrada = new DataInputStream(host.getInputStream());
            datosSalida = new DataOutputStream(host.getOutputStream());
        } catch (IOException ex) {
            
        }
    }
     public Brazo getBrazo() {
        if(miBrazo == null){
            miBrazo = new Brazo();
        }
        return miBrazo;
    }
       
    @Override
    public void run() {
        String mensajeRecibido;
          boolean conectado = true;
        String mensaje = "Hola "+ clienteNo + "!";
        
        mensajes.addObserver(this);
        
        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = datosEntrada.readUTF();
             
                mensajes.setMensaje(mensajeRecibido);
                System.out.println("Cliente"+clienteNo+": "+mensajeRecibido);
              
                
                
            } catch (IOException ex) {
             
                conectado = false; 
         
                try {
                    datosEntrada.close();
                    datosSalida.close();
                } catch (IOException ex2) {
              
                }
            }
        }     
        
    }

    @Override
    public void update(Observable o, Object o1) {
         try {
   
            datosSalida.writeUTF(o1.toString());
        } catch (IOException ex) {
           
        }
    }
    
    
    
    
}
