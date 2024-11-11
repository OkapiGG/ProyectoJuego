package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    private static Conexion instanciaUnicaConexion;
    private Connection objConexion;

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "login";
    private final String USER = "postgres";
    private final String PASSWORD = "ema24"; // aqui no jala la misma base pa la dos cada que cambias la contra

    private Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + DB;
            this.objConexion = DriverManager.getConnection(url, USER, PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexión Exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static Conexion getInstance() {
        if (instanciaUnicaConexion == null) {
            instanciaUnicaConexion = new Conexion();
        }
        return instanciaUnicaConexion;
    }

    public Connection getConexion() {
        return this.objConexion;
    }
}
