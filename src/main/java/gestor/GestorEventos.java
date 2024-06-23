package gestor;

import gestor.clases.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEventos {
    // Atributos
    public  ArrayList<Usuario> usuarios;
    public ArrayList<Evento> eventos;
    public ArrayList<Reserva> reservas;
    public Sala[] listado_salas=new Sala[5];
    Evento eventoSeleccionado;
    Usuario usuarioActivo;

    // Constructor por defecto
    public GestorEventos() {
        this.usuarios = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.reservas = new ArrayList<>();

        try {
            leerUsuario();
        }catch(IOException ioe){
            System.out.println("Error al leer el usuario");
        }
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
        //codigo que genera sala con butacas
        for (int i = 0; i < 5; i++) {
            //System.out.println("Sala " +i);
            //Generar butacas
            int sumar = (int) (Math.random() * 5) + 3;

            ArrayList<Butaca> misbutacas = new ArrayList<>();

            for (char fila = 'A'; fila <= 'E'; fila++) {
                for (int columna = 1; columna <= 6; columna++) {
                    int identificador = 0;
                    identificador++;
                    String posicion = fila + "" + columna + "";
                    misbutacas.add(new Butaca(posicion, false, false));
                }
            }
            listado_salas[i]=new Sala("Sala " + i, misbutacas.size(), 100, misbutacas);

        }

        // Usuarios --- PARA GENERAR LOS USUARIOS
        /*  Usuario asistente1 = new Asistente("David", "Murcia", "davidmurcia04@gmail.com", "1234", "611457654", LocalDate.of(2004, 11, 3), "45673567X");
        Usuario asistente2 = new Asistente("Juan", "Juan", "shino04@gmail.com", "1234", "677546754", LocalDate.of(2004, 4, 23), "41936727E");
        Usuario asistente3 = new Asistente("Ruben", "Pardo", "fachacomunista05@gmail.com", "1234", "623725669", LocalDate.of(2005, 12, 8), "47219583U");

        Usuario administrador1 = new Administrador("root", "", "root@root.com", "1234", "611479845", LocalDate.of(2004, 3, 10), 1);

        usuarios.add(asistente1);
        usuarios.add(asistente2);
        usuarios.add(asistente3);
        usuarios.add(administrador1);
        try {
            guardarUsuario();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el usuario");
        }*/
        try{
            leerUsuario();
        }catch (IOException ioe){
            System.out.println("Error al leer el usuario");
        }


        /*// Eventos
        Evento evento1 = new Evento("Concierto Rock", "Band A", new Sala(), "2003-12-12", "20:10", "Concierto", "100", new ArrayList<>());
        Evento evento2 = new Evento("Conferencia Tech", "Speaker B", new Sala(), "2005-03-09", "12:50", "Conferencia", "50", new ArrayList<>());
        Evento evento3 = new Evento("Festival Cine", "Director C", new Sala(), "2021-01-08", "09:12", "Festival", "200", new ArrayList<>());

        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);

        try {
            guardarEventos();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el Evento");
        }
        */
        try{
            leerEventos();
        }catch (IOException ioe){
            System.out.println("Error al leer el Evento");
        }

        /*// Reservas
        Reserva reserva1 = new Reserva(new Asistente(), new Evento(), new Butaca("A1", true,true));
        Reserva reserva2 = new Reserva(new Asistente(), new Evento(), new Butaca("B2", true,true));
        Reserva reserva3 = new Reserva(new Asistente(), new Evento(), new Butaca("C3", true,true));

        reservas.add(reserva1);
        reservas.add(reserva2);
        reservas.add(reserva3);
        try {
            guardarReserva();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el Evento");
        }
           */
        try{
            leerReservas();
        }catch (IOException ioe){
            System.out.println("Error al leer la Reserva");
        }
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

                usuarioActivo = usuario;
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
        try {
            guardarUsuario();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el usuario");
        }
    }


    /*Eventos*/
    //Agregar Evento
    public void agregarEvento() {
        Scanner scanner = new Scanner(System.in);

        String nombreEvento = "";
        while (nombreEvento.isEmpty() || !Validaciones.validarLetrasYNumeros(nombreEvento)){
            System.out.print("Ingrese el nombre del evento: ");
            nombreEvento = scanner.next().trim();
            if (!Validaciones.validarLetrasYNumeros(nombreEvento)){
                System.out.println("El nombre no esta permitido.");
            }
        }

        String invitado = "";
        while (invitado.isEmpty() || !Validaciones.validarAlfabetoLatino(invitado)){
            System.out.print("Ingrese el invitado del evento: ");
            invitado = scanner.next().trim();
            if (!Validaciones.validarAlfabetoLatino(invitado)){
                System.out.println("El invitado no esta permitido.");
            }
        }

        Sala sala = new Sala();

        String fecha = "";
        while (fecha.isEmpty() || !Validaciones.validarFecha(fecha)) {
            System.out.print("Ingrese la fecha del evento (YYYY-MM-DD): ");
            fecha = scanner.next().trim();
            if (!Validaciones.validarFecha(fecha)) {
                System.out.println("Fecha no disponible. Formato correcto: YYYY-MM-DD.");
            }
        }

        String hora = "";
        while (hora.isEmpty() || !Validaciones.validarHora(hora)) {
            System.out.print("Ingrese la hora del evento (HH:MM): ");
            hora = scanner.next().trim();
            if (!Validaciones.validarHora(hora)) {
                System.out.println("Hora no disponible. Formato correcto: HH:MM.");
            }
        }

        String tipoEvento = "";
        while (tipoEvento.isEmpty() || !Validaciones.validarAlfabetoLatino(tipoEvento)){
            System.out.print("Ingrese el tipo del evento: ");
            tipoEvento = scanner.next().trim();
            if (!Validaciones.validarAlfabetoLatino(tipoEvento)){
                System.out.println("El tipo del evento no esta permitido.");
            }
        }

        String maxAsistentes = "";
        while (maxAsistentes.isEmpty() || !Validaciones.esNum(maxAsistentes)){
            System.out.print("Ingrese el maximo de asistentes para este evento: ");
            maxAsistentes = scanner.next().trim();
            if (!Validaciones.esNum(maxAsistentes)){
                System.out.println("Error, intentalo otra vez.");
            }
        }

        ArrayList<Asistente> listaAsistentes = new ArrayList<>();

        Evento nuevoEvento = new Evento(nombreEvento, invitado, sala, fecha, hora, tipoEvento, maxAsistentes, listaAsistentes);
        eventos.add(nuevoEvento);

        System.out.println("¡Evento agregado exitosamente!");
        try {
            guardarEventos();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el Evento");
        }
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


    /*Menu Asistente*/
    //listar eventos
    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos programados.");
        } else {
            for (Evento evento : eventos) {
                System.out.println("Evento: " + evento.getNombre() + ", Invitado: " + evento.getInvitado() + ", Fecha: " + evento.getFecha() + ", Hora: " + evento.getHora() + ", Tipo: " + evento.getTipo_evento() + ", Máximo Asistentes: " + evento.getNumero_asistentes_maximo());
            }
        }
        try{
            leerReservas();
        }catch (IOException ioe){
            System.out.println("Error al leer la Reserva");
        }
    }



    /*Menu Asistente*/
    //seleccionar Evento
    public void seleccionarEvento() {
        Scanner scanner = new Scanner(System.in);

        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles.");
            return;
        }

        System.out.println("Seleccione un evento:");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i).getNombre());
        }

        int seleccion = -1;
        while (seleccion < 1 || seleccion > eventos.size()) {
            System.out.print("Ingrese el número del evento: ");
            try {
                seleccion = Integer.parseInt(scanner.next().trim());
                if (seleccion < 1 || seleccion > eventos.size()) {
                    System.out.println("Selección inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente nuevamente.");
            }
        }

        this.eventoSeleccionado = eventos.get(seleccion - 1);
        System.out.println("Evento seleccionado: " + eventoSeleccionado.getNombre());
        hacerReserva();

    }

    public void hacerReserva(){
        reservas.add(new Reserva((Asistente) usuarioActivo, (Evento) eventoSeleccionado, new Butaca("A1",true,true)));
    }

    public void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas disponibles.");
            return;
        }

        System.out.println("Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Reserva ID: " + reserva.getId() + ", Evento: " + reserva.getEvento_reserva().getNombre() + ", Asistente: " + reserva.getAsistente_reserva().getNombre());
        }
        try {
            guardarReserva();
        }catch (IOException ioe){
            System.out.println("Problemas al guardar el Evento");
        }
    }



    //TODO: Leer y guardar usuarios
    public void leerUsuario() throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("src/main/java/gestor/data/usuarios.dat");
            ois = new ObjectInputStream(fis);
            Usuario u;

            while (true){
                u=(Usuario)ois.readObject();
                usuarios.add(u);
            }
        }catch (EOFException eof){
            //System.out.println("Usuario agregado correctamente");
        }catch (ClassNotFoundException eclas){
            System.out.println("Clase no encontrada");
        }finally {
            if (ois != null){
                ois.close();
                fis.close();
            }
        }
    }
    public void guardarUsuario() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/gestor/data/usuarios.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Usuario u:usuarios){

            oos.writeObject(u);
        }
         oos.flush();

        if (oos != null){
            oos.close();
            fos.close();
        }
    }

    //TODO: Leer y guardar Reservas
    public void leerReservas() throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("src/main/java/gestor/data/reservas.dat");
            ois = new ObjectInputStream(fis);
            Reserva r;

            while (true){
                r=(Reserva) ois.readObject();
                reservas.add(r);
            }
        }catch (EOFException eof){
            //System.out.println("Reserva agregada correctamente");
        }catch (ClassNotFoundException eclas){
            System.out.println("Clase no encontrada");
        }finally {
            if (ois != null){
                ois.close();
                fis.close();
            }
        }
    }
    public void guardarReserva() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/gestor/data/reservas.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Reserva r:reservas){

            oos.writeObject(r);
        }
        oos.flush();

        if (oos != null){
            oos.close();
            fos.close();
        }
    }


    //TODO: Leer y guardar Eventos
    public void leerEventos() throws IOException {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("src/main/java/gestor/data/eventos.dat");
            ois = new ObjectInputStream(fis);
            Evento e;

            while (true){
                e=(Evento) ois.readObject();
                eventos.add(e);
            }
        }catch (EOFException eof){
            //System.out.println("Evento agregado correctamente");
        }catch (ClassNotFoundException eclas){
            System.out.println("Clase no encontrada");
        }finally {
            if (ois != null){
                ois.close();
                fis.close();
            }
        }
    }
    public void guardarEventos() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/java/gestor/data/eventos.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Evento e:eventos){

            oos.writeObject(e);
        }
        oos.flush();

        if (oos != null){
            oos.close();
            fos.close();
        }
    }

}
