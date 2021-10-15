package es.iespuerto.ricardo.booknown.controlador;

import java.util.ArrayList;

public interface IBiblioteca {
    //void agregarLista(ArrayList<Object> lista);

    void agregarAutor();
    void eliminarAutor();

    void agregarPendiente();
    void eliminarPendiente();

    void agregarLeido();
    void eliminarLeido();

    void agregarCreado();
    void eliminarCreado();
}
