/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Pregunta;
import vista.NivelFacil;

/**
 *
 * @author Alan
 */
public class OperacionesCartas {

    NivelFacil objNivelFacil;
    Timer timer;
    boolean mostrandoDorso = true;
    Pregunta objpregunta;
    private Timer timerNivel;
    private int tiempoRestante = 30; // Tiempo total en segundos
    private JLabel labelTiempo; // Etiqueta para mostrar el tiempo

    public OperacionesCartas(Timer timer, Pregunta objpregunta) {
        this.timer = timer;
        this.objpregunta = objpregunta;
    }
    
    public OperacionesCartas(NivelFacil objNivelFacil){
        this.objNivelFacil=objNivelFacil;
    }

    public void mostrarPregunta(Pregunta objpregunta, JButton botonCarta) {
        this.objpregunta = objpregunta;

        String[] opciones = {
            objpregunta.getOpcionA(),
            objpregunta.getOpcionB(),
            objpregunta.getOpcionC(),
            objpregunta.getOpcionD()
        };

        int respuestaUsuario = JOptionPane.showOptionDialog(
                null,
                objpregunta.getPregunta(),
                "Pregunta",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        verificarRespuesta(respuestaUsuario, opciones);
        botonCarta.setEnabled(false);
    }

    public void iniciarAnimacionVolteo(JButton botonCarta) {
        timer = new Timer(30, new ActionListener() {
            private int contador = 0;
            private int maximoContador = 10;

            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;

                // Primera parte de la animación: reduce el ancho del botón
                if (contador <= maximoContador / 2) {
                    botonCarta.setSize(botonCarta.getWidth() - 10, botonCarta.getHeight());
                } else {
                    // Cambia la imagen del botón al "girar" la carta
                    if (mostrandoDorso) {
                        botonCarta.setIcon(new ImageIcon("carta_1.png")); // Imagen con la pregunta
                        mostrandoDorso = false;
                    } else {
                        botonCarta.setIcon(new ImageIcon("cartaTorso.png")); // Imagen de dorso
                        mostrandoDorso = true;
                    }
                    // Expande el ancho del botón nuevamente
                    botonCarta.setSize(botonCarta.getWidth() + 10, botonCarta.getHeight());
                }

                // Detiene el timer cuando la animación finaliza y muestra la pregunta
                if (contador >= maximoContador) {
                    timer.stop();
                    mostrarPregunta(objpregunta, botonCarta); // Mostrar la pregunta después del giro
                }
            }
        });
        timer.start();
    }
    
    private void verificarRespuesta(int respuestaUsuario, String[] opciones) {
        if (respuestaUsuario == -1) return; // Ninguna respuesta seleccionada

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

        if (opciones[respuestaUsuario].equals(respuestaCorrectaTexto)) {
            JOptionPane.showMessageDialog(null, "¡Correcto!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta es: " + respuestaCorrectaTexto, "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

}
