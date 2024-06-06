package gestor.clases;

import java.sql.Time;
import java.util.Date;

public class Reserva {
    //Atributos
    public String id;
    public Asistente asistente_reserva=new Asistente();
    public Evento evento_reserva=new Evento();
    public Butaca butaca_reserva=new Butaca();
    public Date fecha;
    public Time hora;


    //constructores
    public Reserva(){}

    public Reserva(String id, Asistente asistente_reserva, Evento evento_reserva, Butaca butaca_reserva, Date fecha, Time hora) {
        this.id = id;
        this.asistente_reserva = asistente_reserva;
        this.evento_reserva = evento_reserva;
        this.butaca_reserva = butaca_reserva;
        this.fecha = fecha;
        this.hora = hora;
    }

    //getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Asistente getAsistente_reserva() {
        return asistente_reserva;
    }

    public void setAsistente_reserva(Asistente asistente_reserva) {
        this.asistente_reserva = asistente_reserva;
    }

    public Evento getEvento_reserva() {
        return evento_reserva;
    }

    public void setEvento_reserva(Evento evento_reserva) {
        this.evento_reserva = evento_reserva;
    }

    public Butaca getButaca_reserva() {
        return butaca_reserva;
    }

    public void setButaca_reserva(Butaca butaca_reserva) {
        this.butaca_reserva = butaca_reserva;
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


    public boolean comprobarDisponibilidad(){
        if (butaca_reserva.disponible == true){
            return true;
        }else {
            return false;
        }
    }

    public String reservarPlaza(){
        return asistente_reserva.infoBasica();
    }

    public String generarTocken(){
        StringBuilder GeneradorToken = new StringBuilder();
        String caracteres = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";

        while (GeneradorToken.length() < 17) {
            int Aleatorio = (int) (Math.random() * caracteres.length());
            char caracterAleatorio = caracteres.charAt(Aleatorio);

            if (GeneradorToken.indexOf(String.valueOf(caracterAleatorio)) == -1) {
                GeneradorToken.append(caracterAleatorio);
            }
        }
        String token = GeneradorToken.toString();

        return token;
    }
}
