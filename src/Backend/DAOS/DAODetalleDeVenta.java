
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
        
        String sql = "insert into DetalleDeVenta values("+ detalleDeVenta.getIdProducto()+","+detalleDeVenta.getIdVenta()+","+
                detalleDeVenta.getCantidad()+","+detalleDeVenta.getPrecio()+","+detalleDeVenta.getDescuento()+") ;";

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
    
    
     public boolean actualizar(DetalleDeVenta DetalleDeVenta) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update DetalleDeVenta set idProducto='" + DetalleDeVenta.getIdProducto() 
                +"' ,idVenta=" + DetalleDeVenta.getIdVenta()
                +"' ,cantidad=" + DetalleDeVenta.getCantidad()
                +"' ,precio=" + DetalleDeVenta.getPrecio()
                +"' ,descuento="+ DetalleDeVenta.getDescuento()+" ;";
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

        String sql = "delete from DetalleDeVenta where idProducto=" + detalleDeVenta.getIdProducto()+ " ;";
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
