package org.taqque.almacenamiento;
/**
 *
 * @author hernan
 */
public class Tabla extends Relacion implements java.io.Serializable{
      private String nombre;
    
    public Tabla(String nombre) {
        super();
        this.nombre = nombre;
    } 
    public Tabla(String nombre, java.util.List<Atributo> atributos) {
        super(atributos);
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
