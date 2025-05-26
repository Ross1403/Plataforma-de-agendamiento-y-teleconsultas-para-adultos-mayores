package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Servicios.*;
import Modelo.Login;
import Procesos.ProcesosFrmLogin;
import Vista.*;

public class ControlLogin implements ActionListener {
     public static ControladorMenu men;
     public static FrmInterfaz fm;
    FrmLogin vista;
    Login log;
    public ControlLogin(FrmLogin lg){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnRegistrar){
            log = ProcesosFrmLogin.LeerDatos(vista);
            fm = new FrmInterfaz();
            men = new ControladorMenu(fm);
            
          
       }
        
    
    }
    
}
