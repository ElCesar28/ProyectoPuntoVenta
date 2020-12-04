package Backend.Modelo;

import java.util.logging.Logger;

public class Categoria {

    // propiedades de la categoria
    private int idCategoria;
    private String nombre;

    // constructor de la categoria con parametros
    public Categoria(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    // constructor de categoria con un solo parametro
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    // construcotr vacio
    public Categoria() {

    }

    // metodo tostring para concatenar
    @Override
    public String toString() {
        return idCategoria + "," + nombre ;
    }
    
    
// get y set de categoria
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
