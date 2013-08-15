/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.almacenamiento;



/**
 *
 * @author hernan
 */
public class AtributoTabla extends Atributo implements java.io.Serializable {

    private String tabla;

    public AtributoTabla(String tabla, String nombre,
            Class<? extends Comparable> tipo) {
        super(nombre, tipo);
        this.tabla = tabla;
    }

    public String getTabla() {
        return tabla;
    }
}
