/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.taqque.memoria;

import util.Atributo;
import util.Convert;
import util.Par;
import util.Relacion;
import util.Tupla;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author brau
 */
public class GestorIOTupla {

    /** relación a la que pertenecen las tuplas. */
    private Relacion relacion;
    /** El nombre del archivo de la relación. */
    private String nombreArchivo;

    /**
     * Constructor de un nuevo gestor conociendo el esquema de la relación.
     * 
     * @param relacion, es el esquema de la relación.
     * @param nombre del archivo de la relación.
     */
    public GestorIOTupla(Relacion relacion, String nombreArchivo) {
        this.relacion = relacion;
        this.nombreArchivo = nombreArchivo;
    } // GestorIOTupla()

    /**
     * Escribir una tupla a un arreglo de byte -- esto se usará cuando
     * se gestione las tuplas en las páginas.
     * 
     * @param tupla la tupla a ser escrita.
     * @param bytes el arreglo de byte de la tupla a ser escrita.
     * @param inicio el desplazamiento inicial dentro del arreglo de bytes.
     * @return un nuevo desplazamiento en el arreglo de byte, si es -1 hay
     * problemas.
     * 
     */
    public int escribirTupla(Tupla tupla, byte[] bytes, int inicio) {
        // Escribir el id de la tupla
        byte[] b = Convert.toByte(tupla.getIdTupla().getNumero());
        System.arraycopy(b, 0, bytes, inicio, b.length);
        inicio += b.length;
        // escribir los valores de la tupla a un arreglo de bytes
        b = null;

        int celda = 0;
        for (Atributo atr : relacion) {
            inicio = volcadoDeCelda(
                    atr.getTipo(), tupla, celda++, bytes, inicio);
        }

        return inicio;
    } // escribirTupla()

    /**
     * Leer una tupla de un arreglo de bytes -- se utilizara cuando se gestione 
     * las tuplas en paginas.
     * 
     * @param bytes el arreglo de bytes.
     * @param inicio inicio del desplazamiento dentro del arreglo de bytes.
     * @return un objeto par consistiendo en la tupla leida y el nuevo 
     * desplazamiento en el arreglo de bytes.
     * 
     */
    public Par<Tupla, Integer> leerTupla(byte[] bytes, int inicio) {

        // leer el id de la tupla
        byte[] b = new byte[Convert.INT_SIZE];
        System.arraycopy(bytes, inicio, b, 0, b.length);
        int id = Convert.toInt(b);
        inicio += b.length;
        List<Comparable> valores = new ArrayList<Comparable>();
        int celda = 0;
        for (Iterator<Atributo> it = relacion.iterator();
                it.hasNext(); celda++) {
            Par<? extends Comparable, Integer> par = extraer(it.next().getTipo(), bytes, inicio);
            inicio = par.segundo;
            valores.add(par.primero);
        }
        Tupla t = new Tupla(new IdentificadorTupla(nombreArchivo, id), valores);
        return new Par<Tupla, Integer>(t, new Integer(inicio));
    } // leerTupla()

    /**
     * método base para volcar una celda de tupla a un arreglo de bytes.
     * 
     * @param tipo el tipo de la celda.
     * @param t la tupla.
     * @param s la celda de la tupla a ser volcada como arreglo de bytes.
     * @param bytes el arreglo de donde la celda será volcada.
     * @param inicio el inicio de desplazamiento.
     * @return el nuevo desplazamiento en el arreglo.
     * 
     */
    protected int volcadoDeCelda(Class<? extends Comparable> tipo, Tupla t,
            int c, byte[] bytes, int inicio) {
        if (tipo.equals(Character.class)) {
            byte[] b = Convert.toByte(t.asChar(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(Byte.class)) {
            bytes[inicio] = t.asByte(c);
            return inicio + 1;
        } else if (tipo.equals(Short.class)) {
            byte[] b = Convert.toByte(t.asShort(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(Integer.class)) {
            byte[] b = Convert.toByte(t.asInt(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(Long.class)) {
            byte[] b = Convert.toByte(t.asLong(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(Float.class)) {
            byte[] b = Convert.toByte(t.asFloat(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(Double.class)) {
            byte[] b = Convert.toByte(t.asDouble(c));
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else if (tipo.equals(String.class)) {
            String st = t.asString(c);
            int len = st.length();
            byte[] b = Convert.toByte(len);
            System.arraycopy(b, 0, bytes, inicio, b.length);
            inicio += b.length;
            b = Convert.toByte(st);
            System.arraycopy(b, 0, bytes, inicio, b.length);
            return inicio + b.length;
        } else {
            System.err.println("No soporta el tipo: " + tipo.getClass().getName());
            return -1;
        }
    } // volcadoDeCelda()

    /**
     * Método básico para leer una celda de un arreglo de byte.
     * 
     * @param tipo el tipo de la celda a leer.
     * @param bytes el arreglo de bytes como entrada.
     * @param inicio el desplazamiento inicial en el arreglo de bytes.
     * @return un par de (valor, desplazamiento) con el valor leido y el nuevo
     * desplazamiento en el arreglo de bytes.
     * 
     */
    protected Par<? extends Comparable, Integer> extraer(Class<? extends Comparable> tipo, byte[] bytes, int inicio) {
        try {
            if (tipo.equals(Character.class)) {
                byte[] b = new byte[Convert.CHAR_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Character, Integer>(
                        new Character(Convert.toChar(b)),
                        inicio + b.length);
            } else if (tipo.equals(Byte.class)) {
                return new Par<Byte, Integer>(bytes[inicio],
                        inicio + 1);
            } else if (tipo.equals(Short.class)) {
                byte[] b = new byte[Convert.SHORT_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Short, Integer>(new Short(Convert.toShort(b)),
                        inicio + b.length);
            } else if (tipo.equals(Integer.class)) {
                byte[] b = new byte[Convert.INT_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Integer, Integer>(new Integer(Convert.toInt(b)),
                        inicio + b.length);
            } else if (tipo.equals(Long.class)) {
                byte[] b = new byte[Convert.LONG_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Long, Integer>(new Long(Convert.toLong(b)),
                        inicio + b.length);
            } else if (tipo.equals(Float.class)) {
                byte[] b = new byte[Convert.FLOAT_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Float, Integer>(new Float(Convert.toFloat(b)),
                        inicio + b.length);
            } else if (tipo.equals(Double.class)) {
                byte[] b = new byte[Convert.DOUBLE_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                return new Par<Double, Integer>(
                        new Double(Convert.toDouble(b)),
                        inicio + b.length);
            } else if (tipo.equals(String.class)) {
                byte[] b = new byte[Convert.INT_SIZE];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                inicio += b.length;
                int stLength = Convert.toInt(b);
                b = new byte[2 * stLength];
                System.arraycopy(bytes, inicio, b, 0, b.length);
                String str = Convert.toString(b);
                return new Par<String, Integer>(str, inicio + b.length);
            } else {
                return null;
            }
        } catch (ArrayIndexOutOfBoundsException aiob) {
            return null;
        }
    } // extraer()

    /**
     * Calcular el tamaño de bytes de la tupla.
     *
     * @param t la tupla.
     * @return el tamaño de byte de la tupla.
     */
    public int byteSize(Tupla t) {
        return byteSize(relacion, t);
    }

    /**
     * Calcular el tamaño en byte de una tupla dada su relación.      
     *
     * @param rel la relación.
     * @param t la tupla.
     * @return el tamaño en byte de la tupla.
     */
    public static int byteSize(Relacion rel, Tupla t) {
        // una longitud para el id
        int size = Convert.INT_SIZE;
        int celda = 0;
        for (Atributo it : rel) {
            Class<?> tipo = it.getTipo();
            if (tipo.equals(Character.class)) {
                size += Convert.CHAR_SIZE;
            } else if (tipo.equals(Byte.class)) {
                size += 1;
            } else if (tipo.equals(Short.class)) {
                size += Convert.SHORT_SIZE;
            } else if (tipo.equals(Integer.class)) {
                size += Convert.INT_SIZE;
            } else if (tipo.equals(Long.class)) {
                size += Convert.LONG_SIZE;
            } else if (tipo.equals(Float.class)) {
                size += Convert.FLOAT_SIZE;
            } else if (tipo.equals(Double.class)) {
                size += Convert.DOUBLE_SIZE;
            } else if (tipo.equals(String.class)) {
                size += Convert.INT_SIZE + 2 * t.asString(celda).length();
            }

            celda++;
        }

        return size;
    } // byteSize()

    /**
     * Debug main.
     */
    public static void main(String args[]) {
        try {
            
                
            List<Atributo> attrs = new ArrayList<Atributo>();
            attrs.add(new Atributo("character", Character.class));
            attrs.add(new Atributo("byte", Byte.class));
            attrs.add(new Atributo("short", Short.class));
            attrs.add(new Atributo("integer", Integer.class));
            attrs.add(new Atributo("long", Long.class));
            attrs.add(new Atributo("float", Float.class));
            attrs.add(new Atributo("double", Double.class));
            attrs.add(new Atributo("string", String.class));
            
            Relacion rel = new Relacion(attrs);
            int inicio = 0;
            byte[] bytes = new byte[1024];
            GestorIOTupla man  = new GestorIOTupla(rel, "redes");
            
            //============================================================================
            // AGREGAR VARIAS TUPLAS 
            Scanner in = new Scanner(System.in);
            System.out.println("numero de tuplas : ");
            int numero = in.nextInt();
            for (int i = 0; i < numero; i++) {   
                List<Comparable> v = new ArrayList<Comparable>();
                System.out.print(" char : ");
                char c = Character.valueOf(in.next().charAt(0));
                v.add(new Character(c));
                System.out.print(" byte : ");
                v.add(in.nextByte());
                System.out.print(" shor : ");
                v.add(in.nextShort());
                System.out.print(" int : ");
                v.add(in.nextInt());
                System.out.print(" long : ");
                v.add(in.nextLong());
                System.out.print(" float : ");
                v.add(Float.parseFloat(in.next()));
                System.out.print(" double : ");
                v.add(Double.parseDouble(in.next()));
                System.out.print(" string : ");
                v.add(in.next());

                Tupla t = new Tupla(new IdentificadorTupla("redes", i), v);
                //GestorIOTupla man = new GestorIOTupla(rel, "redes");
                java.io.RandomAccessFile raf = new java.io.RandomAccessFile("redes", "rw");
                //===================================================================================
                
                System.out.println("writing tuple..." + t);
                //byte[] bytes = new byte[1024];
                //man.escribirTupla(t, raf);
                inicio = man.escribirTupla(t, bytes, inicio);
                //raf.close();
                //raf = new java.io.RandomAccessFile("redes", "r");
            }
           
            System.out.println("reading all tuples...");
            inicio = 0;
            for (int i = 0; i < numero; i++) {
                // t = man.leerTupla(bytes);
                Par<Tupla, Integer> st = man.leerTupla(bytes, inicio);
                inicio = st.segundo;
                System.out.println(st);
                //raf.close();
            }

        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            e.printStackTrace(System.err);

        }
    } // main()
} // GestorIOTupla
