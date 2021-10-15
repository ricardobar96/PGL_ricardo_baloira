package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;

public class Biblioteca {
    private int idBiblioteca;
    private ArrayList<Usuario> usuariosSeguidos; //ArrayList que almacenara los usuarios seguidos por el usuario
    private ArrayList<Libro> librosCreados; //ArrayList que almacenara los libros creados por el usuario
    private ArrayList<Libro> librosLeidos; //ArrayList que almacenara los libros leidos por el usuario

    /**
     * Constructor por defecto de la clase Biblioteca
     */
    public Biblioteca() {
    }

    /**
     * Constructor de la clase Biblioteca
     * @param idBiblioteca
     * @param usuariosSeguidos
     * @param librosCreados
     * @param librosLeidos
     */
    public Biblioteca(int idBiblioteca, ArrayList<Usuario> usuariosSeguidos, ArrayList<Libro> librosCreados, ArrayList<Libro> librosLeidos) {
        this.idBiblioteca = idBiblioteca;
        this.usuariosSeguidos = usuariosSeguidos;
        this.librosCreados = librosCreados;
        this.librosLeidos = librosLeidos;
    }
    /**
     * Funcion que muestra los valores de los atributos del objeto Biblioteca
     * @return String con los valores de cada atributo del objeto Biblioteca
     */
    @Override
    public String toString() {
        return "Biblioteca{" +
                "idBiblioteca=" + idBiblioteca +
                ", usuariosSeguidos=" + usuariosSeguidos +
                ", librosCreados=" + librosCreados +
                ", librosLeidos=" + librosLeidos +
                '}';
    }
}
