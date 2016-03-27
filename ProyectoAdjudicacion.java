/*
 Este proyecto simula un evento de adjudicación
 */
package proyectoadjudicacion;
public class ProyectoAdjudicacion {
    public static void main(String[] args) {
        Cliente[] cl=new Cliente[2];
        MetodosCliente mcl=new MetodosCliente();
        cl[0]=new Cliente();
        cl[0].fechas = new int[3];
        cl[0].fechas[0]=29;
        System.out.println(cl[0].fechas[0]);
    }
    
}
