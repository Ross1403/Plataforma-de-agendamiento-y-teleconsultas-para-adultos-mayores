package Modelo;

public class Especialidad {
    int id;
    String nombre;
    String descripcion;
    String estado;
    
    public Especialidad() {}
    
   public Object[] RegistroEspecialidad(int num) {
    Object[] fila = {num, id, nombre, descripcion, estado};
    return fila;
}

    
    public Especialidad(int id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
