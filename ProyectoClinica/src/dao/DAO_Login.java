package dao;
import Modelo.Login;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_Login {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ConectarBD cn = new ConectarBD();
    
    public Login log(String Usuario, String Contraseña){
        Login lg = new Login();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?";
        try {
            con = cn.conexion;
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Contraseña);
            rs= ps.executeQuery();
            if (rs.next()) {
                lg.setIdLogin(rs.getInt("id"));
                lg.setUsuario(rs.getString("nombre"));
                lg.setContraseña(rs.getString("correo"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lg;
    }
    
    /*
    public boolean Registrar(Login reg){
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?,?,?,?)";
        try {
            con = cn.conexion;
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getUsuario());
            ps.setString(2, reg.getContraseña());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarUsuarios(){
       List<Login> Lista = new ArrayList();
       String sql = "SELECT * FROM usuarios";
       try {
           con = cn.conexion;
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Login lg = new Login();
               lg.setIdLogin(rs.getInt("id"));
               lg.setUsuario(rs.getString("nombre"));
               lg.setContraseña(rs.getString("correo"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "no se encuetnra el vlaor ");
       }
       return Lista;
   }
    
    /*public ArrayList<Login>ListaUsuarios(){
        ArrayList<Login> Lista = new ArrayList();
        String consulta = "select * from login where login.Usuario =(?) and login.Contraseña =(?)";
        try{
            /*PreparedStatement st = null;
            ResultSet rs = null;
            Connection con = (new ConectarBD ()).conexion;
            String consulta = "select * from login where login.Usuario =(?) and login.Contraseña =(?)";*/
            /*
            Connection con = (new ConectarBD ()).conexion;  // recuperamos la conexion
            Statement st = con.createStatement();  //crea espacio para hacer la consulta
            ResultSet rs = st.executeQuery(consulta);  //se ejecuta la consulta
            while(rs.next()){ // recorremos los resultados recuperados fila por fila 
                Login us = new Login();
                us.setUsuario(rs.getString(1));
                us.setContraseña(rs.getString(2));
                             
                Lista.add(us);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "no se encuetnra el vlaor ");
        }
        return Lista;
    }*/
}