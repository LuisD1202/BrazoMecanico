
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
    private Modelo modelo;
    private Brazo miBrazo;

   
    public ClienteHilo(Socket c,MensajesGrados mensajes,Modelo modelo) {
        host = c;
        NUM_CLIENTES++;
        clienteNo = NUM_CLIENTES;
        this.mensajes = mensajes;
        this.modelo = modelo;
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
        //String mensaje = "Hola "+ clienteNo + "!";
           System.out.println("Cleinte Conectado: "+host.getRemoteSocketAddress());
        mensajes.addObserver(this);
        
        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                    
                mensajeRecibido = datosEntrada.readUTF();
             
                mensajes.setMensaje(mensajeRecibido,host.getRemoteSocketAddress().toString());
               
                System.out.println("Cliente"+clienteNo+": "+mensajeRecibido);
              
                String msj[]; 
                        msj= mensajeRecibido.split(",");
                        
                        modelo.controlar(msj[0],Integer.parseInt(msj[1]) );
                
                

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
      
       String[] msjClient= o1.toString().split("&");
          
      if(msjClient[1] == null ? host.getRemoteSocketAddress().toString() != null : !msjClient[1].equals(host.getRemoteSocketAddress().toString())) {
      
        datosSalida.writeUTF(msjClient[0]);
      
      }
           
             
           
      
        
          
        } catch (IOException ex) {
           
        }
    }
    
    
    
    
}
