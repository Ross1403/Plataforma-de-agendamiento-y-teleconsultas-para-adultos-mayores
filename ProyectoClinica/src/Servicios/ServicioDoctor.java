package Servicios;
import Modelo.Diagnostico;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ServicioDoctor {
    public static void MostrarDoc(java.util.ArrayList<Diagnostico> Lista, JTable tabla){
        String []titulos = {"Num","ID DOC","DNI","NOMBRE COMPLETO","DIRECCION","TELEFONO","FORMACION ACADEMICA","EXPERIENCIA LABORAL","CERTIFICACION","ESTADO CIVIL","OCUPACION","EMAIL","SEXO","EDAD","HORA ATENCION"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        tabla.setModel(mt);
        for(int i=0; i<Lista.size();i++){
            mt.addRow(Lista.get(i).RegistroDoctor(i+1));
        }
    }
}
