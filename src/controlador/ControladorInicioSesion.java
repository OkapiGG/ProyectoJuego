/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Login;
import vista.InicioJuego;
import vista.InicioSesion;
import vista.LoginAlta;

/**
 *
 * @author Alan
 */
public class ControladorInicioSesion implements ActionListener {

    InicioSesion objInicioSesion;
    OperacionesBDLogin objOperacionesBD;
    LoginAlta objLoginAlta;
    Conexion objConexion;

    public ControladorInicioSesion(InicioSesion objInicioSesion) {
        this.objInicioSesion = objInicioSesion;
        this.objInicioSesion.jButton1.addActionListener(this);
        objConexion = new Conexion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objInicioSesion.jButton1) {

            String usuario = objInicioSesion.jTextField1.getText();
            String contraseña = new String(objInicioSesion.jPasswordField1.getPassword());

            ArrayList<Login> loginExitoso = objOperacionesBD.read();

        }
    }

    public boolean read(String nombreUsuario, String contraseña) {
        try {
            Statement stmt = objConexion.getConexion().createStatement();
            String query = "select * from login where nombre = '" + nombreUsuario + "' and contraseña = '" + contraseña + "'";
            ResultSet resultado = stmt.executeQuery(query);

            if (resultado.next()) {
                System.out.println("Inicio de sesión exitoso");
                return true;
            } else {
                System.out.println("Usuario o contraseña incorrectos");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al autenticar: " + e.getMessage());
            return false;
        }
    }

}
