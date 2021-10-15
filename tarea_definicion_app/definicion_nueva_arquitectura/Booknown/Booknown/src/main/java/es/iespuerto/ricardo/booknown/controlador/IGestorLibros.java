package es.iespuerto.ricardo.booknown.controlador;

public interface IGestorLibros {
    void buscarLibro(String titulo);
    void buscarAutor(String autor);
    void buscarGenero(String genero);
    void crearLibro();
    void modificarLibro(int idLibro);
    void eliminarLibro(int idLibro);
}
