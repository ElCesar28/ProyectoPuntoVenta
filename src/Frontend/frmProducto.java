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
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ElCésar26
 */
public class frmProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProductos
     */
    public frmProducto() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Producto");

        jLabel1.setText("ID: ");

        jLabel2.setText("Descripcion:");

        jLabel3.setText("Stock:");

        jLabel5.setText("Precio");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnElimar.setText("Eliminar");
        btnElimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        spinerStock.setModel(new javax.swing.SpinnerNumberModel(1, 1, 1000, 1));

        jLabel4.setText("ID_Marca:");

        jLabel6.setText("ID_Categoria:");

        jLabel7.setText("ID_Proveedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(38, 38, 38)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidProducto)
                            .addComponent(txtDescripcion)
                            .addComponent(spinerStock, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtPrecio))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxIdMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxIdCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxId_Proveedor, 0, 145, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnElimar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnElimar))
                .addGap(18, 18, 18))
        );

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Stock", "Precio", "ID_Marca", "ID_Categoria", "ID_Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
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
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarcajas();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (estavacias()) {
            if (new DAOProducto().registrar(new Producto(
                    txtidProducto.getText(),
                    txtDescripcion.getText(),
                    Integer.parseInt(spinerStock.getValue().toString()),
                    Double.parseDouble(txtPrecio.getText()),
                    lista1.get(cboxIdMarca.getSelectedIndex() - 1).getIdMarca(),
                    lista2.get(cboxIdCategoria.getSelectedIndex() - 1).getIdCategoria(),
                    lista3.get(cboxId_Proveedor.getSelectedIndex() - 1).getIdProveedor()
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
                    Double.parseDouble(txtPrecio.getText()),
                    lista1.get(cboxIdMarca.getSelectedIndex() - 1).getIdMarca(),
                    lista2.get(cboxIdCategoria.getSelectedIndex() - 1).getIdCategoria(),
                    lista3.get(cboxId_Proveedor.getSelectedIndex() - 1).getIdProveedor()
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
            String columnas[] = new String[]{"ID", "Descripcion", "Stock", "Precio", "ID_Marca", "ID_Categoria", "IDProveedor"};

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

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            txtidProducto.setText(tablaProductos.getValueAt(index, 0).toString());
            txtDescripcion.setText(tablaProductos.getValueAt(index, 1).toString());
            spinerStock.setValue(Integer.parseInt(tablaProductos.getValueAt(index, 2).toString()));
            txtPrecio.setText(tablaProductos.getValueAt(index, 3).toString());
            cboxIdMarca.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 4).toString()), "Marca"));
            cboxIdCategoria.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 5).toString()), "Categoria"));
            cboxId_Proveedor.setSelectedIndex(fijarCboxs(Integer.parseInt(tablaProductos.getValueAt(index, 6).toString()), "Proveedor"));
        }
    }//GEN-LAST:event_tablaProductosMouseClicked
    ///Este metodo nos permite colocar en los combo box el item seleccionado con el que se capturo el id de marca, categoria y proveedores
    public int fijarCboxs(int id, String cual) {
        int r = 0;
        switch (cual) {
            case "Marca": {

                for (int i = 0; i < lista1.size(); i++) {
                    if (id == lista1.get(i).getIdMarca()) {
                        String aux = lista1.get(i).getIdMarca() + " " + lista1.get(i).getNombre();
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

                for (int i = 0; i < lista2.size(); i++) {
                    if (id == lista2.get(i).getIdCategoria()) {
                        String aux = lista2.get(i).getIdCategoria() + " " + lista2.get(i).getNombre();
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

                for (int i = 0; i < lista3.size(); i++) {
                    if (id == lista3.get(i).getIdProveedor()) {
                        String aux = lista3.get(i).getIdProveedor() + " " + lista3.get(i).getNombre();
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
    public void actualizaTablaProducto() {
        ArrayList<Producto> lista = new DAOProducto().obtener();
        String datos[][] = new String[lista.size()][2];
        String columnas[] = new String[]{"ID", "Descripcion", "Stock", "Precio", "ID_Marca", "ID_Categoria", "IDProveedor"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i).toString().split(",");

        }
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    public boolean estavacias() {
        return !txtPrecio.getText().equals("") && !txtidProducto.getText().equals("") && !txtDescripcion.getText().equals("")
                && !cboxIdCategoria.getSelectedItem().toString().equals("Seleccione")
                && !cboxIdMarca.getSelectedItem().toString().equals("Seleccione")
                && !cboxId_Proveedor.getSelectedItem().toString().equals("Seleccione");
    }

    ///Este método nos sirve para limpiar las cajas
    public void limpiarcajas() {
        txtDescripcion.setText("");
        txtidProducto.setText("");
        txtPrecio.setText("");
        spinerStock.setValue(1);
        cboxIdMarca.setSelectedIndex(0);
        cboxIdCategoria.setSelectedIndex(0);
        cboxId_Proveedor.setSelectedIndex(0);
        btnAgregar.setEnabled(true);
    }
    ArrayList<Marca> lista1 = new DAOMarca().obtener();
    ArrayList<Categoria> lista2 = new DAOCategoria().obtener();
    ArrayList<Proveedor> lista3 = new DAOProveedor().obtener();

    ///Este método nos ayuda obtener la lista completa de marca, categoria y proveedores disponibles directamente de la base de datos
    public void llenarCombos() {
        cboxIdMarca.addItem("Seleccione");
        for (int i = 0; i < lista1.size(); i++) {
            cboxIdMarca.addItem(lista1.get(i).getIdMarca() + " " + lista1.get(i).getNombre());
        }
        cboxIdCategoria.addItem("Seleccione");
        for (int i = 0; i < lista2.size(); i++) {
            cboxIdCategoria.addItem((lista2.get(i).getIdCategoria() + " " + lista2.get(i).getNombre()));
        }
        cboxId_Proveedor.addItem("Seleccione");
        for (int i = 0; i < lista3.size(); i++) {
            cboxId_Proveedor.addItem(lista3.get(i).getIdProveedor() + " " + lista3.get(i).getNombre());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinerStock;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JTextField txtidProducto;
    // End of variables declaration//GEN-END:variables
}
