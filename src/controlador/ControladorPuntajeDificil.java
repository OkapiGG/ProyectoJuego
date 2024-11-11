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
import vista.PuntajeDificil;
import vista.PuntajeFacil;

/**
 *
 * @author Alan
 */
public class ControladorPuntajeDificil implements ActionListener{

    PuntajeDificil objPuntaje;
    NivelDificil objNivelDificil;
    MenuNiveles objMenuNiveles;
    ControladorNivelFacil objControladorNivelFacil;
    OperacionesCartas objOperacionesCartas;
    
    
    public ControladorPuntajeDificil(PuntajeDificil objPuntajeDificil) {
        this.objPuntaje = objPuntajeDificil;
        this.objMenuNiveles = new MenuNiveles();
        this.objNivelDificil = new NivelDificil();
        this.objPuntaje.jButton1.addActionListener(this);
        this.objPuntaje.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.objPuntaje.jButton1) {
            objNivelDificil.setVisible(true);
            this.objPuntaje.dispose();
        }
        
        if (e.getSource() == this.objPuntaje.jButton2) {
            objMenuNiveles.setVisible(true);
            this.objPuntaje.dispose();
            objNivelDificil.dispose();         
        }
    }
    
}
