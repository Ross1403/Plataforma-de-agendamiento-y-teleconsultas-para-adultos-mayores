package dao;
import Configuracion.Parametros;
import java.sql.*;
import Formatos.*;

/**
 *
 * CONEXION A BASE DE DATOS
 */
public class ConectarBD implements Parametros{
    public Connection conexion;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    ResultSetMetaData mdata;
    
    public ConectarBD(){
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(RUTA,USUARIO,CLAVE);
            st = conexion.createStatement();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede conectar a la BD..."+ex);
        }
    }
}
