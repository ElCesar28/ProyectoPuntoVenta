
package Backend.Modelo;


public class Marca {
    private int idMarca;
    private String Nombre;

    public Marca(int idMarca, String Nombre) {
        this.idMarca = idMarca;
        this.Nombre = Nombre;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
    
}
