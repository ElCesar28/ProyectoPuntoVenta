    package Backend.Modelo;

public class Producto {

    // propiedades de producto
    private String idProducto;
    private String descripcion;
    private int stock;
    private double precio;
    private int idMarca;
    private int idCategoria;
    private int idProveedor;

    // constructor con sus parametros
    public Producto(String idProducto, String descripcion, int stock, double precio, int idMarca, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;

    }
    
    // constructor vacio
    public Producto(){
        
    }

    // metodo tostring para conctanear
    @Override
    public String toString() {
        return idProducto + "," + descripcion + "," + stock + "," + precio + "," + idMarca + "," + idCategoria + "," + idProveedor ;
    }
    

    
// set y get de la clase producto
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    

    

}
