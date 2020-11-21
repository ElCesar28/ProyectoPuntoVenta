package Backend.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ElCésar26
 */
public class Conexion {


    private static final String url = "jdbc:mysql://localhost:3306/puntoventa?Unicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "root";

    //Clase que nos proporcionará la conexión a la base de datos
    public static Connection Conectar() {
        
        // Reseteamos a null la conexion a la bd
        Connection conexion = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            conexion = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (conexion != null) {
                System.out.println("Conexion establecida");
            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion: \n" + e);
        }
        return conexion;
    }
}
