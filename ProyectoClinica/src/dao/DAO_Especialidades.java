
package dao;
import Modelo.*;
import Formatos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DAO_Especialidades extends ConectarBD{
    private Connection conn;

    public DAO_Especialidades() {}
    public void MostrarEspacialidades(JTable tabla, JLabel etiqueta) {
    String[] titulos = {"N","Id", "Nombre", "Descripcion", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
    tabla.setModel(modelo);
    Especialidad esp = new Especialidad();
    int espcreg = 0;
    try {
        rs = st.executeQuery("SELECT Id, Nombre, Descripcion, Estado, Indicador FROM especialidades WHERE Indicador='S';");

        while (rs.next()) {
            espcreg++;
            esp.setId(rs.getInt(1)); // Columna Id
            esp.setNombre(rs.getString(2)); // Columna Nombre
            esp.setDescripcion(rs.getString(3)); // Columna Descripción
            esp.setEstado(rs.getString(4)); // Columna Estado
            modelo.addRow(esp.RegistroEspecialidad(espcreg));
        }
        ManejadorTablas.FormatoTablaCategorias(tabla);
        etiqueta.setText("Numero de Registro: " + espcreg);
        conexion.close();
    } catch (Exception e) {
        Mensajes.M1("ERROR no se pueden mostrar la lista de Especialidades . . . " + e);
    }
}

/*
    public void MostrarEspacialidades(JTable tabla, JLabel etiqueta){
     String[] titulos={"N°, Id","Nombre","Descripcion","Estado"};
         
     DefaultTableModel modelo = new DefaultTableModel(null,titulos);
     tabla.setModel(modelo);
     Especialidad esp = new Especialidad();
     int espcreg=0;
     try{
       rs = st.executeQuery("SELECT Id, Nombre, Descripcion, Estado, Indicador FROM especialidades WHERE Indicador='S';");



     while(rs.next()){
        while (rs.next()) {
    espcreg++;
    esp.setId(rs.getInt(1)); // Columna ID
    esp.setNombre(rs.getString(2)); // Columna Nombre
    esp.setDescripcion(rs.getString(3)); // Columna Descripción
    esp.setEstado(rs.getString(4)); // Columna Estado
    modelo.addRow(esp.RegistroEspecialidad(espcreg));
      }

     }
     ManejadorTablas.FormatoTablaCategorias(tabla);
     etiqueta.setText("Numero de Registro: "+espcreg);
     conexion.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se pueden mostrar la lista de Especialidades . . . "+e);
     }*/
    
 
    public void InsertarEspecialidad (Especialidad esp){
    try{
  ps = conexion.prepareStatement("INSERT INTO especialidades(Id, Nombre, Descripcion, Estado, Indicador) VALUES (?,?,?,?,?)");
  ps.setInt(1, esp.getId());
  ps.setString(2, esp.getNombre());
  ps.setString(3, esp.getDescripcion());
  ps.setString(4, esp.getEstado());
  ps.setString(5, "S");

    
    ps.executeUpdate();
    Mensajes.M1("Datos insertados correctamente");
    conexion.close();
    } catch(Exception e){
    Mensajes.M1("ERROR no se puede insertar Especialidad. . ."+e);
    }
   }
    
public Especialidad ConsultarRegistro(int Id) {
    Especialidad esp = null;
    try {
        rs = st.executeQuery("select id,Nombre,Descripcion,Estado," +
                "indicador from especialidades where indicador='S' and Id=" + Id + ";");
        if (rs.next()) {
            esp = new Especialidad();
            esp.setId(rs.getInt(1));
            esp.setNombre(rs.getString(2));
            esp.setDescripcion(rs.getString(3));
            esp.setEstado(rs.getString(4));
        }
        rs.close();
    } catch (Exception e) {
        Mensajes.M1("ERROR no se puede consultar el registro ... " + e);
    }
    return esp;
}
public void ActualizarRegistro(Especialidad esp) {
    try {
        ps = conexion.prepareStatement("update especialidades set Nombre=?, Descripcion=?, Estado=? where Id=?;");
        ps.setString(1, esp.getNombre());
        ps.setString(2, esp.getDescripcion());
        ps.setString(3, esp.getEstado());
        ps.setInt(4, esp.getId());
        ps.executeUpdate();
        Mensajes.M1("Registro actualizado correctamente...");
        ps.close();
    } catch (Exception ex) {
        Mensajes.M1("ERROR no se puede actualizar el registro..." + ex);
    }
}
public void EliminarRegistro(int Id) {
    try {
        ps = conexion.prepareStatement("update especialidades set indicador='N' where Id=?;");
        ps.setInt(1, Id);
        ps.executeUpdate();
        Mensajes.M1("Registro eliminado de la tabla especialidades");
        ps.close();
    } catch (Exception ex) {
        Mensajes.M1("ERROR no se puede eliminar el registro..." + ex);
    }
}
}
