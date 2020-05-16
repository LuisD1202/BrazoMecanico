
package logica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import presentacion.Modelo;


public class Sistema {
    private ServerSocket server;
    private Socket cliente;
    private int puerto;
    private boolean conectarActivo;
    
    private Modelo modelo;
    MensajesGrados mensajes = new MensajesGrados();  
    public Sistema(Modelo modelo) {
        puerto = 5000;
        conectarActivo = true;
        this.modelo = modelo;
    }       
    
    public void conectar() throws IOException {
                       
        // Crear el servidor
        server = new ServerSocket(puerto);
        
        while(conectarActivo){
            //Esperar a que alguien se conecte        
            cliente = server.accept();                    
            // Alguien se conectó
            new ClienteHilo(cliente,mensajes,modelo).start();
        }
        
    }
    
}
