/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.LoginAlta;
import vista.MenuNiveles;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.Puntaje;

/**
 *
 * @author Alan
 */
public class ControladorPuntaje implements ActionListener{

    Puntaje objPuntaje;
    
    public ControladorPuntaje(Puntaje objControladorPuntaje) {
        this.objPuntaje = objControladorPuntaje;
        this.objPuntaje.jButton1.addActionListener(this);
        this.objPuntaje.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.objPuntaje.jButton1) {
            NivelFacil objNivelFacil = new NivelFacil();
            objNivelFacil.setVisible(true);

            this.objPuntaje.dispose();
        }
        
        if (e.getSource() == this.objPuntaje.jButton2) {
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);

            this.objPuntaje.dispose();
        }
    }
    
    
    
}
