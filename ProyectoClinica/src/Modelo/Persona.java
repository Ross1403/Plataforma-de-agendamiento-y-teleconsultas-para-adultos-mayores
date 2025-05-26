
package Modelo;

public class Persona {
    private int idPersona;
    protected String NombreCompleto;
    protected String Direcion;
    protected String Dni;
    protected String Telefono;
    protected String EstadoCivil;
    protected String Genero;
    protected String Edad;
    
    public Persona(){}

    public int getIdPersona() {        return idPersona;    }
    public void setIdPersona(int idPersona) {        this.idPersona = idPersona;    }
    public String getNombreCompleto() {        return NombreCompleto;    }
    public void setNombreCompleto(String NombreCompleto) {        this.NombreCompleto = NombreCompleto;    }
    public String getDirecion() {        return Direcion;    }
    public void setDirecion(String Direcion) {        this.Direcion = Direcion;    }
    public String getDni() {        return Dni;    }
    public void setDni(String Dni) {        this.Dni = Dni;    }
    public String getTelefono() {        return Telefono;    }
    public void setTelefono(String Telefono) {        this.Telefono = Telefono;   }
    public String getEstadoCivil() {        return EstadoCivil;    }
    public void setEstadoCivil(String EstadoCivil) {        this.EstadoCivil = EstadoCivil;    }
    public String getGenero() {        return Genero;    }
    public void setGenero(String Genero) {        this.Genero = Genero;    }
    public String getEdad() {        return Edad;    }
    public void setEdad(String Edad) {        this.Edad = Edad;    }
}
