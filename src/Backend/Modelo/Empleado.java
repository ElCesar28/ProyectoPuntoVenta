/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Modelo;

public class Empleado {

    private int idEmpleado;
    private String user;
    private String password;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono1;
    private String telefono2;
    private String rol;
    private String direccion;

    public Empleado(int idEmpleado, String user, String password, String nombre, String apellido, String correo, String telefono1, String telefono2, String rol, String direccion) {
        this.idEmpleado = idEmpleado;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.rol = rol;
        this.direccion = direccion;
    }
    
    public Empleado(){
        
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public String getRol() {
        return rol;
    }

    public String getDireccion() {
        return direccion;
    }

}
