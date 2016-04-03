/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
/**
 *
 * @author samuel
 */
public class MetodosCliente {
    public boolean FalsoPositivo(){
        int i=(int)Math.floor(Math.random() * 7);
        boolean fpositivo=i<5;
        return fpositivo;
    }
    public int RetornaEntero(int max, int min){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    public void DatosClienteAleatorio(LocalDate fev, Cliente[] cli){
        int x;
        boolean a;
        for(x=0; x<=cli.length-1; x++){
            a=FalsoPositivo();
            cli[x]=new Cliente();
            cli[x].clave_cli=RetornaEntero(50, 0);
            cli[x].fecha = new LocalDate[3][2];
            cli[x].monto = new float[3];
            cli[x].estado_men = new String[3];
            for(int y=0; y<=2; y++){
                cli[x].fecha[y][0]=fev.minus(Period.ofMonths(y));
                cli[x].monto[y]=1500.0f;
                if(a){
                    cli[x].estado_men[y]="Pagado";
                    cli[x].fecha[y][1]=cli[x].fecha[y][0];
                }else{
                    if(FalsoPositivo()){
                        cli[x].estado_men[y]="Vencida";
                        cli[x].fecha[y][1]=cli[x].fecha[y][0].plus(Period.ofDays(RetornaEntero(5,1)));
                    }else{
                        if(FalsoPositivo()){
                            cli[x].estado_men[y]="Pagado";
                            cli[x].fecha[y][1]=cli[x].fecha[y][0];
                        }else{
                            cli[x].estado_men[y]="No Pagado";
                            cli[x].fecha[y][1]=null;
                        }
                    }
                }
            }
        }
    }
    
    public void ImprimeMatrizCliente(Cliente [] cl){
        for(int x=0; x<=cl.length-1; x++){
            for(int y=0; y<=2; y++){
                if(cl[x].fecha[y][1]==null)
                    System.out.print(cl[x].clave_cli+"\t"+cl[x].monto[y]+"\t"+cl[x].fecha[y][0]+"\t\t\t"+cl[x].estado_men[y]);
                else
                    System.out.print(cl[x].clave_cli+"\t"+cl[x].monto[y]+"\t"+cl[x].fecha[y][0]+"\t"+cl[x].fecha[y][1]+"\t"+cl[x].estado_men[y]);
                System.out.println("");
            }
            System.out.println("");
        }
    }
}

