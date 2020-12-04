
package Backend.Modelo;

public class Empleado {

    // se declaran las propiedades que tendra la clase
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

    // constructor que pide y almacena cada propiedad
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
    // constructor vacio
    public Empleado(){
        
    }

    // metodo toString para concatenar
    @Override
    public String toString() {
        return idEmpleado + "," + user + "," + password + "," + nombre + "," + apellido + "," + correo + "," + telefono1 + "," + telefono2 + "," + rol + "," + direccion;
    }

    
    // set y getters de las propiedades
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
