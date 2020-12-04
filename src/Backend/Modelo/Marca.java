
package Backend.Modelo;


public class Marca {
    // propiedades de la clase marca
    private int idMarca;
    private String nombre;

    // constructor de con sus propiedades
    public Marca(int idMarca, String nombre) {
        this.idMarca = idMarca;
        this.nombre = nombre;
    }
    // constructor vacio
    public Marca(){
        
    }
    // constructor con un parametro
    public Marca(String nombre){
        this.nombre = nombre;
    }

    // get y set de la clase marca
    public int getIdMarca() {
        return idMarca;
    }

    @Override
    public String toString() {
        return  idMarca + "," + nombre;
    }
    
    

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    
    
}
