package es.iespuerto.ricardo.booknown.modelo;

public class Genero {
    private int idGenero;
    private String nombre;

    /**
     * Constructor por defecto de la clase Genero
     */
    public Genero() {
    }

    /**
     * Constructor de la clase Genero
     * @param idGenero
     * @param nombre
     */
    public Genero(int idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion que muestra los valores de los atributos del objeto Genero
     * @return String con los valores de cada atributo del objeto Genero
     */
    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
