package co.edu.umanizales.alquiler_carros.model;

public class Usuario {

    private String login;
    private String nombre;
    private String password;
    private String rol;

    // Constructor
    public Usuario(String login, String nombre, String password, String rol) {
        this.login = login;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }
    //asigna los valores recibidos en los parametros a los atributos de la clase

    // Getters y setters
    //Métodos públicos que devuelven el valor de los atributos

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) { //Método público que asigna un nuevo valor al atributo login.
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol; //Método público que devuelve el valor del atributo rol
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

