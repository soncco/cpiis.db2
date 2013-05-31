package Miscelaneo.Serializacion.EjemploPersona;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.Scanner;

public class Main {
      public static boolean Serializar(String FileName, Persona p){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs;
                     fs = new FileOutputStream(FileName);
                     //Esta clase tiene el metodo writeObject()  ...
                     ObjectOutputStream os = new ObjectOutputStream(fs);             
                     os.writeObject(p);        
                     os.close();
                 } catch (FileNotFoundException e) {            
                     e.printStackTrace();             
                     listo =false;
                 }        
                 catch (IOException e) {            
                     e.printStackTrace();             
                     listo =false;
                 } 
                 return listo;
        }    
      public static boolean Deserializar(String FileName){
         boolean listo =true;
         //iniciar el proceso de serializacion
         try {
             //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
                         
             Persona p = (Persona)ois.readObject();
             
             while (p != null) {                 
                 System.out.println(p.toString());   
                 p = (Persona)ois.readObject();
             }
                 ois.close();             
             
         } catch (FileNotFoundException e) {            
             e.printStackTrace(); 
             System.out.println("1");
                     
             listo =false;
        }        
         catch (IOException e) {            
             e.printStackTrace();             
             System.out.println("2");
             listo =false;
         } 
         catch (ClassNotFoundException e) {            
             e.printStackTrace();             
             System.out.println("3");
             listo =false;
         }
                return listo;
        }
      public static void  Menu (){
          System.out.println("*************************************");
          System.out.println("*         Datos Personales          *");
          System.out.println("*************************************");
          System.out.println("");
          System.out.println("1.- Agregar persona");
          System.out.println("2.- Listar personas");
          System.out.println("3.- Salir");
          System.out.println("");
          System.out.print("Seleccione una opcion: ");
          

      }
      public static void main(String[] args) {
         new NewJFrame().setVisible(true);
     }
}
