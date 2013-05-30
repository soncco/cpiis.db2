/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brau.db2.memoria;

import org.taqque.memoriaintermedia.*;

/**
 *
 * @author brau
 */
public class BloquesClavados {
    public static void main(String args[]) {
        System.out.println("Paginas del Disco: Hacemos la pagina 1 y 3 clavadas");
        Pagina[] paginas2 = new Pagina[10];
        for (int i = 0; i < paginas2.length; i++) {
            Pagina pagina = new Pagina(i, "contenido" + i);
            
            if (i == 1 || i==3) {
               pagina.setClavado(true); 
            }
            paginas2[i] = pagina;
            System.out.println(pagina);
        }

        System.out.println("Contenido del Gestor: ");
        GestorMemoriaIntermediaClavados gbc = new GestorMemoriaIntermediaClavados(5);
        System.out.println(gbc);
     
        System.out.println("Colocando paginas al Buffer (10 paginas, 5 se  reemplazaran menos la 1 y 3 que son clavadas) ");
         for (int i = 0; i < paginas2.length; i++) {
            //moficando las paginas a proposito
            gbc.ponerPaginaEnBuffer(paginas2[i]);
        }
         System.out.println("");
         System.out.println("Contenido actual de buffer: ");
         System.out.println(gbc);
    }
}
