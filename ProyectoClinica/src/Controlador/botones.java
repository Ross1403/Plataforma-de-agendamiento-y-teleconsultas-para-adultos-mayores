package Controlador;
import Modelo.Login;
import Procesos.ProcesosFrmLogin;
import Vista.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class botones {
    /*FrmLogin login;
    Login lt;
    public botones (FrmLogin lg){
        login = lg;
        login.btnEntrar.addActionListener(this);
        login.txtUsuario.addActionListener(this);
        login.jpsContraseña.addActionListener(this);
        ProcesosFrmLogin.LeerDatos(lg);
    }
   
    public void iniciarSesion(FrmLogin loginFrame){
        String usuario = loginFrame.txtUsuario.getText();
        String contraseña = new String(loginFrame.jpsContraseña.getPassword());
        // Validación simple (esto debe reemplazarse con validación de base de datos)
        if (usuario.equals("admin") & contraseña.equals("admin123")) {
            JOptionPane.showMessageDialog(loginFrame, "Inicio de sesión exitoso");
            // Abrir el formulario FrmHistorialCliente
            FrmInterfaz interfaz = new FrmInterfaz();
            interfaz.setVisible(true);
            // Cerrar el formulario de login
            loginFrame.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== login.btnEntrar){
            lt= ProcesosFrmLogin.LeerDatos(login);
            FrmInterfaz interfaz  = new FrmInterfaz();
            interfaz.setVisible(true);
            iniciarSesion(login);
            login.dispose();
       }
    }*/
    
}
