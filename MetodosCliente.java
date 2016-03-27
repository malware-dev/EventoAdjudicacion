/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
/**
 *
 * @author samuel
 */
public class MetodosCliente {
    public void DatosClienteAleatorio(int dia, int mes, int año, Cliente[] cli){
        Aleatorio alto=new Aleatorio();
        for(int x=0; x<=cli.length; x++){
            for(int y=0; y<=2; y++){
                String f=Integer.toString(año)+Integer.toString(mes-y)+Integer.toString(15);
                int ff=Integer.parseInt(f);
                if(cli[x].fechas==null){
                    cli[x].fechas[y]=ff;
                }
            }
        }
    }
}
