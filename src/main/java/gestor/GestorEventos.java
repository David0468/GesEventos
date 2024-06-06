package gestor;

import gestor.clases.*;

import java.time.LocalDate;
import java.util.ArrayList;

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

        Administrador administrador1 = new Administrador("root", "", "root@root.com", "1234", "611479845", LocalDate.of(2004, 3, 10), 1);

        usuarios.add(asistente1);
        usuarios.add(asistente2);
        usuarios.add(asistente3);
        usuarios.add(administrador1);
    }

    //TODO: Metodo Login y Registro
    //Login


    //Registro


}
