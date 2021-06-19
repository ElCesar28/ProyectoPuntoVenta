/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Modelo.Empleado;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/**
 *
 * @author ElCésar26
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuPrincipal
     */
    Empleado empleado;

    public frmMenuPrincipal(Empleado e) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.empleado = e;
        //permisos(e.getRol());
    }

//    private void permisos(String p) {
//        if (!p.equals("administrador")) {
//           
//        }
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPirncipal = new javax.swing.JDesktopPane();
        btnGenerarVenta = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnMarcas = new javax.swing.JButton();
        btnReporteDelDia = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        btnGenerarPedido = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuPirncipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnGenerarVenta.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generarVenta.png"))); // NOI18N
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.setBorderPainted(false);
        btnGenerarVenta.setContentAreaFilled(false);
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnMarcas.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcas.png"))); // NOI18N
        btnMarcas.setText("Marcas");
        btnMarcas.setBorderPainted(false);
        btnMarcas.setContentAreaFilled(false);
        btnMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasActionPerformed(evt);
            }
        });

        btnReporteDelDia.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnReporteDelDia.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteDelDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporteDelDia.png"))); // NOI18N
        btnReporteDelDia.setText("Reporte del dia ");
        btnReporteDelDia.setBorderPainted(false);
        btnReporteDelDia.setContentAreaFilled(false);
        btnReporteDelDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteDelDiaActionPerformed(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedores.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorderPainted(false);
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleados.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnEstadisticas.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estadisticas.png"))); // NOI18N
        btnEstadisticas.setText("Estadisticas");
        btnEstadisticas.setBorderPainted(false);
        btnEstadisticas.setContentAreaFilled(false);
        btnEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadisticasActionPerformed(evt);
            }
        });

        btnGenerarPedido.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnGenerarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generarPedido.png"))); // NOI18N
        btnGenerarPedido.setText("Generar pedido");
        btnGenerarPedido.setBorderPainted(false);
        btnGenerarPedido.setContentAreaFilled(false);

        btnClientes.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorderPainted(false);
        btnClientes.setContentAreaFilled(false);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnCategorias.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categorias.png"))); // NOI18N
        btnCategorias.setText("Categorias");
        btnCategorias.setBorderPainted(false);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        MenuPirncipal.setLayer(btnGenerarVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnProductos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnMarcas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnReporteDelDia, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnProveedores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnEmpleados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnEstadisticas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnGenerarPedido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(btnCategorias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MenuPirncipalLayout = new javax.swing.GroupLayout(MenuPirncipal);
        MenuPirncipal.setLayout(MenuPirncipalLayout);
        MenuPirncipalLayout.setHorizontalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporteDelDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPirncipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEstadisticas)
                                    .addComponent(btnEmpleados)))
                            .addComponent(btnCategorias)
                            .addComponent(btnProveedores)
                            .addComponent(btnMarcas)
                            .addComponent(btnClientes))))
                .addContainerGap(579, Short.MAX_VALUE))
        );
        MenuPirncipalLayout.setVerticalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporteDelDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProveedores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addGap(1, 1, 1)
                .addComponent(btnMarcas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadisticas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPirncipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPirncipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    ///Sirve para agregar y centrar un interlaframe a nuestro frame principal

    private void centrarVentana(JInternalFrame frame) {
        MenuPirncipal.add(frame);
        Dimension dimension = MenuPirncipal.getSize();
        Dimension dframe = frame.getSize();
        frame.setLocation((dimension.width - dframe.width) / 2, (dimension.height - dframe.height) / 2);
        frame.show();
    }

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmEmpleado());
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmMarca());
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmVenta(empleado));
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmCategoria());
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmProducto());
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnReporteDelDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteDelDiaActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmReporteDelDia());
    }//GEN-LAST:event_btnReporteDelDiaActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmEstadisticas());
    }//GEN-LAST:event_btnEstadisticasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmCliente());
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmProveedor());
    }//GEN-LAST:event_btnProveedoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane MenuPirncipal;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnGenerarPedido;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnReporteDelDia;
    // End of variables declaration//GEN-END:variables
}
