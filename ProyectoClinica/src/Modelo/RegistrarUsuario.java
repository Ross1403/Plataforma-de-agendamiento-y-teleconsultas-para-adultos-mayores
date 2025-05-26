package Modelo;

public class RegistrarUsuario {
    String correoElectronico; 
    String nombreUsuario;
    int contrasena; 
    int idUsuario; 
    
    public RegistrarUsuario(){}
    public Object[] RegistroUsuario(int num){
        Object[] fila={num,idUsuario,nombreUsuario,contrasena,correoElectronico};
    return fila; 
}

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public int getContrasena() {
        return contrasena;
    }
    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
