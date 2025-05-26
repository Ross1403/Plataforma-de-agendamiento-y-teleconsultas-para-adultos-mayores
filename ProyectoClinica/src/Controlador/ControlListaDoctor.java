
package Controlador;

import dao.DAO_Doctor;
import Procesos.ProcesosFrmDiagnostico;
import Vista.ListDoctores;

public class ControlListaDoctor {
    ListDoctores vista;
     DAO_Doctor crud;
    public ControlListaDoctor(ListDoctores ls){
        vista = ls; 
        ActualizarForma();
    }
    
    void ActualizarForma(){
         crud = new DAO_Doctor();
         
         //crud.MostrarDoctores(vista.tblDoctores);
         //ProcesosFrmDoctor.Estado1(vista);
         //ProcesosFrmDoctor.LimpiarEntradas(vista);
     }

}
