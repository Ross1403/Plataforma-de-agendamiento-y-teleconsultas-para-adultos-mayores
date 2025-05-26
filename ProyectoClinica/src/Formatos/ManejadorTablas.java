package Formatos;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ManejadorTablas {
     public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   //metodo que la da formato a la JTable del tabla Categorias
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,100);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,100);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);      
   }
   
   //metodo que da formato al JTable de la tabla Productos
   public static void FormatoTablaProductos(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,400);
       AnchoColumnas(tabla,3,250);  
       AnchoColumnas(tabla,4,250);  
       AnchoColumnas(tabla,5,250);  
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,120);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,120);
       JustificarCelda(tabla,7);
       AnchoColumnas(tabla,8,120);
       JustificarCelda(tabla,8);
   }
   
}
