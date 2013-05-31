/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brau.db2.ranuras;

import org.taqque.memoria.IdentificadorTupla;
import org.taqque.memoria.IdentificadorPagina;
import org.taqque.memoria.GestorIOPagina;
import util.Atributo;
import org.taqque.memoria.Pagina;
import util.Relacion;
import util.Tupla;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kleiber
 */
public class EstructuraPaginaConRanuras {
    public static void main(String[] args) {
        try {
            // Crear el archivo de la relación
            String nombreArchivo = "ranuras.dat";
            // Crear un esquema de relación.
            List<Atributo> attrs = new ArrayList<Atributo>();
            attrs.add(new Atributo("character", Character.class));
            attrs.add(new Atributo("byte", Byte.class));
            attrs.add(new Atributo("short", Short.class));
            attrs.add(new Atributo("integer", Integer.class));
            attrs.add(new Atributo("long", Long.class));
            attrs.add(new Atributo("float", Float.class));
            attrs.add(new Atributo("double", Double.class));
            attrs.add(new Atributo("string", String.class));
            // Esquema de relación
            Relacion esquema_relacion = new Relacion(attrs);
            // Crear una lista de valores de tupla
            List<Comparable> v = new ArrayList<Comparable>();
            v.add(new Character('a'));
            v.add(new Byte((byte) 26));
            v.add(new Short((short) 312));
            v.add(new Integer(2048));
            v.add(new Long(34567));
            v.add(new Float(12.3));
            v.add(new Double(25.6));
            v.add(new String("bla bla"));
            // crear tuplas de la relación
            Tupla t1 = new Tupla(new IdentificadorTupla(nombreArchivo, 0), v);
            Tupla t2 = new Tupla(new IdentificadorTupla(nombreArchivo, 1), v);

            // Crear 2 páginas de disco
            // Crear un id de página
            IdentificadorPagina pid1 = new IdentificadorPagina(nombreArchivo, 0);
            Pagina p1 = new Pagina(esquema_relacion, pid1);

            IdentificadorPagina pid2 = new IdentificadorPagina(nombreArchivo, 1);
            Pagina p2 = new Pagina(esquema_relacion, pid2);

             // añadiendo las tuplas a las paginas
            // añadir tuplas a las páginas
            for(int i = 0;i < 200;i++){
                p1.adicionarTupla(t1);
                p2.adicionarTupla(t2);
            }
            // Mostrar las páginas creadas en pantalla
           System.out.printf("========================================================\n");
           System.out.printf("============          AQUI ESTA LA PAGINA 1 ============\n");
           System.out.printf("========================================================\n");
            System.out.println(p1);

           System.out.printf("========================================================\n");
           System.out.printf("============          AQUI ESTA LA PAGINA 2 ============\n");
           System.out.printf("========================================================\n");
            System.out.println(p2);
            // Almacenar en disco las páginas
            // Abrir en modo de lectura y escritura el archivo de la relación
            java.io.RandomAccessFile raf =
                    new java.io.RandomAccessFile(nombreArchivo, "rw");
            // Escribir las páginas en el archivo de la relación
            System.out.println("Escribiendo paginas ...");
            GestorIOPagina.escribirPagina(raf, p1);
            GestorIOPagina.escribirPagina(raf, p2);
            // cerrar archivo
            raf.close();

            // Leer la página del disco
            // Abrir el archivo de la relacion en modo de lectura
            raf = new java.io.RandomAccessFile(nombreArchivo, "r");
            System.out.println("leyendo paginas...");

            Pagina pagina1 =
                    GestorIOPagina.leerPagina(esquema_relacion,
                    new IdentificadorPagina(nombreArchivo, 0), raf);
            Pagina pagina2 =
                    GestorIOPagina.leerPagina(esquema_relacion,
                    new IdentificadorPagina(nombreArchivo, 1), raf);
            // Mostrar las páginas leidas
            System.out.println(pagina1);
            System.out.println(pagina2);
            // cerrar archivo
            raf.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
