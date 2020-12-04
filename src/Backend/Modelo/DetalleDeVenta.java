package Backend.Modelo;

public class DetalleDeVenta {

    // propiedades de detalle de venta
    private String idProducto ;
    private int idVenta;
    private int cantidad;
    private double precio;
    private double descuento;

    // constructor de la clase con sus paramteros
    public DetalleDeVenta(String idProducto, int idVenta, int cantidad, double precio, double descuento) {
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }
    // constructor sin parametros
    public DetalleDeVenta(){
        
    }

    // metodo tostring para concatenar
    @Override
    public String toString() {
        return idProducto + "," + idVenta + "," + cantidad + "," + precio + "," + descuento;
    }
    
    
// set y get para detalle de venta
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
