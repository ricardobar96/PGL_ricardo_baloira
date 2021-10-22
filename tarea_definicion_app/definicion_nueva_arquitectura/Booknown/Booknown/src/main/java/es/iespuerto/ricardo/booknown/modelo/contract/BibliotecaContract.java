package es.iespuerto.ricardo.booknown.modelo.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class BibliotecaContract {
    public static abstract class BibliotecaEntry implements BaseColumns {
        public static final String nombreTabla ="biblioteca";
        public static final String idBiblioteca ="idBiblioteca";
        public static final String usuariosSeguidos ="usuariosSeguidos";
        public static final String librosCreados = "librosCreados";
        public static final String librosLeidos = "librosLeidos";
    }
}
