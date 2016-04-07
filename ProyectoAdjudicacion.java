/*
 Este proyecto simula un evento de adjudicación
 */
package proyectoadjudicacion;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProyectoAdjudicacion {
    public static void main(String[] args) {
        MetodosCliente mcl=new MetodosCliente();
        MetodosGrupo mgpo=new MetodosGrupo();
        Auxiliar aux=new Auxiliar();
        Grupo[] gpo=null;
        LocalDate f=LocalDate.of(2016,02,15);
        Scanner recibir=new Scanner(System.in);
        String fecha;
        int respuesta=0, res=0, numgrup=0, personasporgrupo=0, gruponum=0;
        boolean x=false,c=false, grupo=true;
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
                            respuesta=Integer.parseInt(JOptionPane.showInputDialog(null,"1.- FECHA DEL EVENTO\n2.-NUMERO DE GRUPOS\n3.-DEFINIR CLIENTES POR GRUPO\n4.-EVENTO POR GRUPO\n5.-VER UN GRUPO\n6.-SALIR","EVENTO DE ADJUDICACION",1 ));//Uso de menús de forma gráfica.
                            x=true;
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null,"INGRESE  UN NUMERO DEL MENU","ERROR",1);
                        }
                    }while(!x);
                    switch(respuesta){
                        case 1:
                            f=aux.PideFecha();
                            break;
                        case 2:
                            numgrup=aux.PideEntero("Número de Grupos que desea");
                            gpo=new Grupo[numgrup];
                            break;
                        case 3:
                            personasporgrupo=aux.PideEntero("Personas por Grupo");
                            mgpo.GeneraGrupos(gpo, personasporgrupo, f,numgrup);
                            break;
                        case 4:
                            do{
                                try{
                                    gruponum=Integer.parseInt(JOptionPane.showInputDialog(null,"QUE GRUPO DESEA PARA EL EVENTO","GRUPOS",1));
                                    grupo=true;
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null,"EL VALOR NO ES ACEPTADO","GRUPO",1);
                                }
                            }while(!grupo || gruponum>numgrup);
                            mgpo.EventoGpo(gpo, gruponum);
                            break;
                        case 5:
                            do{
                                try{
                                    gruponum=Integer.parseInt(JOptionPane.showInputDialog(null,"QUE GRUPO DESEA VER","GRUPOS",1));
                                    grupo=true;
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null,"EL VALOR NO ES ACEPTADO","GRUPO",1);
                                }
                            }while(!grupo || gruponum>numgrup);
                            mgpo.VerGpo(gpo, gruponum);
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
