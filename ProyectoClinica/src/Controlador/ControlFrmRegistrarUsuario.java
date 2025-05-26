package Controlador;
import dao.DAO_RegistrarUsuario;
import Modelo.RegistrarUsuario;
import Procesos.ProcesoRegistrarUsuario;
import Vista.FrmRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlFrmRegistrarUsuario implements ActionListener {

    FrmRegistrarUsuario vista;
    DAO_RegistrarUsuario crud;  // c: create r:read  u:update   d=delete  
    RegistrarUsuario regU;

    public ControlFrmRegistrarUsuario(FrmRegistrarUsuario fr) {
       vista = fr;
       vista.btnRegistrar1.addActionListener(this);

        vista.btnRegresar.addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.btnRegistrar1) {
        // Leer datos del formulario
        regU = ProcesoRegistrarUsuario.LeerDatos(vista);

        if (regU != null) { // Asegurarse de que los datos no sean nulos
            crud = new DAO_RegistrarUsuario();
            crud.InsertarRegistrarUsuario(regU);
            ProcesoRegistrarUsuario.LimpiarEntradas(vista);
            
            // Mostrar el mensaje de éxito
            javax.swing.JOptionPane.showMessageDialog(
                vista,
                "El usuario ha sido registrado correctamente.",
                "Registro Exitoso",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}}
