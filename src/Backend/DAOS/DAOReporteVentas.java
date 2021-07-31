/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.DAOS;

import Backend.Modelo.DetalleDeVenta;
import Backend.Modelo.Producto;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ElCésar26
 */
public class DAOReporteVentas {

    public ArrayList<String> ReporteVentasPorPeriodo(String fechai, String fechaf) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "call lista('" + fechai + "', '" + fechaf + "')";

        ArrayList<String> reporte = new ArrayList<>();
        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String aux = "";
                aux += rs.getString(1);
                aux+=",";
                aux += rs.getString(2);
                aux+=",";
                aux += rs.getString(3);
                aux+=",";
                aux += rs.getString(4);

                reporte.add(aux);
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("obtener reporte "+e);
        }
        return reporte;
    }
    public ArrayList<String> ReporteVentaDelDia(String fecha) {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "call reporteDia('" + fecha + "')";

        ArrayList<String> reporte = new ArrayList<>();
        try {
            con = Conexion.Conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                String aux = "";
                aux += rs.getString(1);
                aux+=",";
                aux += rs.getString(2);
                aux+=",";
                aux += rs.getString(3);
                aux+=",";
                aux += rs.getString(4);
                aux+=",";
                aux += rs.getString(5);
                aux+=",";
                aux += rs.getString(6);
                aux+=",";
                aux += rs.getString(7);
                aux+=",";
                aux += rs.getString(8);
                aux+=",";
                aux += rs.getString(9);
                aux+=",";
                aux += rs.getString(10);

                reporte.add(aux);
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("obtener reporte del dia "+e);
        }
        return reporte;
    }

}
