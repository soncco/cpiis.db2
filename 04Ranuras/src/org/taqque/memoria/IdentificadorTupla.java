/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.memoria;

/**
 *
 * @author brau
 */
public class IdentificadorTupla {

    /** Nombre de archivo al que pertenece la tupla. */
    private String nombreArchivo;
    /** Numero de la tupla. */
    private int numero;

    /**
     * Construye un nuevo identificador de tupla cuando se conoce el nombre del
     * archivo al que pertence la tupla. El numero de tupla se cambia luego
     * 
     * @param Nombre del archivo al que pertenece la tupla.
     */
    public IdentificadorTupla(String nombreArchivo) {
        this(nombreArchivo, -1);
    } 

    /**
     * Construye una nueva tupla conociendo el nombre de archivo y el numero de tupla
     * 
     * @param nombreArchivo Nombre de archivo al que pertenece la tupla.
     * @param numero Numero de la tupla.
     */
    public IdentificadorTupla(String nombreArchivo, int numero) {
        this.nombreArchivo = nombreArchivo;
        this.numero = numero;
    }

    /**
     * Devuelve el nombre del archivo al que pertenece la tupla.
     * 
     * @return nombre del archivo al que pertenece la tupla.
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    } 
    

    /**
     * Devuelve el numero de la tupla.
     * 
     * @return the number of this tuple in the file.
     */
    public int getNumero() {
        return numero;
    } // getNumber()

    /**
     * Sets the number of this tuple in the file.
     * 
     * @param number the new number of this tuple in the file.
     */
    public void setNumero(int number) {
        this.numero = number;
    } // setNumber()

    /**
     * Checks two tuple identifiers for equality.
     * 
     * @param o an object to compare this identifier to.
     * @return <pre>true</pre> if the two tuple identifiers are equal
     * <pre>false</pre> otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof IdentificadorTupla)) {
            return false;
        }
        IdentificadorTupla tid = (IdentificadorTupla) o;
        return getNombreArchivo().equals(tid.getNombreArchivo())
                && getNumero() == tid.getNumero();
    } // equals()

    /**
     * Computes the hashcode of this tuple identifier.
     *
     * @return this tuple identifier's hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + getNombreArchivo().hashCode();
        return hash * 31 + getNumero();
    } // hashCode()

    /**
     * Textual representation.
     */
    @Override
    public String toString() {
        return "[" + (getNombreArchivo() != null ? getNombreArchivo() : "")
                + " - " + getNumero() + "]";
    } // toString()
}
