package gestor;

import gestor.clases.Asistente;
import gestor.clases.Evento;
import gestor.clases.Reserva;
import gestor.clases.Sala;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor {
    //atributos
    public ArrayList<Evento> listado_eventos;
    public ArrayList<Sala> listado_salas;
    public ArrayList<Asistente> listado_asistentes;
    public ArrayList<Reserva> listado_reservas;


    //constructores
    Gestor(){}

    public Gestor(ArrayList<Evento> listado_eventos, ArrayList<Sala> listado_salas, ArrayList<Asistente> listado_asistentes, ArrayList<Reserva> listado_reservas) {
        this.listado_eventos = listado_eventos;
        this.listado_salas = listado_salas;
        this.listado_asistentes = listado_asistentes;
        this.listado_reservas = listado_reservas;
    }

    //geter and seter
    public ArrayList<Evento> getListado_eventos() {
        return listado_eventos;
    }

    public void setListado_eventos(ArrayList<Evento> listado_eventos) {
        this.listado_eventos = listado_eventos;
    }

    public ArrayList<Sala> getListado_salas() {
        return listado_salas;
    }

    public void setListado_salas(ArrayList<Sala> listado_salas) {
        this.listado_salas = listado_salas;
    }

    public ArrayList<Asistente> getListado_asistentes() {
        return listado_asistentes;
    }

    public void setListado_asistentes(ArrayList<Asistente> listado_asistentes) {
        this.listado_asistentes = listado_asistentes;
    }

    public ArrayList<Reserva> getListado_reservas() {
        return listado_reservas;
    }

    public void setListado_reservas(ArrayList<Reserva> listado_reservas) {
        this.listado_reservas = listado_reservas;
    }

    //METODOS
    //TODO: Método login, que pide un usuario y una contraseña
    public Asistente login(String email, String password) {
        for (Asistente asistente : listado_asistentes) {
            if (asistente.getEmail().equals(email) && asistente.getContrasena().equals(password)) {
                return asistente; // Devuelve el asistente si se encuentra
            }
        }
        return null; // Devuelve null si no se encuentra ninguna coincidencia
    }


    //TODO: Metodo registro que permite registrar a un usuario pidiendo el nombre de usuario, dni, email, contraseña, telefono
    public void registrarUsuario(String nombre, String apellidos, String email, String password, String telefono, String dni, LocalDate fechaNacimiento) {
        // Verificar si el correo electrónico ya está registrado
        for (Asistente asistente : listado_asistentes) {
            if (asistente.getEmail().equals(email)) {
                System.out.println("El correo electrónico ya está registrado. Por favor, elija otro.");
                return; // Sale del método si el correo ya está registrado
            }
        }

        // Crear un nuevo asistente y agregarlo a la lista
        Asistente nuevoAsistente = new Asistente(nombre, apellidos, email, password, telefono, fechaNacimiento, dni);
        listado_asistentes.add(nuevoAsistente);
        System.out.println("Usuario registrado correctamente.");
    }

    //metodos
    public void info_inicial() {
        // Eventos
        listado_eventos.add(new Evento());
        // Salas
        listado_salas.add(new Sala());
        // Asistentes
        listado_asistentes.add(new Asistente());
        // Reservas
        listado_reservas.add(new Reserva());
    }
}
