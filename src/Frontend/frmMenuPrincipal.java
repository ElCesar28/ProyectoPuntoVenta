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

        javax.swing.GroupLayout MenuPirncipalLayout = new javax.swing.GroupLayout(MenuPirncipal);
        MenuPirncipal.setLayout(MenuPirncipalLayout);
        MenuPirncipalLayout.setHorizontalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        MenuPirncipalLayout.setVerticalGroup(
            MenuPirncipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane MenuPirncipal;
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
