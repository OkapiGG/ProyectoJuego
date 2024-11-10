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

/**
 *
 * @author Alan
 */
public class ControladorPuntajeFacil implements ActionListener{

    PuntajeFacil objPuntaje;
    NivelFacil objNivelFacil;
    NivelMedio objNivelMedio;
    NivelDificil objNivelDificil;
    MenuNiveles objMenuNiveles;
    ControladorNivelFacil objControladorNivelFacil;
    OperacionesCartas objOperacionesCartas;
    
    
    public ControladorPuntajeFacil(PuntajeFacil objPuntajeFacil) {
        this.objPuntaje = objPuntajeFacil;
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
    
    /*public void actualizarPuntaje(int puntaje) {
        objPuntaje.jLabel2.setText("Puntaje: " + puntaje); // Asegúrate de que jLabel2 sea el correcto en PuntajeFacil
        System.out.println(puntaje); // También puedes imprimir el puntaje para depurar
    }

    public void actualizarTiempo(int tiempo) {
        objPuntaje.jLabel3.setText("Tiempo: " + tiempo + "s");
    }*/
    
}
