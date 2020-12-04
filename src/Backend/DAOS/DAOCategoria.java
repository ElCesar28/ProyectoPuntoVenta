
package Backend.DAOS;

import Backend.Modelo.Categoria;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOCategoria {
    public boolean registrar(Categoria categoria) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "insert into Categoria values (null,'" + categoria.getNombre() + "') ;";

        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en categoria");
            System.out.println(e);
        }
        return registrar;
    }
  
    public ArrayList<Categoria> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Categoria ;";

        ArrayList<Categoria> listaCategoria = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt(1));
                c.setNombre(rs.getString(2));
                listaCategoria.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener Categoria");
            System.out.println(e);
        }

        return listaCategoria;

    }

    public ArrayList<Categoria> buscar(String nombre) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Categoria where nombre = '" + nombre + "';";

         ArrayList<Categoria> listaCategoria = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Categoria m = new Categoria();
                m.setIdCategoria(rs.getInt(1));
                m.setNombre(rs.getString(2));
                listaCategoria.add(m);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener marca");
            System.out.println(e);
        }

        return listaCategoria;

    }

    public boolean actualizar(Categoria categoria) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update Categoria set nombre='" + categoria.getNombre() + "' where idCategoria=" + categoria.getIdCategoria()+ " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actulizar categoria");
            System.out.println(e);
        }
        return actualizar;
    }

    public boolean eliminar(Categoria categoria) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Categoria where idCategoria=" + categoria.getIdCategoria()+ " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar categoria");
            System.out.println(e);
        }
        return eliminar;
    }
}
