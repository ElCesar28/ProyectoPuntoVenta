package Backend.Modelo;

public class DetalleDeVenta {

    private String idProducto ;
    private int idVenta;
    private int cantidad;
    private double precio;
    private double descuento;

    public DetalleDeVenta(String idProducto, int idVenta, int cantidad, double precio, double descuento) {
        this.idProducto = idProducto;
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }
    public DetalleDeVenta(){
        
    }

    @Override
    public String toString() {
        return idProducto + "," + idVenta + "," + cantidad + "," + precio + "," + descuento;
    }
    
    

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
