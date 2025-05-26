
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Procesos.*;
import dao.*;
import dao.DAO_Especialidades;
import Formatos.Mensajes;

public class ControlFrmEspecialidades implements ActionListener{
    FrmEspecialidades vista;
    DAO_Especialidades crud;
    Especialidad esp;
    public ControlFrmEspecialidades(FrmEspecialidades f3){        
        vista=f3;
        vista.btnRegistrar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        inicializarComboBox(); // Llama al método para configurar el ComboBox
        ProcesosFrmEspecialidades.Presentacion(f3);
        ActualizarForma();
    }
    void ActualizarForma(){
        crud= new DAO_Especialidades();
        crud.MostrarEspacialidades(vista.tblEspecialidades, vista.jlblCantidadRegistros);
        ProcesosFrmEspecialidades.Estado1(vista);
        ProcesosFrmEspecialidades.LimpiarEntradas(vista);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==vista.btnRegistrar){
           esp = ProcesosFrmEspecialidades.leerEspecialidades(vista);
           crud= new DAO_Especialidades();
           crud.InsertarEspecialidad(esp);
           ActualizarForma();
       }
         if(e.getSource()==vista.btnConsultar){
             
             
           int Id = Mensajes.M2("Ingrese el Id de la Especialidad a buscar . . . "); // Esto obtiene el ID como entero
             crud = new DAO_Especialidades();
             esp=crud.ConsultarRegistro(Id);
            if (esp==null){
                Mensajes.M1("El Id"+Id+"no exsite en la tabla Especialidad");
            }else{
                vista.txtIdentificador.setText(Integer.toString(esp.getId()));
                vista.txtNombreEsp.setText(esp.getNombre());
                vista.txtDescripcion.setText(esp.getDescripcion());
                vista.cbxEstado.setSelectedItem(esp.getEstado());
                ProcesosFrmEspecialidades.Estado2(vista);
            }
         }
         if(e.getSource()==vista.btnActualizar){
             esp=ProcesosFrmEspecialidades.leerEspecialidades(vista);
             esp.setId(Integer.parseInt(vista.txtIdentificador.getText()));
             crud = new DAO_Especialidades();
             crud.ActualizarRegistro(esp);
             ActualizarForma();
         }
         if(e.getSource()== vista.btnEliminar){
             int respuesta = Mensajes.M3("Confirmar!!!!", "¿Desea eliminar el registro?");
             if(respuesta==0){
                 int Id= Integer.parseInt(vista.txtIdentificador.getText());
                 crud = new DAO_Especialidades();
                 crud.EliminarRegistro(Id);
                 ActualizarForma();
             }
         }
    }
    
  public void inicializarComboBox() {
    vista.cbxEstado.removeAllItems(); // Limpia el ComboBox
    vista.cbxEstado.addItem("APERTURADO");
    vista.cbxEstado.addItem("ESPERA");
}

}
