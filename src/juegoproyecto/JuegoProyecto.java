package juegoproyecto;

import javax.swing.JFrame;
import vista.InicioJuego;

public class JuegoProyecto extends JFrame {

    /*
    public JuegoProyecto(String nombre) {
        super("Vista Juego");
        setSize(400, 400);
        setLocation(300,300);
        setVisible(true);
    }
     */
    public static void main(String[] args) {
        new InicioJuego().setVisible(true);

    }
}
