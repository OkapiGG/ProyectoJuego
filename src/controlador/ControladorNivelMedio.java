package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
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
import vista.NivelMedio;
import vista.Puntaje;

public class ControladorNivelMedio implements ActionListener {

    NivelMedio objNivelMedio;
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

    public ControladorNivelMedio(NivelMedio objControladorNivelMedio) {
        this.objNivelMedio = objControladorNivelMedio;
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        this.objNivelMedio.jButton1.addActionListener(this);
        this.objNivelMedio.jButton2.addActionListener(this);
        this.objNivelMedio.jButton3.addActionListener(this);
        this.objNivelMedio.jButton4.addActionListener(this);
        this.objNivelMedio.jButton5.addActionListener(this);
        this.objNivelMedio.jButton6.addActionListener(this);
        this.objNivelMedio.jButton7.addActionListener(this);
        this.objNivelMedio.jButton8.addActionListener(this);
        this.objNivelMedio.jButton9.addActionListener(this);
        this.objNivelMedio.jButton10.addActionListener(this);
        this.objNivelMedio.jButton11.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();

        if (e.getSource() == this.objNivelMedio.jButton1) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton1);

        }
        if (e.getSource() == this.objNivelMedio.jButton2) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton2);
        }
        if (e.getSource() == this.objNivelMedio.jButton3) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton3);
        }
        if (e.getSource() == this.objNivelMedio.jButton4) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton4);
        }
        if (e.getSource() == this.objNivelMedio.jButton5) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton5);
        }
        if (e.getSource() == this.objNivelMedio.jButton6) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton6);
        }
        if (e.getSource() == this.objNivelMedio.jButton7) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton7);
        }
        if (e.getSource() == this.objNivelMedio.jButton8) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton8);
        }
        if (e.getSource() == this.objNivelMedio.jButton9) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("medianas");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelMedio.jButton9);
        }

        if (e.getSource() == this.objNivelMedio.jButton11) {
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objNivelMedio.dispose();
        }

        if (e.getSource() == this.objNivelMedio.jButton10) {
            objNivelMedio.jButton10.setEnabled(false);

            estado = true;
            int limiteTiempo = 5;
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
                                objNivelMedio.jLabel3.setText(":" + min + " : " + seg + " : ");
                                objNivelMedio.jLabel2.setText(":" + miliseg);
                                miliseg++;

                                if ((min * 60 + seg) >= limiteTiempo) {
                                    estado = false; // Detiene el temporizador
                                    //JOptionPane.showMessageDialog(null, "¡Tiempo agotado!");// Muestra un mensaje
                                    mostrarPuntaje();
                                    objNivelMedio.jButton10.setEnabled(true); // Habilita el botón nuevamente si es necesario

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
        objPuntaje.setLocationRelativeTo(objNivelMedio); // Centrar el JDialog sobre la ventana del nivel fácil
        objPuntaje.setVisible(true); // Hacer visible el JDialog
        objNivelMedio.dispose();
    }

}
