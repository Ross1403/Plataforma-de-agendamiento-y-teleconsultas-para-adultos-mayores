
package Controlador;

import dao.DAO_Doctor;
import Modelo.Diagnostico;
import Procesos.ProcesosFrmDiagnostico;
import Vista.FrmDiagnostico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Formatos.*;
import Vista.ListDoctores;

public class ControlFrmDoctor implements ActionListener{

    FrmDiagnostico vista;
    DAO_Doctor crud; // c: create r:read  u:update   d=delete    
    Diagnostico doc;
   
    
     public ControlFrmDoctor(FrmDiagnostico f1){ 
         vista=f1;
         vista.btnRegistrar.addActionListener(this);
         vista.btnEliminar.addActionListener(this);
         vista.btnActualizar.addActionListener(this);
         vista.btnConsultar.addActionListener(this);
         ProcesosFrmDiagnostico.Presentacion(f1);
          inicializarComboBox(); // Llama al método para configurar el ComboBox
         ActualizarForma();
     }//fin constructor
     
     void ActualizarForma(){
         crud = new DAO_Doctor();
         ProcesosFrmDiagnostico.Estado1(vista);
         ProcesosFrmDiagnostico.LimpiarEntradas(vista);
     }



    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== vista.btnRegistrar){
            doc = ProcesosFrmDiagnostico.LeerDatos(vista);
            crud = new DAO_Doctor();
            crud.InsertarDoctor(doc);
            ActualizarForma();           
       }
       if(e.getSource()== vista.btnConsultar){
           
            int idDoc = Mensajes.M2("Ingrese el ID del Doctor a buscar...");
            crud = new DAO_Doctor();
            doc=crud.ConsultarRegistro(idDoc);
            if(doc==null){
                Mensajes.M1("El id "+idDoc+" no existe en la tabla Doctor...");
            }else{
                vista.txtIdDoctor.setText(Integer.toString(doc.getIdDoc()));
                vista.txtNomCompletd.setText(doc.getNombreCompleto());
                vista.txtDireccion.setText(doc.getDireccion());
                ProcesosFrmDiagnostico.Estado2(vista);
            }
       }
       if(e.getSource()== vista.btnActualizar){
            doc = ProcesosFrmDiagnostico.LeerDatos(vista);
            doc.setIdDoc(Integer.parseInt(vista.txtIdDoctor.getText()));
            crud = new DAO_Doctor();
            crud.ActualizarRegistro(doc);
            ActualizarForma();
       }
       if(e.getSource()== vista.btnEliminar){
            int respuesta = Mensajes.M3("Confirmar!!!!","¿Desea eliminar el registro?");
            if(respuesta==0){
                int idDoc = Integer.parseInt(vista.txtIdDoctor.getText());
                crud = new DAO_Doctor();
                crud.EliminarRegistro(idDoc);
                ActualizarForma();
                ProcesosFrmDiagnostico.LimpiarEntradas(vista); // Limpia los campos del formulario
            }
       }
       
     
       
    }
    
    //prueba de combox
   public void inicializarComboBox() {
    vista.cbxEstadoCivil.removeAllItems(); // Limpia el ComboBox
    vista.cbxEstadoCivil.addItem("Casado");
    vista.cbxEstadoCivil.addItem("Soltero/a");
    vista.cbxEstadoCivil.addItem("Viudo"); 
    vista.cbxEstadoCivil.addItem("Divorciado"); 
    
    vista.cbxGenero.removeAllItems(); // Limpia el ComboBox
    vista.cbxGenero.addItem("Masculino"); 
    vista.cbxGenero.addItem("Femenino");
}
}

