package es.iespuerto.ricardo.booknown.modelo.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class ReseniaContract {
    public static abstract class ReseniaEntry implements BaseColumns {
        public static final String nombreTabla ="Resenia";
        public static final String idResenia ="idResenia";
        public static final String puntuacion ="puntuacion";
        public static final String meGusta = "meGusta";
        public static final String autor = "autor";
        public static final String libroTitulo ="libroTitulo";
        public static final String fecha = "fecha";
    }
}
