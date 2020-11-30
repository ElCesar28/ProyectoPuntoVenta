package Backend.Modelo;

import java.util.Date;



public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private int idCliente;
    private int idEmpleado;

    public Venta(int idVenta, String fecha, double total, int idCliente, int idEmpleado) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }
    
    public Venta(){
        
    }

    @Override
    public String toString() {
        return idVenta + "," + fecha + "," + total + "," + idCliente + "," + idEmpleado ;
    }

    
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
    
}
