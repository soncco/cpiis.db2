/*
 * Creado el 28 de mayo, 2012 por Hernán Nina Hanco
 *
 * Este trabajo es parte del proyecto Taqque, que corresponde a la 
 * implementación de un Sistema de Gestión de Base de Datos. Cualquier
 * cambio es necesario declararlo en este apartado.
 * 
 * Universidad Nacional de San Antonio Abad del Cusco
 * Carrera Profesional de Ingeniería Informática y de Sistemas
 * Asignatura: Sistemas de Bases de Datos II
 */
package org.taqque.memoriaintermedia;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representa una abstracción de un Gestor de la Memoria Intermedia
 * 
 * @author hernan
 */
public class GestorMemoriaIntermediaClavados {

    static final Logger logger = Logger.getLogger("Gestion de Buffer");
    /** Representa a los bloques de la memoria intermedia o buffer. */
    private Pagina[] buffer;
    /** Numero de paginas en total en el buffer. */
    private int numeroPaginas;
    /** Posición en el buffer de la ultima pagina colocada. */
    private int posicionUltimaPagina = -1;
    /** cola para el control de sustitución basada en LRU. */
    private Queue colaLRU;

    /**
     * Crea un nuevo Gestor de memoria intermedia.
     * 
     * @param numeroPaginas cantidad de paginas en total en el buffer.
     */
    public GestorMemoriaIntermediaClavados(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
        // Crear el buffer con paginas vacias
        buffer = new Pagina[numeroPaginas];
        // Crear una cola FIFO
        colaLRU = new LinkedList<Integer>();
    }

    /**
     * Devuelve una pagina conociendo el numero de la página.
     * 
     * @param numeroPagina el id de la pagina que queremos devolver
     * @return la página del id de pagina proporcionado.
     */
    public Pagina recuperarPaginaDelBuffer(int numeroPagina) {
        // Verificar si la pagina esta en el buffer
        int posicion = posicionDePaginaEnBuffer(numeroPagina);
        if (posicion >= 0) // la pagina esta en el buffer
        {
            // Marcar Pagina o bloque como recientemente referenciado
            colaLRU.remove(numeroPagina);
            colaLRU.add(numeroPagina);
            // devolver la pagina del buffer al solicitante
            return buffer[posicion];
        }
        return null;
    }

    /**
     * Poner una pagina en el buffer de la memoria intermedia.
     * 
     * @param pagina la pagina a ser insertado en el buffer.
     * @return la pagina que sera descartada del buffer si es necesario.
     */
    public Pagina ponerPaginaEnBuffer(Pagina pagina) {
        // Si la pagina esta en el buffer
        if (estaPaginaEnBuffer(pagina)) {
            // no descartar ninguna pagina o bloque 
            return null;
        } // Si la pagina no esta en el buffer, pero con espacio en el buffer
        else if (!bufferLLeno()) {
            // Asignar la nueva pagina al bloque o pagina libre del buffer 
            posicionUltimaPagina++;
            buffer[posicionUltimaPagina] = pagina;
            // Actualizar la LRU
            colaLRU.remove(posicionUltimaPagina);
            colaLRU.add(posicionUltimaPagina);
            return null;
        } // Si la pagina no esta en el buffer, pero sin espacio en el buffer
        else {
            // recuperar la pagina a descartar
            int numeroPaginaDescartada = (Integer) colaLRU.peek();
            int posicion = posicionDePaginaEnBuffer(numeroPaginaDescartada);
            Pagina paginaDescartada = buffer[posicion];
            if(paginaDescartada.esClavado()) {
                System.out.println("La pagina que se pretendía sacar: "+ paginaDescartada+"  para colocar la nueva pagina: "+pagina+"Es una pagina clavada");
                // entonces hacer que se saque la sgte pagina;
                int  pag = (Integer)colaLRU.peek();// la k se quería sacar
                colaLRU.remove();
                colaLRU.add(pag);
                return ponerPaginaEnBuffer(pagina);
            } else {
                if (paginaDescartada.esModificado()) {
                    System.out.println("PAGINA MODIFICADA: (REQUIERE MODIFICACION EN DISCO): "+ paginaDescartada); 
                }
                colaLRU.remove();
                buffer[posicion] = pagina;
                colaLRU.add(pagina.getNumeroPagina());
                return paginaDescartada;
            }            
        }

    }

    private int posicionDePaginaEnBuffer(int numeroPagina) {
        int posicion = -1;
        for (int i = 0; i < buffer.length; i++) {
            if ((buffer[i] != null)
                    && (numeroPagina == buffer[i].getNumeroPagina())) {
                posicion = i;
                break;
            }
        }
        return posicion;

    }

    private boolean estaPaginaEnBuffer(Pagina pagina) {
        return (posicionDePaginaEnBuffer(pagina.getNumeroPagina()) != -1);
    }

    private boolean bufferLLeno() {
        return numeroPaginas - 1 == posicionUltimaPagina;
    }
    
    public void modificarPagina(int i, String string) {
        int posicion = this.posicionDePaginaEnBuffer(i);
        if(posicion >= 0)
            buffer[posicion].setDatos((Object)string);
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < buffer.length; i++) {
            resultado += "Pagina[" + i + "]: " + buffer[i] + "\n";
        }
        return resultado + "\n" + this.colaLRU;
    }

}
