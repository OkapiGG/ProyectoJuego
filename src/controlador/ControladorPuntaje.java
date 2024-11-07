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
    NivelFacil objNivelFacil;
    MenuNiveles objMenuNiveles;
    ControladorNivelFacil objControladorNivelFacil;
    
    public ControladorPuntaje(Puntaje objControladorPuntaje) {
        this.objPuntaje = objControladorPuntaje;
        this.objMenuNiveles = new MenuNiveles();
        this.objNivelFacil = new NivelFacil();
        this.objPuntaje.jButton1.addActionListener(this);
        this.objPuntaje.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.objPuntaje.jButton1) {
            objNivelFacil.setVisible(true);
            this.objPuntaje.dispose();
        }
        
        if (e.getSource() == this.objPuntaje.jButton2) {
            objMenuNiveles.setVisible(true);
            this.objPuntaje.dispose();
            objNivelFacil.dispose();         
        }
    }
    
}
