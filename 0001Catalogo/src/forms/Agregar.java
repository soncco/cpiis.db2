/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.taqque.almacenamiento.Atributo;
import org.taqque.almacenamiento.Catalogo;
import org.taqque.almacenamiento.EntradaCatalogo;
import org.taqque.almacenamiento.Tabla;

/**
 *
 * @author brau
 */
public class Agregar extends javax.swing.JInternalFrame {

    private DefaultTableModel theModel;
    private ArrayList<Atributo> metadata = new ArrayList<Atributo>();
    private Catalogo catalogo = new Catalogo(EntradaCatalogo.TAQQUE_DIR+
                    System.getProperty("file.separator") + "catalogotarea.dat");
    
    /**
     * Creates new form Agregar
     */
    public Agregar() {
        initComponents();
        setTypes();
        theModel = (DefaultTableModel) atributos.getModel();
        tabla.requestFocusInWindow();
        updateNumTables();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        atributos = new javax.swing.JTable();
        tablaLabel = new javax.swing.JLabel();
        tabla = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        quitar = new javax.swing.JButton();
        tablasLabel = new javax.swing.JLabel();
        numeroTablas = new javax.swing.JLabel();
        agregarCatalogo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);

        atributos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        atributos.setColumnSelectionAllowed(true);
        atributos.getTableHeader().setReorderingAllowed(false);
        panel.setViewportView(atributos);

        tablaLabel.setText("Nombre de la tabla:");

        agregar.setText("Agregar fila");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        quitar.setText("Quitar fila");
        quitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarActionPerformed(evt);
            }
        });

        tablasLabel.setText("Tablas en el catálogo:");

        numeroTablas.setText("numero");

        agregarCatalogo.setText("Agregar al catálogo");
        agregarCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCatalogoActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(tablaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(tablasLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numeroTablas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(agregar)
                                        .addGap(18, 18, 18)
                                        .addComponent(quitar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(agregarCatalogo)
                        .addGap(18, 18, 18)
                        .addComponent(guardar)
                        .addGap(11, 11, 11)
                        .addComponent(limpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tablaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(quitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tablasLabel)
                    .addComponent(numeroTablas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarCatalogo)
                    .addComponent(limpiar)
                    .addComponent(guardar))
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

    private void agregarCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCatalogoActionPerformed
        if(theModel.getRowCount() < 1){
            JOptionPane.showMessageDialog(this, "Ingresa al menos un campo");
        } else if(tabla.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingresa el nombre de la tabla");
            tabla.requestFocusInWindow();
        } else {
            for(int i = 0; i < theModel.getRowCount(); i++) {
                String nombre = theModel.getValueAt(i, 0).toString();
                String tipo = theModel.getValueAt(i, 1).toString();
                Class<? extends Comparable> tipoClass = null;

                if(tipo.equals("String")) {
                    tipoClass = String.class;
                } else if(tipo.equals("Integer")) {
                    tipoClass = Integer.class;
                } else if(tipo.equals("Float")) {
                    tipoClass = Float.class;
                }
                metadata.add(new Atributo(nombre, tipoClass));
            }

            Tabla t = new Tabla(tabla.getText(), metadata);

            EntradaCatalogo entrada = new EntradaCatalogo(t);

            catalogo.crearNuevaEntrada(entrada);
            updateNumTables();

            System.out.println(catalogo);

            clear();
        }
    }//GEN-LAST:event_agregarCatalogoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            catalogo.escribirCatalogo();
        } catch(Exception e) {
            System.err.println(e.toString());
        }

        System.out.println(catalogo);
    }//GEN-LAST:event_guardarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        clear();
    }//GEN-LAST:event_limpiarActionPerformed

    private void setTypes() {
        TableColumn tipo = atributos.getColumnModel().getColumn(1);
        JComboBox combo = new JComboBox();
        combo.addItem("String");
        combo.addItem("Integer");
        combo.addItem("Float");
        tipo.setCellEditor(new DefaultCellEditor(combo));
    }
    
    private void clear() {
        theModel.setRowCount(0);
        metadata.clear();
        tabla.setText("");
        tabla.requestFocusInWindow();
    }
    
    private void updateNumTables() {
        numeroTablas.setText(String.valueOf(catalogo.getNumeroDeTablas()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton agregarCatalogo;
    private javax.swing.JTable atributos;
    private javax.swing.JButton guardar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel numeroTablas;
    private javax.swing.JScrollPane panel;
    private javax.swing.JButton quitar;
    private javax.swing.JTextField tabla;
    private javax.swing.JLabel tablaLabel;
    private javax.swing.JLabel tablasLabel;
    // End of variables declaration//GEN-END:variables
}