/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.memoria;
import util.Atributo;
import util.Convert;
import org.taqque.memoria.Pagina;
import util.Par;
import util.Relacion;
import util.Tupla;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author brau
 */
public class GestorIOPagina {

    /**
     * Construir una nuevo gestor de página de I/O.
     */
    public GestorIOPagina() {
    }

    /**
     * Escribe una página en un archivo de salida
     * 
     * @param raf archivo de salida.
     * @param pagina la página a ser escrita.
     * @throws StorageManagerException thrown whenever there is an
     * output error.
     */
    public static void escribirPagina(RandomAccessFile raf, Pagina pagina) {

        try {
            // buscar el lugar correcto en el archivo
            long seek = pagina.getIdentificadorPagina().getNumero() * 4096;
            //--realiza el salto
            raf.seek(seek);
            byte[] bytes = new byte[4096];
            volcarNumero(pagina, bytes);
            volcarTuplas(pagina, bytes);
 
            //--escribe pagina en disco
            raf.write(bytes);
        } catch (IOException ioe) {
            System.out.println("Exception mientras se escribe la página "
                    + pagina.getIdentificadorPagina()
                    + " a disco: " + ioe);
        }
    }

    /**
     * Leer una página del disco.
     * 
     * @param relacion la relación a la que la página pertenece.
     * @param pid Identificador de la página.
     * @param raf el archivo de la salida.
     * @return la página leida.
     */
    public static Pagina leerPagina(Relacion relacion, IdentificadorPagina pid, RandomAccessFile raf) {
        try {
            // seek to the appropriate place
            long seek = pid.getNumero() * 4096;
            raf.seek(seek);
            byte[] bytes = new byte[4096];
            int leerBytes = raf.read(bytes);
            if (leerBytes == -1) {
                // hemos llegado al final del archivo, 
                // así que tenemos que asignar una página
                raf.setLength(seek + 4096);
                return new Pagina(relacion, pid);
            }
            if (leerBytes != 4096) {
                System.out.println("Pagina: " + pid.toString()
                        + "no fue leido completamente.");
            }
            return extraerTuplas(relacion, pid, bytes);
            
        } catch (IOException ioe) {
            System.out.println("Exception mientras se lee la página "
                    + pid.toString()
                    + " de disco. " + ioe);
            return null;
        }
    }

    /**
     * Volcar al arreglo de bytes el número de tuplas en la página.
     *
     * @param pagina la página a ser escrita.
     * @param bytes un arreglo de salida de bytes.     
     */
    protected static void volcarNumero(Pagina pagina, byte[] bytes) {

        byte[] b = Convert.toByte(pagina.getNumeroDeTuplas());
        System.arraycopy(b, 0, bytes, 0, b.length);
    }

    /**
     * Volcar a arreglo de bytes una página de tuplas a disco.
     * 
     * @param pagina la página a ser escrito en el disco.
     * @param bytes el arreglo de bytes de salida para las tuplas.
     */
    protected static void volcarTuplas(Pagina pagina, byte[] bytes) {

        // crear un nuevo gestor IO de tuplas
        GestorIOTupla gestor =
                new GestorIOTupla(pagina.getRelacion(),
                pagina.getIdentificadorPagina().getNombreArchivo());
        // Un numero entero se utiliza para el numero de tuplas
        int desplazamiento = Convert.INT_SIZE;
        
        // iterate sobre todas las tuplas de la página, y localizarlo en el arreglo
        for (Tupla tupla : pagina) {
            desplazamiento = gestor.escribirTupla(tupla, bytes, desplazamiento);
        }
        rellenar(bytes, desplazamiento);
    }

    /**
     * Leer las tuplas del disco y los coloca en una página.
     * 
     * @param relacion la relacion a la que pertenece la página.
     * @param pid el identificador de la nueva página.
     * @param bytes el arreglo de bytes donde las tuplas se encuentran.
     * @return la pagina leida del disco.
     */
    protected static Pagina extraerTuplas(Relacion relacion, IdentificadorPagina pid,
            byte[] bytes) {

        // crear un gestor IO de tupla
        GestorIOTupla gestor = new GestorIOTupla(relacion,
                pid.getNombreArchivo());
        // iniciar la lectura de tuplas
        int numeroDeTuplas = extraerNumero(bytes);
        Pagina pagina = new Pagina(relacion, pid);
        // Un numero entero se utiliza para el numero de tuplas
        int desplazamiento = Convert.INT_SIZE;
        for (int i = 0; i < numeroDeTuplas; i++) {
            Par par = gestor.leerTupla(bytes, desplazamiento);
            Tupla tupla = (Tupla) par.primero;
            desplazamiento = ((Integer) par.segundo).intValue();
            pagina.adicionarTupla(tupla);
        }

        return pagina;
    }

    /**
     * Extraer numero de tuplas del arreglo de byte.
     *
     * @param bytes el arreglo de bytes.
     * @return el numero de tuplas.
     */
    public static int extraerNumero(byte[] bytes) {

        byte[] b = new byte[Convert.INT_SIZE];
        System.arraycopy(bytes, 0, b, 0, b.length);
        return Convert.toInt(b);
    }

    /**
     * Rellena una matriz de bytes con ceros para alcanzar 
     * el tamaño de página de disco.  
     * 
     * @param bytes el arreglo de bytes de entrada a ser rellenado.
     * @param inicio el inicio del desplazamiento en el arreglo de bytes.
     */
    protected static void rellenar(byte[] bytes, int inicio) {
        for (int i = inicio; i < bytes.length; i++) {
            bytes[i] = (byte) 0;
        }
    }

    public static void main(String[] args) {
        try {
            String nombreArchivo = "relacion.dat";

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
            Relacion rel = new Relacion(attrs);
            // Crear una lista de valores de tupla
            List<Comparable> v = new ArrayList<Comparable>();
            v.add(new Character('p'));
            v.add(new Byte((byte) 30));
            v.add(new Short((short) 156));
            v.add(new Integer(10));
            v.add(new Long(1234));
            v.add(new Float(12.3));
            v.add(new Double(12.3));
            v.add(new String("Cadena"));
            // Crear una página
            // Crear un id de página
            IdentificadorPagina pid1 = 
                    new IdentificadorPagina(nombreArchivo, 0);
            
            Pagina p1 = new Pagina(rel, pid1);
            // for (int i = 0; i < 60; i++) {
            // crear tupla
                Tupla t1 = new Tupla(new IdentificadorTupla(nombreArchivo, 0), v);
                // añadir tuplas a la página
                p1.adicionarTupla(t1);
            // }
            // mostrar la pagina p1
            System.out.println(p1);
            
            IdentificadorPagina pid2 = new IdentificadorPagina(nombreArchivo, 1);
            Pagina p2 = new Pagina(rel, pid2);
            //for (int i = 0; i < 50; i++) {
                Tupla t2 = new Tupla(new IdentificadorTupla(nombreArchivo, 1), v);
                p2.adicionarTupla(t2);
            //}
            System.out.println(p2);
            // Almacenar en disco las páginas
            java.io.RandomAccessFile raf = 
                    new java.io.RandomAccessFile(nombreArchivo, "rw");

            GestorIOPagina.escribirPagina(raf, p1);
            GestorIOPagina.escribirPagina(raf, p2);
            raf.close();

            // Leer la página 

            raf = new java.io.RandomAccessFile(nombreArchivo, "r");
            System.out.println("Leyendo página...");
            Pagina pagina1 = 
                    GestorIOPagina.leerPagina(rel, 
                    new IdentificadorPagina(nombreArchivo, 0), raf);
            Pagina pagina2 = 
                    GestorIOPagina.leerPagina(rel, 
                    new IdentificadorPagina(nombreArchivo, 1), raf);

            System.out.println(pagina1);
            System.out.println(pagina2);
            
            raf.close();
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}