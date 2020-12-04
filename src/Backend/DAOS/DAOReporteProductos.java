/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.DAOS;

import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAOReporteProductos {
    
    public ArrayList<String> ReporteVentasProductoporCategoria( int idcategoriaString, String fi, String ff){
        
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "call prodxcat(" + idcategoriaString + ", '" + fi + "', '"+ff+"')";

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
    
}
