/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author brau
 */
public class Atributo implements java.io.Serializable {

    /** Nombre del atributo */
    private String nombre;
    /** Tipo de datos del atributo. */
    private Class<? extends Comparable> tipo;

    /**
     * Crear un nuevo atributo por su nombre y clase.
     * 
     * @param nombre, representa el nombre del atributo.
     * @param tipo, representa la clase del atributo.
     */
    public Atributo(String nombre, Class<? extends Comparable> tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    } // Atributo()
    
    /**
     * Devuelve el nombre del atributo.
     * 
     * @return nombre del atributo.
     */    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la clase o tipo del atributo.
     * 
     * @return tipo del atributo.
     */

    public Class<? extends Comparable> getTipo() {
        return tipo;
    }

    public void setTipo(Class<? extends Comparable> tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Atributo)) return false;
        Atributo a = (Atributo) o;
        return getNombre().equals(a.getNombre()) && 
                getTipo().equals(a.getTipo());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash*31 + getNombre().hashCode();
        return hash*31 + getTipo().hashCode();
    }
    
    /**
     * Representación Textual.
     */
    @Override
    public String toString() {
        return getNombre() + ":" + getTipo();
    } // toString()    
}