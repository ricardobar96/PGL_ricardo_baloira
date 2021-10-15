package es.iespuerto.ricardo.booknown.controlador;

public interface IGestorGeneros {
    void crearGenero();
    void eliminarGenero(int idGenero);
    void clasificarLibro(int idLibro);
    void desclasificarLibro(int idLibro);
}
