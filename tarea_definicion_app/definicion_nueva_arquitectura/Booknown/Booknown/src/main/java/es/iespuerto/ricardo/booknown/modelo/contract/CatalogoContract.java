package es.iespuerto.ricardo.booknown.modelo.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class CatalogoContract {
    public static abstract class CatalogoEntry implements BaseColumns {
        public static final String nombreTabla ="catalogo";
        public static final String librosCatalogo ="librosCatalogo";
        public static final String reseniasCatalogo ="reseniasCatalogo";
    }
}