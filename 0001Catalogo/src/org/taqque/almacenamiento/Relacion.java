package org.taqque.almacenamiento;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author hernan
 */
public class Relacion implements 
        java.io.Serializable, Iterable<Atributo> {
    /** lista de atributos de la relación. */
    private List<Atributo> atributos;
    /** Constructor por Default de una relación. */
    public Relacion() {
        atributos = new ArrayList<Atributo>();
    }

    /**
     * Constructor de relación dado una <code>Lista</code> de atributos.
     * 
     * @param atributos, atributos de la relacion.
     */
    public Relacion(List<Atributo> atributos) {
        this.atributos = new ArrayList<Atributo>(atributos);
    }

    /**
     * Añadir un atributo a la relación.
     *
     * @param atributo, atributo a ser añadido.
     */
    protected void adicionarAtributo(Atributo atributo) {
        atributos.add(atributo);
    }

    /**
     * Devuelve el numero de atributos de la relación.
     * 
     * @return numero de atributos de una <code>Relación</code>
     */
    public int getNumeroDeAtributos() {
        return atributos.size();
    }

    /**
     * Devuelve un <code>Iterator</code> sobre los atributos de la 
     * relación.
     * 
     * @return <code>Iterator</code> de Atributos de la <code>Relación</code>.
     * 
     */
    @Override
    public Iterator<Atributo> iterator() {
        return atributos.iterator();
    }
    /**
     * Devuelve un atributo especifico de la relación.
     * 
     * @param i el indice del atributo que será devuelto.
     * @return el atributo especificaco.
     */
    public Atributo getAtributo(int i) {
        return atributos.get(i);
    }
    /**
     * Dado el nombre de un atributo, se devuelve el índice de este atributo
     * en el esquema de la relación. Se devuelve <code>-1</code> si el atributo
     * no aparece en el esquema de la relación.
     * 
     * @param atr el nombre del atributo
     * @return el indice del atributo en el esquema de la relación,
     * <code>-1</code> si el atributo no aparece en el esquema de la relación.
     */
    public int getIndiceAtributo(String atr) {

        int i = 0;
        for (Atributo atributo : atributos) {
            if (atributo.getNombre().equals(atr)) {
                return i;
            }
        }
        return -1;
    } // getIndiceAtributo()
    /**
     * Representación textual de una relación.
     */
    @Override
    public String toString() {
        int numeroAtributos = getNumeroDeAtributos();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < numeroAtributos; i++) {
            sb.append(getAtributo(i)).append(", ");
        }
        sb.append("}");
        return sb.toString();
    } // toString()    
}
