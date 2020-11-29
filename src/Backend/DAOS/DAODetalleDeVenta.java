package Backend.DAOS;

import Backend.Modelo.DetalleDeVenta;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAODetalleDeVenta {

    public boolean registrar(DetalleDeVenta detalleDeVenta) {
        boolean registrar = false;
        Statement stm = null;
        Connection co = null;
        PreparedStatement ps = null;

        String sql = "insert into DetalleDeVenta (idProducto, idVenta, cantidad, precio, descuento) values (?,?,?,?,?)";

        try {
            co = Conexion.Conectar();
            ps = co.prepareStatement(sql);
            ps.setString(1, detalleDeVenta.getIdProducto());
            ps.setInt(2,detalleDeVenta.getIdVenta());
            ps.setInt(3, detalleDeVenta.getCantidad());
            ps.setDouble(4, detalleDeVenta.getPrecio());
            ps.setDouble(5, detalleDeVenta.getDescuento());
            ps.executeUpdate();
            registrar=true;
            stm.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("registro en DetalleDeVenta");
            System.out.println(e);
        }

        return registrar;
    }

    public ArrayList<DetalleDeVenta> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from DetalleDeVenta";

        ArrayList<DetalleDeVenta> listadetalle = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta dv = new DetalleDeVenta();
                dv.setIdProducto(rs.getString(1));
                dv.setIdVenta(rs.getInt(2));
                dv.setCantidad(rs.getInt(3));
                dv.setPrecio(rs.getDouble(4));
                dv.setDescuento(rs.getDouble(5));

                listadetalle.add(dv);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener DetalleDeVenta");
            System.out.println(e);
        }

        return listadetalle;
    }

    public ArrayList<DetalleDeVenta> buscar(String idVenta) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from DetalleDeVenta where idVenta = "+ idVenta ;

        ArrayList<DetalleDeVenta> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta dv = new DetalleDeVenta();
                dv.setIdProducto(rs.getString(1));
                dv.setIdVenta(rs.getInt(2));
                dv.setCantidad(rs.getInt(3));
                dv.setPrecio(rs.getDouble(4));
                dv.setDescuento(rs.getDouble(5));
                listaMarca.add(dv);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener DetalleDeVenta");
            System.out.println(e);
        }

        return listaMarca;
    }

//    public boolean actualizar(DetalleDeVenta DetalleDeVenta) {
//        Connection connect = null;
//        Statement stm = null;
//
//        boolean actualizar = false;
//
//        String sql = "update DetalleDeVenta set idProducto=";
//        try {
//            connect = Conexion.Conectar();
//            stm = connect.createStatement();
//            stm.execute(sql);
//            actualizar = true;
//        } catch (SQLException e) {
//            System.out.println("actualizar DetalleDeVenta");
//            System.out.println(e);
//        }
//        return actualizar;
//    }

    public boolean eliminar(String idVenta) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from DetalleDeVenta where idVenta    =" + idVenta ;
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar detalleDeVenta");
            System.out.println(e);
        }
        return eliminar;
    }

}
