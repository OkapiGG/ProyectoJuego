package controlador;

import modelo.CRUD;
import modelo.Login;
import java.util.ArrayList;

import java.util.ArrayList;

public class OperacionesListaLogin extends CRUD {

    public ArrayList<Login> listaLogin;
    Login objLogin;

    public OperacionesListaLogin() {
        listaLogin = new ArrayList();
    }

    @Override
    public void create() {
        listaLogin.add(objLogin);
    }

    @Override
    public ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setObjLogin(Login objLogin) {
        this.objLogin = objLogin;
    }

}
