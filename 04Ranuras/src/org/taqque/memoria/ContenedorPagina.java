/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.memoria;
/**
 *
 * @author brau
 */
public class ContenedorPagina {
    public Pagina pagina;
    public boolean modificadorEnBuffer;

    public ContenedorPagina(Pagina pagina) {
        this.pagina = pagina;
        modificadorEnBuffer = false;
    } // ContenedorPagina
} // ContenedorPagina