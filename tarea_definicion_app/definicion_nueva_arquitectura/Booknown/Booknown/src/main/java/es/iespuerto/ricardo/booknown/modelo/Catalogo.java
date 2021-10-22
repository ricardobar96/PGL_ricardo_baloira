package es.iespuerto.ricardo.booknown.modelo;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Libro> librosCatalogo; //ArrayList donde se almacenaran todos los objetos Libro
    private ArrayList<Resenia> reseniasCatalogo; //ArrayList donde se almacenaran todos los objetos Resenia

    /**
     * Constructor por defecto de la clase Catalogo
     */
    public Catalogo() {
    }

    /**
     * Constructor de la clase Catalogo
     */
    public Catalogo(ArrayList<Libro> librosCatalogo, ArrayList<Resenia> reseniasCatalogo) {
        this.librosCatalogo = librosCatalogo;
        this.reseniasCatalogo = reseniasCatalogo;
    }
}
