package Procesos;
import Modelo.Especialidad;
import Vista.FrmEspecialidades;

public class ProcesosFrmEspecialidades {
        
public static void Presentacion(FrmEspecialidades f3){
    f3.setTitle("Mantenimiento de Categorías");    
    f3.txtIdentificador.setEnabled(true);
    f3.setVisible(true);
}    

public static void Estado1(FrmEspecialidades f3){
    f3.btnRegistrar.setEnabled(true);
    f3.btnActualizar.setEnabled(false);
    f3.btnEliminar.setEnabled(false);
}
public static void Estado2(FrmEspecialidades f3){
    f3.btnRegistrar.setEnabled(false);
    f3.btnActualizar.setEnabled(true);
    f3.btnEliminar.setEnabled(true);
}

public static void LimpiarEntradas(FrmEspecialidades f3){
    f3.txtIdentificador.setText("");
    f3.txtNombreEsp.setText("");
    f3.txtDescripcion.setText("");
    f3.cbxEstado.setSelectedIndex(0);
    f3.txtNombreEsp.requestFocus();
}

// leer
public static Especialidad leerEspecialidades(FrmEspecialidades f3) {
    Especialidad esp = new Especialidad();
    esp.setId(Integer.parseInt(f3.txtIdentificador.getText()));;
    esp.setNombre(f3.txtNombreEsp.getText());
    esp.setDescripcion(f3.txtDescripcion.getText());
    esp.setEstado(f3.cbxEstado.getSelectedItem().toString());
    return esp;

}}
