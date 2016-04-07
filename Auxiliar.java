/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;

import java.awt.HeadlessException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class Auxiliar {
    public int PideEntero(String f){
        int x=0;
        boolean h=true;
        do{
            try{
                x=Integer.parseInt(JOptionPane.showInputDialog(null, f));
                h=false;
            }catch(HeadlessException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "VALOR NO ACEPTADO");
            }
        }while(h);
        return x;
    }
    
    public LocalDate PideFecha(){
        boolean f=true;
        LocalDate fe=null;
        do{
            String fecha=JOptionPane.showInputDialog(null,"INTRODUZCA LA FECHA DEL EVENTO\nAAAA-MM-DD6\n","FECHA",1);
            try{
                fe=LocalDate.parse(fecha);
                f=false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "VALOR NO ACEPTADO");
            }
        }while(f);
        return fe;
    }
}
