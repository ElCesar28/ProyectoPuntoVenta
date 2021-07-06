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

    // propiedades de proveedor
    private int idProveedor;
    private String nombre;
    private String numCuenta1;
    private String numCuenta2;
    private String correo1;
    private String correo2;
    private String telefono1;
    private String telefono2;

    // constructor con sus arametros
    public Proveedor(int idProveeedor, String nombre, String numCuenta1, String numCuenta2, String correo1, String correo2, String telefono1, String telefono2) {
        this.idProveedor = idProveeedor;
        this.nombre = nombre;
        this.numCuenta1 = numCuenta1;
        this.numCuenta2 = numCuenta2;
        this.correo1 = correo1;
        this.correo2 = correo2;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    // constructor con algunos parametros
    public Proveedor(int idProveeedor, String nombre, String numCuenta1, String correo1, String telefono1) {
        this.idProveedor = idProveeedor;
        this.nombre = nombre;
        this.numCuenta1 = numCuenta1;
        this.correo1 = correo1;
        this.telefono1 = telefono1;
        this.correo2="";
        this.telefono2="";
    }
    
    // constructor vacio
    public Proveedor(){
        
    }

    // metodo tostring para concatenar
    @Override
    public String toString() {
        return idProveedor + "," + nombre + "," + numCuenta1 +"," + numCuenta2 + "," + correo1 + "," + correo2 + "," + telefono1 + "," + telefono2 ;
    }
    
    
    
// set y get de la clase proveedor
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

    public String getNumCuenta1() {
        return numCuenta1;
    }

    public void setNumCuenta1(String numCuenta1) {
        this.numCuenta1 = numCuenta1;
    }

    public String getNumCuenta2() {
        return numCuenta2;
    }

    public void setNumCuenta2(String numCuenta2) {
        this.numCuenta2 = numCuenta2;
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
