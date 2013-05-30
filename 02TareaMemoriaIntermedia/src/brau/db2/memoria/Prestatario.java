/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brau.db2.memoria;

/**
 *
 * @author brau
 */
public class Prestatario {
    private String Nombres;
    private int DNI;

    public Prestatario(String Nombres, int DNI) {
        this.Nombres = Nombres;
        this.DNI = DNI;
    }
    
    @Override
    public String toString() {
        return "Nombres: " + Nombres + ", DNI: " + DNI ;
    }
    public int getDNI() {
        return DNI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
}
