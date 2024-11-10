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
import vista.NivelMedio;
import vista.PuntajeFacil;
import vista.PuntajeMedio;

/**
 *
 * @author Alan
 */
public class ControladorPuntajeMedio implements ActionListener{

    PuntajeMedio objPuntaje;
    NivelMedio objNivelMedio;
    MenuNiveles objMenuNiveles;
    
    public ControladorPuntajeMedio(PuntajeMedio objControladorPuntajeMedio) {
        this.objPuntaje = objControladorPuntajeMedio;
        this.objMenuNiveles = new MenuNiveles();
        this.objNivelMedio = new NivelMedio();
        this.objPuntaje.jButton1.addActionListener(this);
        this.objPuntaje.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.objPuntaje.jButton1) {
            objNivelMedio.setVisible(true);
            this.objPuntaje.dispose();
        }
        
        if (e.getSource() == this.objPuntaje.jButton2) {
            objMenuNiveles.setVisible(true);
            this.objPuntaje.dispose();
            objNivelMedio.dispose();         
        }
    } 
}
