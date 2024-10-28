package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Instrucciones;
import vista.NivelFacil;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objControladorNivelFacil;

    public ControladorNivelFacil(NivelFacil objControladorNivelFacil) {
        this.objControladorNivelFacil = objControladorNivelFacil;
        this.objControladorNivelFacil.jButton10.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objControladorNivelFacil.jButton10) {
            Instrucciones objInstrucciones = new Instrucciones();
            objInstrucciones.setVisible(true);
            
            this.objControladorNivelFacil.dispose();
        }
    }

}
