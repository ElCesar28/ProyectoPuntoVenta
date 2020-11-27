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

        String sql = "insert into Cliente values (null,'" + cliente.getIdCliente() + "') ;";

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
                Cliente m = new Cliente();
                m.setIdCliente(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setApellidos(rs.getString(3));
                m.setDireccion(rs.getString(4));
                m.setTelefono1(rs.getString(5));
                m.setTelefono2(rs.getString(6));
                listaMarca.add(m);
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
                Cliente m = new Cliente();
                m.setIdCliente(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setApellidos(rs.getString(3));
                m.setDireccion(rs.getString(4));
                m.setTelefono1(rs.getString(5));
                m.setTelefono2(rs.getString(6));
                listaMarca.add(m);
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

        String sql = "update marca set idCliente='" + cliente.getIdCliente() + "' where nombre=" 
                + cliente.getNombre()+"' where apellidos=" 
                + cliente.getApellidos()+"' where direccion=" 
                + cliente.getDireccion()+"' where telefono1="
                + cliente.getTelefono1()+"' where telefono2="
                + cliente.getTelefono2()+" ;";
        
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actulizar cliente");
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
