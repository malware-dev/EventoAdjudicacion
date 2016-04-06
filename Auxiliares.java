/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
import javax.swing.JOptionPane;
/**
 *
 * @author samuel
 */
public class Auxiliares {
    public int PideEntero(String f){
        int x=Integer.parseInt(JOptionPane.showInputDialog(null, f));
        return x;
    }
}
