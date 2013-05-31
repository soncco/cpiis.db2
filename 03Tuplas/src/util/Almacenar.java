package util;

import Miscelaneo.Serializacion.EjemploPersona.MiObjectOutputStream;
import Miscelaneo.Serializacion.EjemploPersona.Persona;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public  class Almacenar {
    public static void GuardarRelaciones(String FileName, RelacionFile r){
        if (HayRegistrosRelaciones(FileName, r))
            SerializacionSecundariaRelaciones(FileName, r);
        else 
            SerializacionPrimariaRelaciones(FileName, r);            
    }
    public static ArrayList RecuperarRelaciones(String FileName){
         ArrayList listaRelaciones = new ArrayList();
         try {
             //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
             Object aux = ois.readObject();
             RelacionFile rf;
            // Mientras haya objetos
            while (aux!=null) {
                if (aux instanceof RelacionFile) {
                    rf = (RelacionFile)aux;
                    listaRelaciones.add(rf);
                }   
                aux = ois.readObject();
            }
             ois.close();             
         }  catch (EOFException e1)
            {
            System.out.println ("Fin de fichero");
         }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
        return listaRelaciones;
    }
     private static boolean HayRegistros(String FileName, Object o){
        int cont =0;
        try { //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
             Object aux = ois.readObject();
             // Mientras haya objetos
             while (aux!=null) {                 
                if (aux instanceof Object) {
                    cont++;
                     o =(Object)aux;
                     break;
                 }   
                aux = ois.readObject();
            }
             ois.close();             
         }  
         catch (EOFException e1) {
             System.out.println ("Fin de fichero");
         }
         catch (Exception e2){
             e2.printStackTrace();
         }        
        return (cont >0)? true : false;
    }
      private static boolean HayRegistrosRelaciones(String FileName, RelacionFile rf){
        int cont =0;
        try { //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
             Object aux = ois.readObject();
             // Mientras haya objetos
             while (aux!=null) {                 
                if (aux instanceof RelacionFile) {
                    cont++;
                     rf =(RelacionFile)aux;
                     break;
                 }   
                aux = ois.readObject();
            }
             ois.close();             
         }  
         catch (EOFException e1) {
             System.out.println ("Fin de fichero");
         }
         catch (Exception e2){
             e2.printStackTrace();
         }        
        return (cont >0)? true : false;
    }
     public static boolean SerializacionPrimaria(String FileName, Object o){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName);
                     //Esta clase tiene el metodo writeObject()  ...
                     ObjectOutputStream os = new ObjectOutputStream(fs );             
                     os.writeObject(o);        
                     os.close();
                 }
                 catch (Exception e) {
                        e.printStackTrace();
                        listo = false;
                 }
                 return listo;
        }    
     public static boolean SerializacionSecundaria(String FileName, Object o){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName, true);
                     //Esta clase tiene el metodo writeObject()  ...
                     MiObjectOutputStream os = new MiObjectOutputStream(fs );             
                     os.writeUnshared(o);        
                     os.close();
                 }  catch (Exception e) {
                        e.printStackTrace();
                        listo = false;
                    }
                 return listo;
        } 
     public static boolean SerializacionPrimariaRelaciones(String FileName, RelacionFile rf){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName);
                     //Esta clase tiene el metodo writeObject()  ...
                     ObjectOutputStream os = new ObjectOutputStream(fs );             
                     os.writeObject(rf);        
                     os.close();
                 }
                 catch (Exception e) {
                        e.printStackTrace();
                        listo = false;
                 }
                 return listo;
        }    
     public static boolean SerializacionSecundariaRelaciones(String FileName, RelacionFile rf){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName, true);
                     //Esta clase tiene el metodo writeObject()  ...
                     MiObjectOutputStream os = new MiObjectOutputStream(fs );             
                     os.writeUnshared(rf);        
                     os.close();
                 }  catch (Exception e) {
                        e.printStackTrace();
                        listo = false;
                    }
                 return listo;
        } 
    
     public static boolean Deserializar(String FileName){
         boolean listo =true;
         //iniciar el proceso de serializacion
         DefaultTableModel modelo = new DefaultTableModel();
         
         try {
             //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
                     
             modelo.addColumn("Nro");
             modelo.addColumn("Nombres");
             modelo.addColumn("Apellidos");
             modelo.addColumn("País");
             modelo.addColumn("Ciudad");
             modelo.addColumn("Urbanización");
             modelo.addColumn("Calle");
             modelo.addColumn("Lote");
             Object[] obj = new Object[8];
             int cont =0;
             Object aux = ois.readObject();
             Persona p;
            // Mientras haya objetos
            while (aux!=null) {
                if (aux instanceof Persona) {
                    cont++;
                     p =(Persona)aux;
                     obj[0] = cont;
                     obj[1] = p.getNombres().getNombres();
                     obj[2] = p.getNombres().getApellidos();
                     obj[3] = p.getDireccion().getPais();
                     obj[4] = p.getDireccion().getCiudad();
                     obj[5] = p.getDireccion().getUrbanizacion();
                     obj[6] = p.getDireccion().getCalle();
                     obj[7] = p.getDireccion().getLote();                 
                     modelo.addRow(obj);   
                 }   
                aux = ois.readObject();
            }
             ois.close();             
 
             
         }  catch (EOFException e1)
            {
            System.out.println ("Fin de fichero");
         }
        catch (Exception e2)
        {
            e2.printStackTrace();
            listo = false;
        }
//            jTable1.setModel(modelo);
                return listo;
        }
     
}
