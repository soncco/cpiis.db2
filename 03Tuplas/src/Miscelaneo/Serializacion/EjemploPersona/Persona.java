package Miscelaneo.Serializacion.EjemploPersona;

import java.io.Serializable;

public class Persona implements Serializable  {
    private Nombre Nombres;
    private Direccion Direccion;

    public Persona(Nombre Nombres, Direccion Direccion) {
        this.Nombres = Nombres;
        this.Direccion = Direccion;
    }

    public Direccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(Direccion Direccion) {
        this.Direccion = Direccion;
    }

    public Nombre getNombres() {
        return Nombres;
    }

    public void setNombres(Nombre Nombres) {
        this.Nombres = Nombres;
    }
    @Override
    public String toString() {
        return "Nombres: "+ Nombres.toString() + "  ; Direccion: " + Direccion.toString() ;
    }   
}
