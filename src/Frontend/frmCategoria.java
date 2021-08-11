/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.DAOS.DAOCategoria;
import Backend.Modelo.Categoria;
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
public class frmCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCategoria
     */
    ModeloTabla ModeloTabla;
    private Categoria categoria;
    ArrayList<Categoria> lista;

    public frmCategoria() {
        initComponents();
        actualizaTablaMarca();
        txtidCategoria.setEnabled(false);
        
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        tblCategoria.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        //tblCategoria.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        //tblCategoria.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        for (int i = 0; i < columnas.length; i++) {
            tblCategoria.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        //Ajustamos otras cosas del encavezado
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        tblCategoria.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        tblCategoria.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblCategoria.getColumnModel().getColumn(1).setPreferredWidth(100);

        tblCategoria.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = tblCategoria.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tblCategoria.setTableHeader(jtableHeader);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidCategoria = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModifciar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Modulo Categoria");

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        txtidCategoria.setEditable(false);
        txtidCategoria.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar (2).png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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

        btnModifciar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnModifciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnModifciar.setText("Modificar");
        btnModifciar.setBorder(null);
        btnModifciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifciarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidCategoria)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModifciar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnModifciar)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (!txtNombre.getText().equals("")) {
            if (new DAOCategoria().registrar(new Categoria(txtNombre.getText()))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Registrado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaMarca();
            } else {
                System.out.println("No fue posible regristrar la categoria");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Valores incompatibles", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!txtNombre.getText().equals("") && !txtidCategoria.getText().equals("")) {
            if (new DAOCategoria().eliminar(new Categoria(Integer.parseInt(txtidCategoria.getText()), txtNombre.getText()))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Eliminado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

                actualizaTablaMarca();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun elemento", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (!txtNombre.getText().equals("")) {
            categoria = new DAOCategoria().buscar(txtNombre.getText());
            String datos[][] = new String[1][2];
            String columnas[] = new String[]{"ID", "Nombre"};

            datos[0][0] = categoria.getIdCategoria() + "";
            datos[0][1] = categoria.getNombre();

            //tblCategoria.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
            formatoTabla(datos, columnas);
        } else {
            JOptionPane.showMessageDialog(null, "Caja vacia", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModifciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifciarActionPerformed
        // TODO add your handling code here:
        if (!txtNombre.getText().equals("") && !txtidCategoria.getText().equals("")) {
            if (new DAOCategoria().actualizar(new Categoria(Integer.parseInt(txtidCategoria.getText()), txtNombre.getText()))) {
                limpiarcajas();
                JOptionPane.showMessageDialog(null, "Editado con éxito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                actualizaTablaMarca();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo editar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cajas vacias", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModifciarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarcajas();
        actualizaTablaMarca();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoriaMouseClicked
        // TODO add your handling code here:
        int index = tblCategoria.getSelectedRow();
        btnAgregar.setEnabled(false);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            txtidCategoria.setText(tblCategoria.getValueAt(index, 0).toString());
            txtNombre.setText(tblCategoria.getValueAt(index, 1).toString());
        }
    }//GEN-LAST:event_tblCategoriaMouseClicked

    public void actualizaTablaMarca() {
        lista = new DAOCategoria().obtener();
        String datos[][] = new String[lista.size()][2];
        String columnas[] = new String[]{"ID", "Nombre"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getIdCategoria() + "";
            datos[i][1] = lista.get(i).getNombre();
        }
        //tblCategoria.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
        formatoTabla(datos, columnas);
        lista.clear();
    }

    public void limpiarcajas() {
        txtNombre.setText("");
        txtidCategoria.setText("");
        btnAgregar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModifciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtidCategoria;
    // End of variables declaration//GEN-END:variables
}
