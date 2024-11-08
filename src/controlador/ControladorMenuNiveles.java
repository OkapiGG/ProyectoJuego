package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Instrucciones;
import vista.MenuNiveles;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.NivelMedio;

public class ControladorMenuNiveles implements ActionListener {

    MenuNiveles objMenuNiveles;

    public ControladorMenuNiveles(MenuNiveles objMenuNiveles) {
        this.objMenuNiveles = objMenuNiveles;
        this.objMenuNiveles.jButton1.addActionListener(this);
        this.objMenuNiveles.jButton2.addActionListener(this);
        this.objMenuNiveles.jButton3.addActionListener(this);
        this.objMenuNiveles.jButton4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objMenuNiveles.jButton1) {
            NivelFacil objNivelFacil = new NivelFacil();
            objNivelFacil.setVisible(true);
            this.objMenuNiveles.dispose();
        }
        if (e.getSource() == this.objMenuNiveles.jButton2) {
            NivelMedio objNivelMedio = new NivelMedio();
            objNivelMedio.setVisible(true);
            this.objMenuNiveles.dispose();
        }
        if (e.getSource() == this.objMenuNiveles.jButton3) {
            NivelDificil objNivelDificil = new NivelDificil();
            objNivelDificil.setVisible(true);
            this.objMenuNiveles.dispose();
        }
        if(e.getSource()==this.objMenuNiveles.jButton4){
            Instrucciones objInstrucciones = new Instrucciones();
            objInstrucciones.setVisible(true);
            this.objMenuNiveles.dispose();
        }
    }

}
