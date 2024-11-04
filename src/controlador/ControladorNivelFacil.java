package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
        if (e.getSource() == this.objNivelFacil.jButton1) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton2) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton3) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton4) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton5) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton6) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton7) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton8) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            if (objpregunta != null) {
                mostrarPregunta(objpregunta);
                //objNivelFacil.mostrarPregunta(objpregunta);
            }
        }
        if (e.getSource() == this.objNivelFacil.jButton9) {
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
        // Operaciones Boton
        if (e.getSource() == this.objNivelFacil.jButton12) {

        }
    }

    public void mostrarPregunta(Pregunta objpregunta) {
        String[] opciones = {
            objpregunta.getOpcionA(),
            objpregunta.getOpcionB(),
            objpregunta.getOpcionC(),
            objpregunta.getOpcionD()
        };

        // Muestra el cuadro de diálogo con la pregunta y las opciones
        int respuestaUsuario = JOptionPane.showOptionDialog(
                null,
                objpregunta.getPregunta(), // Texto de la pregunta
                "Pregunta", // Título del diálogo
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones, // Arreglo de opciones de respuesta
                opciones[0] // Respuesta predeterminada
        );

        // Obtiene el texto de la respuesta correcta basado en la letra
        String respuestaCorrectaTexto = "";
        switch (objpregunta.getRespuestaCorrecta()) {
            case 'A':
                respuestaCorrectaTexto = objpregunta.getOpcionA();
                break;
            case 'B':
                respuestaCorrectaTexto = objpregunta.getOpcionB();
                break;
            case 'C':
                respuestaCorrectaTexto = objpregunta.getOpcionC();
                break;
            case 'D':
                respuestaCorrectaTexto = objpregunta.getOpcionD();
                break;
        }

        // Verifica si la respuesta es correcta
        if (respuestaUsuario != -1 && opciones[respuestaUsuario].equals(respuestaCorrectaTexto)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta es: " + respuestaCorrectaTexto, "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

}
