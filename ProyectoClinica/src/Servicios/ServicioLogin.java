package Servicios;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Modelo.Login;
import java.util.ArrayList;

public class ServicioLogin {
    public static void MostrarLog(ArrayList<Login> Lista, JTable tabla){
        String []titulos = {"Num","ID USUARIO","NOMBRE","APELLIDO","EMAIL","CLAVE","NUMERO"};
        DefaultTableModel mt = new DefaultTableModel(null, titulos);
        tabla.setModel(mt);
        for(int i=0; i<Lista.size();i++){
            mt.addRow(Lista.get(i).Registro(i+1));
        }
    }
}
