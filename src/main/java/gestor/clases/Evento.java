package gestor.clases;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Evento {
    //atriburos
    public String nombre;
    public String invitado;
    public Sala sala_evento = new Sala();
    public Date fecha;
    public Time hora;
    public String tipo_evento;
    public int numero_asistentes_maximo;
    public ArrayList<Asistente> lista_asistentes;

    //constructores
    public Evento(){}

    public Evento(String nombre, String invitado, Sala sala_evento, Date fecha, Time hora, String tipo_evento, int numero_asistentes_maximo, ArrayList<Asistente> lista_asistentes) {
        this.nombre = nombre;
        this.invitado = invitado;
        this.sala_evento = sala_evento;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_evento = tipo_evento;
        this.numero_asistentes_maximo = numero_asistentes_maximo;
        this.lista_asistentes = lista_asistentes;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInvitado() {
        return invitado;
    }

    public void setInvitado(String invitado) {
        this.invitado = invitado;
    }

    public Sala getSala_evento() {
        return sala_evento;
    }

    public void setSala_evento(Sala sala_evento) {
        this.sala_evento = sala_evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public int getNumero_asistentes_maximo() {
        return numero_asistentes_maximo;
    }

    public void setNumero_asistentes_maximo(int numero_asistentes_maximo) {
        this.numero_asistentes_maximo = numero_asistentes_maximo;
    }

    public ArrayList<Asistente> getLista_asistentes() {
        return lista_asistentes;
    }

    public void setLista_asistentes(ArrayList<Asistente> lista_asistentes) {
        this.lista_asistentes = lista_asistentes;
    }
}
