/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.almacenamiento;

/**
 *
 * @author user
 */
public class Atributo implements java.io.Serializable{
    private String nombre;
    private Class<? extends Comparable> tipo;
    
    public Atributo(String nombre, Class<? extends Comparable> tipo)
    {
        this.nombre=nombre;
        this.tipo=tipo;
    }
    
    public Atributo(String nombre) {
        this.nombre = nombre;
        this.tipo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
    public String toString() {
        return getNombre() + ":" + getTipo();
    } // toString() 
    
}
