package gestor.clases;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable {
    //atributos
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String contrasena;
    protected String telefono;
    protected LocalDate fechaNacimiento;

    //constructores
    Usuario(){}

    public Usuario(String nombre, String apellidos, String email, String contrasena, String telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    //getter y seter


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //metodos
    public String infoBasica(){
        return "Nombre: "+nombre+", Apellidos: "+apellidos+", Email: "+email;
    }
}
