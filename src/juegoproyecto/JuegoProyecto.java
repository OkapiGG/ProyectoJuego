package juegoproyecto;

import javax.swing.JFrame;

public class JuegoProyecto extends JFrame {

    public JuegoProyecto(String nombre) {
        super("Vista Juego");
        setSize(400, 400);
        setLocation(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        JuegoProyecto ventana = new JuegoProyecto("vista");
        
    }
}
