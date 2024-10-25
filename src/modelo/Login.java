package modelo;

public class Login {

    private String usuario, contraseña;
    private int idusaurio;

    public Login() {
    }

    public Login(int idusaurio, String usuario, String contraseña) {
        this.idusaurio = idusaurio;
        this.usuario = usuario;
        this.contraseña = contraseña;
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
