    package Backend.Modelo;

public class Producto {

    private String idProducto;
    private String descripcion;
    private int stock;
    private double precio;
    private String idMarca;
    private int idCategoria;
    private int idProveedor;

    public Producto(String idProducto, String descripcion, int stock, double precio, String idMarca, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;

    }
    
    public Producto(){
        
    }

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

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
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
