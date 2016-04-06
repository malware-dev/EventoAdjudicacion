/*
 Este proyecto simula un evento de adjudicación
 */
package proyectoadjudicacion;

import java.time.LocalDate;

public class ProyectoAdjudicacion {
    public static void main(String[] args) {
        Cliente[] cl=new Cliente[7];
        int[] part=new int[7];
        int[] sorteo=new int[7];
        int[] subasta=new int[7];
        MetodosCliente mcl=new MetodosCliente();
        LocalDate f=LocalDate.of(2016,02,15);
        mcl.DatosClienteAleatorio(f, cl);
        mcl.ImprimeMatrizCliente(cl);
        mcl.Participantes(cl, part);
        mcl.MostrarParticipantes(part);
        mcl.AcomodarParticipantes(part, sorteo, subasta);
    }
    
}
