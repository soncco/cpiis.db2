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

/**
 * Pagina: Representa un bloque de Disco donde se almacenan los archivos de 
 * la base de datos
 * 
 * @author hernan
 */
public class Pagina<T> {
    /** Identidicador de la página en el disco. */ 
    private int numeroPagina;
    /** Datos almacenados en el bloque. */
    private T datos;
    
    /**
     * Crea una nueva pagina conociendo su id de pagina y los datos.
     * 
     * @param numeroPagina el ID de esta página.
     * @param datos datos almacenados en esta página.
     */
    
    public Pagina(int numeroPagina, T datos) {
        this.numeroPagina = numeroPagina;
        this.datos = datos;
    }

    public T getDatos() {
        return datos;
    }

    public void setDatos(T datos) {
        this.datos = datos;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }
    
    /**
     * Devuelve una representación textual de una página.
     * 
     * @return representación textual de esta página.
     */
    @Override
    public String toString()
    {
        return "Numero de Pagina: "+this.numeroPagina + "\t" +
                "Dato de pagina: " + this.datos;
    }
}
