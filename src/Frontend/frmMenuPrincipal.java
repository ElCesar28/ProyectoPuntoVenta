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
        permisos(e.getRol());
    }

    
    private void permisos(String p){
        if(!p.equals("administrador")){
            mnuMantenimiento.setEnabled(false);
        }
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPirncipal = new javax.swing.JDesktopPane();
        btnGenerarVenta = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuMenu = new javax.swing.JMenu();
        mnuAcercaDe = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        mnuGenerarVenta = new javax.swing.JMenuItem();
        mnuMantenimiento = new javax.swing.JMenu();
        mnuCliente = new javax.swing.JMenuItem();
        mnuEmpleado = new javax.swing.JMenuItem();
        mnuProveedor = new javax.swing.JMenuItem();
        mnuProductos = new javax.swing.JMenu();
        mnuMarca = new javax.swing.JMenuItem();
        mnuCategoria = new javax.swing.JMenuItem();
        mnuProducto = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuReporteProductos = new javax.swing.JMenuItem();
        mnuVentasPeriodo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGenerarVenta.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
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

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        jButton1.setText("Productos");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/marcas.png"))); // NOI18N
        jButton2.setText("Marcas");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporteDelDia.png"))); // NOI18N
        jButton3.setText("Reporte del dia ");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedores.png"))); // NOI18N
        jButton4.setText("Proveedores");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleados.png"))); // NOI18N
        jButton5.setText("Empleados");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estadisticas.png"))); // NOI18N
        jButton6.setText("Estadisticas");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);

        jButton7.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/generarPedido.png"))); // NOI18N
        jButton7.setText("Generar pedido");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);

        jButton8.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientes.png"))); // NOI18N
        jButton8.setText("Clientes");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);

        jButton9.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/categorias.png"))); // NOI18N
        jButton9.setText("Categorias");
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);

        MenuPirncipal.setLayer(btnGenerarVenta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MenuPirncipal.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MenuPirncipalLayout = new javax.swing.GroupLayout(MenuPirncipal);
        MenuPirncipal.setLayout(MenuPirncipalLayout);
        MenuPirncipalLayout.setHorizontalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuPirncipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton9)
                            .addComponent(jButton4)
                            .addComponent(jButton8)
                            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6)
                                    .addComponent(jButton5))))))
                .addContainerGap(630, Short.MAX_VALUE))
        );
        MenuPirncipalLayout.setVerticalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPirncipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );

        mnuMenu.setText("Menu");

        mnuAcercaDe.setText("Acerca de");
        mnuMenu.add(mnuAcercaDe);

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuMenu.add(mnuSalir);

        jMenuBar1.add(mnuMenu);

        mnuVentas.setText("Ventas");

        mnuGenerarVenta.setText("Generar Venta");
        mnuGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGenerarVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(mnuGenerarVenta);

        jMenuBar1.add(mnuVentas);

        mnuMantenimiento.setText("Mantenimiento");

        mnuCliente.setText("Cliente");
        mnuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClienteActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuCliente);

        mnuEmpleado.setText("Empleado");
        mnuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleadoActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuEmpleado);

        mnuProveedor.setText("Proveedor");
        mnuProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProveedorActionPerformed(evt);
            }
        });
        mnuMantenimiento.add(mnuProveedor);

        mnuProductos.setText("Productos");

        mnuMarca.setText("Marca");
        mnuMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMarcaActionPerformed(evt);
            }
        });
        mnuProductos.add(mnuMarca);

        mnuCategoria.setText("Categoria");
        mnuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCategoriaActionPerformed(evt);
            }
        });
        mnuProductos.add(mnuCategoria);

        mnuProducto.setText("Producto");
        mnuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProductoActionPerformed(evt);
            }
        });
        mnuProductos.add(mnuProducto);

        mnuMantenimiento.add(mnuProductos);

        jMenuBar1.add(mnuMantenimiento);

        mnuReportes.setText("Reportes");

        mnuReporteProductos.setText("Cantindad de productos");
        mnuReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuReporteProductosActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuReporteProductos);

        mnuVentasPeriodo.setText("Ventas por periodo");
        mnuVentasPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentasPeriodoActionPerformed(evt);
            }
        });
        mnuReportes.add(mnuVentasPeriodo);

        jMenuBar1.add(mnuReportes);

        setJMenuBar(jMenuBar1);

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

    private void mnuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGenerarVentaActionPerformed
        centrarVentana(new frmVenta(empleado));
    }//GEN-LAST:event_mnuGenerarVentaActionPerformed
    ///Sirve para agregar y centrar un interlaframe a nuestro frame principal
    private void centrarVentana(JInternalFrame frame) {
        MenuPirncipal.add(frame);
        Dimension dimension = MenuPirncipal.getSize();
        Dimension dframe = frame.getSize();
        frame.setLocation((dimension.width - dframe.width) / 2, (dimension.height - dframe.height) / 2);
        frame.show();
    }

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleadoActionPerformed
        centrarVentana(new frmEmpleado());
    }//GEN-LAST:event_mnuEmpleadoActionPerformed

    private void mnuMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMarcaActionPerformed
        centrarVentana(new frmMarca());
    }//GEN-LAST:event_mnuMarcaActionPerformed

    private void mnuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCategoriaActionPerformed
        centrarVentana(new frmCategoria());
    }//GEN-LAST:event_mnuCategoriaActionPerformed

    private void mnuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductoActionPerformed
        centrarVentana(new frmProducto());
    }//GEN-LAST:event_mnuProductoActionPerformed

    private void mnuReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuReporteProductosActionPerformed
        centrarVentana(new frmReporteProductos());
    }//GEN-LAST:event_mnuReporteProductosActionPerformed

    private void mnuVentasPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentasPeriodoActionPerformed
        centrarVentana(new frmReporteVentas());
    }//GEN-LAST:event_mnuVentasPeriodoActionPerformed

    private void mnuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClienteActionPerformed
        centrarVentana(new frmCliente());
    }//GEN-LAST:event_mnuClienteActionPerformed

    private void mnuProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProveedorActionPerformed
        centrarVentana(new frmProveedor());
    }//GEN-LAST:event_mnuProveedorActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
        centrarVentana(new frmVenta(empleado));
    }//GEN-LAST:event_btnGenerarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane MenuPirncipal;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAcercaDe;
    private javax.swing.JMenuItem mnuCategoria;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuEmpleado;
    private javax.swing.JMenuItem mnuGenerarVenta;
    private javax.swing.JMenu mnuMantenimiento;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenu mnuMenu;
    private javax.swing.JMenuItem mnuProducto;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenuItem mnuProveedor;
    private javax.swing.JMenuItem mnuReporteProductos;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuVentas;
    private javax.swing.JMenuItem mnuVentasPeriodo;
    // End of variables declaration//GEN-END:variables
}
