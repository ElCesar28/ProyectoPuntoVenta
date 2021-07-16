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

public class frmTablaCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTablaCliente
     *
     * @param vv
     */
    ModeloTabla ModeloTabla;
    private frmVenta vv;
    ArrayList<Cliente> lista;

    public frmTablaCliente(frmVenta vv) {
        initComponents();
        this.vv = vv;
        actualizaTablaCliente();
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        tablaIndexCliente.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        tablaIndexCliente.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        tablaIndexCliente.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        tablaIndexCliente.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("texto"));

        //Ajustamos otras cosas del encavezado
        tablaIndexCliente.getTableHeader().setReorderingAllowed(false);
        tablaIndexCliente.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        tablaIndexCliente.getColumnModel().getColumn(0).setPreferredWidth(30);
        tablaIndexCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
        tablaIndexCliente.getColumnModel().getColumn(2).setPreferredWidth(50);

        tablaIndexCliente.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = tablaIndexCliente.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaIndexCliente.setTableHeader(jtableHeader);
    }

    public void actualizaTablaCliente() {
        lista = new DAOCliente().obtener();
        String datos[][] = new String[lista.size()][2];
        String columnas[] = new String[]{"ID", "Nombre", "Tipo"};

        for (int i = 0; i < lista.size(); i++) {
            datos[i] = lista.get(i).toStringCorto().split(",");
        }
        formatoTabla(datos, columnas);
        //tablaCliente.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIndexCliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        tablaIndexCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaIndexCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIndexClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIndexCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaIndexClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIndexClienteMouseClicked
        // TODO add your handling code here:
        int index = tablaIndexCliente.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Empty table");
        } else {
            vv.getTxtIdCliente().setText(lista.get(index).getIdCliente()+"");
            vv.getBtnBuscarCliente().doClick();
            this.dispose();
        }
    }//GEN-LAST:event_tablaIndexClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIndexCliente;
    // End of variables declaration//GEN-END:variables
}
