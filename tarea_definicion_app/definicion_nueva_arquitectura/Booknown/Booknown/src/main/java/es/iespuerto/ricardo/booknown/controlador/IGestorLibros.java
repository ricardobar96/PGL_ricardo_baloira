package es.iespuerto.ricardo.booknown.controlador;

public interface IGestorLibros {
    void buscarLibro(String titulo_autor_genero); //el usuario elige si buscar Libro por su titulo, autor o genero antes de introducir el String
    void crearLibro();
    void modificarLibro(int idLibro);
    void eliminarLibro(int idLibro);
}
