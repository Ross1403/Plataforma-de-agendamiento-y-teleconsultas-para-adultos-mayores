package Modelo;
public class Paciente {
    // nuevos datos ingresados
    
     int dni; 
     String nombreCompleto;
     String direccion; 
     String telefono; 
     String tipoSeguro; 
     String genero; 
     int edad; 
     String tipoSangre; 
     String pacienteReferenciado; 
     String profesion; 
     int nhijos; 
     String indicador;
     
    public Paciente(){}
    public Object[] RegistroPaciente(int num){
        Object[] fila={num,dni,nombreCompleto, direccion,telefono,tipoSeguro,genero,edad,tipoSangre,pacienteReferenciado,profesion,nhijos};
    return fila;         
    } 

    public int getDni() {
        return dni;
    }public void setDni(int dni) {
        this.dni = dni;
    }public String getNombreCompleto() {
        return nombreCompleto;
    }public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }public String getDireccion() {
        return direccion;
    }public void setDireccion(String direccion) {
        this.direccion = direccion;
    }public String getTelefono() {
        return telefono;
    }public void setTelefono(String telefono) {
        this.telefono = telefono;
    }public String getTipoSeguro() {
        return tipoSeguro;
    }public void setTipoSeguro(String tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }public String getGenero() {
        return genero;
    }public void setGenero(String genero) {
        this.genero = genero;
    }public int getEdad() {
        return edad;
    }public void setEdad(int edad) {
        this.edad = edad;
    }public String getTipoSangre() {
        return tipoSangre;
    }public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }public String getPacienteReferenciado() {
        return pacienteReferenciado;
    }public void setPacienteReferenciado(String pacienteReferenciado) {
        this.pacienteReferenciado = pacienteReferenciado;
    }public String getProfesion() {
        return profesion;
    }public void setProfesion(String profesion) {
        this.profesion = profesion;
    }public int getNhijos() {
        return nhijos;
    }public void setNhijos(int nhijos) {
        this.nhijos = nhijos;
    }public String getIndicador() {
        return indicador;
    }public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
}