package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;

public class Biblioteca {
    private int idBiblioteca;
    private ArrayList<Usuario> autores;
    private ArrayList<Libro> creados;
    private ArrayList<Libro> pendientes;
    private ArrayList<Libro> leidos;

    /**
     * Constructor por defecto de la clase Biblioteca
     */
    public Biblioteca() {
    }

    /**
     * Constructor de la clase Biblioteca
     * @param idBiblioteca
     * @param autores
     * @param creados
     * @param pendientes
     * @param leidos
     */
    public Biblioteca(int idBiblioteca, ArrayList<Usuario> autores, ArrayList<Libro> creados, ArrayList<Libro> pendientes, ArrayList<Libro> leidos) {
        this.idBiblioteca = idBiblioteca;
        this.autores = autores;
        this.creados = creados;
        this.pendientes = pendientes;
        this.leidos = leidos;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public ArrayList<Usuario> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Usuario> autores) {
        this.autores = autores;
    }

    public ArrayList<Libro> getCreados() {
        return creados;
    }

    public void setCreados(ArrayList<Libro> creados) {
        this.creados = creados;
    }

    public ArrayList<Libro> getPendientes() {
        return pendientes;
    }

    public void setPendientes(ArrayList<Libro> pendientes) {
        this.pendientes = pendientes;
    }

    public ArrayList<Libro> getLeidos() {
        return leidos;
    }

    public void setLeidos(ArrayList<Libro> leidos) {
        this.leidos = leidos;
    }

    /**
     * Funcion que muestra los valores de los atributos del objeto Biblioteca
     * @return String con los valores de cada atributo del objeto Biblioteca
     */
    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", autores=" + autores +
                ", creados=" + creados +
                ", pendientes=" + pendientes +
                ", leidos=" + leidos +
                '}';
    }
}
