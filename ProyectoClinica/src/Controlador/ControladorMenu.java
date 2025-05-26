package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Formatos.*;
import javax.swing.JFrame;

public class ControladorMenu implements ActionListener {
 
    FrmInterfaz  vista;
    public ControladorMenu(FrmInterfaz fm){
        vista = fm;
        vista.metemRegistrarDoctor.addActionListener(this);
        vista.metemRegistrarPaciente.addActionListener(this);
        vista.metenEspecialidades.addActionListener(this);
        vista.metemHistoriaClinica.addActionListener(this);
        vista.metemListarDoctores.addActionListener(this);
        fm.setExtendedState(JFrame.MAXIMIZED_VERT);
        fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
        fm.setVisible(true);
        fm.setTitle("Aplicación de Historialinica");  
    }
    

//FALTA REPARAR ESTA PARTE DE AQUI DEL BOTON PARA INICAR SESION 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.metemRegistrarDoctor){ 
            
            FrmDiagnostico f1 = new FrmDiagnostico();
            ControlFrmDoctor  controlf1 = new ControlFrmDoctor(f1);
         /* Main.f1 = new FrmDiagnostico();
          Main.controlf1 = new ControlFrmDoctor(Main.f1);*/          
          vista.dspEscritorio.add(f1);          
          CentrarForma.CPanel(vista.dspEscritorio,f1);
        }
        if(e.getSource()== vista.metemRegistrarPaciente){
            FrmCitas f2 = new FrmCitas();
            ControlFrmPacientes controlf2 =  new ControlFrmPacientes(f2);
            vista.dspEscritorio.add(f2);
            CentrarForma.CPanel(vista.dspEscritorio,f2);
        }
      
        if(e.getSource()== vista.metenEspecialidades){
            FrmEspecialidades f3 =  new FrmEspecialidades();
            ControlFrmEspecialidades controlf3 = new ControlFrmEspecialidades(f3);
            vista.dspEscritorio.add(f3);
            CentrarForma.CPanel(vista.dspEscritorio,f3);
        }
        
        if(e.getSource()== vista.metemHistoriaClinica){
            FrmHistClinica f4 =  new FrmHistClinica();
            ControlFrmHistoriaClinica controlf4 = new ControlFrmHistoriaClinica(f4);
            vista.dspEscritorio.add(f4);
            CentrarForma.CPanel(vista.dspEscritorio,f4);
        }
        
        //para lista de doctores
        if(e.getSource()== vista.metemListarDoctores){
            ListDoctores f5 =  new ListDoctores();
            vista.dspEscritorio.add(f5);
            CentrarForma.CPanel(vista.dspEscritorio,f5);
        }
        /*if(e.getSource()== log.btnEntrar){
            FrmInterfaz f6 = new FrmInterfaz();
            ControlLogin controlf6 = new ControlLogin();
            log.btnEntrar.add(f6);
            
        }*/
    }  
}

