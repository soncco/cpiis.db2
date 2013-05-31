/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author brau
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Catalogo {
    /** Nombre de archivo del catalogo. */
    private String archivoCatalogo;
    /** Entradas del catalogo, mapean nombres de tabla a entradas. */
    private java.util.Map<String, EntradaCatalogo> entradas;
    /** Numero de tablas actualmente almacenadas en el catalogo. */
    private int numeroDeTablas;
    public Catalogo(String archivoCatalogo) {
        this.archivoCatalogo = archivoCatalogo;
        entradas = new java.util.Hashtable<String, EntradaCatalogo>();
    }
    public void crearNuevaEntrada(EntradaCatalogo entrada)  
            throws IllegalArgumentException {
        if (!existeTabla(entrada.getNombreTabla())) {
            entradas.put(entrada.getNombreTabla(), entrada);
            numeroDeTablas++;
        } else {
            throw new IllegalArgumentException("Tabla: " + entrada.getNombreTabla()
                    + " ya existe.");
        }
    }
    protected boolean existeTabla(String nombreTabla) {
        return (entradas.get(nombreTabla) != null);
    }
    
    @Override
    public String toString(){
        return "Catalogo: "+numeroDeTablas+" tablas, Entradas: \n"+ "\t"+entradas.toString();
           
    }
    // Leer un archivo de catalogo del Disco
    public void leerCatalogo() throws Exception {
        try {
            // Objeto que representa al archivo
            FileInputStream fstream = new FileInputStream(archivoCatalogo);
            // tarea de lectura utilizamos este objeto
            ObjectInputStream istream = new ObjectInputStream(fstream);

            // leer en del número de tablas
            numeroDeTablas = istream.readInt();
            // leer en las entradas del catálogo

            entradas = (Map<String, EntradaCatalogo>) istream.readObject();

            istream.close();
        } catch (Exception ex) {
            System.out.println("Problemas al abrir el archivo: " + ex.getMessage());
        }
    }
    // Metodo para almacenar el catalogo en disco

    public void escribirCatalogo() throws Exception {

        try {
            // Crear un nuevo archivo en disco - Interface acceso de archivo
            FileOutputStream fstream = new FileOutputStream(archivoCatalogo);
            // realizar operaciones de escritura en el archivo
            ObjectOutputStream ostream = new ObjectOutputStream(fstream);

            // write out the number of tables
            ostream.writeInt(numeroDeTablas);
            // write out the entries of the catalog
            ostream.writeObject(entradas);
            // ejecutar el almacenamiento
            ostream.flush();
            ostream.close(); // si no realiza cerrar no almacena 
        } catch (IOException ioe) {
            System.out.println("I/O Exception mientras se almacenaba el archvio del catalogo "
                    + archivoCatalogo + ioe.getMessage());
        }
    }
    
    public void eliminarTabla(String nombreTabla)
            throws NoSuchElementException {
        
        if (! existeTabla(nombreTabla))
            throw new NoSuchElementException("Tabla " + nombreTabla + " no esta "
                                             + "en el catalogo de la BD.");
        entradas.remove(nombreTabla);
        numeroDeTablas--;
    } // deleteTable()

    public static void main(String args[]) {
        try {
           
            //=====================================================================
            // REGISTRO DE INFORMACION DE UNA TABLA
            // crear tres nuevas entradas de tabla
            List<Atributo> attrs = new ArrayList<Atributo>();
            attrs.add(new Atributo("character", Character.class));
            attrs.add(new Atributo("byte", Byte.class));
            attrs.add(new Atributo("short", Short.class));
            attrs.add(new Atributo("integer", Integer.class));
            attrs.add(new Atributo("long", Long.class));
            attrs.add(new Atributo("float", Float.class));
            attrs.add(new Atributo("double", Double.class));
            attrs.add(new Atributo("string", String.class));
            
            List<Atributo> attrs2 = new ArrayList<Atributo>();
            attrs2.add(new Atributo("character", Character.class));
            attrs2.add(new Atributo("byte", Byte.class));
            attrs2.add(new Atributo("short", Short.class));
            
            List<Atributo> attrs3 = new ArrayList<Atributo>();
            attrs3.add(new Atributo("byte", Byte.class));
            attrs3.add(new Atributo("integer", Integer.class));
            attrs3.add(new Atributo("long", Long.class));
            attrs3.add(new Atributo("double", Double.class));
                       
            EntradaCatalogo ce1 = new EntradaCatalogo(
                    new Tabla("alumno", attrs));
            EntradaCatalogo ce2 =
                    new EntradaCatalogo(new Tabla("docente",attrs2));
            EntradaCatalogo ce3 =
                    new EntradaCatalogo(new Tabla("curso",attrs3));

            // crear el catalogo

            Catalogo catalogo = new Catalogo(EntradaCatalogo.TAQQUE_DIR+
                    System.getProperty("file.separator") + "catalogoprueba.dat");
            // añdir informacion a catalogo
            
            catalogo.crearNuevaEntrada(ce1);
            catalogo.crearNuevaEntrada(ce2);
            catalogo.crearNuevaEntrada(ce3);

            // imprimir en patalla el catalogo
            System.out.println(catalogo.toString());
            Thread.sleep(1000);

            // escribir el catalogo en archivo
            System.out.println("Creando catalogo catalog.");
            catalogo.escribirCatalogo();
            Thread.sleep(1000);

            // Leer el catalogo almacenado recientemente
            System.out.println("Leyendo catalogo.");
            catalogo.leerCatalogo();

             // Imprimir nuevamente el catalogo
            System.out.println(catalogo);
            Thread.sleep(1000);
            
            // Eliminar una Tabla
            System.out.println("Eliminado una tabla.");
            catalogo.eliminarTabla("docente");
             // Imprimir nuevamente el catalogo
            System.err.println(catalogo);
            Thread.sleep(1000);
            
             System.out.println(catalogo);
             
             //=============================================================================
            
        } catch (Exception e) {
            System.err.println("Exception " + e.getMessage());
            e.printStackTrace(System.err);
        }
    } // main()
}