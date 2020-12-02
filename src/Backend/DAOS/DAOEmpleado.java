package Backend.DAOS;

import Backend.Modelo.Empleado;
import Backend.Util.Conexion;
import Frontend.frmLogin;
import Frontend.frmMenuPrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAOEmpleado {

//    public boolean p(String us, String pass) {
//        Connection co = null;
//        Statement stm = null;
//        ResultSet rs = null;
//        boolean result=false;
//        String sql = "select * from empleado where user='" + us + "'"
//                + " and password=sha1('" + pass + "')";
//        try {
//            co = Conexion.Conectar();
//            stm = co.createStatement();
//            rs = stm.executeQuery(sql);
//            if (rs.next()) {
//                result = true;  
//            }
//        } catch (SQLException er) {
//            System.out.println("Algo salio mal con la consulta "+er);
//        }
//        return result;
//    }
     public ArrayList<Empleado> login(String us, String pass) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

         String sql = "select * from empleado where user='" + us + "'"
                + " and password=sha1('" + pass + "')";

        ArrayList<Empleado> listaEmpleado = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt(1));
                e.setUser(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setNombre(rs.getString(4));
                e.setApellido(rs.getString(5));
                e.setCorreo(rs.getString(6));
                e.setTelefono1(rs.getString(7));
                e.setTelefono2(rs.getString(8));
                e.setRol(rs.getString(9));
                e.setDireccion(rs.getString(10));
                listaEmpleado.add(e);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener login");
            System.out.println(e);
        }

        return listaEmpleado;

    }
    
    
    
    public ArrayList<Empleado> buscar(int idEmpleado) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Empleado where idEmpleado = " + idEmpleado;

        ArrayList<Empleado> listaEmpleado = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt(1));
                e.setUser(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setNombre(rs.getString(4));
                e.setApellido(rs.getString(5));
                e.setCorreo(rs.getString(6));
                e.setTelefono1(rs.getString(7));
                e.setTelefono2(rs.getString(8));
                e.setRol(rs.getString(9));
                e.setDireccion(rs.getString(10));
                listaEmpleado.add(e);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener Empleado");
            System.out.println(e);
        }

        return listaEmpleado;

    }
    
    public boolean registrar(Empleado empleado) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "insert into Empleado values (null,'" + empleado.getUser() + "', sha1('" + empleado.getPassword() + "'), '" + empleado.getNombre() + "'"
                + ", '" + empleado.getApellido() + "', '" + empleado.getCorreo() + "', '" + empleado.getTelefono1() + "', '" + empleado.getTelefono2() + "'"
                + ", '" + empleado.getRol() + "', '" + empleado.getDireccion() + "');";
        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en Empleado");
            System.out.println(e);
        }
        return registrar;
    }

    public ArrayList<Empleado> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Empleado ;";

        ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt(1));
                e.setUser(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setNombre(rs.getString(4));
                e.setApellido(rs.getString(5));
                e.setCorreo(rs.getString(6));
                e.setTelefono1(rs.getString(7));
                e.setTelefono2(rs.getString(8));
                e.setRol(rs.getString(9));
                e.setDireccion(rs.getString(10));
                listaEmpleado.add(e);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener Empleado");
            System.out.println(e);
        }

        return listaEmpleado;

    }

   
    public boolean actualizar(Empleado empleado) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update Empleado set user= '" + empleado.getUser() + "', password= password" + ", nombre= '" + empleado.getNombre() + "'"
                + ", apellido= '" + empleado.getApellido() + "',correo= '" + empleado.getCorreo() + "', telefono1= '" + empleado.getTelefono1() + "', telefono2='" + empleado.getTelefono2() + "'"
                + ", rol='" + empleado.getRol() + "', direccion= '" + empleado.getDireccion() + "' where idEmpleado=" + empleado.getIdEmpleado();
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar Empleado");
            System.out.println(e);
        }
        return actualizar;
    }

    public boolean actualizarPassword(int id, String newPassword) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update Empleado set user= user" + ", password= sha1('" + newPassword + "'), nombre= nombre" + ""
                + ", apellido= apellido" + ",correo= correo" + ", telefono1= telefono1" + ", telefono2= telefono2" + ""
                + ", rol= rol" + ", direccion= direccion where idEmpleado=" + id;
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar pass empleado");
            System.out.println(e);
        }
        return actualizar;
    }

    public boolean eliminar(int idEmpleado) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Empleado where idEmpleado=" + idEmpleado;
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar Empleado");
            System.out.println(e);
        }
        return eliminar;
    }

}
