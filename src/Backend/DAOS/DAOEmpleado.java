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
    
    // metodo de arraylist de tipo empleado, el login
     public ArrayList<Empleado> login(String us, String pass) {
       // obtner conexiones
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        // consulta almacenada en un string para workbench
         String sql = "select * from empleado where user='" + us + "'"
                + " and password=sha1('" + pass + "')";

         // se crea un array de tipo empleado llamada listaempleado
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            // se ejecuta el comando
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                // se crea una instancia de empleado
                Empleado e = new Empleado();
                // las siguientes lineas almacenan los valores registrados 
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
                // se almacenan los datos a la lista de empleado
                listaEmpleado.add(e);
            }
            // se cierran las conexiones
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener login");
            System.out.println(e);
        }

        // retorna la lista de empleado para poder visualizarla
        return listaEmpleado;

    }
    
    
    public Empleado buscar(int idEmpleado) {
        // conexiones
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        // se crea una instancia de tipo empleado
        Empleado e = new Empleado();

        // consulta de obtener los datos de empleado
        String sql = "select * from Empleado where idEmpleado = '" + idEmpleado+"';";

        try {
            // se activan las conexiones
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
               
                // se almacenan los datos registrados a mostrar
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

            }
            // se cierran las conexiones
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException ex) {
            System.out.println("obtener Empleado");
            System.out.println(ex);
        }

        // se retorna la lista
        return e;

    }
    
    // se crea un metodo de registrar     
    public boolean registrar(Empleado empleado) {
        // se crea un boleano inicializado en falso
        boolean registrar = false;
        // conexiones
        Statement stm = null;
        Connection con = null;

        // comando para insertar los datos que se registren en la pantalla
        String sql = "insert into Empleado values (null,'" + empleado.getUser() + "', sha1('" + empleado.getPassword() + "'), '" + empleado.getNombre() + "'"
                + ", '" + empleado.getApellido() + "', '" + empleado.getCorreo() + "', '" + empleado.getTelefono1() + "', '" + empleado.getTelefono2() + "'"
                + ", '" + empleado.getRol() + "', '" + empleado.getDireccion() + "');";
        try {
            // conexiones abiertas
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            // se cambia el boleano a verdadero
            registrar = true;
            // se cierran las conexiones
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en Empleado");
            System.out.println(e);
        }
        // retorna si es false o true
        return registrar;
    }

    // metodo de obtener tipo arraylist
    public ArrayList<Empleado> obtener() {
        // conexiones
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        // consulta que retornara los datos
        String sql = "select * from Empleado ;";

        // lista de tipo empleado
        ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();

        try {
            // conexiones activas
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                // instancia de tipo empleado
                Empleado e = new Empleado();
                // se almacenan los regsitros
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
            // se cierran las conexiones
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener Empleado");
            System.out.println(e);
        }

        // retorna la lista
        return listaEmpleado;

    }

   // se crea un metodo de actualizar
    public boolean actualizar(Empleado empleado) {
        // conexiones
        Connection connect = null;
        Statement stm = null;

        // boleano inicializado en falso
        boolean actualizar = false;

        // comando que actualiza los datos del empleado
        String sql = "update Empleado set user= '" + empleado.getUser() + "', password= password" + ", nombre= '" + empleado.getNombre() + "'"
                + ", apellido= '" + empleado.getApellido() + "',correo= '" + empleado.getCorreo() + "', telefono1= '" + empleado.getTelefono1() + "', telefono2='" + empleado.getTelefono2() + "'"
                + ", rol='" + empleado.getRol() + "', direccion= '" + empleado.getDireccion() + "' where idEmpleado=" + empleado.getIdEmpleado();
        try {
            // conexiones activas
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar Empleado");
            System.out.println(e);
        }
        // retorna la lista
        return actualizar;
    }

    // se crea el metodo actualizarpassword
    public boolean actualizarPassword(int id, String newPassword) {
        // conexiones
        Connection connect = null;
        Statement stm = null;

        // boleano inicializado falso
        boolean actualizar = false;

        // comando que actualizara la nueva password
        String sql = "update Empleado set user= user" + ", password= sha1('" + newPassword + "'), nombre= nombre" + ""
                + ", apellido= apellido" + ",correo= correo" + ", telefono1= telefono1" + ", telefono2= telefono2" + ""
                + ", rol= rol" + ", direccion= direccion where idEmpleado=" + id;
        try {
            // conexiones activas
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            // se ejecuta el comando
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actualizar pass empleado");
            System.out.println(e);
        }
        // retorna si el boleano es falso o verdadero
        return actualizar;
    }

    // se crea un metodo llamado eliminar
    public boolean eliminar(int idEmpleado) {
        // conexiones
        Connection connect = null;
        Statement stm = null;

        // boleano en falso
        boolean eliminar = false;

        // ccomando que elimina el empleado mediante su id
        String sql = "delete from Empleado where idEmpleado=" + idEmpleado;
        try {
            // conexiones activas
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            // boleano en verdadero
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar Empleado");
            System.out.println(e);
        }
        // retorna el valor del boleano
        return eliminar;
    }

}
