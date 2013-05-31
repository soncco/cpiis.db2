package Miscelaneo.Serializacion.EjemploPersona;

import java.io.Serializable;


/**
 *
 * @author brau
 */
public class Direccion implements Serializable {
    private String Pais;
    private String Ciudad;
    private String Urbanizacion;
    private String Calle;
    private String Lote;

    public Direccion(String Pais, String Ciudad, String Urbanizacion, String Calle, String Lote) {
        this.Pais = Pais;
        this.Ciudad = Ciudad;
        this.Urbanizacion = Urbanizacion;
        this.Calle = Calle;
        this.Lote = Lote;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String Lote) {
        this.Lote = Lote;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getUrbanizacion() {
        return Urbanizacion;
    }

    public void setUrbanizacion(String Urbanizacion) {
        this.Urbanizacion = Urbanizacion;
    }
    @Override
    public String toString() {
        return  Pais + ", " + Ciudad + ", " + Urbanizacion + ", " + Calle + ", " + Lote ;
    }

                
            
}
