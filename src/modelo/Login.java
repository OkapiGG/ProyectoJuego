package modelo;

public class Login {

    private String nombre, contraseña;
    private int idusaurio;

    public Login() {
    }

    public Login(String usuario, String nombre, String contraseña, int idusaurio) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.idusaurio = idusaurio;
    }

    public String getUsuario() {
        return nombre;
    }

    public void setUsuario(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdusaurio() {
        return idusaurio;
    }

    public void setIdusaurio(int idusaurio) {
        this.idusaurio = idusaurio;
    }

}
