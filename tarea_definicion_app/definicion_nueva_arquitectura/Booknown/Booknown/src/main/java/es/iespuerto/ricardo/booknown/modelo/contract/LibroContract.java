package es.iespuerto.ricardo.booknown.modelo.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class LibroContract {
    public static abstract class LibroEntry implements BaseColumns {
        public static final String nombreTabla ="libro";
        public static final String idLibro ="idLibro";
        public static final String visualizaciones ="visualizaciones";
        public static final String paginas = "paginas";
        public static final String puntuacionMedia = "puntuacionMedia";
        public static final String titulo ="titulo";
        public static final String autor = "autor";
        public static final String genero = "genero";
        public static final String fechaActualizacion = "fechaActualizacion";
        public static final String fechaPublicacion = "fechaPublicacion";
        public static final String pagoOpcional = "pagoOpcional";
    }
}
