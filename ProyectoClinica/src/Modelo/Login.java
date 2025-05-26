package Modelo;
public class Login {
    private int idLogin;
    private String Usuario;
    private String Contraseña;

    public Login(){}

     public Object[] Registro(int num){
        Object fila[] = {num, Usuario,Contraseña};
        return fila; 
    }
    public String getUsuario() {        return Usuario;    }
    public void setUsuario(String Usuario) {        this.Usuario = Usuario;    }
    public String getContraseña() {        return Contraseña;    }
    public void setContraseña(String Contraseña) {        this.Contraseña = Contraseña;    }

    public int getIdLogin() {        return idLogin;    }
    public void setIdLogin(int idLogin) {        this.idLogin = idLogin;    } 
}
