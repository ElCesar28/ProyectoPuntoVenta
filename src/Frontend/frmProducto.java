/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.DAOS.DAOCategoria;
import Backend.DAOS.DAOMarca;
import Backend.DAOS.DAOProducto;
import Backend.DAOS.DAOProveedor;
import Backend.Modelo.Categoria;
import Backend.Modelo.Marca;
import Backend.Modelo.Producto;
import Backend.Modelo.Proveedor;
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
public class frmProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProductos
     */
    ModeloTabla ModeloTabla;
    ArrayList<Marca> listaMarca;
    ArrayList<Categoria> listaCategoria;
    ArrayList<Proveedor> listaProveedor;

    public frmProducto() {
        initComponents();

        listaMarca = new DAOMarca().obtener();
        listaCategoria = new DAOCategoria().obtener();
        listaProveedor = new DAOProveedor().obtener();

        actualizaTablaProducto();
        llenarCombos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnElimar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        spinerStock = new javax.swing.JSpinner();
        txtPrecio = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboxIdMarca = new javax.swing.JComboBox<>();
        cboxIdCategoria = new javax.swing.JComboBox<>();
        cboxId_Proveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioPublico = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioTaller = new javax.swing.JFormattedTextField();
        btnCalculaPrecio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Producto");

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID: ");

        txtidProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripcion:");

        txtDescripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio:");

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

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
        btnLimpiar.setText("Limpiar y Actualizar");
        btnLimpiar.setBorder(null);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        spinerStock.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        spinerStock.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));

        txtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID_Marca:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID_Categoria:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID_Proveedor:");

        cboxIdMarca.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        cboxIdCategoria.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        cboxId_Proveedor.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Publico:");

        txtPrecioPublico.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Taller:");

        txtPrecioTaller.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnCalculaPrecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calculator.png"))); // NOI18N
        btnCalculaPrecio.setBorder(null);
        btnCalculaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculaPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spinerStock, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(btnElimar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalculaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxIdMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxIdCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxId_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboxIdMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboxIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinerStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cboxId_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalculaPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtPrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtPrecioTaller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnElimar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablaProductos.setAutoCreateRowSorter(true);
        tablaProductos.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        listaMarca = new DAOMarca().obtener();
        listaCategoria = new DAOCategoria().obtener();
        listaProveedor = new DAOProveedor().obtener();
        limpiarcajas();
        actualizaTablaProducto();
        llenarCombos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estavacias()) {
            if (new DAOProducto().registrar(new Producto(
                    txtidProducto.getText(),
                    txtDescripcion.getText(),
                    Integer.parseInt(spinerStock.getValue().toString()),
                    Double.parseDouble(txtPrecioPublico.getText()),
                    Double.parseDouble(txtPrecioTaller.getText()),
                    listaMarca.get(cboxIdMarca.getSelectedIndex() - 1).getIdMarca(),
                    listaCategoria.get(cboxIdCategoria.getSelectedIndex() - 1).getIdCategoria(),
                    listaProveedor.get(cboxId_Proveedor.getSelectedIndex() - 1).getIdProveedor()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Registrado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible registrar", "Mensaje", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (estavacias()) {
            if (new DAOProducto().actualizar(new Producto(
                    txtidProducto.getText(),
                    txtDescripcion.getText(),
                    Integer.parseInt(spinerStock.getValue().toString()),
                    Double.parseDouble(txtPrecioPublico.getText()),
                    Double.parseDouble(txtPrecioTaller.getText()),
                    listaMarca.get(cboxIdMarca.getSelectedIndex() - 1).getIdMarca(),
                    listaCategoria.get(cboxIdCategoria.getSelectedIndex() - 1).getIdCategoria(),
                    listaProveedor.get(cboxId_Proveedor.getSelectedIndex() - 1).getIdProveedor()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Editado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtidProducto.getText().equals("")) {
            ArrayList<Producto> lista = new DAOProducto().buscar(txtidProducto.getText());
            String datos[][] = new String[lista.size()][2];
            String columnas[] = new String[]{"ID", "Descripcion", "Stock", "PrecioPublico", "PrecioTaller", "Marca", "Categoria", "Proveedor"};

            for (int i = 0; i < lista.size(); i++) {
                datos[i] = lista.get(i).toString().split(",");
            }
            tablaProductos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        } else {
            JOptionPane.showMessageDialog(null, "Caja vacia", null, JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnElimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimarActionPerformed
        if (estavacias()) {
            if (new DAOProducto().eliminar((txtidProducto.getText()))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Eliminado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun producto", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnElimarActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int index = tablaProductos.getSelectedRow();
        btnAgregar.setEnabled(false);
        txtidProducto.setEnabled(false);
        txtidProducto.setEditable(false);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            txtidProducto.setText(tablaProductos.getValueAt(index, 0).toString());
            txtDescripcion.setText(tablaProductos.getValueAt(index, 1).toString());
            spinerStock.setValue(Integer.parseInt(tablaProductos.getValueAt(index, 2).toString()));
            txtPrecioPublico.setText(tablaProductos.getValueAt(index, 3).toString());
            txtPrecioTaller.setText(tablaProductos.getValueAt(index, 4).toString());
            cboxIdMarca.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 5).toString()), "Marca"));
            cboxIdCategoria.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 6).toString()), "Categoria"));
            cboxId_Proveedor.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 7).toString()), "Proveedor"));
        }
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnCalculaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculaPrecioActionPerformed
        // TODO add your handling code here:
        //condicionales-precio
        if (!cboxId_Proveedor.getSelectedItem().toString().equals("Seleccione")) {
            if (listaProveedor.get(cboxId_Proveedor.getSelectedIndex() - 1).getNombre().equals("Ryse")) {
                preciosR();
            } else if (listaProveedor.get(cboxId_Proveedor.getSelectedIndex() - 1).getNombre().equals("Frilav")) {
                preciosFY();
            } else if (listaProveedor.get(cboxId_Proveedor.getSelectedIndex() - 1).getNombre().equals("llyrsa")) {
                preciosFY();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar un Proveedor", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCalculaPrecioActionPerformed

//establece precio publico y taller
    private void preciosFY() {
        try {
            String precioS = txtPrecio.getText();
            double precio = precioS.contains(".") ? Double.parseDouble(txtPrecio.getText() + "") : Double.parseDouble((txtPrecio.getText() + ".0"));

            System.out.println("precio = " + precio);
            double pp = precio;

            pp += (pp * 0.10);
            pp += (pp * 0.10);
            pp += (pp * 0.10);
            pp += (pp * 0.10);

            if (precio < 200) {
                if (precio < 50) {
                    pp += 1;
                } else {
                    pp += 5;
                }
            } else {
                pp += 7;
            }

            pp += (pp * 0.10);

            if (precio < 200) {
                if (precio < 50) {
                    pp += 1;
                } else {
                    pp += 5;
                }
            } else {
                pp += 7;
            }

            txtPrecioPublico.setText(Math.round(pp) + "");
            txtPrecioTaller.setText(Math.round(pp - (pp * 0.10)) + "");
        } catch (Exception e) {
            txtPrecioPublico.setText("");
            txtPrecioTaller.setText("");
        }
    }

    private void preciosR() {
        try {
            String precioS = txtPrecio.getText();
            double precio = precioS.contains(".") ? Double.parseDouble(txtPrecio.getText() + "") : Double.parseDouble((txtPrecio.getText() + ".0"));

            //System.out.println("precio = " + precio);
            double pp = precio;

            pp += (pp * 0.16);//IVA
            pp += (pp * 0.05);

            if (precio < 200) {
                if (precio < 50) {
                    pp += 1;
                } else {
                    pp += 5;
                }
            } else {
                pp += 7;
            }

            pp += (pp * 0.10);

            if (precio < 200) {
                if (precio < 50) {
                    pp += 1;
                } else {
                    pp += 5;
                }
            } else {
                pp += 7;
            }

            txtPrecioPublico.setText(Math.round(pp) + "");
            txtPrecioTaller.setText(Math.round(pp - (pp * 0.10)) + "");
        } catch (Exception e) {
            txtPrecioPublico.setText("");
            txtPrecioTaller.setText("");
        }
    }

    ///Este metodo nos permite colocar en los combo box el item seleccionado con el que se capturo el id de marca, idcategoria e idproveedores
    private int fijarCboxs(int id, String cual) {
        int r = 0;
        switch (cual) {
            case "Marca": {

                for (int i = 0; i < listaMarca.size(); i++) {
                    if (id == listaMarca.get(i).getIdMarca()) {
                        String aux = listaMarca.get(i).getIdMarca() + " " + listaMarca.get(i).getNombre();
                        for (int j = 0; j < cboxIdMarca.getItemCount(); j++) {
                            if (aux.equals(cboxIdMarca.getItemAt(j))) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            case "Categoria": {

                for (int i = 0; i < listaCategoria.size(); i++) {
                    if (id == listaCategoria.get(i).getIdCategoria()) {
                        String aux = listaCategoria.get(i).getIdCategoria() + " " + listaCategoria.get(i).getNombre();
                        for (int j = 0; j < cboxIdCategoria.getItemCount(); j++) {
                            if (aux.equals(cboxIdCategoria.getItemAt(j))) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    }
                }

                break;
            }
            case "Proveedor": {

                for (int i = 0; i < listaProveedor.size(); i++) {
                    if (id == listaProveedor.get(i).getIdProveedor()) {
                        String aux = listaProveedor.get(i).getIdProveedor() + " " + listaProveedor.get(i).getNombre();
                        for (int j = 0; j < cboxId_Proveedor.getItemCount(); j++) {
                            if (aux.equals(cboxId_Proveedor.getItemAt(j))) {
                                r = j;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
            default: {
                return 0;
            }
        }
        return r;
    }

    ///Método encargado de llenar la tabla de productos
    private void actualizaTablaProducto() {
        ArrayList<Producto> lista = new DAOProducto().obtener();
        String datos[][] = new String[lista.size()][2];
        String columnas[] = new String[]{"ID", "Descripcion", "Stock", "PrecioPublico", "PrecioTaller", "Marca", "Categoria", "Proveedor"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i).toString().split(",");
        }

        formatoTabla(datos, columnas);//llamamos el metodo para dar formato especifico a la tabla

        //tablaProductos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        tablaProductos.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        tablaProductos.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        tablaProductos.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        for (int i = 2; i < columnas.length; i++) {
            tablaProductos.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("numerico"));
        }

        //Ajustamos otras cosas del encavezado
        tablaProductos.getTableHeader().setReorderingAllowed(false);
        tablaProductos.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(120);
        tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(270);
        tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(35);
        tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(35);
        tablaProductos.getColumnModel().getColumn(6).setPreferredWidth(40);
        tablaProductos.getColumnModel().getColumn(7).setPreferredWidth(45);

        tablaProductos.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaProductos.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaProductos.setTableHeader(jtableHeader);
    }

    private boolean estavacias() {
        return !txtPrecioPublico.getText().equals("") && !txtPrecioTaller.getText().equals("") && !txtidProducto.getText().equals("") && !txtDescripcion.getText().equals("")
                && !cboxIdCategoria.getSelectedItem().toString().equals("Seleccione")
                && !cboxIdMarca.getSelectedItem().toString().equals("Seleccione")
                && !cboxId_Proveedor.getSelectedItem().toString().equals("Seleccione");
    }

    ///Este método nos sirve para limpiar las cajas
    private void limpiarcajas() {
        txtDescripcion.setText("");
        txtidProducto.setText("");
        txtPrecio.setText("");
        txtPrecioPublico.setText("");
        txtPrecioTaller.setText("");
        spinerStock.setValue(1);
        cboxIdMarca.setSelectedIndex(0);
        cboxIdCategoria.setSelectedIndex(0);
        cboxId_Proveedor.setSelectedIndex(0);
        btnAgregar.setEnabled(true);
        txtidProducto.setEnabled(true);
        txtidProducto.setEditable(true);
    }

    ///Este método nos ayuda obtener la lista completa de marca, categoria y proveedores disponibles directamente de la base de datos
    private void llenarCombos() {
        cboxIdMarca.removeAllItems();
        cboxIdMarca.addItem("Seleccione");
        for (int i = 0; i < listaMarca.size(); i++) {
            cboxIdMarca.addItem(listaMarca.get(i).getIdMarca() + " " + listaMarca.get(i).getNombre());
        }
        cboxIdCategoria.removeAllItems();
        cboxIdCategoria.addItem("Seleccione");
        for (int i = 0; i < listaCategoria.size(); i++) {
            cboxIdCategoria.addItem((listaCategoria.get(i).getIdCategoria() + " " + listaCategoria.get(i).getNombre()));
        }
        cboxId_Proveedor.removeAllItems();
        cboxId_Proveedor.addItem("Seleccione");
        for (int i = 0; i < listaProveedor.size(); i++) {
            cboxId_Proveedor.addItem(listaProveedor.get(i).getIdProveedor() + " " + listaProveedor.get(i).getNombre());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalculaPrecio;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnElimar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboxIdCategoria;
    private javax.swing.JComboBox<String> cboxIdMarca;
    private javax.swing.JComboBox<String> cboxId_Proveedor;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JSpinner spinerStock;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JFormattedTextField txtPrecioPublico;
    private javax.swing.JFormattedTextField txtPrecioTaller;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
