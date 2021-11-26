/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.DAOS.DAOProveedor;
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
public class frmProveedor extends javax.swing.JInternalFrame {

    ModeloTabla ModeloTabla;
    Proveedor proveedor;
    ArrayList<Proveedor> lista;
    String datos[][];
    String columnas[];

    public frmProveedor() {
        initComponents();
        actualizaTablaProducto();
        limpiarcajas();
        txtidProveedor.setEnabled(false);
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        tablaProveedores.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        for (int i = 0; i < columnas.length; i++) {
            tablaProveedores.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }
        //{"ID", "Nombre", "NumCuenta1", "NumCuenta2", "Correo1", "Correo2", "Telefono1", "Telofono2"};
        //Ajustamos otras cosas del encavezado
        tablaProveedores.getTableHeader().setReorderingAllowed(false);
        tablaProveedores.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        tablaProveedores.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaProveedores.getColumnModel().getColumn(1).setPreferredWidth(40);
        tablaProveedores.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaProveedores.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);
        tablaProveedores.getColumnModel().getColumn(5).setPreferredWidth(100);
        tablaProveedores.getColumnModel().getColumn(6).setPreferredWidth(80);
        tablaProveedores.getColumnModel().getColumn(7).setPreferredWidth(80);

        tablaProveedores.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaProveedores.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaProveedores.setTableHeader(jtableHeader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnElimar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtidProveedor = new javax.swing.JTextField();
        txtCorreo1 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        txtNumCuenta1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JTextField();
        txtCorreo2 = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumCuenta2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtidProveedorbusqueda = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Proveedor");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

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
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txtidProveedor.setEditable(false);
        txtidProveedor.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtCorreo1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtTelefono1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtNumCuenta1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Num Cuenta1:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teleofono1:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo1:");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID: ");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo2:");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Teleofono2:");

        txtTelefono2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtCorreo2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Num Cuenta2:");

        txtNumCuenta2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono1)
                    .addComponent(txtCorreo1)
                    .addComponent(txtNumCuenta1)
                    .addComponent(txtidProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumCuenta2)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCorreo2)
                    .addComponent(txtNombre))
                .addGap(2, 2, 2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtidProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNumCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumCuenta2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtidProveedorbusqueda.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtidProveedorbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidProveedorbusquedaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(txtidProveedorbusqueda))
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtidProveedorbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257)
                        .addComponent(btnElimar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnElimar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarcajas();
        actualizaTablaProducto();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        int index = tablaProveedores.getSelectedRow();
        btnAgregar.setEnabled(false);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            txtidProveedor.setText(tablaProveedores.getValueAt(index, 0).toString());
            txtNombre.setText(tablaProveedores.getValueAt(index, 1).toString());
            txtNumCuenta1.setText(tablaProveedores.getValueAt(index, 2).toString());
            txtNumCuenta2.setText(tablaProveedores.getValueAt(index, 3).toString());
            txtCorreo1.setText(tablaProveedores.getValueAt(index, 4).toString());
            txtCorreo2.setText((String) tablaProveedores.getValueAt(index, 5));
            txtTelefono1.setText(tablaProveedores.getValueAt(index, 6).toString());
            txtTelefono2.setText((String) tablaProveedores.getValueAt(index, 7));

        }
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (estavacias()) {
            if (new DAOProveedor().actualizar(new Proveedor(
                    Integer.parseInt(txtidProveedor.getText()),
                    txtNombre.getText(),
                    txtNumCuenta1.getText(),
                    txtNumCuenta2.getText(),
                    txtCorreo1.getText(),
                    txtCorreo2.getText(),
                    txtTelefono1.getText(),
                    txtTelefono2.getText()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Editado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible actualizar", "Mensaje", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estavacias()) {
            if (new DAOProveedor().registrar(new Proveedor(
                    0,
                    txtNombre.getText(),
                    txtNumCuenta1.getText(),
                    txtNumCuenta2.getText(),
                    txtCorreo1.getText(),
                    txtCorreo2.getText(),
                    txtTelefono1.getText(),
                    txtTelefono2.getText()
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

    private void btnElimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimarActionPerformed
        if (estavacias()) {
            if (new DAOProveedor().eliminar(new Proveedor(
                    Integer.parseInt(txtidProveedor.getText()),
                    txtNombre.getText(),
                    txtNumCuenta1.getText(),
                    txtNumCuenta2.getText(),
                    txtCorreo1.getText(),
                    txtCorreo2.getText(),
                    txtTelefono1.getText(),
                    txtTelefono2.getText()
            ))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Eliminado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "No fue posible eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnElimarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtidProveedorbusqueda.getText().equals("")) {
            proveedor = new DAOProveedor().buscar(Integer.parseInt(txtidProveedorbusqueda.getText()));
            datos = new String[lista.size()][2];
            columnas = new String[]{"ID", "Nombre", "NumCuenta1", "NumCuenta2", "Correo1", "Correo2", "Telefono1", "Telofono2"};

            for (int i = 0; i < lista.size(); i++) {
                datos[i] = lista.get(i).toString().split(",");

            }
            formatoTabla(datos, columnas);
            //tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtidProveedorbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidProveedorbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidProveedorbusquedaActionPerformed

    ///Método encargado de llenar la tabla de proveedores
    public void actualizaTablaProducto() {
        lista = new DAOProveedor().obtener();
        datos = new String[lista.size()][2];
        columnas = new String[]{"ID", "Nombre", "NumCuenta1", "NumCuenta2", "Correo1", "Correo2", "Telefono1", "Telofono2"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i).toString().split(",");

        }
        formatoTabla(datos, columnas);
        //tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    ///Este metodo nos permite validar que las cajas no estén vacias 
    public boolean estavacias() {
        return !txtNombre.getText().equals("") && !txtNumCuenta1.getText().equals("")
                && !txtCorreo1.getText().equals("") && !txtTelefono1.getText().equals("");
    }

    ///Este método nos sirve para limpiar las cajas
    public void limpiarcajas() {
        txtidProveedor.setText("");
        txtNombre.setText("");
        txtNumCuenta1.setText("");
        txtNumCuenta2.setText("");
        txtCorreo1.setText("");
        txtTelefono1.setText("");
        txtCorreo2.setText("");
        txtTelefono2.setText("");
        btnAgregar.setEnabled(true);
        txtidProveedorbusqueda.setText("");
        txtNumCuenta1.setEnabled(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnElimar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTextField txtCorreo1;
    private javax.swing.JTextField txtCorreo2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumCuenta1;
    private javax.swing.JTextField txtNumCuenta2;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    private javax.swing.JTextField txtidProveedor;
    private javax.swing.JTextField txtidProveedorbusqueda;
    // End of variables declaration//GEN-END:variables
}
