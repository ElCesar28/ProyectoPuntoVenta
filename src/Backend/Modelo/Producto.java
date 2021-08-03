package Backend.Modelo;

public class Producto {

    // propiedades de producto
    private String idProducto;
    private String descripcion;
    private String descripcionCorta;
    private int stock;
    private double precioPublico;
    private double precioTaller;
    private int idMarca;
    private int idCategoria;
    private int idProveedor;

    // constructor con sus parametros
    public Producto(String idProducto, String descripcion, String descripcionCorta, int stock, double precioPublico, double precioTaller, int idMarca, int idCategoria, int idProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.descripcionCorta = descripcionCorta;
        this.stock = stock;
        this.precioPublico = precioPublico;
        this.precioTaller = precioTaller;
        this.idMarca = idMarca;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;

    }

    // constructor vacio
    public Producto() {

    }

    // metodo tostring para conctanear
    @Override
    public String toString() {
        return idProducto + "," + descripcion + "," + descripcionCorta+ "," + stock + "," + precioPublico + "," + precioTaller + "," + idMarca + "," + idCategoria + "," + idProveedor;
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

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public double getPrecioTaller() {
        return precioTaller;
    }

    public void setPrecioTaller(double precioTaller) {
        this.precioTaller = precioTaller;
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
