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
import vista.LoginAlta;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.MenuNiveles;
import vista.Puntaje;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objNivelFacil;
    NivelDificil objNivelDificil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;
    Timer timer;
    boolean mostrandoDorso = true;
    OperacionesCartas objOperacionesCartas;
    ControladorPuntaje objControladorPuntaje;
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    boolean estado = true;

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
            objNivelFacil.jButton11.setEnabled(false);

            estado = true;
            int limiteTiempo = 20;
            Thread hilo = new Thread() {
                public void run() {
                    for (;;) {
                        if (estado == true) {
                            try {
                                sleep(1);
                                if (miliseg >= 1000) {
                                    miliseg = 0;
                                    seg++;
                                }
                                if (seg >= 60) {
                                    miliseg = 0;
                                    seg = 0;
                                    min++;
                                }
                                if (min >= 60) {
                                    miliseg = 0;
                                    seg = 0;
                                    min = 0;
                                }
                                objNivelFacil.label1.setText(":" + min + " : " + seg + " : ");
                                objNivelFacil.label2.setText(":" + miliseg);
                                miliseg++;

                                if ((min * 60 + seg) >= limiteTiempo) {
                                    estado = false; // Detiene el temporizador
                                    //JOptionPane.showMessageDialog(null, "¡Tiempo agotado!");// Muestra un mensaje
                                    mostrarPuntaje();
                                    objNivelFacil.jButton11.setEnabled(true); // Habilita el botón nuevamente si es necesario

                                    break;
                                }

                            } catch (Exception e) {

                            }
                        } else {
                            break;
                        }

                    }
                }
            };
            hilo.start();
        }
    }

    public void mostrarPuntaje() {
        Puntaje objPuntaje = new Puntaje();
        objPuntaje.setLocationRelativeTo(objNivelFacil); // Centrar el JDialog sobre la ventana del nivel fácil
        objPuntaje.setVisible(true); // Hacer visible el JDialog
    }

}
