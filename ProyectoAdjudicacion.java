/*
 Este proyecto simula un evento de adjudicación
 */
package proyectoadjudicacion;

import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProyectoAdjudicacion {
    public static void main(String[] args) {
        MetodosCliente mcl=new MetodosCliente();
        LocalDate f=LocalDate.of(2016,02,15);
        Scanner recibir=new Scanner(System.in);
        String fecha;
        int respuesta=0, res=0, numgrup=0, personasporgrupo=0;
        boolean x=false,c=false;
        //Aplicación de secuencias de escape y formato en números decimales, presentando de preferencia en tablas
        do{
            try{
                res=Integer.parseInt(JOptionPane.showInputDialog(null,"\\\'ESTE ES UN PROGRAMA DE UN EVENTO DE ADJUDICACION\'\\\n ¿DESEA CONTINUAR? \n 1=si o 2=no","INICIO",1));//Aplicación de ciclo for y while o do-while (por lo menos 2). Uno de ellos dejará de realizar iteraciones cuando el usuario lo decida.
                c=true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"SELECCIONE UNA OPCION DEL MENU PORFAVOR","CONTINUAR",1);
            }
        }while(!c);
        
        switch(res){
            case 1:
                do{
                    do{
                        try{//Control de errores en tiempos de ejecución perfectamente delimitados (try-catch)
                            respuesta=Integer.parseInt(JOptionPane.showInputDialog(null,"1.- FECHA DEL EVENTO\n2.-NUMERO DE GRUPOS\n3.-CLIENTES POR GRUPO\n4.-VER UN GRUPO\n5.-EVENTO DE ADJUDICACION POR GRUPO\n6.-SALIR","EVENTO DE ADJUDICACION",1 ));//Uso de menús de forma gráfica.
                            x=true;
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null,"INGRESE  UN NUMERO DEL MENU","ERROR",1);
                        }
                    }while(!x);
                    switch(respuesta){
                        case 1:
                            fecha=JOptionPane.showInputDialog(null,"INTRODUZCA LA FECHA DEL EVENTO\nAAAA/AA/AA\n","FECHA",1);
                            break;
                        case 2:
                            numgrup=Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL NUMERO DE GRUPOS QUE DESEA","GRUPOS",3)) ;
                            Grupo[] gpo=new Grupo[numgrup];
                            break;
                        case 3:
                            personasporgrupo=Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE LOS CLIENTES POR GRUPO","CLIENTES",3));
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null,"LOS GANADORES SON","GANDORES",1);
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null,"LOS GRUPOS SON","GRUPOS",1);
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null,"GRACIAS");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"OPCION DEL MENU PORFAVOR");
                    }
                }while(respuesta<=5);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "GRACIAS");
                break;
            default:
                break;
        }

    }
    
}
