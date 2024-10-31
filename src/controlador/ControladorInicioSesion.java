/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    public ControladorInicioSesion(InicioSesion objInicioSesion) {
        this.objInicioSesion = objInicioSesion;
        this.objInicioSesion.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objInicioSesion.jButton1) {

            String usuario = objInicioSesion.jTextField1.getText();
            String contraseña = new String(objInicioSesion.jPasswordField1.getPassword());

            ArrayList<Login> loginExitoso = objOperacionesBD.read();
            
            
            

        }
    }
}
