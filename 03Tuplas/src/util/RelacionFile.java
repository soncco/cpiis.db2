/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author AMD
 */
public class RelacionFile implements Serializable{
    private Relacion relacion;
    private String nameRelacion;

    public RelacionFile(Relacion relacion, String nameRelacion) {
        this.relacion = relacion;
        this.nameRelacion = nameRelacion;
    }

    public String getNameRelacion() {
        return nameRelacion;
    }

    public Relacion getRelacion() {
        return relacion;
    }
    @Override
    public String toString() {
        return nameRelacion;
    }
    
}
