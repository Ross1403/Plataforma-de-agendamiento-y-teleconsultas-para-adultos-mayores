package Servicios;
import Modelo.Paciente;
import Vista.FrmCitas;
import java.util.ArrayList; 
import javax.swing.table.DefaultTableModel; 
import Formatos.*; 

public class ServicioPaciente {
    public static void MostrarEnTabla(ArrayList<Paciente>Lista, FrmCitas pc){
        String[] titulos = {"Nro","DNI", " Nombre Completo", "Direccion","Telefono","Tipo Seguro","Genero", "Edad","Tipo Sangre", "Referenciado","Profesion","N° hijos"}; 
        DefaultTableModel mt =  new DefaultTableModel(null, titulos);
        for(int i=0; i<Lista.size(); i++){
            mt.addRow(Lista.get(i).RegistroPaciente(i+1)); 
        }
        pc.jlblCantidadRegistros.setText("Cantidad de registros : " +Lista.size());
    }    
}
