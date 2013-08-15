/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import arbol.ArbolBMas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.taqque.almacenamiento.Atributo;
import org.taqque.almacenamiento.IdentificadorTupla;
import org.taqque.almacenamiento.Relacion;
import org.taqque.almacenamiento.Tupla;

/**
 *
 * @author brau
 */
public class App extends javax.swing.JFrame {

    private DefaultTableModel theModel;
    private ArrayList<Atributo> metadata = new ArrayList<Atributo>();
    private DefaultTableModel theTuplas;
    private int nroTuplas = 0;
    private Relacion relacion;
    private ArbolBMas arbol;
    
    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        setTypes();
        theModel = (DefaultTableModel) atributos.getModel();
        theTuplas = (DefaultTableModel) tuplas.getModel();
        metadata = new ArrayList<Atributo>();
        
    }
    
    private void setTypes() {
        TableColumn tipo = atributos.getColumnModel().getColumn(1);
        JComboBox combo = new JComboBox();
        combo.addItem("Integer");
        combo.addItem("String");
            tipo.setCellEditor(new DefaultCellEditor(combo));
    }
    
    private Atributo getTipo(Object object) {
        String nombre = "";
        Class<? extends Comparable> tipo = null;
        if(object.equals("String")) {
            return new Atributo("string", String.class);
        } else if(object.equals("Integer")) {
            return new Atributo("integer", Integer.class);
        }
        return new Atributo(nombre, tipo);
    }
    
    public int getIndexable() {
        int index = 0;
        for(int i = 0; i < theModel.getRowCount(); i++) {
            int val = Integer.parseInt(theModel.getValueAt(i, 2).toString());
            if(val == 1) index = i;
        }
        return index;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JScrollPane();
        atributos = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        quitar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tuplas = new javax.swing.JTable();
        agregar1 = new javax.swing.JButton();
        quitar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        guardar = new javax.swing.JButton();
        mostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        atributos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Indexar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        atributos.setColumnSelectionAllowed(true);
        atributos.getTableHeader().setReorderingAllowed(false);
        panel.setViewportView(atributos);

        agregar.setText("+");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        quitar.setText("-");
        quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarActionPerformed(evt);
            }
        });

        jLabel1.setText("Atributos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(agregar)
                        .addGap(18, 18, 18)
                        .addComponent(quitar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(quitar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tuplas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tuplas);

        agregar1.setText("+");
        agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar1ActionPerformed(evt);
            }
        });

        quitar1.setText("-");
        quitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitar1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tuplas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(agregar1)
                .addGap(18, 18, 18)
                .addComponent(quitar1)
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar1)
                    .addComponent(quitar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        log.setColumns(20);
        log.setRows(5);
        jScrollPane2.setViewportView(log);

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        mostrar.setText("Mostrar");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mostrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(mostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        theModel.addRow(new Object[2]);
    }//GEN-LAST:event_agregarActionPerformed

    private void quitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarActionPerformed
        int selected = atributos.getSelectedRow();
        if(selected >= 0) {
            theModel.removeRow(selected);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila");
        }
    }//GEN-LAST:event_quitarActionPerformed

    private void agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar1ActionPerformed
        theTuplas.addRow(new Object[2]);
    }//GEN-LAST:event_agregar1ActionPerformed

    private void quitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitar1ActionPerformed
        int selected = tuplas.getSelectedRow();
        if(selected >= 0) {
            theTuplas.removeRow(selected);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila");
        }
    }//GEN-LAST:event_quitar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i = 0; i < theModel.getRowCount(); i++) {
            theTuplas.addColumn(theModel.getValueAt(i, 0).toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        nroTuplas = theTuplas.getRowCount();
        int indexabable = getIndexable();
        log.append(indexabable + "\n");
        for(int i = 0; i < theModel.getRowCount(); i++) {
            metadata.add(getTipo(theModel.getValueAt(i, 0)));
        }
        relacion = new Relacion(metadata);
        
        arbol = new ArbolBMas(nroTuplas);
        
        ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
        
        for(int j = 0; j < theTuplas.getRowCount(); j++) {
            List<Comparable> v = new ArrayList<Comparable>();
            
            for(int k = 0; k < theModel.getRowCount(); k++ ){
                if(theModel.getValueAt(k, 1).equals("String")) {
                    v.add(new String(theTuplas.getValueAt(j, k).toString()));
                } else if (theModel.getValueAt(k, 1).equals("Integer")) {
                    v.add(new Integer(theTuplas.getValueAt(j, k).toString()));
                }
            }
            log.append(v + ".\n");
            Tupla tupla = new Tupla(new IdentificadorTupla("TUPLA", j), v);
            tuplas.add(tupla);
            arbol.insertar(j, tuplas.get(j).getValor(indexabable));
            log.append("Agregando tupla: " + tupla + " al árbol.\n");
        }
        
    }//GEN-LAST:event_guardarActionPerformed

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        log.append("\n\nEl arbol es el siguiente:  \n");
        log.append(arbol.getRaiz().toString());
    }//GEN-LAST:event_mostrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregar1;
    private javax.swing.JTable atributos;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea log;
    private javax.swing.JButton mostrar;
    private javax.swing.JScrollPane panel;
    private javax.swing.JButton quitar;
    private javax.swing.JButton quitar1;
    private javax.swing.JTable tuplas;
    // End of variables declaration//GEN-END:variables
}