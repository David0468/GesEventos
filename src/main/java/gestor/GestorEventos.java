package gestor;

import gestor.clases.*;
import java.time.LocalDate;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEventos {
    // Atributos
    public  ArrayList<Usuario> usuarios;
    public ArrayList<Evento> eventos;
    public ArrayList<Reserva> reservas;

    // Constructor por defecto
    public GestorEventos() {
        this.usuarios = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        info_inicial();
    }

    // Constructor parametrizado
    public GestorEventos(ArrayList<Usuario> usuarios, ArrayList<Evento> eventos, ArrayList<Reserva> reservas) {
        this.usuarios = usuarios != null ? usuarios : new ArrayList<>();
        this.eventos = eventos != null ? eventos : new ArrayList<>();
        this.reservas = reservas != null ? reservas : new ArrayList<>();
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

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método de inicialización
    public void info_inicial() {
        // Usuarios
        Usuario asistente1 = new Asistente("David", "Murcia", "davidmurcia04@gmail.com", "1234", "611457654", LocalDate.of(2004, 11, 3), "45673567X");
        Usuario asistente2 = new Asistente("Juan", "Juan", "shino04@gmail.com", "1234", "677546754", LocalDate.of(2004, 4, 23), "41936727E");
        Usuario asistente3 = new Asistente("Ruben", "Pardo", "fachacomunista05@gmail.com", "1234", "623725669", LocalDate.of(2005, 12, 8), "47219583U");

        Usuario administrador1 = new Administrador("root", "", "root@root.com", "1234", "611479845", LocalDate.of(2004, 3, 10), 1);

        usuarios.add(asistente1);
        usuarios.add(asistente2);
        usuarios.add(asistente3);
        usuarios.add(administrador1);
    }

    /*Login & Registro*/
    //Login
    public Usuario login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su correo electrónico: ");
        String email = scanner.next();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.next();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getContrasena().equals(contrasena)) {
                if (usuario instanceof Administrador) {
                    System.out.println("¡Login exitoso! Bienvenido Administrador " + usuario.getNombre());
                    return usuario;
                } else if (usuario instanceof Asistente) {
                    System.out.println("¡Login exitoso! Bienvenido Asistente " + usuario.getNombre());
                    return usuario;
                }
            }
        }

        System.out.println("Correo electrónico o contraseña incorrectos.");
        return null;
    }

    //Registro
    public void registro() {
        Scanner scanner = new Scanner(System.in);

        String nombre = "";
        while (nombre.isEmpty() || !Validaciones.validarAlfabetoLatino(nombre)){
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.next().trim();
            if (!Validaciones.validarAlfabetoLatino(nombre)){
                System.out.println("El nombre no esta permitido.");
            }
        }

        String apellido = "";
        while (apellido.isEmpty() || !Validaciones.validarAlfabetoLatino(apellido)){
            System.out.print("Ingrese su apellido: ");
            apellido = scanner.next().trim();
            if (!Validaciones.validarAlfabetoLatino(apellido)){
                System.out.println("El apellido no esta permitido.");
            }
        }

        String email = "";
        while (email.isEmpty() || !Validaciones.validarEmail(email)) {
            System.out.print("Ingrese su correo electrónico: ");
            email = scanner.next().trim();
            if (!Validaciones.validarEmail(email)) {
                System.out.println("Correo electrónico inválido.");
            }
        }

        String contrasena = "";
        while (contrasena.isEmpty() || !Validaciones.validarContrasena(contrasena)){
            System.out.println("Ingrese una contraseña: ");
            contrasena = scanner.next().trim();
            if (!Validaciones.validarContrasena(contrasena)) {
                System.out.println("Contraseña no valida");
            }
        }

        String telefono = "";
        while (telefono.isEmpty() || !Validaciones.validarTelefono(telefono)){
            System.out.print("Ingrese su telefono: ");
            telefono = scanner.next().trim();
            if (!Validaciones.validarTelefono(telefono)) {
                System.out.println("Telefono no valido.");
            }
        }

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Ingrese su fecha de nacimiento (YYYY-MM-DD): ");
            try {
                fechaNacimiento = LocalDate.parse(scanner.next().trim());
            } catch (Exception e) {
                System.out.println("Fecha de nacimiento inválida. Formato correcto: YYYY-MM-DD.");
            }
        }

        String dni = "";
        while (dni.isEmpty() || !Validaciones.validarDNI(dni)){
            System.out.print("Ingrese su DNI: ");
            dni = scanner.next().trim();
            if (!Validaciones.validarDNI(dni)) {
                System.out.println("DNI no valido.");
            }
        }


        Usuario nuevoUsuario = new Asistente(nombre, apellido, email, contrasena, telefono, fechaNacimiento, dni);
        usuarios.add(nuevoUsuario);

        System.out.println("¡Registro exitoso! Bienvenido " + nuevoUsuario.getNombre());
    }


    /*Eventos*/
    //Agregar Evento
    public void agregarEvento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del evento: ");
        String nombreEvento = String.valueOf(Validaciones.validarAlfabetoLatino(scanner.next()));

        System.out.print("Ingrese el nombre del invitado: ");
        String invitado = String.valueOf(Validaciones.validarAlfabetoLatino(scanner.next()));

        Sala sala = new Sala();

        System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(scanner.next());

        System.out.print("Ingrese la hora del evento (HH:MM): ");
        LocalTime hora = LocalTime.parse(scanner.next());

        System.out.print("Ingrese el tipo de evento: ");
        String tipoEvento = scanner.next();

        System.out.print("Ingrese el número máximo de asistentes: ");
        String maxAsistentes = String.valueOf(Validaciones.esNum(scanner.next()));

        ArrayList<Asistente> listaAsistentes = new ArrayList<>();

        Evento nuevoEvento = new Evento(nombreEvento, invitado, sala, fecha, hora, tipoEvento, maxAsistentes, listaAsistentes);
        eventos.add(nuevoEvento);

        System.out.println("¡Evento agregado exitosamente!");
    }


    //eliminador evento
    public void eliminarEvento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del evento a eliminar: ");
        String nombreEvento = scanner.nextLine();

        Evento eventoAEliminar = null;

        for (Evento evento : eventos) {
            if (evento.getNombre().equals(nombreEvento)) {
                eventoAEliminar = evento;
                break;
            }
        }

        if (eventoAEliminar != null) {
            eventos.remove(eventoAEliminar);
            System.out.println("¡Evento eliminado exitosamente!");
        } else {
            System.out.println("No se encontró un evento con ese nombre.");
        }
    }

    //listar eventos
    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos programados.");
        } else {
            for (Evento evento : eventos) {
                System.out.println("Evento: " + evento.getNombre() + ", Invitado: " + evento.getInvitado() + ", Fecha: " + evento.getFecha() + ", Hora: " + evento.getHora() + ", Tipo: " + evento.getTipo_evento() + ", Máximo Asistentes: " + evento.getNumero_asistentes_maximo());
            }
        }
    }
}
