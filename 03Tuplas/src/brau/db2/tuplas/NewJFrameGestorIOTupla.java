package brau.db2.tuplas;

import Almacenamiento.Accesorios.JFrameConFondo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.Almacenar;
import util.Atributo;
import util.GestorIOTupla;
import util.Relacion;
import util.RelacionFile;

public class NewJFrameGestorIOTupla extends JFrameConFondo {
    
    
    //List<Atributo> Atributos;
    JDialogAgregarTuplas agregarTuplas;
    NewJDialogAtributosRelacion DialogoAtributos;
    ArrayList listaRelaciones;
    final String nameFileRelation = "relaciones.dat";
    Relacion relacion;
    String nameRelacion;
    GestorIOTupla gestor;
    DefaultTableModel modelTablaAtributos;
    DefaultTableModel modelTablaTuplas;
    
    
    public NewJFrameGestorIOTupla() {
        initComponents();
        try {
            PonerRelacionesEnComboBox();
        } catch (Exception e) {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbx_tipo = new javax.swing.JComboBox();
        btn_agregarAtributo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_Atributos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_relacion = new javax.swing.JTextField();
        btn_relacionAceptar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_nombreAtributo = new javax.swing.JTextField();
        btn_CrearRelacion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_tuplas = new javax.swing.JTable();
        btn_Salir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbx_Relaciones = new javax.swing.JComboBox();
        btn_VerAtributos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lbl_relacion = new javax.swing.JLabel();
        btn_AgregarTuplas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestor de Tuplas");

        jLabel3.setText("Atributos:");

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "Byte", "Character", "Double", "Integer", "Float", "Long", "Short", "String" }));

        btn_agregarAtributo.setText("Agregar");
        btn_agregarAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarAtributoActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo:");

        jtable_Atributos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtable_Atributos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(jtable_Atributos);

        jLabel2.setText("Nueva Relación:");

        txt_relacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_relacionAceptar.setText("Aceptar");
        btn_relacionAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_relacionAceptarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre:");

        txt_nombreAtributo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_CrearRelacion.setText("Crear Relación");
        btn_CrearRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CrearRelacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_relacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_relacionAceptar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_nombreAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_agregarAtributo))
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btn_CrearRelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_relacionAceptar)
                    .addComponent(jLabel2)
                    .addComponent(txt_relacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombreAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_agregarAtributo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CrearRelacion, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtable_tuplas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtable_tuplas);

        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        jLabel7.setText("Todas las RELACIONES");

        cbx_Relaciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_Relaciones_itemStateChanged(evt);
            }
        });

        btn_VerAtributos.setText("Ver Atributos");
        btn_VerAtributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VerAtributosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cbx_Relaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_VerAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbx_Relaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_VerAtributos))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel6.setText("Tuplas de la Relación: ");

        btn_AgregarTuplas.setText("Agregar Tuplas");
        btn_AgregarTuplas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarTuplasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_relacion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btn_AgregarTuplas, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_relacion, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_AgregarTuplas)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                                .addComponent(btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private boolean ExisteRelacion (String nameRelacion){
        boolean existe = false;
        for (int i = 0; i < cbx_Relaciones.getItemCount(); i++) {
            if ( nameRelacion.compareTo((String)cbx_Relaciones.getItemAt(i))==0 )
                existe = true;
                break;
        }
        return existe;
    }
    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed
    private void btn_relacionAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_relacionAceptarActionPerformed
        nameRelacion = txt_relacion.getText();
        if (nameRelacion.isEmpty() || ExisteRelacion(nameRelacion))
             JOptionPane.showMessageDialog(null, "Este nombre existe o no escribió nada...","ERROR",0);
        else{//creamos la lista de atributos para esta relacion
                relacion = new Relacion();
              //  Atributos = new ArrayList<Atributo>();
        }
    }//GEN-LAST:event_btn_relacionAceptarActionPerformed
    public void MostrarAtributosDeRelacionEnTabla(Relacion relacion){
        String [] encabezado ={"Nro", "Nombre Atributo", "Tipo Atributo"};        
             modelTablaAtributos = new DefaultTableModel(encabezado, 0);            
                for (int i = 0; i <relacion.getAtributos().size(); i++) {
                    Object[] o = {i+1, relacion.getAtributos().get(i).getNombre(), relacion.getAtributos().get(i).getTipo()};                    
                    modelTablaAtributos.addRow(o);
                }  
                jtable_Atributos.setModel(modelTablaAtributos);
                jtable_Atributos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    public boolean ExisteAtributoEnRelacion(Relacion relacion, String nameAtributo){
        boolean existe = false;
        for (int i = 0; i < relacion.getAtributos().size(); i++) {
            if (nameAtributo.compareTo(relacion.getAtributo(i).getNombre())==0){
                existe = true;
                break;
            }
        }
        return existe;
    }
    private void btn_agregarAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarAtributoActionPerformed
        try {
            String nameAtributo = txt_nombreAtributo.getText();
            if (nameAtributo.isEmpty() || ExisteAtributoEnRelacion(relacion, nameAtributo))
                JOptionPane.showMessageDialog(null, "El nombre de atributo existe o no escribió nada...","ERROR",0);
            else{
                int indice = cbx_tipo.getSelectedIndex();
                switch(indice) {
                    case 1: //byte
                       relacion.adicionarAtributo(new Atributo(nameAtributo, Byte.class));
                        break;
                    case 2://caracter
                        relacion.adicionarAtributo(new Atributo(nameAtributo, Character.class));
                        break;
                    case 3: //integer
                       relacion.adicionarAtributo(new Atributo(nameAtributo, Double.class));
                        break;
                    case 4: //integer
                       relacion.adicionarAtributo(new Atributo(nameAtributo, Integer.class));
                        break;
                    case 5: //float
                       relacion.adicionarAtributo(new Atributo(nameAtributo, Float.class));
                        break;
                    case 6://long
                       relacion.adicionarAtributo(new Atributo(nameAtributo,  Long.class));
                        break;
                    case 7: //string
                       relacion.adicionarAtributo(new Atributo(nameAtributo, Short.class));
                        break;
                    case 8: //string
                       relacion.adicionarAtributo(new Atributo(nameAtributo, String.class));
                        break;
                    default: 
                        JOptionPane.showMessageDialog(null, "Seleccione un tipo para el atributo...","ERROR",0);
                        break;
                }
                //mostramos los datos de esta relacion                                
                MostrarAtributosDeRelacionEnTabla(relacion);
                txt_nombreAtributo.setText("");
                //lbl_relacion.setText(String.valueOf(indice));
             //attrs.add(new Atributo("character", Character.class));
            }
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay errores previos para esta operación...","ERROR",0);
        }
    }//GEN-LAST:event_btn_agregarAtributoActionPerformed
    private void PonerRelacionesEnComboBox(){
        cbx_Relaciones.removeAllItems();
        listaRelaciones = Almacenar.RecuperarRelaciones(nameFileRelation);
        for (int i = 0; i < listaRelaciones.size(); i++) {
            RelacionFile rf = (RelacionFile)listaRelaciones.get(i);
            cbx_Relaciones.addItem(rf.getNameRelacion());
        }
       // lbl_relacion.setText(String.valueOf(listaRelaciones.size()));
    }
    private void btn_VerAtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VerAtributosActionPerformed
        try {
            String nameRel = (String)cbx_Relaciones.getSelectedItem();
            listaRelaciones = Almacenar.RecuperarRelaciones(nameFileRelation);
            RelacionFile rf = null;
            for (int i = 0; i < listaRelaciones.size(); i++) {
                rf = (RelacionFile)listaRelaciones.get(i);
                if(nameRel.compareTo(rf.getNameRelacion())==0){
                    break;
                }
            }
            DialogoAtributos = new NewJDialogAtributosRelacion(this, true, rf);
            DialogoAtributos.setVisible(true);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hay errores previos para esta operación...","ERROR",0);
        }
    }//GEN-LAST:event_btn_VerAtributosActionPerformed
    private void btn_AgregarTuplasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarTuplasActionPerformed
        String Relacion_Seleccionado= lbl_relacion.getText();
        RelacionFile rf = null;
        for (int i = 0; i < listaRelaciones.size(); i++) {
            rf = (RelacionFile)listaRelaciones.get(i);
            if (rf.getNameRelacion().compareTo(Relacion_Seleccionado) == 0 ){
                break;
            }
        }
        agregarTuplas = new JDialogAgregarTuplas(this,true, rf);
        agregarTuplas.setVisible(true);
    }//GEN-LAST:event_btn_AgregarTuplasActionPerformed
    private void btn_CrearRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CrearRelacionActionPerformed
        try {
            if (!ExisteRelacion(nameRelacion)){
                if (jtable_Atributos.getModel().getRowCount()>0){
                //tememos que mostrar en el combo de relaciones
                RelacionFile rf = new RelacionFile(relacion, nameRelacion);
                Almacenar.GuardarRelaciones(nameFileRelation, rf);
                
                modelTablaAtributos = null;            
                txt_nombreAtributo.setText("");
                txt_relacion.setText("");
                cbx_tipo.setSelectedIndex(0);
                PonerRelacionesEnComboBox();
                nameRelacion ="";
                rf = null;
                }
                else
                   JOptionPane.showMessageDialog(null, "Esta relación no tiene ningún atributo...","ERROR",0);
            }
            else
               JOptionPane.showMessageDialog(null, "Esta relación ya existe ...","ERROR",0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay errores previos para esta operación...","ERROR",0);
        }
    }//GEN-LAST:event_btn_CrearRelacionActionPerformed
    private void cbx_Relaciones_itemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_Relaciones_itemStateChanged
        try {
            String Relacion_Seleccionado=(String)cbx_Relaciones.getSelectedItem();
            lbl_relacion.setText(Relacion_Seleccionado);
            //tememos que colocar las tuplas de esta relación
            RelacionFile rf = null;
             listaRelaciones = Almacenar.RecuperarRelaciones(nameFileRelation);
            for (int i = 0; i < listaRelaciones.size(); i++) {
                rf = (RelacionFile)listaRelaciones.get(i);
                if (rf.getNameRelacion().equals(Relacion_Seleccionado)) 
                    break;
            }
            PonerTuplasDeRelacion(rf);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbx_Relaciones_itemStateChanged
    private void PonerTuplasDeRelacion(RelacionFile rf){
        String [] encabezado = new String[rf.getRelacion().getAtributos().size()];        
        //los encabezados son dinamicos
        for (int i = 0; i < encabezado.length ; i++) {
            encabezado[i] = rf.getRelacion().getAtributo(i).getNombre();
        }
        modelTablaTuplas = new   DefaultTableModel(encabezado, 0);
        jtable_tuplas.setModel(modelTablaTuplas);
        //agregamos las tuplas que corresponden a esta relacion
        
    }
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
            java.util.logging.Logger.getLogger(NewJFrameGestorIOTupla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameGestorIOTupla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameGestorIOTupla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameGestorIOTupla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                //new NewJFrameGestorIOTupla().setVisible(true);
                 JFrameConFondo jf = new NewJFrameGestorIOTupla();
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AgregarTuplas;
    private javax.swing.JButton btn_CrearRelacion;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_VerAtributos;
    private javax.swing.JButton btn_agregarAtributo;
    private javax.swing.JButton btn_relacionAceptar;
    private javax.swing.JComboBox cbx_Relaciones;
    private javax.swing.JComboBox cbx_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable_Atributos;
    private javax.swing.JTable jtable_tuplas;
    private javax.swing.JLabel lbl_relacion;
    private javax.swing.JTextField txt_nombreAtributo;
    private javax.swing.JTextField txt_relacion;
    // End of variables declaration//GEN-END:variables
}
