package gestor.clases;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Reserva implements Serializable {
    //Atributos
    public String id;
    public Asistente asistente_reserva=new Asistente();
    public Evento evento_reserva=new Evento();
    public Butaca butaca_reserva=new Butaca();



    //constructores
    public Reserva(){}

    public Reserva(Asistente asistente_reserva, Evento evento_reserva, Butaca butaca_reserva) {
        this.id = generarTocken();
        this.asistente_reserva = asistente_reserva;
        this.evento_reserva = evento_reserva;
        this.butaca_reserva = butaca_reserva;

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

    //Comprobar disponible
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

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", asistente_reserva=" + asistente_reserva +
                ", evento_reserva=" + evento_reserva +
                ", butaca_reserva=" + butaca_reserva +

                '}';
    }

    public String infoReserva(){
        return "id: "+id+"Reserva Evento: "+evento_reserva+"Reserva Butaca: "+butaca_reserva;
    }
}
