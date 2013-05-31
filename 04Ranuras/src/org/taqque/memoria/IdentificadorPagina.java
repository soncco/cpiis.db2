/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.memoria;

/**
 *
 * @author brau
 */
public class IdentificadorPagina {
        
    /** Nombre del archivo al que pertenece la página. */
    private String nombreArchivo;
        
    /** numero de la página. */
    private int numero;

    
    /**
     * Crear un nuevo identificador.
     * 
     * @param nombreArchivo el archivo al que la página pertenece.
     * @param numero el numero de la página en el archivo.
     */
    public IdentificadorPagina(String nombreArchivo, int numero) {
        
        this.nombreArchivo = nombreArchivo;
        this.numero = numero;
    } // PageIdentifier()

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    
    /**
     * Recupera el nombre de archivo al que pertenece la página.
     * 
     * @return nombre de archivo.
     */
    
    public String getNombreArchivo() {
        
        return nombreArchivo;
    }

    
    /**
     * Recupera el número de la página.
     * 
     * @return numero de página.
     */
    public int getNumero () {
        return numero;
    }
    
    /**
     * Retorna una representación textual del identificador de página.
     * 
     * @return representación textual del identificador.
     */
    @Override
    public String toString() {
        
        return "[page " + getNombreArchivo() + ":" + getNumero() + "]";
    }
} 

