/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Pregunta;
import java.sql.*;

/**
 *
 * @author Alan
 */
public class OperacionesPreguntaBD {

    private Conexion conexion;

    public OperacionesPreguntaBD() {
        this.conexion = new Conexion();
    }

    public Pregunta obtenerPreguntaAleatoria(String nivel) {
        String consulta = "SELECT * FROM preguntas" + nivel + " ORDER BY RANDOM() LIMIT 1";
        try (Connection conn = conexion.getConexion(); PreparedStatement stmt = conn.prepareStatement(consulta); ResultSet resultado = stmt.executeQuery()) {

            if (resultado.next()) {
                return new Pregunta(
                        resultado.getString("pregunta"),
                        resultado.getString("opca"),
                        resultado.getString("opcb"),
                        resultado.getString("opcc"),
                        resultado.getString("opcd"),
                        resultado.getString("respuestacorrecta").charAt(0)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
