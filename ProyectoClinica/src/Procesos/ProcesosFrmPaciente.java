package Procesos;

import Modelo.Paciente;
import Vista.FrmCitas;

public class ProcesosFrmPaciente {
    public static void Presentacion(FrmCitas f2){
        f2.setTitle("Mantenimiento de Paciente");    
        f2.txtDni1.setEnabled(true);
        f2.setVisible(true);
    }    

    public static void Estado1(FrmCitas f2){
        f2.btnRegistrar.setEnabled(true);
        f2.btnConsultar.setEnabled(true);
        f2.btnActualizar.setEnabled(false);
        f2.btnEliminar.setEnabled(false);
    }
    public static void Estado2(FrmCitas f2){
        f2.btnRegistrar.setEnabled(false);
        f2.btnConsultar.setEnabled(true);
        f2.btnActualizar.setEnabled(true);
        f2.btnEliminar.setEnabled(true);
    }

   public static void LimpiarEntradas(FrmCitas f2){ 
        f2.txtDni1.setText("");
        f2.txtNombres.setText("");
        f2.txtDireccion.setText("");
        f2.txtTelefonoPaciente.setText("");
        f2.cbxTipodeSguro1.setSelectedIndex(0);
        f2.cbxGenero1.setSelectedIndex(0);
        f2.spnEdad.setValue(0);
        f2.txtReferenciado.setText("");
        f2.txtProfesión.setText("");
        f2.spnHijos.setValue(0);
        f2.txtNombres.requestFocus();
       
    }

    public static Paciente LeerDatos(FrmCitas f2){
        Paciente pc =  new Paciente();         
        pc.setDni(Integer.parseInt(f2.txtDni1.getText()));;
        pc.setNombreCompleto(f2.txtNombres.getText());
        pc.setDireccion(f2.txtDireccion.getText());                  
        pc.setTelefono(f2.txtTelefonoPaciente.getText()); 
        pc.setTipoSeguro(f2.cbxTipodeSguro1.getSelectedItem().toString());
        pc.setGenero(f2.cbxGenero1.getSelectedItem().toString());
        pc.setEdad(Integer.parseInt(f2.spnEdad.getValue().toString()));
        pc.setPacienteReferenciado(f2.txtReferenciado.getText());
        pc.setProfesion(f2.txtProfesión.getText());
        pc.setNhijos(Integer.parseInt(f2.spnHijos.getValue().toString()));
       
        return pc;
}
}


