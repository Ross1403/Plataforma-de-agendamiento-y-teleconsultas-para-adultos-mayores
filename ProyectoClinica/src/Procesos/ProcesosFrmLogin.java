
package Procesos;
import Modelo.Login;
import Vista.FrmLogin;

public class ProcesosFrmLogin {
    public static void Presentacion(FrmLogin f5){
        f5.setTitle("LOGIN DE INICIO");    
        f5.setVisible(true);
    }    
    public static void Estado1(FrmLogin f5){
        f5.btnRegistrar.setEnabled(true);
        f5.btnEntrar.setEnabled(true);
    }
    public static Login LeerDatos(FrmLogin lg){
        Login log =  new Login();         
        log.setUsuario(lg.txtUsuario.getText());
        log.setContraseña(lg.jpsContraseña.getText());                  
        return log;
     }
}
