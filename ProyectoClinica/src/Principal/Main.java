package Principal;

import Vista.*;
import Controlador.*;
// tener en cuenta que solo lo implemente como ejemplo aqui se importa el controlador
/**
 *
 * Class main --> proyect 4 ciclo
 */
public class Main {
    public static FrmLogin lg;
    public static ControlLogin controllg;
    
    public static FrmInterfaz fm;
    public static ControladorMenu controlfm;
    
   
    
    public static void main(String[] args) {
        lg = new FrmLogin();
        controllg = new ControlLogin(lg);
        lg.setVisible(true);
        /*fm = new FrmInterfaz();
        controlfm = new ControladorMenu(fm);*/
       //controlfm = new ControladorMenu(fm);
    }
}