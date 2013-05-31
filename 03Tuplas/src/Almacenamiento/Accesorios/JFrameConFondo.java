/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacenamiento.Accesorios;

import java.awt.Image;
import javax.swing.JFrame;

public class JFrameConFondo extends JFrame {

    private final JPanelConFondo contenedor = new JPanelConFondo();

    public JFrameConFondo() {
        setContentPane(contenedor);
    }

    public void setImagen(String nombreImagen) {
        contenedor.setImagen(nombreImagen);
    }

    public void setImagen(Image nuevaImagen) {
        contenedor.setImagen(nuevaImagen);
    }
}

