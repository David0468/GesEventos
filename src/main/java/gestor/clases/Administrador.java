package gestor.clases;

import java.time.LocalDate;

public class Administrador extends Usuario{
    //ATRIBUTOS
    private int permisos;

    //CONSTRUCTORES
    Administrador(){}

    public Administrador(String nombre, String apellidos, String email, String contrasena, String telefono, LocalDate fechaNacimiento, int permisos) {
        super(nombre, apellidos, email, contrasena, telefono, fechaNacimiento);
        this.permisos = permisos;
    }

    //GETTER SETER
    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    //OVERDIBREDIDHJFDSFIO
    @Override
    public String toString() {
        return "Administrador{" +
                "permisos=" + permisos +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento='" + fechaNacimiento +
                '}';
    }
}
