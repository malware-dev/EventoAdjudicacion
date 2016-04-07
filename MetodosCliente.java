/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import javax.swing.JOptionPane;
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
                    System.out.printf(cl[x].clave_cli+"\t\t%.2f\t\t"+cl[x].fecha[y][0]+"\t\t\t"+cl[x].estado_men[y],cl[x].monto[y]);
                else
                    System.out.printf(cl[x].clave_cli+"\t\t%.2f\t\t"+cl[x].fecha[y][0]+"\t"+cl[x].fecha[y][1]+"\t"+cl[x].estado_men[y],cl[x].monto[y]);
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
            for(h=0; h<=2; h++)
                sorteo[h]=part[h];
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
        JOptionPane.showMessageDialog(null,"Se mostrarán lo clientes por sorteo");
        System.out.println("\nClientes por sorteo:");
        while(sorteo[x]!=0 && x<=sorteo.length-1){
            System.out.println("Cliente: "+sorteo[x]);
            x++;
            if(x==sorteo.length) break;
        }
        if(subasta[0]!=0){
            x=0;
            JOptionPane.showMessageDialog(null,"Se mostrarán los clientes por subasta");
            System.out.println("\nClientes por subasta");
            while(subasta[x]!=0 && x<=subasta.length-1){
                System.out.println("Cliente: "+subasta[x]);
                x++;
                if(x==sorteo.length) break;
            }
        }
    }
    
    public void Evento(int[] sorteo, int[] subasta, Cliente[] cl, int[] men_subastadas){
        boolean b;
        int s=0, su=0, ms=0,c=0, gs=0;
        JOptionPane.showMessageDialog(null, "Se iniciará el evento para el grupo\nseleccionado");
        while(sorteo[s]!=0 && s<=sorteo.length-1){
            s++;
            if(s==sorteo.length) break;
        }
        int gana_sorteo=sorteo[RetornaEntero(s-1,0)];
        while(cl[c].clave_cli!=gana_sorteo)
            c++;
        JOptionPane.showMessageDialog(null, "El cliente "+cl[c].clave_cli+" ganó por sorteo");
        for(int y=0; y<=2; y++)
            cl[c].estado_men[y]="Adjudicado Ganador por Sorteo";
        while(subasta[su]!=0 && su<=subasta.length-1){
            su++;
            if(su==subasta.length) break;
        }
        if(su>0){
            JOptionPane.showMessageDialog(null, "Se iniciará la subasta para el grupo seleccionado");
            do{
                System.out.println("");
                for(int d=0; d<=su-1; d++)
                    men_subastadas[d]+=RetornaEntero(3,1);
                for(int d=0; d<=su-1; d++){
                    System.out.println("El cliente "+subasta[d]+" ofrece "+men_subastadas[d]+" mensualidades ahora");
                    if(men_subastadas[d]>ms){
                        gs=subasta[d];
                        ms=men_subastadas[d];
                    }
                    if(ms>=9){
                        System.out.println("Solo se pueden subastar hasta 9 mensualidades");
                        break;
                    }
                }
                b=JOptionPane.showInputDialog(null, "Desea volver a subastar s/n").equalsIgnoreCase("s");
            }while(b && ms<9);
            c=0;
            while(cl[c].clave_cli!=gs)
                c++;
            for(int y=0; y<=2; y++)
                cl[c].estado_men[y]="Adjudicado Ganador por Subasta";
            JOptionPane.showMessageDialog(null,"Se mostrará el estado de los clientes\ndel grupo en función");
            ImprimeMatrizCliente(cl);
            JOptionPane.showMessageDialog(null,"Ha terminado el evento para este grupo");
        }
    }
}