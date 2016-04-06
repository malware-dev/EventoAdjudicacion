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
        boolean b=true;
        int a=0;
        for(int x=0; x<=cl.length-1; x++){
            b=true;
            for(int y=0; y<=2; y++){
                if(!cl[x].estado_men[y].equals("Pagado")){
                    b=false;
                }
            }
            if(b){
                part[a]=cl[x].clave_cli;
                a++;
            }
        }
    }
    
    public void MostrarParticipantes(int[] part){
        int x=0;
        System.out.println("Participantes");
        while(part[x]!=0 && x<=part.length-1){
            System.out.println("Cliente: "+part[x]+" Indice "+x);
            x++;
            if(x==part.length) break;
        }
    }
    
    public void AcomodarParticipantes(int[] part, int[] sorteo, int[] subasta){
        int x=0, h, i, s=0;
        while(part[x]!=0 && x<=part.length-1){
            x++;
            if(x==part.length) break;
        }
        if(x<=3){
            sorteo=part;
        }else{
            i=RetornaEntero(x-2,2);
            for(h=0; h<=i-1; h++)
                sorteo[h]=part[h];
            for(h=h; h<=x-1; h++){
                subasta[s]=part[h];
                s++;
            }
        }
        x=0;
        System.out.println("\nClientes por sorteo:");
        while(sorteo[x]!=0 && x<=sorteo.length-1){
            System.out.println("Cliente: "+sorteo[x]);
            x++;
            if(x==sorteo.length) break;
        }
        x=0;
        System.out.println("\nClientes por subasta");
        while(subasta[x]!=0 && x<=subasta.length-1){
            System.out.println("Cliente: "+subasta[x]);
            x++;
            if(x==sorteo.length) break;
        }
    }
    
    public void Evento(){
    
    }
}

