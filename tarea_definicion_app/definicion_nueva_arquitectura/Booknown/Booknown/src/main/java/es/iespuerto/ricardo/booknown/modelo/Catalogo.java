package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Libro> libros; //ArrayList donde se almacenaran todos los objetos Libro
    private ArrayList<Resenia> resenias; //ArrayList donde se almacenaran todos los objetos Resenia

    /**
     * Constructor por defecto de la clase Catalogo
     */
    public Catalogo() {
    }

    /**
     * Constructor de la clase Catalogo
     */
    public Catalogo(ArrayList<Libro> libros, ArrayList<Resenia> resenias) {
        this.libros = libros;
        this.resenias = resenias;
    }
}
