package gestor.clases;

import java.time.LocalDate;

public class Asistente extends Usuario{

    //atributos
    String dni;


    //Constructores
    public Asistente(){}

    public Asistente(String nombre, String apellidos, String email, String contrasena, String telefono, LocalDate fechaNacimiento, String dni) {
        super(nombre, apellidos, email, contrasena, telefono, fechaNacimiento);
        this.dni = dni;
    }

    //getter & setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //metodos
    /*Método toString que muestre toda la información de un asistente*/

    @Override
    public String toString() {
        return "gestor.clases.Asistente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + contrasena + '\'' +
                ", telefono=" + telefono +
                ", dni='" + dni + '\'' +
                ", fecha_nacimiento=" + fechaNacimiento +
                '}';
    }

    /*Método llamado infoBasica que muestre el nombre, apellido, email y dni del cliente*/
    public String infoBasica() {
        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(email);
        System.out.println(dni);
        return infoBasica();
    }
}
