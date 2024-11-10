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
import vista.PuntajeFacil;

public class ControladorNivelFacil implements ActionListener {

    NivelFacil objNivelFacil;
    OperacionesPreguntaBD objOperacionesPreguntaBD;
    Pregunta objpregunta;
    Timer timer;
    OperacionesCartas objOperacionesCartas;
    ConexionArduino objConexionArduino;
    private Thread hilo;
    boolean estado = true;
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    private SerialPort arduinoPort;
    private boolean keepListening = false;

    public ControladorNivelFacil(NivelFacil objNivelFacil) {
        this.objNivelFacil = objNivelFacil;
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        //iniciarConexionArduino();  // Abrimos la conexión al crear el controlador
        desactivarBotones();
        agregarListeners();
    }

    private void agregarListeners() {
        this.objNivelFacil.jButton1.addActionListener(this);
        this.objNivelFacil.jButton2.addActionListener(this);
        this.objNivelFacil.jButton3.addActionListener(this);
        this.objNivelFacil.jButton4.addActionListener(this);
        this.objNivelFacil.jButton5.addActionListener(this);
        this.objNivelFacil.jButton6.addActionListener(this);
        this.objNivelFacil.jButton7.addActionListener(this);
        this.objNivelFacil.jButton8.addActionListener(this);
        this.objNivelFacil.jButton9.addActionListener(this);
        this.objNivelFacil.jButton10.addActionListener(this);  // Botón para regresar al menú
        this.objNivelFacil.jButton11.addActionListener(this);  // Botón para reiniciar el nivel
    }

    private void iniciarConexionArduino() {
        // Verifica si el puerto está asignado y abierto
        if (arduinoPort != null && arduinoPort.isOpen()) {
            System.out.println("La conexión con Arduino ya está abierta.");
            return;
        }

        // Configurar el puerto y abrir conexión si no está abierta
        arduinoPort = SerialPort.getCommPort("COM5"); // Ajusta el puerto correcto
        arduinoPort.setBaudRate(9600);

        if (arduinoPort.openPort()) {
            System.out.println("Conexión establecida con Arduino.");
            keepListening = true;
            new Thread(this::escucharDatosArduino).start();
        } else {
            System.out.println("No se pudo abrir el puerto.");
        }
    }

    public void escucharDatosArduino() {
        while (keepListening) {
            if (arduinoPort.bytesAvailable() > 0) {
                byte[] buffer = new byte[arduinoPort.bytesAvailable()];
                arduinoPort.readBytes(buffer, buffer.length);
                String data = new String(buffer).trim();
                System.out.println("Datos recibidos: " + data); // Debug: Ver qué datos recibe
                this.procesarEntrada(data);
            }
        }
    }

    public void cerrarConexionArduino() {
        keepListening = false; // Detener la escucha
        if (arduinoPort != null && arduinoPort.isOpen()) {
            arduinoPort.closePort();
            System.out.println("Conexión cerrada con Arduino.");
        } else {
            System.out.println("La conexión ya estaba cerrada.");
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
            default:
                System.out.println("Entrada no reconocida desde Arduino: " + input);
        }
    }

    private void desactivarBotones() {
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
            objpregunta = objOperacionesPreguntaBD.obtenerPreguntaAleatoria("faciles");
            objOperacionesCartas.mostrarPregunta(objpregunta, objNivelFacil.jButton9);
        }

        if (e.getSource() == this.objNivelFacil.jButton10) {
            cerrarConexionArduino();// Cierra la conexión al volver al menú de niveles
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objNivelFacil.dispose();
        }

        if (e.getSource() == this.objNivelFacil.jButton11) {
            objNivelFacil.jButton11.setEnabled(false);
            estado = true;
            int limiteTiempo = 5;
            Thread hilo = new Thread(() -> {
                desactivarBotones();
                activarBotones();
                while (estado) {
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
                    } catch (Exception ex) {
                        System.out.println("Error en el temporizador: " + ex.getMessage());
                    }
                }
            });
            hilo.start();
            //cerrarConexionArduino();  // Asegúrate de cerrar la conexión antes de reiniciar
            if (!keepListening || arduinoPort == null || !arduinoPort.isOpen()) {
                System.out.println("Intentando iniciar o reiniciar la conexión con Arduino...");
                iniciarConexionArduino(); // Reabrir la conexión solo si no está abierta
            } else {
                System.out.println("La conexión con Arduino ya está activa.");
            }

        }
    }

    public void mostrarPuntaje() {
        cerrarConexionArduino();
        PuntajeFacil objPuntaje = new PuntajeFacil();
        objPuntaje.setLocationRelativeTo(objNivelFacil);
        objPuntaje.setVisible(true);
        this.objNivelFacil.dispose();
        // Actualizar puntaje si es necesario
    }

}