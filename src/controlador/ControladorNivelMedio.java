package controlador;

import com.fazecast.jSerialComm.SerialPort;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.Timer;
import modelo.Pregunta;
import vista.MenuNiveles;
import vista.NivelMedio;
import vista.PuntajeFacil;
import vista.PuntajeMedio;

public class ControladorNivelMedio implements ActionListener {

    NivelMedio objNivelMedio;
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

    public ControladorNivelMedio(NivelMedio objNivelMedio) {
        this.objNivelMedio = objNivelMedio;
        objOperacionesPreguntaBD = new OperacionesPreguntaBD();
        objOperacionesCartas = new OperacionesCartas(this.timer, this.objpregunta);
        //iniciarConexionArduino();  // Abrimos la conexión al crear el controlador
        desactivarBotones();
        agregarListeners();
    }

    private void agregarListeners() {
        this.objNivelMedio.jButton1.addActionListener(this);
        this.objNivelMedio.jButton2.addActionListener(this);
        this.objNivelMedio.jButton3.addActionListener(this);
        this.objNivelMedio.jButton4.addActionListener(this);
        this.objNivelMedio.jButton5.addActionListener(this);
        this.objNivelMedio.jButton6.addActionListener(this);
        this.objNivelMedio.jButton7.addActionListener(this);
        this.objNivelMedio.jButton8.addActionListener(this);
        this.objNivelMedio.jButton9.addActionListener(this);
        this.objNivelMedio.jButton10.addActionListener(this);  // Botón para regresar al menú
        this.objNivelMedio.jButton11.addActionListener(this);  // Botón para play el nivel
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
                objNivelMedio.jButton1.doClick();
                break;
            case "2":
                objNivelMedio.jButton2.doClick();
                break;
            case "3":
                objNivelMedio.jButton3.doClick();
                break;
            case "4":
                objNivelMedio.jButton4.doClick();
                break;
            case "5":
                objNivelMedio.jButton5.doClick();
                break;
            case "6":
                objNivelMedio.jButton6.doClick();
                break;
            case "7":
                objNivelMedio.jButton7.doClick();
                break;
            case "8":
                objNivelMedio.jButton8.doClick();
                break;
            case "9":
                objNivelMedio.jButton9.doClick();
                break;
            default:
                System.out.println("Entrada no reconocida desde Arduino: " + input);
        }
    }

    private void desactivarBotones() {
        objNivelMedio.jButton1.setEnabled(false);
        objNivelMedio.jButton2.setEnabled(false);
        objNivelMedio.jButton3.setEnabled(false);
        objNivelMedio.jButton4.setEnabled(false);
        objNivelMedio.jButton5.setEnabled(false);
        objNivelMedio.jButton6.setEnabled(false);
        objNivelMedio.jButton7.setEnabled(false);
        objNivelMedio.jButton8.setEnabled(false);
        objNivelMedio.jButton9.setEnabled(false);
    }

    private void activarBotones() {
        objNivelMedio.jButton1.setEnabled(true);
        objNivelMedio.jButton2.setEnabled(true);
        objNivelMedio.jButton3.setEnabled(true);
        objNivelMedio.jButton4.setEnabled(true);
        objNivelMedio.jButton5.setEnabled(true);
        objNivelMedio.jButton6.setEnabled(true);
        objNivelMedio.jButton7.setEnabled(true);
        objNivelMedio.jButton8.setEnabled(true);
        objNivelMedio.jButton9.setEnabled(true);
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

        if (e.getSource() == this.objNivelMedio.jButton10) {
            cerrarConexionArduino();// Cierra la conexión al volver al menú de niveles
            MenuNiveles objMenuNiveles = new MenuNiveles();
            objMenuNiveles.setVisible(true);
            this.objNivelMedio.dispose();
        }

        if (e.getSource() == this.objNivelMedio.jButton11) {
            objNivelMedio.jButton11.setEnabled(false);
            estado = true;
            int limiteTiempo = 40;
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
                        objNivelMedio.jLabel1.setText(":" + min + " : " + seg + " : ");
                        objNivelMedio.jLabel2.setText(":" + miliseg);
                        miliseg++;

                        if ((min * 60 + seg) >= limiteTiempo) {
                            estado = false;
                            mostrarPuntaje();
                            objNivelMedio.jButton11.setEnabled(true);
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
        PuntajeMedio objPuntaje = new PuntajeMedio();
        objPuntaje.setLocationRelativeTo(objNivelMedio);
        objPuntaje.setVisible(true);
        this.objNivelMedio.dispose();
        // Actualizar puntaje si es necesario
    }
}