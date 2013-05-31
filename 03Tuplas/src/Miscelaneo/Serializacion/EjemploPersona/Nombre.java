/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Miscelaneo.Serializacion.EjemploPersona;

import java.io.Serializable;

/**
 *
 * @author brau
 */
public class Nombre implements Serializable{
    private String Nombres;
    private String Apellidos;

    public Nombre(String Nombres, String Apellidos) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }
    @Override
    public String toString() {
        return  Apellidos+", "+ Nombres;
    }
}
