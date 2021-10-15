package es.iespuerto.ricardo.booknown.modelo;

import java.util.Date;

public class Resenia {
    private int idResenia, puntuacion, meGusta;
    private String autor, libro;
    private Date fecha;

    /**
     * Constructor por defecto de la clase Resenia
     */
    public Resenia() {
    }

    /**
     * Constructor de la clase Resenia
     * @param idResenia
     * @param puntuacion
     * @param meGusta
     * @param autor
     * @param libro
     * @param fecha
     */
    public Resenia(int idResenia, int puntuacion, int meGusta, String autor, String libro, Date fecha) {
        this.idResenia = idResenia;
        this.puntuacion = puntuacion;
        this.meGusta = meGusta;
        this.autor = autor;
        this.libro = libro;
        this.fecha = fecha;
    }

    public int getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(int idResenia) {
        this.idResenia = idResenia;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Funcion que muestra los valores de los atributos del objeto Resenia
     * @return String con los valores de cada atributo del objeto Resenia
     */
    @Override
    public String toString() {
        return "Resenia{" +
                "idResenia=" + idResenia +
                ", puntuacion=" + puntuacion +
                ", meGusta=" + meGusta +
                ", autor='" + autor + '\'' +
                ", libro='" + libro + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
