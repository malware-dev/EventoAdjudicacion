/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;

import java.time.LocalDate;

/**
 *
 * @author samuel
 */
public class MetodosGrupo {
    MetodosCliente mcli=new MetodosCliente();
    public void GeneraGrupos(Grupo[] gpo, int no_clientes, LocalDate fev){
        for(int x=0; x<=gpo.length-1; x++){
            gpo[x].cl=new Cliente[no_clientes];
            mcli.DatosClienteAleatorio(fev, gpo[x].cl);
            gpo[x].men_subastadas=new int[no_clientes];
            gpo[x].part=new int[no_clientes];
            gpo[x].sorteo=new int[no_clientes];
            gpo[x].subasta=new int[no_clientes];
        }
    }
    
    public void VerGpo(Grupo[] gpo, int numgrup){
        mcli.ImprimeMatrizCliente(gpo[numgrup-1].cl);
    }
    
    public void EventoGpo(Grupo[] gpo, int numgrup){
        mcli.Participantes(gpo[numgrup-1].cl, gpo[numgrup-1].part);
        mcli.AcomodarParticipantes(gpo[numgrup-1].part, gpo[numgrup-1].sorteo, gpo[numgrup-1].subasta);
        mcli.Evento(gpo[numgrup-1].sorteo, gpo[numgrup-1].subasta, gpo[numgrup-1].cl, gpo[numgrup-1].men_subastadas);
    }
}
