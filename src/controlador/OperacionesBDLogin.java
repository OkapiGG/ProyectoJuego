package controlador;

import modelo.CRUD;
import java.sql.Statement;
import modelo.Login;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OperacionesBDLogin extends CRUD {

    public Login objLogin;
    Conexion objConexion;

    public OperacionesBDLogin() {
        objConexion = new Conexion();
    }

    @Override
    public void create() {
        try {
            System.out.println("Insercion a la base de datos correcta");
            Statement stmt = objConexion.getConexion().createStatement();
            /*stmt.execute("insert into login values ('"
                    + objLogin.getIdusaurio() + "','" + objLogin.getUsuario()
                    + "','" + objLogin.getContraseña()
                    + ")");*/
        } catch (Exception e) {
            System.out.println("Error al insertar en la base de datos");
        }
    }

    @Override
    public ArrayList read() {
        ArrayList<Login> objListaLogin = new ArrayList();
        Login objLogin;
        try {
            Statement stmt = objConexion.getConexion().createStatement();
            ResultSet resultado = stmt.executeQuery("select * from login");
            while (resultado.next()) {
                objLogin = new Login();
                objLogin.setIdusaurio(resultado.getInt("idusuario"));
                objLogin.setUsuario(resultado.getString("nombre"));
                objLogin.setContraseña(resultado.getString("contraseña"));
                objListaLogin.add(objLogin); // Añade a la lista
            }
        } catch (Exception e) {
            System.out.println("No encontrado" + e.getMessage());
        }
        return objListaLogin;
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Login getObjLogin() {
        return objLogin;
    }

    public void setObjLogin(Login objLogin) {
        this.objLogin = objLogin;
    }

}
