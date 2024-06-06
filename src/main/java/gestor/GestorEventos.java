package gestor;

import gestor.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEventos {
    //Atributos
    public ArrayList<Usuario> usuarios;
    public ArrayList<Evento> eventos;
    public ArrayList<Reserva> reserva;

    //Constructores
    GestorEventos(){}

    public GestorEventos(ArrayList<Usuario> usuarios, ArrayList<Evento> eventos, ArrayList<Reserva> reserva) {
        this.usuarios = usuarios;
        this.eventos = eventos;
        this.reserva = reserva;
        info_inicial();
    }





    //Getter & Setter

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(ArrayList<Reserva> reserva) {
        this.reserva = reserva;
    }

    //Metodos
    public void info_inicial(){
        //Usuarios
        Usuario asistente1 = new Asistente("David", "Murcia", "davidmurcia04@gmail.com", "1234", "611457654", LocalDate.of(2004, 11, 3), "45673567X");
        Usuario asistente2 = new Asistente("Juan", "Juan", "shino04@gmail.com", "1234", "677546754", LocalDate.of(2004, 4, 23), "41936727E");
        Usuario asistente3 = new Asistente("Ruben", "Pardo", "fachacomunista05@gmail.com", "1234", "623725669", LocalDate.of(2005, 12, 8), "47219583U");

        Usuario administrador1 = new Administrador("root", "", "root@root.com", "1234", "611479845", LocalDate.of(2004, 3, 10), 1);

        usuarios.add(asistente1);
        usuarios.add(asistente2);
        usuarios.add(asistente3);
        usuarios.add(administrador1);
    }

    //TODO: Metodo Login y Registro
    //Login
    public Usuario login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su correo electrónico: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        // Recorre la lista de usuarios para encontrar una coincidencia
        for (Usuario usuario : usuarios) {
            // Comprueba si el correo y la contraseña coinciden
            if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(password)) {
                // Verifica si el usuario es un administrador o un asistente
                if (usuario instanceof Administrador) {
                    System.out.println("¡Login exitoso! Bienvenido Administrador " + usuario.getNombre());
                } else if (usuario instanceof Asistente) {
                    System.out.println("¡Login exitoso! Bienvenido Asistente " + usuario.getNombre());
                }
                return usuario;
            }
        }

        System.out.println("Correo electrónico o contraseña incorrectos.");
        return null;
    }

    //Registro
    public void registro() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        System.out.print("Ingrese su teléfono: ");
        String telefono = sc.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());

        System.out.print("Ingrese su DNI: ");
        String dni = sc.nextLine();

        // Solicita al usuario que ingrese el tipo de usuario
        System.out.print("Ingrese el tipo de usuario (1 para Administrador, 2 para Asistente): ");
        int tipoUsuario = Integer.parseInt(sc.nextLine());

        // Crea un nuevo usuario basado en el tipo seleccionad
        Usuario nuevoUsuario;
        if (tipoUsuario == 1) {
            nuevoUsuario = new Administrador(nombre, apellido, email, password, telefono, fechaNacimiento, usuarios.size() + 1);
        } else {
            nuevoUsuario = new Asistente(nombre, apellido, email, password, telefono, fechaNacimiento, dni);
        }


        // Agrega el nuevo usuario a la lista de usuarios
        usuarios.add(nuevoUsuario);

        System.out.println("¡Registro exitoso! Bienvenido " + nuevoUsuario.getNombre());
    }


}
