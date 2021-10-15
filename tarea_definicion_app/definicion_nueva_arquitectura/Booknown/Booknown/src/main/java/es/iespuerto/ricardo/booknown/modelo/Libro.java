package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Libro {
    private int idLibro, visualizaciones, paginas;
    private double puntuacionMedia;
    private String titulo, autor;
    private Date fechaActualizacion, fechaPublicacion;
    private boolean pagoOpcional;
    private ArrayList<Genero> generos;
    /**Atributo anadido. Todos los libros van dentro del ArrayList del
    catalogo y, dentro de cada libro, existira un ArrayList con sus generos para poder hacer
     busquedas en GestorLibros por generos, no solo por titulo y autor*/

    /**
     * Constructor por defecto de la clase Libro
     */
    public Libro() {
    }

    /**
     * Constructor de la clase Libro
     * @param idLibro
     * @param visualizaciones
     * @param paginas
     * @param puntuacionMedia
     * @param titulo
     * @param autor
     * @param fechaActualizacion
     * @param fechaPublicacion
     * @param pagoOpcional
     */
    public Libro(int idLibro, int visualizaciones, int paginas, double puntuacionMedia, String titulo, String autor, Date fechaActualizacion, Date fechaPublicacion, boolean pagoOpcional, ArrayList<Genero> generos) {
        this.idLibro = idLibro;
        this.visualizaciones = visualizaciones;
        this.paginas = paginas;
        this.puntuacionMedia = puntuacionMedia;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaPublicacion = fechaPublicacion;
        this.pagoOpcional = pagoOpcional;
        this.generos = generos;
    }

    public Libro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getVisualizaciones() {
        return visualizaciones;
    }

    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPuntuacionMedia() {
        return puntuacionMedia;
    }

    public void setPuntuacionMedia(double puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean isPagoOpcional() {
        return pagoOpcional;
    }

    public void setPagoOpcional(boolean pagoOpcional) {
        this.pagoOpcional = pagoOpcional;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    /**
     * Funcion que muestra los valores de los atributos del objeto Libro
     * @return String con los valores de cada atributo del objeto Libro
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", visualizaciones=" + visualizaciones +
                ", paginas=" + paginas +
                ", puntuacionMedia=" + puntuacionMedia +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaActualizacion=" + fechaActualizacion +
                ", fechaPublicacion=" + fechaPublicacion +
                ", pagoOpcional=" + pagoOpcional +
                ", generos=" + generos +
                '}';
    }
}
