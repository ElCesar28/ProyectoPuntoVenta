/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.DAOS.DAOCliente;
import Backend.Modelo.Cliente;
import Backend.Util.ModeloTabla.GestionCeldas;
import Backend.Util.ModeloTabla.GestionEncabezadoTabla;
import Backend.Util.ModeloTabla.ModeloTabla;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ElCésar26
 */
public class frmCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCliente
     */
    ModeloTabla ModeloTabla;
    Cliente cliente;
    ArrayList<Cliente> lista;

    public frmCliente() {
        initComponents();
        // btnLimpiar.setIcon(setIcono("/imagenes/limpiar.png", btnLimpiar));
        actualizaTablaCliente();
        txtidCliente.setEnabled(false);
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        tablaCliente.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        for (int i = 0; i < columnas.length; i++) {
            tablaCliente.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        //Ajustamos otras cosas del encavezado
        tablaCliente.getTableHeader().setReorderingAllowed(false);
        tablaCliente.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        tablaCliente.getColumnModel().getColumn(0).setPreferredWidth(45);
        tablaCliente.getColumnModel().getColumn(1).setPreferredWidth(110);
        tablaCliente.getColumnModel().getColumn(2).setPreferredWidth(110);
        tablaCliente.getColumnModel().getColumn(3).setPreferredWidth(180);
        tablaCliente.getColumnModel().getColumn(4).setPreferredWidth(60);
        tablaCliente.getColumnModel().getColumn(5).setPreferredWidth(60);
        tablaCliente.getColumnModel().getColumn(6).setPreferredWidth(50);

        tablaCliente.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaCliente.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaCliente.setTableHeader(jtableHeader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnElimar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtidClienteBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTel2 = new javax.swing.JTextField();
        txtTel1 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lstboxTipo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Cliente");

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnElimar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnElimar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar (2).png"))); // NOI18N
        btnElimar.setText("Eliminar");
        btnElimar.setBorder(null);
        btnElimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText(" Limpiar y Actualizar");
        btnLimpiar.setBorder(null);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID: ");

        txtidClienteBusqueda.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtidClienteBusqueda)
                .addGap(28, 28, 28))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtidClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID: ");

        txtidCliente.setEditable(false);
        txtidCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono1:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono2:");

        txtTel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtTel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtApellidos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo:");

        lstboxTipo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lstboxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico", "Publico" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidCliente, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lstboxTipo, 0, 266, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lstboxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnElimar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCliente);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarcajas();
        actualizaTablaCliente();

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estavacias()) {
            if (new DAOCliente().registrar(new Cliente(
                    0,
                    txtNombre.getText(),
                    txtApellidos.getText(),
                    txtDireccion.getText(),
                    txtTel1.getText(),
                    txtTel2.getText(),
                    lstboxTipo.getSelectedItem().toString()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Registrado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaCliente();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible registrar ", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (estavacias()) {
            if (new DAOCliente().actualizar(new Cliente(
                    Integer.parseInt(txtidCliente.getText()),
                    txtNombre.getText(),
                    txtApellidos.getText(),
                    txtDireccion.getText(),
                    txtTel1.getText(),
                    txtTel2.getText(),
                    lstboxTipo.getSelectedItem().toString()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Editado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaCliente();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnElimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimarActionPerformed
        if (estavacias()) {
            if (new DAOCliente().eliminar(new Cliente(
                    Integer.parseInt(txtidCliente.getText()),
                    txtNombre.getText(),
                    txtApellidos.getText(),
                    txtDireccion.getText(),
                    txtTel1.getText(),
                    txtTel2.getText()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Eliminado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaCliente();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnElimarActionPerformed

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        int index = tablaCliente.getSelectedRow();
        btnAgregar.setEnabled(false);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            txtidCliente.setText(tablaCliente.getValueAt(index, 0).toString());
            txtNombre.setText(tablaCliente.getValueAt(index, 1).toString());
            txtApellidos.setText(tablaCliente.getValueAt(index, 2).toString());
            txtDireccion.setText(tablaCliente.getValueAt(index, 3).toString());
            txtTel1.setText(tablaCliente.getValueAt(index, 4).toString());
            txtTel2.setText((String) tablaCliente.getValueAt(index, 5));

        }

    }//GEN-LAST:event_tablaClienteMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtidClienteBusqueda.getText().equals("")) {
            cliente = new DAOCliente().buscar(Integer.parseInt(txtidClienteBusqueda.getText()));
            String datos[][] = new String[1][2];
            String columnas[] = new String[]{"ID", "Nombre", "Apellidos", "Direccion", "Telefono1", "Telefono2", "Tipo"};

            datos[0] = cliente.toString().split(",");

            formatoTabla(datos, columnas);
            //tablaCliente.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        } else {
            JOptionPane.showMessageDialog(null, "Caja vacia", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    ///Este metodo nos permite validar que las cajas no estén vacias 
    public boolean estavacias() {
        return !txtNombre.getText().equals("") && !txtApellidos.getText().equals("")
                && !txtDireccion.getText().equals("") && !txtTel1.getText().equals("");
    }

    public void actualizaTablaCliente() {
        lista = new DAOCliente().obtener();
        String datos[][] = new String[lista.size()][2];
        String columnas[] = new String[]{"ID", "Nombre", "Apellidos", "Direccion", "Telefono1", "Telefono2", "Tipo"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i).toString().split(",");
        }
        formatoTabla(datos, columnas);
        //tablaCliente.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        lista.clear();
    }

    public void limpiarcajas() {
        txtidCliente.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTel1.setText("");
        txtTel2.setText("");
        txtidClienteBusqueda.setText("");
        btnAgregar.setEnabled(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnElimar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstboxTipo;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTel1;
    private javax.swing.JTextField txtTel2;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtidClienteBusqueda;
    // End of variables declaration//GEN-END:variables

//    public Icon setIcono(String url, JButton boton){
//        ImageIcon icon=new ImageIcon(getClass().getResource(url));
//        
//        int ancho = boton.getWidth();
//        int alto = boton.getHeight();
//        
//        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
//        return icono;
//    }
}
