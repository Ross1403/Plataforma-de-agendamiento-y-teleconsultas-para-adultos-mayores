
package dao;
import Formatos.Mensajes;
import Modelo.Diagnostico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
////////////////////////////////
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class DAO_Doctor extends ConectarBD{
    public DAO_Doctor(){}

     //Método que muestra los datos de la tabla categorías en un JTable
    public void MostrarDoctores(JTable tabla,JLabel etiqueta){
        String[] titulos={"Nro","IdDoc","DNI","Nombre del Doctor","Edad","Telefono","Estado Civil","Genero","Dirección","formacionAcademica","Experiencia Laboral","Años Servicio","Horario Atencion","Email"};
                               //idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formaciónAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        Diagnostico doc =  new Diagnostico();
        int docreg=0;
        try{
            rs = st.executeQuery("select idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formacionAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador from doctor where indicador='S';");
            while(rs.next()){          //idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formaciónAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador
                docreg++;
                doc.setIdDoc(rs.getInt(1));
                doc.setDni(rs.getString(2));
                doc.setNombreCompleto(rs.getString(3));
                doc.setEdad(rs.getString(4));
                doc.setTelefono(rs.getString(5));
                doc.setSexo(rs.getString(7));
                doc.setEstadCivil(rs.getString(6));
                doc.setDireccion(rs.getString(8));
                doc.setFormacionAcademica(rs.getString(9));
                doc.setExperienciaLaboral(rs.getString(10));
                doc.setAñosServicio(rs.getString(11));
                doc.setHoraAtencion(rs.getInt(12));
                doc.setEmail(rs.getString(13));
                //doc.setIndicador(rs.getString(10));
                modelo.addRow(doc.RegistroDoctor(docreg));
            }//fin while
            ManejadorTablas.FormatoTablaCategorias(tabla);
            etiqueta.setText("Numero de Registro: "+docreg);
            conexion.close();         
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden mostrar la lista de Doctores ...."+e);
        }
    }  
 
    public void InsertarDoctor(Diagnostico doc){
        try{
            //preparamos la consulta
            ps = conexion.prepareStatement("insert into doctor(idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formacionAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador) values (?,?,?,?,?,?,?,?,?,?,?,?,?,'S')");
            //actualizando los parametros
            ps.setInt(1,doc.getIdDoc());
            ps.setString(2,doc.getDni());
            ps.setString(3,doc.getNombreCompleto());
            ps.setString(4, doc.getEdad());
            ps.setString(5,doc.getTelefono());
            ps.setString(6,doc.getEstadCivil());
            ps.setString(7,doc.getSexo());
            ps.setString(8,doc.getDireccion());
            ps.setString(9,doc.getFormacionAcademica());
            ps.setString(10,doc.getExperienciaLaboral());
            ps.setString(11,doc.getAñosServicio());
            ps.setInt(12,doc.getHoraAtencion());
            ps.setString(13,doc.getEmail());
            ps.executeUpdate(); //actualizamos la consulta y ejecutamos
            Mensajes.M1("Datos insertados correctamente");
            conexion.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar doctor..."+e);
        }
    }
     //cambiar
    public Diagnostico ConsultarRegistro(int idDoc){
        Diagnostico doc = null;
        try{
           rs = st.executeQuery("select idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,"
                   +"genero,direccion,formacionAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador from doctor where indicador='S' and idDoc="+idDoc+";");
            if(rs.next()){
                doc = new Diagnostico();
                doc.setIdDoc(rs.getInt(1));
                doc.setDni(rs.getString(2));
                doc.setNombreCompleto(rs.getString(3));
                doc.setEdad(rs.getString(4));
                doc.setTelefono(rs.getString(5));
                doc.setSexo(rs.getString(7));
                doc.setEstadCivil(rs.getString(6));
                doc.setDireccion(rs.getString(8));
                doc.setFormacionAcademica(rs.getString(9));
                doc.setExperienciaLaboral(rs.getString(10));
                doc.setAñosServicio(rs.getString(11));
                doc.setHoraAtencion(rs.getInt(12));
                doc.setEmail(rs.getString(13));
            }
            rs.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
        }
        return doc;
    }
    
    public void ActualizarRegistro(Diagnostico doc){
        try{
            ps = conexion.prepareStatement(
    "update doctor set nombreCompleto=?, dni=?, edad=?, telefono=?, estadoCivil=?, genero=?, direccion=?, formacionAcademica=?, experienciaLaboral=?, añosServicio=?, horarioAtencion=?, email=? where idDoc=?;"
);
           
           ps.setString(1, doc.getNombreCompleto());
           ps.setString(2, doc.getDni());
           ps.setString(3, doc.getEdad());
           ps.setString(4, doc.getTelefono());
           ps.setString(5, doc.getEstadCivil());
           ps.setString(6, doc.getSexo());
           ps.setString(7, doc.getDireccion());
           ps.setString(8, doc.getFormacionAcademica());
           ps.setString(9, doc.getExperienciaLaboral());
           ps.setString(10, doc.getAñosServicio());
           ps.setInt(11, doc.getHoraAtencion());
           ps.setString(12, doc.getEmail());
           ps.setInt(13, doc.getIdDoc()); // Este es el filtro (WHERE idDoc=?)
           ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente...");
            ps.close();
        }catch(Exception  ex){
            Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
        }
    }
    
    public void EliminarRegistro(int idDoc){
        try{
            ps = conexion.prepareStatement("update doctor set indicador='N' where idDoc=?;");
            ps.setInt(1,idDoc);
            ps.executeUpdate();
            Mensajes.M1("Registro eliminado de la tabla Categorias");
            ps.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede eliminar el registro.."+ex);
        }
    }
  
    
}   
    /***
     * 
     * 
     * 
     * public ArrayList<Doctor> MostrarDoctor(){
        ArrayList<Doctor> Lista = new ArrayList();
        String Consulta = "select IdDoc,NombreCompleto,Dni,Direccion,Telefono,FormacionAcademica,ExperienciaLaboral,Certificacion,EstadCivil,Ocupacion,Email,Sexo,Edad,HoraAtencion"+" from Doctor where indicador = 'S' order by 2;";
        try{
            rs = st.executeQuery(Consulta);
            while(rs.next()){
                Doctor dc = new Doctor();
                dc.setIdDoc(rs.getInt("idDoc"));
                dc.setNombreCompleto(rs.getString("nombrecompleto"));
                dc.setDni(rs.getString("dni"));
                dc.setDireccion(rs.getString("direccion"));
                dc.setTelefono(rs.getString("telefono"));
                dc.setFormacionAcademica(rs.getString("formacionacadmica"));
                dc.setExperienciaLaboral(rs.getString("experiencialaboral"));
                dc.setCertificacion(rs.getString("certificacion"));
                dc.setEstadCivil(rs.getString("estadcivil"));
                dc.setOcupacion(rs.getString("ocupacion"));
                dc.setEmail(rs.getString("email"));
                dc.setSexo(rs.getString("sexo"));
                dc.setEdad(rs.getString("edad"));
                dc.setHoraAtencion(rs.getString("horaatencion"));
                Lista.add(dc);
            }
        }catch (Exception ex){
            Mensajes.M1("ERROR no se puede hacer la consulta "+ex);
        }
        return Lista;
    }
    
    public void InsertarDoctor (Doctor doc){
        try{
            ps = conexion.prepareStatement("insert into Doctor(nombrecompleto,dni,direccion,telefono,formacionacademica,experiencialaboral,certificacion,estadcivil,ocupacion,email,sexo,edad,horaatencion)"+ " values(?,?,'S')");
            ps.setString(1, doc.getNombreCompleto());
            ps.setString(2, doc.getDni());
            ps.setString(2, doc.getDireccion());
            ps.setString(2,doc.getTelefono());
            ps.setString(2, doc.getDni());
            ps.setString(2, doc.getDni());
            ps.setString(2, doc.getDni());
            ps.setString(2, doc.getDni());
            ps.setString(2, doc.getDni());
            
        }catch (Exception ex){
            
        }
    }
    
    public void guardar(Doctor doctor) {
        String sql = "INSERT INTO pacientes (dni, nombre, direccion, telefono, estado_civil, genero, edad, tipo_seguro, tipo_sangre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, doctor.getIdDoc());
            stmt.setString(2, doctor.getDni());
            stmt.setString(3, doctor.getNombreCompleto());
            stmt.setString(4, doctor.getDireccion());
            stmt.setString(5, doctor.getTelefono());
            stmt.setString(6, doctor.getEstadCivil());
            stmt.setString(7, doctor.getSexo());
            stmt.setString(8, doctor.getEdad());
            stmt.setString(9, doctor.getFormacionAcademica());
            stmt.setString(10, doctor.getExperienciaLaboral());
            stmt.setString(11, doctor.getCertificacion());
            stmt.setString(12, doctor.getOcupacion());
            stmt.setString(13, doctor.getEmail());
            stmt.setString(14, doctor.getHoraAtencion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Doctor> obtenerTodos() {
        List<Doctor> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Doctor doc = new Doctor();
                doc.setDni(rs.getString("dni"));
                doc.setNombreCompleto(rs.getString("nombres"));
                doc.setDireccion(rs.getString("direccion"));
                doc.setTelefono(rs.getString("telefono"));
                doc.setFormacionAcademica(rs.getString("Formacion Academica"));
                doc.setSexo(rs.getString("genero"));
                doc.setIdDoc(rs.getInt("edad"));
                doc.setExperienciaLaboral(rs.getString("Experiencia Laboral"));
                doc.setOcupacion(rs.getString("Ocupacion"));
                lista.add(doc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }*/

