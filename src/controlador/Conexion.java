package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "login";
    private final String USER = "postgres";
    private final String PASSWORD = "maiz564";

    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + HOST + ":" + PUERTO + "/" + DB;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConexion();
    }
}
