package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Pregunta;
import vista.Instrucciones;
import vista.NivelDificil;
import vista.NivelFacil;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objNivelFacil;
    NivelDificil objNivelDificil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;

    public ControladorNivelFacil(NivelFacil objControladorNivelFacil) {
        this.objNivelFacil = objControladorNivelFacil;
        objNivelDificil = new NivelDificil();
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        this.objNivelFacil.jButton1.addActionListener(this);
        this.objNivelFacil.jButton10.addActionListener(this);
        this.objNivelFacil.jButton11.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objNivelFacil.jButton1) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }

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

    public void mostrarPregunta(Pregunta objpregunta) {
        System.out.println(objpregunta.getPregunta());
        System.out.println(objpregunta.getOpcionA());
        System.out.println(objpregunta.getOpcionB());
        System.out.println(objpregunta.getOpcionC());
        System.out.println(objpregunta.getOpcionD());
        System.out.println(objpregunta.getRespuestaCorrecta());
    }

}
