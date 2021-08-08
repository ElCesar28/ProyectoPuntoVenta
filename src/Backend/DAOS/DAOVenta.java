package Backend.DAOS;

import Backend.Modelo.Venta;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOVenta {
    
    public int idVenta(int idEmpleado) {
       int idv=0;

        Statement stm = null;
        Connection co = null;
        ResultSet rs = null;

        String sql = "select max(idVenta) from Venta where idEmpleado="+idEmpleado;

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idv=rs.getInt(1); 
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
    
    public boolean GuardarVenta(Venta v){
        PreparedStatement ps = null;
        Connection co = null;
        boolean bandera=false;
            
        String sql="insert into Venta (idVenta, fecha, total, estado, idCliente, idEmpleado)values (null,?,?,?,?,?)";
        try{
            co=Conexion.Conectar();
            ps=co.prepareStatement(sql);
            ps.setString(1, v.getFecha());
            ps.setDouble(2, v.getTotal());
            ps.setString(3, v.getEstado());
            ps.setInt(4, v.getIdCliente());
            ps.setInt(5, v.getIdEmpleado());
            ps.executeUpdate();
            bandera=true;
      
        }catch(Exception e){
            System.out.println(e + "ingresaventa");
        }
        return bandera;
    }
    
}
