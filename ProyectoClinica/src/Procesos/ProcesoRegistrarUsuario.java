package Procesos;
import Modelo.*;
import Vista.FrmRegistrarUsuario;

public class ProcesoRegistrarUsuario {
    
public class Mensajes {
    public static void M1(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Mensaje", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}
     public static void Estado1(FrmRegistrarUsuario fr){
        fr.btnRegistrar1.setEnabled(true);
        fr.btnRegresar.setEnabled(true);
    }
   
    public static void LimpiarEntradas(FrmRegistrarUsuario fr){
        fr.txtNewUsuario.setText("");
        fr.txtPassword.setText("");
        fr.txtCorreoElectronico.setText("");
        fr.txtNewUsuario.requestFocus();         
    }
 
   public static RegistrarUsuario LeerDatos(FrmRegistrarUsuario fr) {
    if (fr.txtNewUsuario.getText().isEmpty() || 
        fr.txtPassword.getText().isEmpty() || 
        fr.txtCorreoElectronico.getText().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
            fr,
            "Todos los campos son obligatorios.",
            "Error de Validación",
            javax.swing.JOptionPane.ERROR_MESSAGE
        );
        return null; // Detiene el flujo si faltan datos
    }

    RegistrarUsuario regU = new RegistrarUsuario();
    regU.setNombreUsuario(fr.txtNewUsuario.getText());
    regU.setContrasena(Integer.parseInt(fr.txtPassword.getText()));
    regU.setCorreoElectronico(fr.txtCorreoElectronico.getText());
    return regU;
}}


    

