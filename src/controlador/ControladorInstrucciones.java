package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Instrucciones;
import vista.MenuNiveles;
import vista.NivelFacil;

public class ControladorInstrucciones implements ActionListener {

    Instrucciones objInstrucciones;

    public ControladorInstrucciones(Instrucciones objInstrucciones) {
        this.objInstrucciones = objInstrucciones;
        this.objInstrucciones.jButton2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objInstrucciones.jButton2) {
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objInstrucciones.dispose();
        }

    }

}
