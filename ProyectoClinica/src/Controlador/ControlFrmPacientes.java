package Controlador;

import dao.DAO_Paciente;
import Modelo.Paciente;
import Procesos.ProcesosFrmPaciente;
import Vista.FrmCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formatos.*;


  
public class ControlFrmPacientes implements ActionListener  {

    FrmCitas vista;
    DAO_Paciente crud;  // c: create r:read  u:update   d=delete  
    Paciente pac;
    
    public ControlFrmPacientes(FrmCitas f2){        
        vista=f2;
        vista.btnRegistrar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        inicializarComboBox(); // Llama al método para configurar el ComboBox
      
        ProcesosFrmPaciente.Presentacion(f2);
        ActualizarForma();
        
        //ublic void inicializarComboBox() {
   
    }
    
    void ActualizarForma(){
         crud = new DAO_Paciente();
         ProcesosFrmPaciente.Estado1(vista);
         ProcesosFrmPaciente.LimpiarEntradas(vista);
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnRegistrar){
            pac = ProcesosFrmPaciente.LeerDatos(vista);
            crud = new DAO_Paciente();
            crud.InsertarPaciente(pac);
            ActualizarForma();           
       }
        if(e.getSource()== vista.btnConsultar){
            int DNI= Mensajes.M2("Ingrese el DNI de la tabla Paciente a buscar...");
            crud = new DAO_Paciente();
            pac=crud.ConsultarRegistro(DNI);
            if(pac==null){
                Mensajes.M1("El id "+DNI+" no existe en la tabla Pacientes...");
            }else{
                vista.txtDni1.setText(Integer.toString(pac.getDni()));
                vista.txtNombres.setText(pac.getNombreCompleto());
                vista.txtDireccion.setText(pac.getDireccion());
                
                ProcesosFrmPaciente.Estado2(vista);
                
                
                
            }
      }
       if(e.getSource()== vista.btnActualizar){
            pac = ProcesosFrmPaciente.LeerDatos(vista);
            pac.setDni(Integer.parseInt(vista.txtDni1.getText()));
            crud = new DAO_Paciente();
            crud.ActualizarRegistro(pac);
            ActualizarForma();
       }
       if (e.getSource() == vista.btnEliminar) {
       int respuesta = Mensajes.M3("Confirmar", "¿Desea eliminar el registro?");
       if (respuesta == 0) { // Si confirma
        int DNI = Integer.parseInt(vista.txtDni1.getText());
        crud = new DAO_Paciente();
        crud.EliminarRegistro(DNI);
        ActualizarForma(); // Refresca la tabla
        ProcesosFrmPaciente.LimpiarEntradas(vista); // Limpia los campos del formulario
    }
}
        
    }
 //prueba de combox
   public void inicializarComboBox() {
    vista.cbxTipodeSguro1.addItem("SIS");
    vista.cbxTipodeSguro1.addItem("ESSALUD");
    vista.cbxGenero1.addItem("Masculino"); 
    vista.cbxGenero1.addItem("Femenino");
}
}
