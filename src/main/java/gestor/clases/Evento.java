package gestor.clases;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Evento implements Serializable {
    //atriburos
    public String nombre;
    public String invitado;
    public Sala sala_evento = new Sala();
    public String fecha;
    public String hora;
    public String tipo_evento;
    public String numero_asistentes_maximo;
    public ArrayList<Asistente> lista_asistentes;

    //constructores
    public Evento(){}

    public Evento(String nombre, String invitado, Sala sala_evento, String fecha, String hora, String tipo_evento, String numero_asistentes_maximo, ArrayList<Asistente> lista_asistentes) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public String getNumero_asistentes_maximo() {
        return numero_asistentes_maximo;
    }

    public void setNumero_asistentes_maximo(String numero_asistentes_maximo) {
        this.numero_asistentes_maximo = numero_asistentes_maximo;
    }

    public ArrayList<Asistente> getLista_asistentes() {
        return lista_asistentes;
    }

    public void setLista_asistentes(ArrayList<Asistente> lista_asistentes) {
        this.lista_asistentes = lista_asistentes;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", invitado='" + invitado + '\'' +
                ", sala_evento=" + sala_evento +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", tipo_evento='" + tipo_evento + '\'' +
                ", numero_asistentes_maximo='" + numero_asistentes_maximo + '\'' +
                ", lista_asistentes=" + lista_asistentes +
                '}';
    }

    public String infoEvento(){
        return "Nombre: "+nombre+"Invitado: "+invitado+"Sala: "+sala_evento+"Fecha: "+fecha+"Hora: "+hora+"Maximo asistentes: "+numero_asistentes_maximo+"Lista: "+lista_asistentes+"\n";
    }
}
