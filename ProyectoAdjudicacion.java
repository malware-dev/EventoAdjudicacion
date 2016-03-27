/*
 Este proyecto simula un evento de adjudicación
 */
package proyectoadjudicacion;

import java.time.LocalDate;

public class ProyectoAdjudicacion {
    public static void main(String[] args) {
        Cliente[] cl=new Cliente[2];
        MetodosCliente mcl=new MetodosCliente();
        LocalDate f=LocalDate.of(2016,02,15);
        mcl.DatosClienteAleatorio(f, cl);
        System.out.println(cl[0].fecha[0][0]+""+cl[0].fecha[1][0]+""+cl[0].fecha[2][0]);
    }
    
}
