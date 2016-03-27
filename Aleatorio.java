/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoadjudicacion;
import java.util.Random;
/**
 *
 * @author samuel
 */
public class Aleatorio {
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
}
