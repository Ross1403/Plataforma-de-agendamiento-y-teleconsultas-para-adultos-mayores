package Modelo;
public class Diagnostico {
    int IdDoc;
    String NombreCompleto;
    String Dni;
    String Direccion;
    String Telefono;
    String FormacionAcademica;
    String ExperienciaLaboral;
    String Certificacion;
    String EstadCivil;
    String Ocupacion; //tipo especializacion
    String Email;
    String Sexo;
    String Edad;
    private String AñosServicio;
    private int HoraAtencion;
    String indicador;
    
    public Diagnostico(){}
    public Object[] RegistroDoctor(int num){
        Object[] fila={num,IdDoc,Dni,NombreCompleto,Edad,Telefono,EstadCivil,Sexo,Direccion,FormacionAcademica,ExperienciaLaboral,AñosServicio,HoraAtencion,Email};
    return fila;         //idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formaciónAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador
    } 

    
    
    public String getIndicador() {        return indicador;    }
    public void setIndicador(String indicador) {        this.indicador = indicador;    }
    public int getIdDoc() {        return IdDoc;    }
    public void setIdDoc(int IdDoc) {        this.IdDoc = IdDoc;    }
    public String getNombreCompleto() {        return NombreCompleto;    }
    public void setNombreCompleto(String NombreCompleto) {        this.NombreCompleto = NombreCompleto;    }
    public String getDni() {        return Dni;    }
    public void setDni(String Dni) {        this.Dni = Dni;    }
    public String getDireccion() {        return Direccion;    }
    public void setDireccion(String Direccion) {        this.Direccion = Direccion;    }
    public String getTelefono() {        return Telefono;    }
    public void setTelefono(String Telefono) {        this.Telefono = Telefono;    }
    public String getFormacionAcademica() {        return FormacionAcademica;    }
    public void setFormacionAcademica(String FormacionAcademica) {        this.FormacionAcademica = FormacionAcademica;    }
    public String getExperienciaLaboral() {        return ExperienciaLaboral;    }
    public void setExperienciaLaboral(String ExperienciaLaboral) {        this.ExperienciaLaboral = ExperienciaLaboral;    }
    public String getCertificacion() {        return Certificacion;    }
    public void setCertificacion(String Certificacion) {        this.Certificacion = Certificacion;    }
    public String getEstadCivil() {        return EstadCivil;    }
    public void setEstadCivil(String EstadCivil) {        this.EstadCivil = EstadCivil;    }
    public String getOcupacion() {        return Ocupacion;    }
    public void setOcupacion(String Ocupacion) {        this.Ocupacion = Ocupacion;    }
    public String getEmail() {        return Email;    }
    public void setEmail(String Email) {        this.Email = Email;    }
    public String getSexo() {        return Sexo;    }
    public void setSexo(String Sexo) {        this.Sexo = Sexo;    }
    public String getEdad() {        return Edad;    }
    public void setEdad(String Edad) {        this.Edad = Edad;    }

    public int getHoraAtencion() {
        return HoraAtencion;
    }

    public void setHoraAtencion(int HoraAtencion) {
        this.HoraAtencion = HoraAtencion;
    }

    public String getAñosServicio() {
        return AñosServicio;
    }

    public void setAñosServicio(String AñosServicio) {
        this.AñosServicio = AñosServicio;
    }

}
