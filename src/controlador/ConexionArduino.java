package controlador;

import com.fazecast.jSerialComm.SerialPort;

public class ConexionArduino {
    private SerialPort arduinoPort;
    private ControladorNivelFacil controladorNivelFacil;

    public ConexionArduino(ControladorNivelFacil controladorNivelFacil) {
        this.controladorNivelFacil = controladorNivelFacil;
        iniciarConexionArduino();
    }

    private void iniciarConexionArduino() {
        arduinoPort = SerialPort.getCommPort("COM5"); // Asegúrate de que sea el puerto correcto
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
                controladorNivelFacil.procesarEntrada(data);
            }
        }
    }
}