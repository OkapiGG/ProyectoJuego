package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.LoginAlta;
import modelo.Login;
import java.sql.*;
import vista.Instrucciones;

public class ControladorLogin implements ActionListener {

    public LoginAlta objLoginAlta;
    public Instrucciones objInstrucciones;
    OperacionesBDLogin objOperacionesBDLogin;
    OperacionesListaLogin objOperacionesListaLogin;
    public ArrayList<Login> objListaLogin;
    Login objLogin;
    Conexion objConexion;
    Verificador objVerificador;

    public ControladorLogin(LoginAlta objLoginAlta) {
        this.objLoginAlta = objLoginAlta;
        objLogin = new Login();
        this.objLoginAlta.jButton1.addActionListener(this);

        objOperacionesBDLogin = new OperacionesBDLogin();
        objOperacionesListaLogin = new OperacionesListaLogin();

        objConexion = new Conexion();
        this.objVerificador = new Verificador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objLoginAlta.jButton1) {

            if (!verificaCampos()) {
                return;
            }

            int nuevoId = obtenerUltimoIdUsuario() + 1;

            Login objLogin = new Login();
            objLogin.setIdusaurio(nuevoId);
            objLogin.setUsuario(objLoginAlta.jTextField1.getText());
            objLogin.setContraseña(objLoginAlta.jTextField2.getText());
            //objLoginAlta.getObjListaLogin().add(objLogin);

            objOperacionesListaLogin.setObjLogin(objLogin);
            objOperacionesListaLogin.create();

            objOperacionesBDLogin.setObjLogin(objLogin);
            objOperacionesBDLogin.create();

        }
    }

    public int obtenerUltimoIdUsuario() {
        int ultimoId = 0;
        try {
            Statement stmt = objConexion.getConexion().createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT MAX(idusuario) AS ultimoId FROM login");
            if (resultado.next()) {
                ultimoId = resultado.getInt("ultimoId");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el último ID: " + e.getMessage());
        }
        return ultimoId;
    }

    public boolean verificaCampos() {
        if (!objVerificador.verificaCajaTextoVacio(this.objLoginAlta.jTextField1)) {
            return false;
        } else if (!objVerificador.verificaCajaTextoVacio(this.objLoginAlta.jTextField2)) {
            return false;
        }
        return true;
    }

}
