package default_package;
import java.io.IOException;
import presentacion.Modelo;

public class Launcher {
    private Modelo miApp;

    public Launcher() throws IOException {
        miApp = new Modelo();
        miApp.iniciar();
    }

    public static void main(String[] args) throws IOException {
        new Launcher();
    }
}
