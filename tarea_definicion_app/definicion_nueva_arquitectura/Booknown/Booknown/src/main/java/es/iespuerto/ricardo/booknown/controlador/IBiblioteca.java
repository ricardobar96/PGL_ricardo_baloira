package es.iespuerto.ricardo.booknown.controlador;

import java.util.ArrayList;

public interface IBiblioteca {
    void seguirUsuario(); //agregar al ArrayList usuariosSeguidos un nuevo objeto Usuario
    void dejarDeSeguirUsuario(int idUsuario); //eliminar del ArrayList usuariosSeguidos un objeto Usuario

    void agregarLibroLeido(); //agregar al ArrayList librosLeidos un nuevo objeto Libro
    void eliminarLibroLeido(int idLibro); //eliminar del ArrayList librosLeidos un objeto Libro

    void agregarLibroCreado(); //agregar al ArrayList librosCreados un nuevo objeto Libro
    void eliminarLibroCreado(int idLibro); //eliminar del ArrayList librosCreados un objeto Libro
}
