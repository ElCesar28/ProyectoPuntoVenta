/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Modelo;

/**
 *
 * @author USER
 */
public class Proveedor {
    
    private int idProveedor;
    private String nombre;
    private String numCuenta;
    private String correo1;
    private String correo2;
    private String telefono1;
    private String telefono2;

    public Proveedor(int idProveeedor, String nombre, String numCuenta, String correo1, String correo2, String telefono1, String telefono2) {
        this.idProveedor = idProveeedor;
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public Proveedor(int idProveeedor, String nombre, String numCuenta, String correo1, String telefono1) {
        this.idProveedor = idProveeedor;
        this.nombre = nombre;
        this.numCuenta = numCuenta;
        this.correo1 = correo1;
        this.telefono1 = telefono1;
    }
    
    public Proveedor(){
        
    }
    

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveeedor) {
        this.idProveedor = idProveeedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    
    
}
