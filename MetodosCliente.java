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
            cli[x].clave_cli=x+1;
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
        System.out.println("Clave Cli\tMonto Men\tFecha Pago\tFecha Vence\tEstatus");
        for(int x=0; x<=cl.length-1; x++){
            for(int y=0; y<=2; y++){
                if(cl[x].fecha[y][1]==null)
                    System.out.print(cl[x].clave_cli+"\t\t"+cl[x].monto[y]+"\t\t"+cl[x].fecha[y][0]+"\t\t\t"+cl[x].estado_men[y]);
                else
                    System.out.print(cl[x].clave_cli+"\t\t"+cl[x].monto[y]+"\t\t"+cl[x].fecha[y][0]+"\t"+cl[x].fecha[y][1]+"\t"+cl[x].estado_men[y]);
                System.out.println("");
            }
            System.out.println("");
        }
    }
    
    public void Participantes(Cliente [] cl, int[] part){
        boolean p;
        for(int x=0; x<=cl.length-1; x++){
            p=true;
            for(int y=0; y<=2; y++){
                if(!cl[x].estado_men[y].equals("Pagado"))
                    p=false;
            }
            if(p)
                part[x]=cl[x].clave_cli;
        }
    }
    
    public void MostrarParticipantes(int[] part){
        boolean b=true;
        System.out.println("Participantes");
        for(int x=0; x<=part.length-1; x++){
            if(part[x]!=0){
                System.out.println("Cliente: "+part[x]);
                b=false;
            }
        }
        if(b)
            System.out.println("No hay participantes en este grupo");
    }
    
    public void AcomodarParticipantes(int[] part, int[] sorteo, int[] subasta){
        int x=0,h=0, i=0, s=0;
        for(int y=0; y<=part.length-1; y++)
            if(part[y]!=0)
                x++;
        if(x<=3)
            sorteo=part;
        else{
            i=RetornaEntero(x-2,2);
            for(h=0; h<=i-1; h++)
                sorteo[h]=part[h];
            for(int j=h; j<=x; j++)
                subasta[j]=part[j];
        }
        
        System.out.println("\nClientes por sorteo");
        for(h=0; h<=sorteo.length-1; h++)
            if(sorteo[h]!=0)
                System.out.println("Cliente: "+sorteo[h]);
        System.out.println("\nClientes por subasta");
        for(h=0; h<=subasta.length-1; h++)
            if(subasta[h]!=0)
                System.out.println("Cliente: "+subasta[h]);
    }
}

