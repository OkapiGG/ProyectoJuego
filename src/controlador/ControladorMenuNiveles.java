package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MenuNiveles;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.NivelMedio;

public class ControladorMenuNiveles implements ActionListener {

    MenuNiveles objMenuNiveles;
    NivelFacil objNivelFacil;
    NivelMedio objNivelMedio;
    NivelDificil objNivelDificil;

    public ControladorMenuNiveles(MenuNiveles objMenuNiveles) {
        this.objMenuNiveles = objMenuNiveles;
        objNivelFacil = new NivelFacil();
        this.objMenuNiveles.jButton1.addActionListener(this);
        objNivelMedio = new NivelMedio();
        this.objMenuNiveles.jButton2.addActionListener(this);
        objNivelDificil = new NivelDificil();
        this.objMenuNiveles.jButton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objMenuNiveles.jButton1) {
            NivelFacil objNivelFacil = new NivelFacil();
            objNivelFacil.setVisible(true);
            this.objNivelFacil.dispose();
        }
        if (e.getSource() == this.objMenuNiveles.jButton2) {
            NivelMedio objNivelMedio = new NivelMedio();
            objNivelMedio.setVisible(true);
            this.objNivelMedio.dispose();
        }
        if (e.getSource() == this.objMenuNiveles.jButton3) {
            NivelDificil objNivelDificil = new NivelDificil();
            objNivelDificil.setVisible(true);
            this.objNivelDificil.dispose();
        }
    }

}
