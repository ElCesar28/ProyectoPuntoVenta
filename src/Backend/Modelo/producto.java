package Backend.Modelo;

public class producto {
    private String idProducto;
    private String Descripcion;
    private int Stock;
    private double Precio;
    private String Marca;
    private int idCategoria;
    private int idProveedor;

    public producto(String idProducto, String Descripcion, int Stock, double Precio, String Marca, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Precio = Precio;
        this.Marca = Marca;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
    
}
public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
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
