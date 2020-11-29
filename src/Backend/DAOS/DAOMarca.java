package Backend.DAOS;

import Backend.Modelo.Marca;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOMarca {

    public boolean registrar(Marca marca) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "insert into Marca values (null,'" + marca.getNombre() + "') ;";

        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("registro en marca");
            System.out.println(e);
        }
        return registrar;
    }

    public ArrayList<Marca> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Marca ;";

        ArrayList<Marca> listaMarca = new ArrayList<Marca>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Marca m = new Marca();
                m.setIdMarca(rs.getInt(1));
                m.setNombre(rs.getString(2));
                listaMarca.add(m);
            }
            stm.close();
            rs.close();
            co.close(); 
        } catch (SQLException e) {
            System.out.println("obtener marca");
            System.out.println(e);
        }

        
        return listaMarca;

    }

    public ArrayList<Marca> buscar(String nombre) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "select * from Marca where nombre = '" + nombre + "';";

         ArrayList<Marca> listaMarca = new ArrayList<>();

        try {
            co = Conexion.Conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Marca m = new Marca();
                m.setIdMarca(rs.getInt(1));
                m.setNombre(rs.getString(2));
                listaMarca.add(m);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("obtener marca");
            System.out.println(e);
        }

        return listaMarca;

    }

    public boolean actualizar(Marca marca) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "update marca set nombre='" + marca.getNombre() + "' where idMarca=" + marca.getIdMarca() + " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("actulizar marca");
            System.out.println(e);
        }
        return actualizar;
    }

    public boolean eliminar(Marca marca) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "delete from Marca where idMarca=" + marca.getIdMarca() + " ;";
        try {
            connect = Conexion.Conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("eliminar marca");
            System.out.println(e);
        }
        return eliminar;
    }

}
