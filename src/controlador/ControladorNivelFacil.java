package controlador;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.Timer;
import modelo.Pregunta;
import vista.NivelDificil;
import vista.NivelFacil;
import vista.MenuNiveles;
import vista.Puntaje;

public class ControladorNivelFacil implements ActionListener {
    NivelFacil objNivelFacil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;
    Timer timer;
    OperacionesCartas objOperacionesCartas;
    boolean estado = true;
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    private SerialPort arduinoPort;

    public ControladorNivelFacil(NivelFacil objNivelFacil) {
        this.objNivelFacil = objNivelFacil;
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        iniciarConexionArduino();
        desactivarBotones();
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

    private void iniciarConexionArduino() {
        arduinoPort = SerialPort.getCommPort("COM5"); // Cambia "COM5" al puerto correcto
        arduinoPort.setBaudRate(9600);

        if (arduinoPort.openPort()) {
            System.out.println("Conexión establecida con Arduino.");
            new Thread(this::escucharDatosArduino).start();
        } else {
            System.out.println("No se pudo abrir el puerto.");
        }
    }

    private void escucharDatosArduino() {
        while (arduinoPort.isOpen()) {
            if (arduinoPort.bytesAvailable() > 0) {
                byte[] buffer = new byte[arduinoPort.bytesAvailable()];
                arduinoPort.readBytes(buffer, buffer.length);
                String data = new String(buffer).trim();
                procesarEntrada(data);
            }
        }
    }

    public void procesarEntrada(String input) {
        switch (input) {
            case "1":
                objNivelFacil.jButton1.doClick();
                break;
            case "2":
                objNivelFacil.jButton2.doClick();
                break;
            case "3":
                objNivelFacil.jButton3.doClick();
                break;
            case "4":
                objNivelFacil.jButton4.doClick();
                break;
            case "5":
                objNivelFacil.jButton5.doClick();
                break;
            case "6":
                objNivelFacil.jButton6.doClick();
                break;
            case "7":
                objNivelFacil.jButton7.doClick();
                break;
            case "8":
                objNivelFacil.jButton8.doClick();
                break;
            case "9":
                objNivelFacil.jButton9.doClick();
                break;
            case "10":
                objNivelFacil.jButton10.doClick();
                break;
            case "11":
                objNivelFacil.jButton11.doClick();
                break;
            default:
                System.out.println("Entrada no reconocida desde Arduino: " + input);
        }
    }

    private void desactivarBotones() {
        // Desactiva todos los botones al inicio
        objNivelFacil.jButton1.setEnabled(false);
        objNivelFacil.jButton2.setEnabled(false);
        objNivelFacil.jButton3.setEnabled(false);
        objNivelFacil.jButton4.setEnabled(false);
        objNivelFacil.jButton5.setEnabled(false);
        objNivelFacil.jButton6.setEnabled(false);
        objNivelFacil.jButton7.setEnabled(false);
        objNivelFacil.jButton8.setEnabled(false);
        objNivelFacil.jButton9.setEnabled(false);
    }

    private void activarBotones() {
        // Activa todos los botones una vez que comienza el juego
        objNivelFacil.jButton1.setEnabled(true);
        objNivelFacil.jButton2.setEnabled(true);
        objNivelFacil.jButton3.setEnabled(true);
        objNivelFacil.jButton4.setEnabled(true);
        objNivelFacil.jButton5.setEnabled(true);
        objNivelFacil.jButton6.setEnabled(true);
        objNivelFacil.jButton7.setEnabled(true);
        objNivelFacil.jButton8.setEnabled(true);
        objNivelFacil.jButton9.setEnabled(true);
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
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
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
            int limiteTiempo = 5;
            Thread hilo = new Thread() {
                public void run() {
                    // Desactivar botones antes de empezar
                    desactivarBotones();
                    
                    // Activar botones cuando el temporizador empiece
                    activarBotones();

                    for (;;) {
                        if (estado) {
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
                                    estado = false;
                                    mostrarPuntaje();
                                    objNivelFacil.jButton11.setEnabled(true);
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error en el temporizador: " + e.getMessage());
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
        objPuntaje.setLocationRelativeTo(objNivelFacil);
        objPuntaje.setVisible(true);
        objNivelFacil.dispose();
    }
}

