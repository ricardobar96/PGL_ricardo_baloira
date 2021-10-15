package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Libro> libros;

    /**
     * Constructor por defecto de la clase Catalogo
     */
    public Catalogo() {
    }

    /**
     * Constructor de la clase Catalogo
     */
    public Catalogo(ArrayList<Libro> libros) {
        this.libros = libros;
    }
}
