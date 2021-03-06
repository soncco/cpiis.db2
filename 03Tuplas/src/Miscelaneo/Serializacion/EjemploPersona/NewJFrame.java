/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//http://www.chuidiang.com/java/ficheros/ObjetosFichero.php
/*
 * NewJFrame.java
 *
 * Created on 16/05/2012, 11:41:15 AM
 */
package Miscelaneo.Serializacion.EjemploPersona;

import java.io.EOFException;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AMD
 */
public class NewJFrame extends javax.swing.JFrame {
    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        txt_Apellidos = new javax.swing.JTextField();
        txt_Pais = new javax.swing.JTextField();
        txt_Ciudad = new javax.swing.JTextField();
        txt_Urbanizacion = new javax.swing.JTextField();
        txt_Calle = new javax.swing.JTextField();
        txt_Lote = new javax.swing.JTextField();
        btn_Agregar = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton2 = new javax.swing.JToggleButton();
        btn_listar = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Serialización con \"Personas\"");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        jLabel3.setText("Nombres: ");

        jLabel4.setText("Apellidos: ");

        jLabel5.setText("Pais: ");

        jLabel6.setText("Cuidad: ");

        jLabel7.setText("Urbanización: ");

        jLabel8.setText("Calle: ");

        jLabel9.setText("Lote:  ");

        btn_Agregar.setText("Agregar");
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel4)
                            .addGap(10, 10, 10)
                            .addComponent(txt_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(txt_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_Urbanizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(248, 248, 248)
                        .addComponent(btn_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_Urbanizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8))
                    .addComponent(btn_Agregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Agregar personas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Nombres", "Apellidos", "País", "Ciudad", "Urbanización", "Calle", "Lote"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jToggleButton2.setText("Salir");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        btn_listar.setText("Actualizar tabla");
        btn_listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listarActionPerformed(evt);
            }
        });

        jLabel10.setText("Alumno: Javier Quispe Alcca  073313  Sistema de Bases de Datos II");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(btn_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_listar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jLabel10))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        //this.setVisible(false);
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    private boolean HayRegistros(String FileName){
        int cont =0;
        try {
             //recuperamos un archivo del disco
             FileInputStream fis = new FileInputStream(FileName);
             //Esta clase tiene el metodo writeObject()  ...
             ObjectInputStream ois = new ObjectInputStream(fis);             
             
             Object aux = ois.readObject();
             Persona p;
             // Mientras haya objetos
             while (aux!=null) {
                 
                if (aux instanceof Persona) {
                    cont++;
                     p =(Persona)aux;
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
    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        /* El true del final indica que se abre el fichero para añadir datos al final del fichero.*/
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero,true));
        if (EstaDatosCompletos()){
            Persona p = new Persona(new Nombre(txt_nombres.getText(), txt_Apellidos.getText()),
                                            new Direccion(txt_Pais.getText(),txt_Ciudad.getText(),
                                                    txt_Urbanizacion.getText(), txt_Calle.getText(), txt_Lote.getText()));       
            boolean respuesta = false;
            if (!HayRegistros("Personas.dat")){
                respuesta = SerializacionPrimaria("Personas.dat", p);
            }
            else{
                respuesta = SerializacionSecundaria("Personas.dat", p);
            }
            if(respuesta){
                System.out.println("Agregado correctamente...");
                txt_Apellidos.setText("");
                txt_Calle.setText("");
                txt_Ciudad.setText("");
                txt_Lote.setText("");
                txt_Pais.setText("");
                txt_Urbanizacion.setText("");
                txt_nombres.setText("");
                Deserializar("Personas.dat");
                JOptionPane.showMessageDialog(null, "Datos agregados correctamente...");
            }
            
            else
                System.out.println("Error al agregar...");                   
        }
        else{
            JOptionPane.showMessageDialog(null, "Falta agregar uno o varios datos...");
        }
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listarActionPerformed
        boolean respuesta = Deserializar("Personas.dat");
                   if(respuesta)
                        System.out.println("Lista correcta...");
                    else
                        System.out.println("Error al listar...");
        


    }//GEN-LAST:event_btn_listarActionPerformed
    public  boolean SerializacionPrimaria(String FileName, Persona p){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName);
                     //Esta clase tiene el metodo writeObject()  ...
                     ObjectOutputStream os = new ObjectOutputStream(fs );             
                     os.writeObject(p);        
                     os.close();
                 }  catch (Exception e)
                    {
                        e.printStackTrace();
                        listo = false;
                    }
                 return listo;
        }    
    public  boolean SerializacionSecundaria(String FileName, Persona p){
                boolean listo =true;
                //iniciar el proceso de serializacion
                 try {//colocar los obejtos en el disco
                     //creamos el archivo
                     FileOutputStream fs = new FileOutputStream(FileName, true);
                     //Esta clase tiene el metodo writeObject()  ...
                     MiObjectOutputStream os = new MiObjectOutputStream(fs );             
                     os.writeUnshared(p);        
                     os.close();
                 }  catch (Exception e)
                    {
                        e.printStackTrace();
                        listo = false;
                    }
                 return listo;
        } 
    public boolean Deserializar(String FileName){
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
            jTable1.setModel(modelo);
                return listo;
        }
      
    private boolean EstaDatosCompletos(){
        if (txt_Apellidos.getText().isEmpty() || 
            txt_Ciudad.getText().isEmpty() ||
            txt_Lote.getText().isEmpty() || 
            txt_Pais.getText().isEmpty() || 
            txt_Urbanizacion.getText().isEmpty() ||
            txt_nombres.getText().isEmpty() ||
            txt_Calle.getText().isEmpty())
            return false;
        else
              return true;
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Agregar;
    private javax.swing.JToggleButton btn_listar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField txt_Apellidos;
    private javax.swing.JTextField txt_Calle;
    private javax.swing.JTextField txt_Ciudad;
    private javax.swing.JTextField txt_Lote;
    private javax.swing.JTextField txt_Pais;
    private javax.swing.JTextField txt_Urbanizacion;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
