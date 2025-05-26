package Procesos;
import Modelo.Diagnostico;
import Vista.FrmDiagnostico;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ProcesosFrmDiagnostico {
    public static void Presentacion(FrmDiagnostico f1){
        f1.setTitle("Mantenimiento de Doctor");    
        f1.txtIdDoctor.setEnabled(true);
        f1.setVisible(true);
    }    

    public static void Estado1(FrmDiagnostico f1){
        f1.btnRegistrar.setEnabled(true);
        f1.btnConsultar.setEnabled(true);
        f1.btnActualizar.setEnabled(false);
        f1.btnEliminar.setEnabled(false);
    }
    public static void Estado2(FrmDiagnostico f1){
        f1.btnRegistrar.setEnabled(false);
        f1.btnConsultar.setEnabled(true);
        f1.btnActualizar.setEnabled(true);
        f1.btnEliminar.setEnabled(true);
    }

    public static void LimpiarEntradas(FrmDiagnostico f1){
        f1.txtBuscarDoc.setText("");
        f1.txtIdDoctor.setText("");
        f1.txtNomCompletd.setText("");
        f1.txtDireccion.setText("");
        f1.txtDNI.setText("");
        f1.txtTelefono.setText("");
        f1.txtAñosServicio.setText("");
        f1.cbxGenero.setSelectedIndex(0);
        f1.txaExperienciaLaboral.setText("");
        f1.cbxEstadoCivil.setSelectedIndex(0);
        f1.txtEmail.setText("");
        f1.spnHorarioAtencion.setValue(0);
        f1.txtEdad.setText("");
        Calendar cal = new GregorianCalendar();
        f1.txtNomCompletd.requestFocus();
    }
 //idDoc,dni,nombreCompleto,edad,telefono,estadoCivil,genero,direccion,formaciónAcademica,experienciaLaboral,añosServicio,horarioAtencion,email,indicador
//metodo que la categoria
    public static Diagnostico LeerDatos(FrmDiagnostico f1){
        Diagnostico doct =  new Diagnostico();   
        doct.setIdDoc(Integer.parseInt(f1.txtIdDoctor.getText()));;
        doct.setNombreCompleto(f1.txtNomCompletd.getText());
        doct.setDireccion(f1.txtDireccion.getText());    
        doct.setDni(f1.txtDNI.getText());    
        doct.setTelefono(f1.txtTelefono.getText());    
        doct.setAñosServicio(f1.txtAñosServicio.getText());
        doct.setEstadCivil(f1.cbxEstadoCivil.getSelectedItem().toString());   // para combobox
        doct.setSexo(f1.cbxGenero.getSelectedItem().toString());
        doct.setHoraAtencion(Integer.parseInt(f1.spnHorarioAtencion.getValue().toString()));   //para spn
        doct.setExperienciaLaboral(f1.txaExperienciaLaboral.getText());
        doct.setEmail(f1.txtEmail.getText());
        doct.setEdad(f1.txtEdad.getText());

        return doct;
     }
}
