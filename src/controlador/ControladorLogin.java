package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import vista.LoginAlta;
import modelo.Login;

public class ControladorLogin implements ActionListener {

    public LoginAlta objLoginAlta;
    OperacionesBDLogin objOperacionesBDLogin;
    OperacionesListaLogin objOperacionesListaLogin;
    public ArrayList<Login> objListaLogin;
    Login objLogin;

    public ControladorLogin(LoginAlta objLoginAlta) {
        this.objLoginAlta = objLoginAlta;
        objLogin = new Login();
        objOperacionesBDLogin = new OperacionesBDLogin();
        objOperacionesListaLogin = new OperacionesListaLogin();
        this.objLoginAlta.jButton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objLoginAlta.jButton1) {
            // System.out.println("Click en el boton");

            Login objLogin = new Login();
            //objLogin.setIdusaurio(objLoginAlta.jTextField1.getX());
            objLogin.setUsuario(objLoginAlta.jTextField1.getText());
            objLogin.setContraseña(objLoginAlta.jTextField2.getText());
            objLoginAlta.getObjListaLogin().add(objLogin);

            objLoginAlta.getObjOperacionesListaLogin().setObjLogin(objLogin);
            objLoginAlta.getObjOperacionesListaLogin().create();
            objOperacionesListaLogin.setObjLogin(objLogin);
            objOperacionesListaLogin.create();
            
            objOperacionesBDLogin.setObjLogin(objLogin);
            objOperacionesBDLogin.create();
        }
    }

}
