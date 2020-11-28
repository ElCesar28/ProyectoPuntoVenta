package Backend.DAOS;


import Backend.Modelo.Cliente;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCliente {
    
    public boolean registrar(Cliente cliente) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

         String sql = "insert into Producto values("+ cliente.getIdCliente()+","+cliente.getNombre()+","+
                cliente.getApellidos()+","+cliente.getDireccion()+","+cliente.getTelefono1()+","+cliente.getTelefono2()+") ;";

        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en cliente");
            System.out.println(e);
        }
        return registrar;
    }
    
    
     public ArrayList<Cliente> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Cliente ;";

        ArrayList<Cliente> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono1(rs.getString(5));
                c.setTelefono2(rs.getString(6));
                
                listaMarca.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener cliente");
            System.out.println(e);
        }

        return listaMarca;

    }
     
     
     public ArrayList<Cliente> buscar(String idCliente) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Cliente where idCliente = '" + idCliente + "';";

         ArrayList<Cliente> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono1(rs.getString(5));
                c.setTelefono2(rs.getString(6));
                listaMarca.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener cliente");
            System.out.println(e);
        }

        return listaMarca;

    }
     
     
     public boolean actualizar(Cliente cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update Cliente set idCliente='"+ cliente.getIdCliente()
                +"' ,nombre="+ cliente.getNombre()
                +"' ,apellidos="+ cliente.getApellidos()
                +"' ,direccion="+ cliente.getDireccion()
                +"' ,telefono1="+cliente.getTelefono1()
		+"' ,telefono2="+cliente.getTelefono2()+" ;";
        
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar cliente");
            System.out.println(e);
        }
        return actualizar;
    }
     
     
     public boolean eliminar(Cliente cliente) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Cliente where idCliente=" + cliente.getIdCliente() + " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar cliente");
            System.out.println(e);
        }
        return eliminar;
    }
}
