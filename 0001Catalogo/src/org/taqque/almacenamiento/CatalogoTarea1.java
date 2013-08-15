/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.almacenamiento;

import java.util.ArrayList;

/**
 *
 * @author MARI
 */
public class CatalogoTarea1 {
    public static void main(String args[]) {
        try {
        
        ArrayList<Atributo> atributos = new ArrayList<Atributo>();
        
        atributos.add(new Atributo("nombres", String.class));
        atributos.add(new Atributo("apellidos", String.class));
        
        Tabla tabla = new Tabla("alumno", atributos);
        
        EntradaCatalogo entrada = new EntradaCatalogo(tabla);
        
        Catalogo catalogo = new Catalogo(EntradaCatalogo.TAQQUE_DIR+
                    System.getProperty("file.separator") + "catalogotarea.dat");
        
        catalogo.crearNuevaEntrada(entrada);
        
        catalogo.escribirCatalogo();
        
        System.out.println(catalogo);
        } catch(Exception e) {
            System.err.println(e.toString());
        }
    }
}
