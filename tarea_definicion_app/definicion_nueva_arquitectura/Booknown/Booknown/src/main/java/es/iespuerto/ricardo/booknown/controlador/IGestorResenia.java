package es.iespuerto.ricardo.booknown.controlador;

public interface IGestorResenia {
    void crearResenia();
    void modificarResenia(int idResenia);
    void eliminarResenia(int idResenia);
    void darMeGusta(int idResenia); //suma un meGusta a los meGusta del objeto Resenia
}
