/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author samuel
 */
public class MetodosCliente {
    public void DatosClienteAleatorio(LocalDate fev, Cliente[] cli){
        Aleatorio alto=new Aleatorio();
        for(int x=0; x<=cli.length-1; x++){
            cli[x]=new Cliente();
            cli[x].fecha = new LocalDate[3][2];
            for(int y=0; y<=2; y++){
                cli[x].fecha[y][0]=fev.minus(Period.ofMonths(y));
            }
        }
    }
}
