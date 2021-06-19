package Backend.Modelo;

public class Cliente {

    // propiedades de cliente
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono1;
    private String telefono2;
    private String tipo;

    // constructor de cliente con sus parametros
    public Cliente(int idCliente, String nombre, String apellidos, String direccion, String telefono1, String telefono2, String tipo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.tipo = tipo;
    }

    // constructor con algunas parametros
    public Cliente(int idCliente, String nombre, String apellidos, String direccion, String telefono1, String tipo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = "";
        this.tipo = tipo;
    }

    // constructor vacio
    public Cliente() {

    }

    // metodo tostring para concatenar
    @Override
    public String toString() {
        return idCliente + "," + nombre + "," + apellidos + "," + direccion + "," + telefono1 + "," + telefono2+","+tipo;
    }

    // set y get de cliente
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }
}
