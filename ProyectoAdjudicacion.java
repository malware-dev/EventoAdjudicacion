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
        mcl.ImprimeMatrizCliente(cl);
    }
    
}
