package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Instrucciones;
import vista.NivelDificil;
import vista.NivelFacil;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objNivelFacil;
    NivelDificil objNivelDificil;

    public ControladorNivelFacil(NivelFacil objControladorNivelFacil) {
        this.objNivelFacil = objControladorNivelFacil;
        this.objNivelFacil.jButton10.addActionListener(this);        
        objNivelDificil = new NivelDificil();
        this.objNivelFacil.jButton11.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objNivelFacil.jButton10) {
            Instrucciones objInstrucciones = new Instrucciones();
            objInstrucciones.setVisible(true);

            this.objNivelFacil.dispose();
        }

        if (e.getSource() == this.objNivelFacil.jButton11) {
            NivelDificil objNivelDificil = new NivelDificil();
            objNivelDificil.setVisible(true);
            
            this.objNivelDificil.dispose();
        }
    }

}
