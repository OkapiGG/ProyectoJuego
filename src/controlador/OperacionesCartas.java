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

/**
 *
 * @author Alan
 */
public class OperacionesCartas {

    Timer timer;
    boolean mostrandoDorso = true;
    Pregunta objpregunta;
    private int puntaje = 0;
    private Timer timerNivel;
    private int tiempoRestante = 30; // Tiempo total en segundos
    private JLabel labelTiempo; // Etiqueta para mostrar el tiempo

    public OperacionesCartas(Timer timer, Pregunta objpregunta) {
        this.timer = timer;
        this.objpregunta = objpregunta;
    }

    public void mostrarPregunta(Pregunta objpregunta, JButton botonCarta) {
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
            puntaje += 10;
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. La respuesta correcta es: " + respuestaCorrectaTexto, "Resultado", JOptionPane.ERROR_MESSAGE);
        }

        // Deshabilita el botón para que no se pueda volver a presionar
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
                        botonCarta.setIcon(new ImageIcon("carta1.png")); // Imagen con la pregunta
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

    public void iniciarNivel() {
        labelTiempo = new JLabel("Tiempo restante: " + tiempoRestante + "s");
        // Añade labelTiempo a la interfaz gráfica en el lugar adecuado

        timerNivel = new Timer(1000, new ActionListener() { // 1000 ms = 1 segundo
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante--;
                labelTiempo.setText("Tiempo restante: " + tiempoRestante + "s");

                if (tiempoRestante <= 0) {
                    timerNivel.stop(); // Detener el timer cuando se acaba el tiempo
                    terminarNivel(); // Llama a un método que termine el nivel
                }
            }
        });
        timerNivel.start(); // Inicia el conteo regresivo
    }

    public void terminarNivel() {
        JOptionPane.showMessageDialog(null, "Tiempo agotado. Fin del nivel.", "Fin del Tiempo", JOptionPane.INFORMATION_MESSAGE);
        // Bloquear botones o deshabilitar respuestas
        deshabilitarBotones(); // Método que desactiva los botones de las preguntas
    }

    private void deshabilitarBotones() {
        // Aquí desactiva los botones de las cartas o preguntas para evitar más respuestas
        // Ejemplo: botonCarta1.setEnabled(false);
    }
}
