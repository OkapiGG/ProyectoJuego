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

public class ControladorNivelDificil implements ActionListener {
    NivelDificil objNivelDificil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;
    Timer timer;
    OperacionesCartas objOperacionesCartas;
    boolean estado = true;
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    private SerialPort arduinoPort;

    public ControladorNivelDificil(NivelDificil objNivelDificil) {
        this.objNivelDificil = objNivelDificil;
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        iniciarConexionArduino();
        desactivarBotones();
        this.objNivelDificil.jButton1.addActionListener(this);
        this.objNivelDificil.jButton2.addActionListener(this);
        this.objNivelDificil.jButton3.addActionListener(this);
        this.objNivelDificil.jButton4.addActionListener(this);
        this.objNivelDificil.jButton5.addActionListener(this);
        this.objNivelDificil.jButton6.addActionListener(this);
        this.objNivelDificil.jButton7.addActionListener(this);
        this.objNivelDificil.jButton8.addActionListener(this);
        this.objNivelDificil.jButton9.addActionListener(this);
        this.objNivelDificil.jButton10.addActionListener(this);
        this.objNivelDificil.jButton11.addActionListener(this);
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
                objNivelDificil.jButton1.doClick();
                break;
            case "2":
                objNivelDificil.jButton2.doClick();
                break;
            case "3":
                objNivelDificil.jButton3.doClick();
                break;
            case "4":
                objNivelDificil.jButton4.doClick();
                break;
            case "5":
                objNivelDificil.jButton5.doClick();
                break;
            case "6":
                objNivelDificil.jButton6.doClick();
                break;
            case "7":
                objNivelDificil.jButton7.doClick();
                break;
            case "8":
                objNivelDificil.jButton8.doClick();
                break;
            case "9":
                objNivelDificil.jButton9.doClick();
                break;
            case "10":
                objNivelDificil.jButton10.doClick();
                break;
            case "11":
                objNivelDificil.jButton11.doClick();
                break;
            default:
                System.out.println("Entrada no reconocida desde Arduino: " + input);
        }
    }

    private void desactivarBotones() {
        // Desactiva todos los botones al inicio
        objNivelDificil.jButton1.setEnabled(false);
        objNivelDificil.jButton2.setEnabled(false);
        objNivelDificil.jButton3.setEnabled(false);
        objNivelDificil.jButton4.setEnabled(false);
        objNivelDificil.jButton5.setEnabled(false);
        objNivelDificil.jButton6.setEnabled(false);
        objNivelDificil.jButton7.setEnabled(false);
        objNivelDificil.jButton8.setEnabled(false);
        objNivelDificil.jButton9.setEnabled(false);
    }

    private void activarBotones() {
        // Activa todos los botones una vez que comienza el juego
        objNivelDificil.jButton1.setEnabled(true);
        objNivelDificil.jButton2.setEnabled(true);
        objNivelDificil.jButton3.setEnabled(true);
        objNivelDificil.jButton4.setEnabled(true);
        objNivelDificil.jButton5.setEnabled(true);
        objNivelDificil.jButton6.setEnabled(true);
        objNivelDificil.jButton7.setEnabled(true);
        objNivelDificil.jButton8.setEnabled(true);
        objNivelDificil.jButton9.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();

        if (e.getSource() == this.objNivelDificil.jButton1) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton1);
        }
        if (e.getSource() == this.objNivelDificil.jButton2) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton2);
        }
        if (e.getSource() == this.objNivelDificil.jButton3) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton3);
        }
        if (e.getSource() == this.objNivelDificil.jButton4) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton4);
        }
        if (e.getSource() == this.objNivelDificil.jButton5) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton5);
        }
        if (e.getSource() == this.objNivelDificil.jButton6) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton6);
        }
        if (e.getSource() == this.objNivelDificil.jButton7) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton7);
        }
        if (e.getSource() == this.objNivelDificil.jButton8) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton8);
        }
        if (e.getSource() == this.objNivelDificil.jButton9) {
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("dificil");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelDificil.jButton9);
        }
        

        if (e.getSource() == this.objNivelDificil.jButton10) {
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objNivelDificil.dispose();
        }

        if (e.getSource() == this.objNivelDificil.jButton11) {
            objNivelDificil.jButton11.setEnabled(false);
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
                                objNivelDificil.jLabel1.setText(":" + min + " : " + seg + " : ");
                                objNivelDificil.jLabel2.setText(":" + miliseg);
                                miliseg++;

                                if ((min * 60 + seg) >= limiteTiempo) {
                                    estado = false;
                                    mostrarPuntaje();
                                    objNivelDificil.jButton11.setEnabled(true);
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
        objPuntaje.setLocationRelativeTo(objNivelDificil);
        objPuntaje.setVisible(true);
        objNivelDificil.dispose();
    }
}

