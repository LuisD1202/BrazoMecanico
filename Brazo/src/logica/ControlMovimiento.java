

package logica;

public class ControlMovimiento {
    
    private final Brazo brazo;
    
    private int x, y,g;


    public ControlMovimiento() {
        brazo = new Brazo();
    }

    public Brazo getBrazo() {
        return brazo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }
    
   
   
   
}
