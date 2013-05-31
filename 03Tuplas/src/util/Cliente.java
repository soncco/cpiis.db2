/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMD
 */
public class Cliente {
     public static void main(String args[]) {
        try {
            List<Atributo> attrs = new ArrayList<Atributo>();
            
            attrs.add(new Atributo("id_Cliente", Integer.class));
            attrs.add(new Atributo("nombre_Cliente", String.class));
            attrs.add(new Atributo("direccion_Cliente", String.class));
            attrs.add(new Atributo("telefono_Cliente", Long.class));
            
            //agregamos los primeros atributos a la relacion
            Relacion relCliente = new Relacion(attrs);
            System.out.println("Relacion Inicial");
            System.out.println( relCliente.toString()); 
            
            //agregamos un nuevo atributo a la relacion
            relCliente.adicionarAtributo(new Atributo("tipo_Cliente", Character.class));
            System.out.println("Relacion Agregada");
            System.out.println( relCliente.toString()); 
            
            //eliminamos un atributo de la relacion
            relCliente.EliminarAtributo("telefono_Cliente");
            System.out.println("Eliminando el atributo");
            System.out.println( relCliente.toString()); 
            
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    } // main()
}
