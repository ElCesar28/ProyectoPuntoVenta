/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.DAOS.DAOCliente;
import Backend.DAOS.DAODetalleDeVenta;
import Backend.DAOS.DAOProducto;
import Backend.DAOS.DAOVenta;
import Backend.Modelo.Cliente;
import Backend.Modelo.DetalleDeVenta;
import Backend.Modelo.Empleado;
import Backend.Modelo.Producto;
import Backend.Modelo.Venta;
import Backend.Util.ModeloTabla.GestionCeldas;
import Backend.Util.ModeloTabla.GestionEncabezadoTabla;
import Backend.Util.ModeloTabla.ModeloTabla;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

/**
 *
 *
 *
 *
 */
public class frmVenta extends javax.swing.JInternalFrame implements Runnable {

    //Principales variables que ayudan al funcionamiento
    private Cliente objCliente;
    private Empleado objEmpleado;
    private Producto objProducto;
    private ArrayList<Producto> productosNotaObjetos;
    private ArrayList<String> productosNotaString;
    private SpinnerNumberModel modeloSpinner;
    private String hora, minutos, segundos;
    private Thread hilo;
    private Double total;
    private boolean descuento;
    private String fechadb;
    private ModeloTabla ModeloTabla;
    private frmMenuPrincipal menu;

    //Como parametros recivimos un menu y un objEmpleado para la logica y algunos datos importantes
    public frmVenta(Empleado e, frmMenuPrincipal menu) {

        initComponents();
        this.productosNotaObjetos = new ArrayList<>();
        this.modeloSpinner = new SpinnerNumberModel();
        this.objEmpleado = e;
        this.txtNombreEmpleado.setText(e.getNombre() + " " + e.getApellido());
        this.txtFecha.setText(fecha());
        this.hilo = new Thread(this);
        this.hilo.start();
        this.txtNombreEmpleado.setEditable(false);
        this.txtFecha.setEditable(false);
        this.txtHora.setEditable(false);
        this.txtTotal.setEditable(false);
        this.btnAgregarProducto.setEnabled(false);
        this.productosNotaString = new ArrayList<>();
        this.descuento = false;
        this.fechadb = "";
        this.total = 0.0;
        this.menu = menu;
        this.rbtnContado.setSelected(true);
        this.pnlNotas.setVisible(false);
    }

    //getters y setters
    public JTextField getTxtIdCliente() {
        return txtIdCliente;
    }

    public void setTxtIdCliente(JTextField txtIdCliente) {
        this.txtIdCliente = txtIdCliente;
    }

    public JTextField getTxtIdProducto() {
        return txtIdProducto;
    }

    public void setTxtIdProducto(JTextField txtIdProducto) {
        this.txtIdProducto = txtIdProducto;
    }

    public JButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public void setBtnBuscarCliente(JButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }

    public JButton getBtnBuscarProducto() {
        return btnBuscarProducto;
    }

    public void setBtnBuscarProducto(JButton btnBuscarProducto) {
        this.btnBuscarProducto = btnBuscarProducto;
    }

    //metodo para dar formato especifico a la tabla
    private void formatoTabla(String datos[][], String columnas[]) {
        //Instanciamos un modelo de tabla con los datos de los productos
        ModeloTabla = new ModeloTabla(datos, columnas);
        //Le asignamos a nuestra tabla el modelo
        TablaDetalleVenta.setModel(ModeloTabla);

        //Establecemos el formato de nuestros encabezaos con ayuda de métodos sobreescritos en la clase
        // gestionEncabezados (setCellRerender)
        TablaDetalleVenta.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));
        TablaDetalleVenta.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("texto"));
        for (int i = 2; i < columnas.length; i++) {
            TablaDetalleVenta.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("numerico"));
        }

        //Ajustamos otras cosas del encavezado
        TablaDetalleVenta.getTableHeader().setReorderingAllowed(false);
        TablaDetalleVenta.setRowHeight(25);//definimos el alto de las celdas
        //Establecemos el ancho de las celdas (al gusto y necesidad)
        TablaDetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(130);
        TablaDetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(280);
        TablaDetalleVenta.getColumnModel().getColumn(2).setPreferredWidth(45);
        TablaDetalleVenta.getColumnModel().getColumn(3).setPreferredWidth(45);
        TablaDetalleVenta.getColumnModel().getColumn(4).setPreferredWidth(45);

        TablaDetalleVenta.setGridColor(new java.awt.Color(0, 0, 0));//Color

        //personaliza el encabezado
        JTableHeader jtableHeader = TablaDetalleVenta.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        TablaDetalleVenta.setTableHeader(jtableHeader);
    }

    ///determina la hora en tiempo real 
    private void hora() {
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    ///metodo run del hilo que muestra la fecha y hora en tiempo real
    @Override
    public void run() {
        Thread current = Thread.currentThread();

        while (current == hilo) {
            hora();
            txtHora.setText(hora + ":" + minutos + ":" + segundos);
        }
    }

    ///Proporciona la fecha en un formato especifico (dia,mes,anio) o (anio,mes,dia)
    //que usaremos para mostrar al usuario e insertar datos en la base de datos
    private static String fecha() {
        Date fecha = new Date();
        //SimpleDateFormat formatodefechadb = new SimpleDateFormat("YYYY/MM/dd");
        SimpleDateFormat formatodefecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatodefecha.format(fecha);
    }

    private static String fechadb() {
        Date fecha = new Date();
        SimpleDateFormat formatodefechadb = new SimpleDateFormat("YYYY/MM/dd");
        //SimpleDateFormat formatodefecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatodefechadb.format(fecha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdbtnGrupoTipoVenta = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnLimpiarCliente = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spinerCantidad = new javax.swing.JSpinner();
        btnAgregarProducto = new javax.swing.JButton();
        btnLimpiarProducto = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        pnlNotas = new javax.swing.JPanel();
        txtFolioPorCobrar1 = new javax.swing.JTextField();
        btnPorCobrar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDetalleVenta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        rbtnCredito = new javax.swing.JRadioButton();
        rbtnContado = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JFormattedTextField();
        btnGenerarVenta = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Generar Venta");

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Refacciones Origninales ");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Boulevar Ponciano Vega #670");

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tel: 4451455052");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(357, 357, 357))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(403, 403, 403))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(437, 437, 437))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jPanel5.setBackground(new java.awt.Color(0, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID_Cliente:");

        txtIdCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnBuscarCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtCliente.setDragEnabled(true);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente:");

        btnLimpiarCliente.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnLimpiarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiarCliente.setText("Limpiar");
        btnLimpiarCliente.setBorder(null);
        btnLimpiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(txtIdCliente)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliente)
                    .addComponent(btnLimpiarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnBuscarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiarCliente)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID_Producto:");

        txtIdProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnBuscarProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Producto:");

        txtProducto.setEditable(false);
        txtProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtPrecio.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Stock:");

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad:");

        spinerCantidad.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        spinerCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinerCantidad.setPreferredSize(new java.awt.Dimension(7, 27));

        btnAgregarProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnLimpiarProducto.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnLimpiarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiarProducto.setText("Limpiar");
        btnLimpiarProducto.setBorder(null);
        btnLimpiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtProducto)
                    .addComponent(txtIdProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarProducto)
                            .addComponent(btnLimpiarProducto))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lblNombreEmpleado.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreEmpleado.setText("Le atiende:");

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        txtHora.setEditable(false);
        txtHora.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNombreEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreEmpleado)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlNotas.setBackground(new java.awt.Color(0, 102, 204));
        pnlNotas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txtFolioPorCobrar1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        btnPorCobrar1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnPorCobrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar (2).png"))); // NOI18N
        btnPorCobrar1.setText("Buscar");
        btnPorCobrar1.setBorder(null);

        javax.swing.GroupLayout pnlNotasLayout = new javax.swing.GroupLayout(pnlNotas);
        pnlNotas.setLayout(pnlNotasLayout);
        pnlNotasLayout.setHorizontalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPorCobrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFolioPorCobrar1))
                .addContainerGap())
        );
        pnlNotasLayout.setVerticalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotasLayout.createSequentialGroup()
                .addComponent(txtFolioPorCobrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPorCobrar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaDetalleVenta);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        rbtnCredito.setBackground(new java.awt.Color(0, 51, 153));
        rdbtnGrupoTipoVenta.add(rbtnCredito);
        rbtnCredito.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        rbtnCredito.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCredito.setText("Credito");

        rbtnContado.setBackground(new java.awt.Color(0, 51, 153));
        rdbtnGrupoTipoVenta.add(rbtnContado);
        rbtnContado.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        rbtnContado.setForeground(new java.awt.Color(255, 255, 255));
        rbtnContado.setText("Contado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnContado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnCredito)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCredito)
                    .addComponent(rbtnContado))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 0));
        txtTotal.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Efectivo:");

        txtEfectivo.setBackground(new java.awt.Color(102, 204, 0));
        txtEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtEfectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtEfectivo.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        btnGenerarVenta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sell.png"))); // NOI18N
        btnGenerarVenta.setText("Generar");
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGenerarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Metodo para buscar un cliente 
    private void buscarCliente() {
        if (!txtIdCliente.getText().equals("")) {//revisamos si hay un id de cliente para asi buscarlo
            try {
                //buscamos y asignamos un Cliente a un objCliente 
                objCliente = new DAOCliente().buscar(Integer.parseInt(txtIdCliente.getText()));
                //enviamos informacion y formato a los txt
                txtCliente.setText(objCliente.getNombre() + " " + objCliente.getApellidos());
                txtCliente.setEditable(false);
                //de acuerdo al tipo de cliente aplicacmos o no descuento
                descuento = objCliente.getTipo().equals("Tecnico") ? true : false;

            } catch (Exception e) {
                //si hubo un error es porque no se encontro al cliente 
                //y arroja una notificacion
                JOptionPane.showMessageDialog(null, "Cliente no encontrado", null, JOptionPane.WARNING_MESSAGE);
            }
        } else {//si no hay un id, se desplega una ventana con los nombres de clientes donde podemos seleccionarlos
            this.menu.centrarVentana(new frmTablaCliente(this));
        }
    }

    //Metodo para buscar un Producto
    private void buscarProducto() {
        if (!txtIdProducto.getText().equals("")) {//Revisamos que el txt no este vacio
            try {//usamos un try por convenencia por si ocurre algun error
                objProducto = new DAOProducto().buscar(txtIdProducto.getText());

                if (objProducto.getStock() > 0) {//revisamos que productos disponibles

                    //del obj extraemos algunos datos para los txt
                    txtProducto.setText(objProducto.getDescripcion());
                    txtProducto.setEditable(false);

                    txtPrecio.setText(String.valueOf(descuento ? objProducto.getPrecioTaller() : objProducto.getPrecioPublico()));//aplicamos el descuento
                    txtPrecio.setEditable(false);

                    txtStock.setText(String.valueOf(objProducto.getStock()));
                    txtStock.setEditable(false);

                    //apartir del stock del producto definimos el modelo del spinner
                    modeloSpinner.setMaximum(objProducto.getStock());
                    modeloSpinner.setMinimum(1);
                    modeloSpinner.setStepSize(1);
                    modeloSpinner.setValue(1);

                    spinerCantidad.setModel(modeloSpinner);

                    btnAgregarProducto.setEnabled(true);
                    txtIdProducto.setEditable(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Producto Agotado", null, JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Producto no encontrado", null, JOptionPane.WARNING_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Caja vacia", null, JOptionPane.WARNING_MESSAGE);
        }
    }

    //Metodo para agregar un producto a la tablaNota
    private void agregarProducto() {
        boolean bandera = false;
        try {
            if (!productosNotaString.isEmpty()) {

                for (int i = 0; i < productosNotaObjetos.size(); i++) {
                    if (txtIdProducto.getText().equals(productosNotaObjetos.get(i).getIdProducto())) {

                        String[] aux = productosNotaString.get(i).split(",");
                        int cantidad = Integer.parseInt(aux[2]);

                        int nuevacantidad = cantidad + Integer.parseInt(spinerCantidad.getValue().toString());

                        if (nuevacantidad <= productosNotaObjetos.get(i).getStock()) {
                            productosNotaString.set(i, aux[0] + "," + aux[1] + "," + nuevacantidad + "," + aux[3] + ","
                                    + nuevacantidad * (descuento ? productosNotaObjetos.get(i).getPrecioTaller() : productosNotaObjetos.get(i).getPrecioPublico()));
                            actualizaTablaNota();
                            limpiarProducto();
                            obtenerTotal();
                            txtTotal.setText(total + "");
                            bandera = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Stock insuficiente", null, JOptionPane.ERROR_MESSAGE);
                            bandera = true;
                            limpiarProducto();
                        }
                    }
                }
                if (!bandera) {
                    cargaProducto(new DAOProducto().buscar(txtIdProducto.getText()));
                }

            } else {
                cargaProducto(new DAOProducto().buscar(txtIdProducto.getText()));
            }
            btnAgregarProducto.setEnabled(false);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo cargar el ultimo producto", null, JOptionPane.WARNING_MESSAGE);
        }
    }
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        buscarCliente();
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        buscarProducto();
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        agregarProducto();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    ///este metodo nos ayuda guardar los datos del producto que se venderá en estructuraas internas y en la tabla para man
    private void cargaProducto(Producto p) {
        //definimos las variables que formaran parte de n uestra tabla y calculamos el total 
        String idProducto = p.getIdProducto();
        String descripcion = p.getDescripcion();
        String cantidad = spinerCantidad.getValue().toString();
        String precio = (descuento ? p.getPrecioTaller() : p.getPrecioPublico()) + "";
        String importe = String.valueOf((Integer.parseInt(cantidad) * Double.parseDouble(precio)));
        //preparamos nuestros datos para ingresarlos de manera más sensilla a la tabla
        String aux = idProducto + "," + descripcion + "," + cantidad + "," + precio + "," + importe;
        //Agregamos los objetos creados a nuestros Arrays que nos ayudan a llenar la tabla y a guardar en la base de datos
        productosNotaString.add(aux);
        productosNotaObjetos.add(p);
        //controlamos la interfaz 
        actualizaTablaNota();
        limpiarProducto();
        obtenerTotal();
        txtTotal.setText(total + "");
        btnAgregarProducto.setEnabled(false);
        txtIdProducto.setEnabled(true);
    }

    private void btnLimpiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProductoActionPerformed
        limpiarProducto();
    }//GEN-LAST:event_btnLimpiarProductoActionPerformed

    private void btnLimpiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarClienteActionPerformed
        limpiarCliente();
    }//GEN-LAST:event_btnLimpiarClienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarCliente();
        limpiarProducto();
        limpiarTabla();
        productosNotaObjetos.clear();
        productosNotaString.clear();
        total = 0.0;
        txtTotal.setText("");
        txtEfectivo.setText("");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        try {
            if (revisaCajas()) {//revisar que las cajas no est{en vacias
                if ((Double.parseDouble(txtEfectivo.getText()) - Double.parseDouble(txtTotal.getText())) >= 0) {//(revisamos que el efectivo sea el apropiado
                    if (new DAOVenta().GuardarVenta(new Venta(0, fechadb() + " " + txtHora.getText(), total, rbtnContado.isSelected() ? "pagada" : "porCobrar", objCliente.getIdCliente(), objEmpleado.getIdEmpleado()))) {//registramos en primer instancia la fecha
                        if (insertarDetalleVenta()) {// insertamos los detalles de venta
                            JOptionPane.showMessageDialog(null, "Vendido con éxito\nSu cambio:  " + Math.round(Double.parseDouble(txtEfectivo.getText()) - Double.parseDouble(txtTotal.getText())) + "", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                            limpiarCliente(); //limpiamos las cajas 
                            limpiarProducto();
                            limpiarTabla();
                            txtEfectivo.setText("");
                            txtTotal.setText("");
                            //descontar stock e imprimir ticket
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al realizar la venta", "Mensaje", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al realizar la venta", "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El efectivo no es suficiente", "Mensaje", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private boolean insertarDetalleVenta() {
        boolean bandera = false;
        for (int i = 0; i < productosNotaObjetos.size(); i++) {
            String[] aux = productosNotaString.get(i).split(",");
            int cantidad = Integer.parseInt(aux[2]);
            bandera = new DAODetalleDeVenta().GuardarDetalleVenta(new DetalleDeVenta(productosNotaObjetos.get(i).getIdProducto(),
                    new DAOVenta().idVenta(objEmpleado.getIdEmpleado()),
                    cantidad,
                    (descuento ? productosNotaObjetos.get(i).getPrecioTaller() : productosNotaObjetos.get(i).getPrecioPublico()),
                    0));
            if (!bandera) {
                break;
            }
        }
        if (bandera) {
            productosNotaObjetos.clear();
            productosNotaString.clear();
            total = 0.0;
        }

        return bandera;
    }

    ///este metodo verifica que las cajas requeridas para realizar la venta no estén vacias
    private boolean revisaCajas() {
        return !txtCliente.getText().equals("") && !productosNotaString.isEmpty() && !txtEfectivo.getText().equals("");
    }

    ///limpia nuestra tabla de ventas
    public void limpiarTabla() {
        String datos[][] = new String[0][2];
        String columnas[] = new String[]{"ID", "Descripcion", "Cantidad", "Precio", "Importe"};
        formatoTabla(datos, columnas);
        //TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    ///obtenmos el total a partir de la lista 
    private void obtenerTotal() {
        double sum = 0;
        for (int i = 0; i < productosNotaString.size(); i++) {
            String[] aux = productosNotaString.get(i).split(",");
            sum += Double.parseDouble(aux[4]);
        }

        total = sum;
    }

    ///actualizamos los datos de la tabla cada que se agregue un nuevo producto
    private void actualizaTablaNota() {
        String datos[][] = new String[productosNotaString.size()][2];
        String columnas[] = new String[]{"ID", "Descripcion", "Cantidad", "Precio", "Importe"};

        for (int i = 0; i < productosNotaString.size(); i++) {
            datos[i] = productosNotaString.get(i).split(",");

        }
        formatoTabla(datos, columnas);
        //TablaDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(datos, columnas));
    }

    ///limpiamos la sección de cliente  de nuestro formulario por si nos equivocamos
    private void limpiarCliente() {
        txtIdCliente.setText("");
        txtCliente.setText("");
    }

    ///limpiamos la sección de productos
    private void limpiarProducto() {
        txtIdProducto.setText("");
        txtProducto.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        spinerCantidad.setValue(1);
        txtIdProducto.setEditable(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaDetalleVenta;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnLimpiarCliente;
    private javax.swing.JButton btnLimpiarProducto;
    private javax.swing.JButton btnPorCobrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JPanel pnlNotas;
    private javax.swing.JRadioButton rbtnContado;
    private javax.swing.JRadioButton rbtnCredito;
    private javax.swing.ButtonGroup rdbtnGrupoTipoVenta;
    private javax.swing.JSpinner spinerCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolioPorCobrar1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
