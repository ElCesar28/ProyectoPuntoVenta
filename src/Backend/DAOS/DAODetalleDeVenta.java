
package Backend.DAOS;

import Backend.Modelo.DetalleDeVenta;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAODetalleDeVenta {
    
    public boolean registrar(DetalleDeVenta detalleDeVenta){
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        
        String sql = "insert into DetalleDeVenta values (null,'" + detalleDeVenta.getIdProducto() + "') ;";

        try {
           con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
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

        String sql = "select * from DetalleDeVenta ;";

        ArrayList<DetalleDeVenta> listaMarca = new ArrayList<DetalleDeVenta>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta m = new DetalleDeVenta();
                m.setIdProducto(rs.getString(1));
                m.setIdVenta(rs.getInt(2));
                m.setCantidad(rs.getInt(3));
                m.setPrecio(rs.getDouble(4));
                m.setDescuento(rs.getDouble(5));
                
                listaMarca.add(m);
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
    
    
    
    public ArrayList<DetalleDeVenta> buscar(String idProducto) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from DetalleDeVenta where idProducto = '" + idProducto + "';";

         ArrayList<DetalleDeVenta> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                DetalleDeVenta m = new DetalleDeVenta();
                m.setIdProducto(rs.getString(1));
                m.setIdVenta(rs.getInt(2));
                m.setCantidad(rs.getInt(3));
                m.setPrecio(rs.getDouble(4));
                m.setDescuento(rs.getDouble(5));
                listaMarca.add(m);
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
    
    
     public boolean actualizar(DetalleDeVenta DetalleDeVenta) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update marca set idProducto='" + DetalleDeVenta.getIdProducto() + "' where idVenta=" 
                + DetalleDeVenta.getIdVenta()+"' where cantidad=" 
                + DetalleDeVenta.getCantidad()+"' where precio=" 
                + DetalleDeVenta.getPrecio()+"' where descuento="
                + DetalleDeVenta.getDescuento()+" ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar DetalleDeVenta");
            System.out.println(e);
        }
        return actualizar;
    }
     
      public boolean eliminar(DetalleDeVenta detalleDeVenta) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Marca where idProducto=" + detalleDeVenta.getIdProducto()+ " ;";
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
