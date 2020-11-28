/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author ElCésar26
 */
public class frmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuPrincipal
     */
    public frmMenuPrincipal() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuAcercaDe = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuGenerarVenta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuCliente = new javax.swing.JMenuItem();
        mnuEmpleado = new javax.swing.JMenuItem();
        mnuProducto = new javax.swing.JMenu();
        mnuMarca = new javax.swing.JMenuItem();
        mnuCategoria = new javax.swing.JMenuItem();
        mnuProductos = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuReporteProductos = new javax.swing.JMenuItem();
        mnuVentasPeriodo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 983, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );

        jMenu1.setText("Menu");

        mnuAcercaDe.setText("Acerca de");
        jMenu1.add(mnuAcercaDe);

        mnuSalir.setText("Salir");
        jMenu1.add(mnuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");

        mnuGenerarVenta.setText("Generar Venta");
        mnuGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGenerarVentaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuGenerarVenta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Mantenimiento");

        mnuCliente.setText("Cliente");
        jMenu3.add(mnuCliente);

        mnuEmpleado.setText("Empleado");
        jMenu3.add(mnuEmpleado);

        mnuProducto.setText("Producto");

        mnuMarca.setText("Marca");
        mnuProducto.add(mnuMarca);

        mnuCategoria.setText("Categoria");
        mnuProducto.add(mnuCategoria);

        mnuProductos.setText("Productos");
        mnuProducto.add(mnuProductos);

        jMenu3.add(mnuProducto);

        jMenuBar1.add(jMenu3);

        mnuReportes.setText("Reportes");

        mnuReporteProductos.setText("Cantindad de productos");
        mnuReportes.add(mnuReporteProductos);

        mnuVentasPeriodo.setText("Ventas por periodo");
        mnuReportes.add(mnuVentasPeriodo);

        jMenuBar1.add(mnuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGenerarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuGenerarVentaActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAcercaDe;
    private javax.swing.JMenuItem mnuCategoria;
    private javax.swing.JMenuItem mnuCliente;
    private javax.swing.JMenuItem mnuEmpleado;
    private javax.swing.JMenuItem mnuGenerarVenta;
    private javax.swing.JMenuItem mnuMarca;
    private javax.swing.JMenu mnuProducto;
    private javax.swing.JMenuItem mnuProductos;
    private javax.swing.JMenuItem mnuReporteProductos;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenuItem mnuVentasPeriodo;
    // End of variables declaration//GEN-END:variables
}
