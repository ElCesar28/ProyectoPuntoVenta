package Backend.DAOS;

import Backend.Modelo.Marca;
import Backend.Util.Conexion;
import java.sql.Connection;
import java.sql.Statement;
public class DAOMarca {
    
    public boolean registrar (Marca marca){
        boolean registrar = false;
        
        Statement stm =null;
        Connection con =null;
        
        String sql ="insert into Marca values (null,'"+marca.getNombre()+")";
        
        try{
            con=Conexion.Conectar();
            stm=con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error: DAOMarca, método registrar");
            e.printStackTrace();
        }
        return registrar;
    } 

    
    
}
