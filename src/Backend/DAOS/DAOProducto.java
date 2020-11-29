
package Backend.DAOS;

import Backend.Modelo.Producto;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOProducto {
    
    //Registra un nuevo producto con la conexion a la base de datos PuntoVenta
    public boolean registrar(Producto producto){
        boolean registrar = false;
        
        Statement stm = null;
        Connection con = null;
        
        String sql = "insert into Producto values('"+ producto.getIdProducto()+"', '"+producto.getDescripcion()+"' ,"+
                producto.getStock()+","+producto.getPrecio()+","+producto.getIdMarca()+","+producto.getIdCategoria()+
                ","+producto.getIdProveedor()+") ;";
        
        try{
            con = Conexion.Conectar();
            stm = con.createStatement();
             stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        }catch(SQLException e){
            System.out.println("registro en producto");
            System.out.println(e);
        }
        return registrar;    
    }
    public static void main(String[] args) {
        DAOProducto p = new DAOProducto();
        p.registrar(new Producto("189DG005","Tarjeta para lavadora whirlpool",3,457,2,1,1));
    }
    //Obtiene todos los productos que se encuentren el la tabla Productos de la base de datos PutoVenta
    public ArrayList<Producto> obtener(){
          Connection con = null;
          Statement stm = null;                  
          ResultSet rs = null;
          
          String sql = "select * from Producto";                  
            
          ArrayList<Producto> listaProducto =  new ArrayList<>();
          try{
              con = Conexion.Conectar();
              stm = con.createStatement();
              rs = stm.executeQuery(sql);
              
              while(rs.next()){
                  Producto p = new Producto();
                  p.setIdProducto(rs.getString(1));
                  p.setDescripcion(rs.getString(2));
                  p.setStock(rs.getInt(3));
                  p.setPrecio(rs.getDouble(4));
                  p.setIdCategoria(rs.getInt(5));
                  p.setIdCategoria(rs.getInt(6));
                  p.setIdProveedor(rs.getInt(7));
                  
                  listaProducto.add(p);
              }
              stm.close();
              rs.close();
              con.close();
              
          }catch(SQLException e){
              System.out.println("obtener producto");
              System.out.println(e);
          }
          return listaProducto;           
      }
    //Elimina un producto deacuerdo a su idProducto de la base de datos PuntoVenta
    public boolean eliminar(int id){
        Connection con = null;
        Statement stm = null;
        
        boolean eliminar = false;
        
        String sql = "delete from Producto where idProducto = "+id;
        
        try{
            con = Conexion.Conectar();
            stm =  con.createStatement();
            stm.execute(sql);
            eliminar = true;
            
        }catch(SQLException e){
            System.out.println("eliminar producto");
            System.out.println(e);
        }
        
        return eliminar;
    }
    
    public ArrayList<Producto> buscar(int idProducto) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Producto where idProducto = '" + idProducto + "';";

         ArrayList<Producto> listaProducto = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getString(1));
                p.setDescripcion(rs.getString(2));
                p.setStock(rs.getInt(3));
                p.setPrecio(rs.getDouble(4));
                p.setIdMarca(rs.getInt(5));
                p.setIdCategoria(rs.getInt(6));
                p.setIdProveedor(rs.getInt(7));
             
                listaProducto.add(p);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener producto");
            System.out.println(e);
        }

        return listaProducto;

    }
    
    
}
