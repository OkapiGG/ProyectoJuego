package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import vista.InicioJuego;
import vista.InicioSesion;
import vista.MenuNiveles;

public class ControladorInicioSesion implements ActionListener {

    private InicioSesion objInicioSesion;
    private Conexion objConexion;

    public ControladorInicioSesion(InicioSesion objInicioSesion) {
        this.objInicioSesion = objInicioSesion;
        this.objConexion = Conexion.getInstance();
        this.objInicioSesion.jButton1.addActionListener(this);
        this.objInicioSesion.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objInicioSesion.jButton1) {
            String nombre = objInicioSesion.jTextField1.getText();
            String password = new String(objInicioSesion.jPasswordField1.getPassword());

            if (autenticarUsuario(nombre, password)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                MenuNiveles menu = new MenuNiveles();
                menu.setVisible(true);
                objInicioSesion.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        }
        
        if(e.getSource() == this.objInicioSesion.jButton2){
            InicioJuego objInicioJuego = new InicioJuego();
            objInicioJuego.setVisible(true);
            this.objInicioSesion.dispose();
        }
    }

    private boolean autenticarUsuario(String nombre, String password) {
        boolean autenticado = false;
        String sql = "SELECT * FROM login WHERE nombre = ? AND password = ?";

        try {
            Connection conexion = objConexion.getConexion(); // Obtén la conexión sin cerrarla automáticamente
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            autenticado = rs.next();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + ex.getMessage());
        }
        return autenticado;
    }

}
