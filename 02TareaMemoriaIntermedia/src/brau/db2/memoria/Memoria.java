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
public class Memoria {
    public static void main(String args[]) {
        // Gestor de memoria.
        GestorMemoriaIntermedia gestor = new GestorMemoriaIntermedia(6);
        
        System.out.println("1. Controlar si una página fue modificada.");
        System.out.println("Paginas del Disco:");
        Pagina[] paginas = new Pagina[10]; 
        for(int i = 0; i < paginas.length; i++) {
            Pagina pagina = new Pagina(i, "dato " + i);
            paginas[i] = pagina;
            System.out.println(pagina);
        }
        
        System.out.println("Contenido del Gestor: ");
        System.out.println(gestor);
        System.out.println("Ponemos y modificamos páginas al buffer.");
        
        for (int i = 0; i < paginas.length; i++) {
            gestor.ponerPaginaEnBuffer(paginas[i]);
            gestor.modificarPagina(i, "nuevo dato " + i);
        }
        
        // Modificamos páginas que se encuentran en el buffer.
        System.out.println("Contenido del Gestor despues de poner bloques");
        System.out.println("Se reemplazaron las 4 primeras páginas: ");
        System.out.println(gestor);

        System.out.println("Añadimos más páginas al buffer: ");
        Pagina paginaN = new Pagina(10,"p10");
        Pagina paginaE = gestor.ponerPaginaEnBuffer(paginaN);
        System.out.println(paginaE);
        System.out.println(gestor);
        
    }
}
