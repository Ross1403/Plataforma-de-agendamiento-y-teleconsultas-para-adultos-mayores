package dao;

import Formatos.Mensajes;
import Modelo.RegistrarUsuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
////////////////////////////////
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class DAO_RegistrarUsuario extends ConectarBD {
    public DAO_RegistrarUsuario() {}
    
    //insertando los datos de contraseña
   public void InsertarRegistrarUsuario(RegistrarUsuario regU) {
    try {
        ps = conexion.prepareStatement(
            "INSERT INTO registrousuario (nombreUsuario, contraseñaUsuario, correoElectronico) VALUES (?, ?, ?)"
        );
        ps.setString(1, regU.getNombreUsuario());
        ps.setInt(2, regU.getContrasena());
        ps.setString(3, regU.getCorreoElectronico());
        ps.executeUpdate();

        // Verificar si llega a esta línea
        System.out.println("Datos insertados correctamente.");
        Mensajes.M1("Datos insertados correctamente.");
        conexion.close();
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(
            null,
            "Error al registrar: " + e.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
}
}