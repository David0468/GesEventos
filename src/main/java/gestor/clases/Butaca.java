package gestor.clases;

import java.io.Serializable;

public class Butaca implements Serializable {

    /*  Atributos del objeto. */
    public String id;
    public boolean accesibilidad;
    public boolean disponible;


    /*Constructor por defecto (por defecto=nada)*/
    Butaca(){}

    public Butaca(String id, boolean accesibilidad, boolean disponible) {
        this.id = id;
        this.accesibilidad = accesibilidad;
        this.disponible = disponible;
    }

    /*un get y un set para cada atributo*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    //metodos
    /*Método toString*/
    @Override
    public String toString() {
        return "Butaca{" +
                "id='" + id + '\'' +
                ", accesibilidad=" + accesibilidad +
                ", disponible=" + disponible +
                '}';
    }

    // Método para ocupar la butaca
    public void ocuparButaca() {
        if (disponible) {
            disponible = false;
            System.out.println("La butaca " + id + " ha sido ocupada.");
        } else {
            System.out.println("La butaca " + id + " no está disponible.");
        }
    }

    public void desocuparButaca() {
        if (!disponible) {
            disponible = true;
            System.out.println("La butaca " + id + " ha sido desocupada.");
        } else {
            System.out.println("La butaca " + id + " ya está desocupada.");
        }
    }



}
