/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brau.db2.memoria;

/**
 *
 * @author brau
 */
public class Cliente {
    private String Nombres;
    private int DNI;

    public Cliente(String Nombres, int DNI) {
        this.Nombres = Nombres;
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Nombres: " + this.getNombres() + ", DNI: " + this.getDNI();
    }

    public int getDNI() {
        return DNI;
    }

    public int DNI() {
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
