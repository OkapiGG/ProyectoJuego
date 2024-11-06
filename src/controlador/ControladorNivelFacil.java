package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Pregunta;
import vista.Instrucciones;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.MenuNiveles;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objNivelFacil;
    NivelDificil objNivelDificil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;
    Timer timer;
    boolean mostrandoDorso = true;
    OperacionesCartas objOperacionesCartas;
    ControladorPuntaje objControladorPuntaje;

    public ControladorNivelFacil(NivelFacil objControladorNivelFacil) {
        this.objNivelFacil = objControladorNivelFacil;
        objNivelDificil = new NivelDificil();
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        this.objNivelFacil.jButton1.addActionListener(this);
        this.objNivelFacil.jButton2.addActionListener(this);
        this.objNivelFacil.jButton3.addActionListener(this);
        this.objNivelFacil.jButton4.addActionListener(this);
        this.objNivelFacil.jButton5.addActionListener(this);
        this.objNivelFacil.jButton6.addActionListener(this);
        this.objNivelFacil.jButton7.addActionListener(this);
        this.objNivelFacil.jButton8.addActionListener(this);
        this.objNivelFacil.jButton9.addActionListener(this);
        this.objNivelFacil.jButton10.addActionListener(this);
        this.objNivelFacil.jButton11.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();

        if (e.getSource() == this.objNivelFacil.jButton1) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton1);

        }
        if (e.getSource() == this.objNivelFacil.jButton2) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton2);
        }
        if (e.getSource() == this.objNivelFacil.jButton3) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton3);
        }
        if (e.getSource() == this.objNivelFacil.jButton4) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton4);
        }
        if (e.getSource() == this.objNivelFacil.jButton5) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton5);
        }
        if (e.getSource() == this.objNivelFacil.jButton6) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton6);
        }
        if (e.getSource() == this.objNivelFacil.jButton7) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton7);
        }
        if (e.getSource() == this.objNivelFacil.jButton8) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton8);
        }
        if (e.getSource() == this.objNivelFacil.jButton9) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton9);
        }

        if (e.getSource() == this.objNivelFacil.jButton10) {
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objNivelFacil.dispose();
        }

        if (e.getSource() == this.objNivelFacil.jButton11) {

        }

    }

}
