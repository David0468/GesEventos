package gestor.clases;

public class Sala {
    //ATRIBUTOS
    public String nombre;
    public int capacidad_maxima;
    public String lista_butacas_disponibles;
    public float dimension;
    public boolean accesibilidad;
    public String caracteristicas_acusticas;
    public String observaciones;


    //constructores
    public Sala(){}

    public Sala(String observaciones, String caracteristicas_acusticas, boolean accesibilidad, float dimension, String lista_butacas_disponibles, int capacidad_maxima, String nombre) {
        this.observaciones = observaciones;
        this.caracteristicas_acusticas = caracteristicas_acusticas;
        this.accesibilidad = accesibilidad;
        this.dimension = dimension;
        this.lista_butacas_disponibles = lista_butacas_disponibles;
        this.capacidad_maxima = capacidad_maxima;
        this.nombre = nombre;
    }

    //GETTER Y SETTER
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(int capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public String getLista_butacas_disponibles() {
        return lista_butacas_disponibles;
    }

    public void setLista_butacas_disponibles(String lista_butacas_disponibles) {
        this.lista_butacas_disponibles = lista_butacas_disponibles;
    }

    public float getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public boolean isAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getCaracteristicas_acusticas() {
        return caracteristicas_acusticas;
    }

    public void setCaracteristicas_acusticas(String caracteristicas_acusticas) {
        this.caracteristicas_acusticas = caracteristicas_acusticas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    //metodo comprobar capacidad
    public boolean verificarCapacidad(int numeroAsistentes) {
        if (numeroAsistentes <= capacidad_maxima){
            return true;
        }else {
            return false;
        }
    }

}
