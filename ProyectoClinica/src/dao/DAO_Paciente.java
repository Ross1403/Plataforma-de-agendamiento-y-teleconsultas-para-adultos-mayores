package dao;
import Formatos.Mensajes;
import Modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
////////////////////////////////
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;


public class DAO_Paciente extends ConectarBD{
    public DAO_Paciente() {}

      //Método que muestra los datos de la tabla paciente en un JTable
    public void MostrarPaciente(JTable tabla,JLabel etiqueta){
        String[] titulos={"Nro","DNI", " Nombre Completo", "Direccion","Telefono","Tipo Seguro","Genero", "Edad","Tipo Sangre", "Referenciado","Profesion","N° hijos"};
                              
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        Paciente pac =  new Paciente();
        int paccreg=0;
   
        try{
            rs = st.executeQuery("select dni,nombreCompleto, direccion,telefono,tipoSeguro,genero,edad,tipoSangre,pacienteReferenciado,profesion,nhijos, indicador from paciente where indicador='S';");
            while(rs.next()){        
                paccreg++;
                pac.setDni(rs.getInt(1));
                pac.setNombreCompleto(rs.getString(2));
                pac.setDireccion(rs.getString(3));
                pac.setTelefono(rs.getString(4));
                pac.setTipoSeguro(rs.getString(5));
                pac.setGenero(rs.getString(6));
                pac.setEdad(rs.getInt(7));
                pac.setTipoSangre(rs.getString(8));
                pac.setPacienteReferenciado(rs.getString(9));
                pac.setProfesion(rs.getString(10));
                pac.setNhijos(rs.getInt(11));
                //doc.setIndicador(rs.getString(10));
                modelo.addRow(pac.RegistroPaciente(paccreg));
             }//fin while
            ManejadorTablas.FormatoTablaCategorias(tabla);
            etiqueta.setText("Numero de Registro: "+paccreg);
            conexion.close();         
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden mostrar la lista de pacientes ...."+e);
        }
    }
     //insertando los datos del paciente
    public void InsertarPaciente(Paciente pac){
      //preparamos la consulta
       try{
            ps = conexion.prepareStatement("insert into paciente(dni,nombreCompleto, direccion,telefono,tipoSeguro,genero,edad,tipoSangre,pacienteReferenciado,profesion,nhijos,indicador) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            //cambiar la asignacion de parametros
            ps.setInt(1, pac.getDni());
           ps.setString(2, pac.getNombreCompleto());
            ps.setString(3, pac.getDireccion());
            ps.setString(4, pac.getTelefono());
            ps.setString(5, pac.getTipoSeguro());
            ps.setString(6, pac.getGenero());
            ps.setInt(7, pac.getEdad());
            ps.setString(8, pac.getTipoSangre());
            ps.setString(9, pac.getPacienteReferenciado());
            ps.setString(10, pac.getProfesion());
            ps.setInt(11, pac.getNhijos());
            ps.setString(12, "S"); // Asigna el valor fijo 'S' para indicador

            ps.executeUpdate(); //actualizamos la consulta y ejecutamos
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
       } catch(Exception e){
            Mensajes.M1("ERROR no se pueden mostrar la lista de pacientes...."+e);
}
}  //consultar paciente 
    public Paciente ConsultarRegistro(int DNI){
        Paciente pac = null; 
        try{
           rs = st.executeQuery("select dni,nombreCompleto, direccion,telefono,tipoSeguro,genero,edad,tipoSangre,pacienteReferenciado,profesion,nhijos,"
                   +"indicador from paciente where indicador='S'  and dni="+DNI+";");
           if(rs.next()){
               pac= new Paciente(); 
                pac.setDni(rs.getInt(1));
                pac.setNombreCompleto(rs.getString(2));
                pac.setDireccion(rs.getString(3));
                pac.setTelefono(rs.getString(4));
                pac.setTipoSeguro(rs.getString(5));
                pac.setGenero(rs.getString(6));
                pac.setEdad(rs.getInt(7));
                pac.setTipoSangre(rs.getString(8));
                pac.setPacienteReferenciado(rs.getString(9));
                pac.setProfesion(rs.getString(10));
                pac.setNhijos(rs.getInt(11));   
           }
           rs.close(); 
        }catch(Exception e){
             Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
        }
        return pac; 
    }
    
    
    public void ActualizarRegistro(Paciente pac) {
    try {
          ps = conexion.prepareStatement(
        "update paciente set nombreCompleto=?, direccion=?, telefono=?, tipoSeguro=?, genero=?, edad=?, tipoSangre=?, pacienteReferenciado=?, profesion=?, nhijos=? where DNI=?;"
    );

    // Asignación de parámetros
    ps.setString(1, pac.getNombreCompleto());
    ps.setString(2, pac.getDireccion());
    ps.setString(3, pac.getTelefono());
    ps.setString(4, pac.getTipoSeguro());
    ps.setString(5, pac.getGenero());
    ps.setInt(6, pac.getEdad());
    ps.setString(7, pac.getTipoSangre());
    ps.setString(8, pac.getPacienteReferenciado());
    ps.setString(9, pac.getProfesion());
    ps.setInt(10, pac.getNhijos());
    ps.setInt(11, pac.getDni());

    ps.executeUpdate(); // Ejecutamos la actualización
    Mensajes.M1("Registro actualizado correctamente...");
    ps.close();
} catch (Exception ex) {
    Mensajes.M1("ERROR no se puede actualizar el registro..." + ex);
}
    }
    public void EliminarRegistro(int DNI) {
    try {
        ps = conexion.prepareStatement("DELETE FROM paciente WHERE DNI=?;");
        ps.setInt(1, DNI);
        ps.executeUpdate();
         Mensajes.M1("Registro eliminado correctamente.");
         ps.close();
         } catch (Exception ex) {
        Mensajes.M1("ERROR no se puede eliminar el registro: " + ex);
    }
}
         
        /*ESTA PARTE DE AQUI DNI SALE COMO SI LO LO RECONonociera 
         public void EliminarRegistro(int DNI ){
            try{
                // Método para eliminar registro del paciente
            ps = conexion.prepareStatement("update paciente set indicador='N' where DNI=?;");
            ps.setInt(1,DNI);
            ps.executeUpdate();
            Mensajes.M1("Registro eliminado de la tabla");
            ps.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede eliminar el registro.."+ex);
        }
    }*/
        }    
