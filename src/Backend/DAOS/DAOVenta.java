package Backend.DAOS;

import Backend.Modelo.DetalleDeVenta;
import Backend.Modelo.Venta;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory.Result;

public class DAOVenta {
    int r=0;
    
    public String idVenta() {
       String idv="";

        Statement stm = null;
        Connection co = null;
        ResultSet rs = null;

        String sql = "select max(idVenta) from Venta";

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idv=rs.getString(1);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("");
            System.out.println(e);
        }
        return idv;
    }
    
    public int GuardarVenta(Venta v){
        PreparedStatement ps = null;
        Connection co = null;
            
        String sql="insert into Venta (idVenta, fecha, total, idCliente, idEmpleado)values (null,?,?,?,?)";
        try{
            co=Conexion.Conectar();
            ps=co.prepareStatement(sql);
            ps.setString(1, v.getFecha());
            ps.setDouble(2, v.getTotal());
            ps.setInt(3, v.getIdCliente());
            ps.setInt(4, v.getIdEmpleado());
            r=ps.executeUpdate();
      
        }catch(Exception e){
            System.out.println(e + "ingresaventa");
        }
        return r;
    }
    
    public static void main(String[] args) {
        DAOVenta v = new DAOVenta();
        System.out.println(v.GuardarVenta(new Venta(0,"1000-01-01 00:00:00",1235,1,1)));
    }
    
    public int GuardarDetalleVenta(DetalleDeVenta dv){
        PreparedStatement ps = null;
        Connection co = null;
        
        String sql="insert into DetalleDeVenta (idProducto,idVenta,cantidad,precio,descuento) values (?,?,?,?,?)";
        try{
            co=Conexion.Conectar();
            ps=co.prepareStatement(sql);
            ps.setString(1, dv.getIdProducto());
            ps.setInt(2, dv.getIdVenta());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio());
            ps.setDouble(5, dv.getDescuento());
               
        }catch(Exception e){
            System.out.println(e);
        }
        return r;
    }
    
}
