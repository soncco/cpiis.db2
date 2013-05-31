/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author brau
 */
public class Tabla extends Relacion implements java.io.Serializable{
      private String nombre;
      Relacion rel;
    public Tabla(String nombre) {
        super();
        this.nombre = nombre;
    } 
    public Tabla(String nombre, java.util.List<Atributo> atributos) {
        super(atributos);
        this.nombre = nombre;
        rel=new Relacion(atributos);
    }
    public String getNombre() {
        return nombre;
    }
}