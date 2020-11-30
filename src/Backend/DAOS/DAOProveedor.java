
package Backend.DAOS;

import Backend.Modelo.Proveedor;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOProveedor {
    
    public boolean registrar(Proveedor proveedor) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;
        
        String sql = "insert into Proveedor values(null,'"+proveedor.getNombre()+
                "', hex(aes_encrypt('"+proveedor.getNumCuenta()+"',"+proveedor.getIdProveedor()+")), '"
                +proveedor.getCorreo1()+"' , '"+proveedor.getCorreo2()+"' , '"+proveedor.getTelefono1()+"' , '"+proveedor.getTelefono2()+"')";
        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en proveedor");
            System.out.println(e);
        }
        return registrar;
    }
    public static void main(String[] args) {
        DAOProveedor p = new DAOProveedor();
        p.registrar(new Proveedor(0,"LLYRSA","44515908876","llirsa1@gmail.com","","12345656543","")); 
    }
    
    
    public ArrayList<Proveedor> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Proveedor";

        ArrayList<Proveedor> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor m = new Proveedor();
                m.setIdProveedor(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setNumCuenta(rs.getString(3));
                m.setCorreo1(rs.getString(4));
                m.setCorreo2(rs.getString(5));
                m.setTelefono1(rs.getString(6));
                m.setTelefono2(rs.getString(7));
                listaMarca.add(m);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener proveedor");
            System.out.println(e);
        }

        return listaMarca;

    }
    
    
    
    ///USAR procedimiento para obetener la contraseña 
    public ArrayList<Proveedor> buscar(int idProveedor) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Proveedor where idProveedor = " + idProveedor ;

         ArrayList<Proveedor> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Proveedor m = new Proveedor();
                m.setIdProveedor(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setNumCuenta(rs.getString(3));
                m.setCorreo1(rs.getString(4));
                m.setCorreo2(rs.getString(5));
                m.setTelefono1(rs.getString(6));
                m.setTelefono2(rs.getString(7));
                listaMarca.add(m);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener Proveedor");
            System.out.println(e);
        }

        return listaMarca;

    }
    
    
    public boolean actualizar(Proveedor proveedor) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update Proveedor set nombre='"+ proveedor.getNombre()
                +"' ,numCuenta= hex(aes_encrypt('"+ proveedor.getNumCuenta()+"',"+proveedor.getIdProveedor()+"))"
                +" ,correo1= '"+ proveedor.getCorreo1()
                +"' ,correo2= '"+ proveedor.getCorreo2()
                +"' ,telefono1= '"+ proveedor.getTelefono1()
                +"' ,telefono2= '"+ proveedor.getTelefono2()+"' where idProveedor="+proveedor.getIdProveedor();
        
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.print(e+" actualizar proveedor");
        }
        return actualizar;
    }
    
    
    public boolean eliminar(Proveedor proveedor) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Proveedor where idProveedor=" + proveedor.getIdProveedor() + " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar proveedor");
            System.out.println(e);
        }
        return eliminar;
    }
    
    
    
    
}
