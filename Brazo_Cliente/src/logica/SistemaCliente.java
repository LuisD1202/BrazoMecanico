package logica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import presentacion.Modelo;

public class SistemaCliente implements Runnable{

      public static final int MAX_BYTES = 200; //Tamaño máximo del mensaje
      private String host = "localhost";
      private int puerto = 5000;
      private Socket sock;
      private Modelo modelo;
      private DataInputStream datosEntrada;
      private DataOutputStream datosSalida;

      private boolean lecturaActiva;
      private Thread hiloLectura;

      public SistemaCliente(Modelo modelo) {
            lecturaActiva = true;
            hiloLectura = new Thread(this);
            this.modelo= modelo;

      }

      public void conectar() throws IOException {

            //establecer conexion
            sock = new Socket(host, puerto);

            //capturar los flujos
            datosEntrada = new DataInputStream(sock.getInputStream());
            datosSalida = new DataOutputStream(sock.getOutputStream());
            // COMUNICACION
            hiloLectura.start();

      }

      public boolean isLecturaActiva() {
            return lecturaActiva;
      }
     public void enviarGrados(String grados){
         
          try {
            this.datosSalida = new DataOutputStream(sock.getOutputStream());
            datosSalida.writeUTF(grados);
        } catch (IOException ex) {
           // log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            //log.error("El socket no se creo correctamente. ");
        }
     }
      @Override
      public void run() {
            try {
                  // Para almacenar lo que llegue del servidor
         
                while (lecturaActiva) {
                      try {
                              // leo lo que envía el server
                                
                              System.out.println("Esperando mensaje...");

                              String mensaje=datosEntrada.readUTF(); // Se queda acá, hasta que el servidor envíe algo
                              System.out.print("El servidor envía: ");
                              System.out.println(mensaje);
                              
                              String msj[];
                              msj= mensaje.split(",");
                              
                              
                              
                            modelo.ControlarSever(msj[0], Integer.parseInt(msj[1]));
                           
                             

                        } catch (IOException ex) {
                              System.out.println("error en la comunicación");
                        }
                  }
           
                      
                  System.out.println("Finaliza hilo");
                  // Finalizar
                
                  datosSalida.close();
                  datosEntrada.close();
                  sock.close();
            } catch (IOException ex) {                 
            }
      }
}
