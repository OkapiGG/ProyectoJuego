/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Login;
import vista.InicioJuego;
import vista.LoginAlta;

/**
 *
 * @author Alan
 */
public class ControladorInicioJuego implements ActionListener {

    InicioJuego objInicioJuego;

    public ControladorInicioJuego(InicioJuego objInicioJuego) {
        this.objInicioJuego = objInicioJuego;
        this.objInicioJuego.jButton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objInicioJuego.jButton1) {

            LoginAlta objLoginAlta = new LoginAlta();
            objLoginAlta.setVisible(true);

            this.objInicioJuego.dispose();
        }

    }

}
