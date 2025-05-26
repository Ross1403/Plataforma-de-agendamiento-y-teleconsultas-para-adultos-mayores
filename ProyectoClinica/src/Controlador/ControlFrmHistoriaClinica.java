/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Procesos.*;
import dao.*;
public class ControlFrmHistoriaClinica implements ActionListener {
    
    FrmHistClinica vista;
     
    public ControlFrmHistoriaClinica(FrmHistClinica f4){
        vista=f4;
        vista.btnBuscar.addActionListener(this);        
        vista.btnBuscar.addActionListener(this);
        
        
        vista.setVisible(true);        
    }    
    void ActualizarTabla(){
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
