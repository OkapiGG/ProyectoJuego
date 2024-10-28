package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Instrucciones;
import vista.NivelFacil;

public class ControladorInstrucciones implements ActionListener {

    Instrucciones objInstrucciones;

    public ControladorInstrucciones(Instrucciones objInstrucciones) {
        this.objInstrucciones = objInstrucciones;
        this.objInstrucciones.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objInstrucciones.jButton1) {

            NivelFacil objNivelFacil = new NivelFacil();
            objNivelFacil.setVisible(true);

            this.objInstrucciones.dispose();
        }

    }

}
