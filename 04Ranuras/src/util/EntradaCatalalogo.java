/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author brau
 */
class EntradaCatalogo implements java.io.Serializable {
    /** Directory of the server. */
    public static String TAQQUE_DIR="";
    /** Tabla para este entrada a catalogo. */
    private Tabla tabla;
    /** El nombre de archvio para la tabla. */
    private String nombreArchivo;
    public EntradaCatalogo(Tabla tabla) {
        this.tabla = tabla;
        crearNombreArchivo();
    } 
    public String getNombreTabla() {
        return tabla.getNombre();
    } 
    public Tabla getTabla() {
        return tabla;
    } 
    public String getNombreArchivo() {
        return nombreArchivo;
    } 
    @Override
    public String toString() {
        return "Tabla: " + getNombreTabla() + ", nombre de Archivo: "
            + nombreArchivo + ", definición: "+tabla.rel.toString() +"\n";
    }
    protected void crearNombreArchivo() {
        String nombreTabla = tabla.getNombre();
        nombreArchivo = new String(TAQQUE_DIR
                              + System.getProperty("file.separator")
                              + nombreTabla + "_" + nombreTabla.hashCode());
    } 
}